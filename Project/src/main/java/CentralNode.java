import com.ibm.wala.classLoader.Language;
import com.ibm.wala.classLoader.ShrikeBTMethod;
import com.ibm.wala.ipa.callgraph.*;
import com.ibm.wala.ipa.callgraph.impl.AllApplicationEntrypoints;
import com.ibm.wala.ipa.callgraph.impl.Util;
import com.ibm.wala.ipa.callgraph.propagation.SSAPropagationCallGraphBuilder;
import com.ibm.wala.ipa.cha.ClassHierarchy;
import com.ibm.wala.ipa.cha.ClassHierarchyException;
import com.ibm.wala.ipa.cha.ClassHierarchyFactory;
import com.ibm.wala.shrikeCT.InvalidClassFileException;
import com.ibm.wala.util.CancelException;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;

public class CentralNode {
    ArrayList<ClassNode> classNodes;
    ArrayList<MethodNode> methodNodes;
    ArrayList<String> classNames;
    ArrayList<String> methodNames;
    ArrayList<String> classDotSentences;
    ArrayList<String> methodDotSentences;
    String[] args;
    ArrayList<String> changeResultInfos;
    String changeResultInfo;
    ArrayList<String> changeInfos;
    ArrayList<ClassNode> changeClassNodes;
    ArrayList<MethodNode> changeMethodNodes;
    String projectName = "";

