import java.util.ArrayList;

public class MethodNode {
    String name;
    ClassNode classNode;
    ArrayList<MethodNode> predMethodNodes;

    public MethodNode(String name){
        this.name = name;
        classNode = null;
        this.predMethodNodes = new ArrayList<>();
    }

    public void setClassName(ClassNode classNode) {
        this.classNode = classNode;
    }

    public void addPredMethod(MethodNode methodNode){
        if(!this.predMethodNodes.contains(methodNode)) {
            this.predMethodNodes.add(methodNode);
        }
    }
}
