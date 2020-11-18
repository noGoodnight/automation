import java.util.ArrayList;

public class ClassNode {
    String name;
    ArrayList<MethodNode> methods;
    ArrayList<ClassNode> predClassNodes;
    MethodNode currentNode;

    public ClassNode(String name){
        this.name = name;
        methods = new ArrayList<>();
        predClassNodes = new ArrayList<>();
        currentNode = null;
    }

    public void addMethod(MethodNode method){
        if(!this.methods.contains(method)) {
            this.methods.add(method);
        }
        method.setClassName(this);
    }

    public void setCurrentNode(MethodNode currentNode) {
        this.currentNode = currentNode;
    }

    public void addPredClass(ClassNode classNode){
        if(!this.predClassNodes.contains(classNode)){
            this.predClassNodes.add(classNode);
        }
    }
}
