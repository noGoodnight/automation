import org.junit.Test;

public class CentralNodeDotFileTest {
    @Test
    public void CentralNodeDotFileBuilder0() {
        try {
            CentralNode centralNode = new CentralNode(new String[]{"-c",
                    "../Data/0-CMD/target",
                    "../Data/0-CMD/data/change_info.txt"});
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
                    "../Data/1-ALU/data/change_info.txt"});
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
                    "../Data/2-DataLog/data/change_info.txt"});
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
                    "../Data/3-BinaryHeap/data/change_info.txt"});
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
                    "../Data/4-NextDay/data/change_info.txt"});
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
                    "../Data/5-MoreTriangle/data/change_info.txt"});
            centralNode.classDotFileBuilder();
            centralNode.methodDotFileBuilder();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
