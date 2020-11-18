import org.junit.Test;

public class CentralNodeDotFileTest {
    @Test
    public void CentralNodeDotFileBuilder0() {
        try {
            CentralNode centralNode = new CentralNode(new String[]{"-c",
                    "../Data/0-CMD/target",
                    "noChange"});
            centralNode.classDotFileBuilder();
            centralNode.methodDotFileBuilder();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void CentralNodeDotFileBuilder1() {
        try {
            CentralNode centralNode = new CentralNode(new String[]{"-c",
                    "../Data/1-ALU/target",
                    "noChange"});
            centralNode.classDotFileBuilder();
            centralNode.methodDotFileBuilder();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void CentralNodeDotFileBuilder2() {
        try {
            CentralNode centralNode = new CentralNode(new String[]{"-c",
                    "../Data/2-DataLog/target",
                    "noChange"});
            centralNode.classDotFileBuilder();
            centralNode.methodDotFileBuilder();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void CentralNodeDotFileBuilder3() {
        try {
            CentralNode centralNode = new CentralNode(new String[]{"-c",
                    "../Data/3-BinaryHeap/target",
                    "noChange"});
            centralNode.classDotFileBuilder();
            centralNode.methodDotFileBuilder();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void CentralNodeDotFileBuilder4() {
        try {
            CentralNode centralNode = new CentralNode(new String[]{"-c",
                    "../Data/4-NextDay/target",
                    "noChange"});
            centralNode.classDotFileBuilder();
            centralNode.methodDotFileBuilder();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void CentralNodeDotFileBuilder5() {
        try {
            CentralNode centralNode = new CentralNode(new String[]{"-c",
                    "../Data/5-MoreTriangle/target",
                    "noChange"});
            centralNode.classDotFileBuilder();
            centralNode.methodDotFileBuilder();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void CentralNodeDotFileBuilderOwn(){
        try{
            CentralNode centralNode = new CentralNode(new String[]{"-c",
                    "./target",
                    "noChange"});
            centralNode.classDotFileBuilder();
            centralNode.methodDotFileBuilder();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
