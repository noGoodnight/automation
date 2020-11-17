import com.ibm.wala.classLoader.Language;
import com.ibm.wala.classLoader.ShrikeBTMethod;
import com.ibm.wala.ipa.callgraph.*;
import com.ibm.wala.ipa.callgraph.cha.CHACallGraph;
import com.ibm.wala.ipa.callgraph.impl.AllApplicationEntrypoints;
import com.ibm.wala.ipa.callgraph.impl.Util;
import com.ibm.wala.ipa.callgraph.propagation.SSAPropagationCallGraphBuilder;
import com.ibm.wala.ipa.cha.ClassHierarchy;
import com.ibm.wala.ipa.cha.ClassHierarchyException;
import com.ibm.wala.ipa.cha.ClassHierarchyFactory;
import com.ibm.wala.shrikeCT.InvalidClassFileException;
import com.ibm.wala.util.CancelException;

import java.io.IOException;

public class TestSelection {
    public static void main(String[] args) {
        args = new String[]{"-c",
                "C:/南大软院/自动化/大作业/自动化测试实践/经典大作业/automation/Data/0-CMD/target",
                "C:/南大软院/自动化/大作业/自动化测试实践/经典大作业/automation/Data/0-CMD/data/change_info.txt"};
        try {
            if(args[0].equals("-c")){
                new TestSelection().goClasses(args);
            }else if(args[1].equals("-m")){
                new TestSelection().goMethods(args);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goClasses(String[] args) throws IOException, InvalidClassFileException, ClassHierarchyException, CancelException {
//        指令一： java -jar testSelection.jar -c <project_target> <change_info>，执行类级测试选择；
//        指令二： java -jar testSelection.jar -m <project_target> <change_info>。执行方法级测试选择；
//        System.out.println(TestSelection.class.getResource("./scope.txt"));
        AnalysisScope scope = new ScopeBuilder(args[1]).getScope();
        ClassHierarchy classHierarchy = ClassHierarchyFactory.makeWithRoot(scope);
        Iterable<Entrypoint> entrypoints = new AllApplicationEntrypoints(scope, classHierarchy);
//        Iterable<Entrypoint> entrypoints = Util.makeMainEntrypoints(scope, classHierarchy);
        CHACallGraph chaCallGraph = new CHACallGraph(classHierarchy);
        chaCallGraph.init(entrypoints);

        for (CGNode node : chaCallGraph) {
            if (node.getMethod() instanceof ShrikeBTMethod) {
                ShrikeBTMethod method = (ShrikeBTMethod) node.getMethod();
                if ("Application".equals(method.getDeclaringClass().getClassLoader().toString())) {
                    String classInnerName = method.getDeclaringClass().getName().toString();
                    String signature = method.getSignature();
                    System.out.println(classInnerName + " " + signature);
                }
            } else {
                System.out.println(String.format("'%s'不是一个ShrikeBTMethod：%s", node.getMethod(), node.getMethod().getClass()));
            }
        }
    }

    public void goMethods(String[] args) throws IOException, InvalidClassFileException, ClassHierarchyException, CancelException {
        AnalysisScope scope = new ScopeBuilder(args[1]).getScope();
        ClassHierarchy classHierarchy = ClassHierarchyFactory.makeWithRoot(scope);
        AllApplicationEntrypoints entrypoints = new AllApplicationEntrypoints(scope, classHierarchy);
        AnalysisOptions options = new AnalysisOptions(scope, entrypoints);
        SSAPropagationCallGraphBuilder builder = Util.makeZeroCFABuilder(Language.JAVA, options, new AnalysisCacheImpl(), classHierarchy, scope);
    }
}