    public static void main(String[] args) {
        args = new String[]{"-c",
                "C:/南大软院/自动化/大作业/自动化测试实践/经典大作业/automation/Data/1-ALU/target",
                "C:/南大软院/自动化/大作业/自动化测试实践/经典大作业/automation/Data/1-ALU/data/change_info.txt"};
        try {
            new CentralNode(args).go();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CentralNode(String[] strings) throws IOException {
        this.classNodes = new ArrayList<>();
        this.methodNodes = new ArrayList<>();
        this.classNames = new ArrayList<>();
        this.methodNames = new ArrayList<>();
        this.classDotSentences = new ArrayList<>();
        this.classDotSentences.add("digraph cmd_class {");
        this.methodDotSentences = new ArrayList<>();
        this.methodDotSentences.add("digraph cmd_method {");
        this.args = strings;
        this.changeResultInfos = new ArrayList<>();
        this.changeResultInfo = "";
        this.changeInfos = this.getChangeInfo();
        this.changeClassNodes = new ArrayList<>();
        this.changeMethodNodes = new ArrayList<>();
        String[] temp = this.args[1].split("/");
        this.projectName = temp[temp.length - 2];

        try {
            go();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void go() throws IOException, InvalidClassFileException, ClassHierarchyException, CancelException {
        AnalysisScope scope;
        ClassHierarchy classHierarchy;
        AllApplicationEntrypoints entrypoints;
        AnalysisOptions options;
        SSAPropagationCallGraphBuilder builder;
        CallGraph callGraph;

        scope = new ScopeBuilder(this.args[1]).getScope();
        classHierarchy = ClassHierarchyFactory.makeWithRoot(scope);
        entrypoints = new AllApplicationEntrypoints(scope, classHierarchy);
        options = new AnalysisOptions(scope, entrypoints);
        builder = Util.makeZeroCFABuilder(Language.JAVA, options, new AnalysisCacheImpl(), classHierarchy, scope);
        callGraph = builder.makeCallGraph(options);

        for (CGNode cgNode : callGraph) {
            if (cgNode.getMethod() instanceof ShrikeBTMethod) {
                ShrikeBTMethod method = (ShrikeBTMethod) cgNode.getMethod();
                if ("Application".equals(method.getDeclaringClass().getClassLoader().toString())) {
                    ClassNode classNode = getCurrentClassNode(method);
                    MethodNode methodNode = classNode.currentNode;

                    Iterator<CGNode> iterator = callGraph.getPredNodes(cgNode);
                    while (iterator.hasNext()) {
                        CGNode predCGNode = iterator.next();
                        if (predCGNode.getMethod() instanceof ShrikeBTMethod) {
                            ShrikeBTMethod predMethod = (ShrikeBTMethod) predCGNode.getMethod();
                            if ("Application".equals(predMethod.getDeclaringClass().getClassLoader().toString())) {
                                ClassNode predClassNode = getCurrentClassNode(predMethod);
                                MethodNode predMethodNode = predClassNode.currentNode;

                                classNode.addPredClass(predClassNode);
                                methodNode.addPredMethod(predMethodNode);
                                String classReference = "    \"" + classNode.name + "\" -> \"" + predClassNode.name + "\";";
                                String methodReference = "    \"" + methodNode.name + "\" -> \"" + predMethodNode.name + "\";";
                                if (!this.classDotSentences.contains(classReference)) {
                                    this.classDotSentences.add(classReference);
                                }
                                if (!this.methodDotSentences.contains(methodReference)) {
                                    this.methodDotSentences.add(methodReference);
                                }
                            }
                        }
                    }
                }
            }
        }
        this.classDotSentences.add("}");
        this.methodDotSentences.add("}");
        if (this.args[0].equals("-c")) {
            this.classChangeInfo();
        } else if (this.args[0].equals("-m")) {
            this.methodChangeInfo();
        }
        this.collectChangeResultInfo();
    }

    public void classChangeInfo() {
        MethodNode changeMethod;
        ClassNode changeClass;

        for (String changeInfo : this.changeInfos) {
            changeMethod = getMethodNode(changeInfo);
            changeClass = changeMethod.classNode;
            this.getChangeClass(changeClass, this.changeClassNodes, this.changeMethodNodes);
        }
    }

    public void methodChangeInfo() {
        MethodNode changeMethod;

        for (String changeInfo : this.changeInfos) {
            changeMethod = getMethodNode(changeInfo);
            this.getChangeMethod(changeMethod, this.changeMethodNodes);
        }
    }

    public ClassNode getClassNode(String className) {
        if (!this.classNames.contains(className)) {
            return null;
        } else {
            for (ClassNode node : this.classNodes) {
                if (node.name.equals(className)) {
                    return node;
                }
            }
        }
        return null;
    }

    public MethodNode getMethodNode(String methodName) {
        if (!this.methodNames.contains(methodName)) {
            return null;
        } else {
            for (MethodNode node : this.methodNodes) {
                if (node.name.equals(methodName)) {
                    return node;
                }
            }
        }
        return null;
    }

    public ClassNode getCurrentClassNode(ShrikeBTMethod method) {
        String classInnerName = method.getDeclaringClass().getName().toString();
        String signature = method.getSignature();
        String methodInnerName = classInnerName + " " + signature;
        ClassNode classNode = getClassNode(classInnerName);
        MethodNode methodNode = getMethodNode(methodInnerName);
        if (classNode == null) {
            classNode = new ClassNode(classInnerName);
            this.classNames.add(classInnerName);
            this.classNodes.add(classNode);
        }
        if (methodNode == null) {
            methodNode = new MethodNode(methodInnerName);
            this.methodNames.add(methodInnerName);
            this.methodNodes.add(methodNode);
        }
        methodNode.setClassName(classNode);
        classNode.addMethod(methodNode);
        classNode.setCurrentNode(methodNode);
        return classNode;
    }

    public void classDotFileBuilder() throws IOException {
        FileWriter classDotFile;
        String content;
        String path;
        Runtime run;
        String command;

        String name = this.projectName + "-class";
        path = "../Report/" + name + ".dot";
        classDotFile = new FileWriter(path);
        content = "";
        command = "dot -T pdf -o ../Report/" + name + ".pdf ../Report/" + name + ".dot";
        run = Runtime.getRuntime();

        for (String sentence : this.classDotSentences) {
            content = content + sentence + "\n";
        }
        classDotFile.write(content);
        classDotFile.close();
//        run.exec("cmd.exe /c " + command);
    }

    public void methodDotFileBuilder() throws IOException {
        FileWriter methodDotFile;
        String content;
        String path;
        Runtime run;
        String command;

        String name = this.projectName + "-method";
        path = "../Report/" + name + ".dot";
        methodDotFile = new FileWriter(path);
        content = "";
        command = "dot -T pdf -o ../Report/" + name + ".pdf ../Report/" + name + ".dot";
        run = Runtime.getRuntime();

        for (String sentence : this.methodDotSentences) {
            content = content + sentence + "\n";
        }
        methodDotFile.write(content);
        methodDotFile.close();
//        run.exec("cmd.exe /c " + command);
    }

    public ArrayList<String> getChangeInfo() throws IOException {
        ArrayList<String> changeInfos;
        BufferedReader fileReader;
        String changeInfo;

        changeInfos = new ArrayList<>();
        fileReader = new BufferedReader(new FileReader(this.args[2]));

        while ((changeInfo = fileReader.readLine()) != null) {
            changeInfos.add(changeInfo);
        }
        return changeInfos;
    }

    private void getChangeClass(ClassNode classNode, ArrayList<ClassNode> changeClassNodes, ArrayList<MethodNode> changeMethodNodes) {
        for (ClassNode node : classNode.predClassNodes) {
            if (!changeClassNodes.contains(node) && !node.equals(classNode)) {
                for (MethodNode methodNode : node.methods) {
                    if (!changeMethodNodes.contains(methodNode)) {
                        changeMethodNodes.add(methodNode);
                    }
                }
                changeClassNodes.add(node);
                this.getChangeClass(node, changeClassNodes, changeMethodNodes);
            }
        }
    }


    private void getChangeMethod(MethodNode methodNode, ArrayList<MethodNode> changeMethodNodes) {
        for (MethodNode node : methodNode.predMethodNodes) {
            if (!changeMethodNodes.contains(node) && !node.equals(methodNode)) {
                changeMethodNodes.add(node);
                this.getChangeMethod(node, changeMethodNodes);
            }
        }
    }

    public void collectChangeResultInfo() {
        for (MethodNode node : this.changeMethodNodes) {
            if (node.name.contains("Test") && !node.name.contains("init")) {
                this.changeResultInfos.add(node.name);
            }
        }
        this.changeResultInfos.sort(Comparator.naturalOrder());
        for (String info : this.changeResultInfos) {
            this.changeResultInfo += info;
            this.changeResultInfo += "\n";
        }
        this.changeResultInfo += "\n";

        try {
            FileWriter fileWriter = null;
            if(this.args[0].equals("-c")){
                fileWriter = new FileWriter("selection-class.txt");
            }else if(this.args[0].equals("-m")){
                fileWriter = new FileWriter("selection-method.txt");
            }
            fileWriter.write(this.changeResultInfo);
            fileWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
