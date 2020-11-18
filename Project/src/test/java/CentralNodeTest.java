import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class CentralNodeTest {
    @Test
    public void classChangeInfo0Test() {
        try {
            CentralNode centralNode = new CentralNode(new String[]{"-c",
                    "../Data/0-CMD/target",
                    "../Data/0-CMD/data/change_info.txt"});
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("../Data/0-CMD/data/selection-class.txt"));
            ArrayList<String> infos = new ArrayList<>();
            String info;

            while ((info = bufferedReader.readLine()) != null) {
                infos.add(info);
            }
            infos.sort(Comparator.naturalOrder());
            while(infos.get(0).equals("")){
                infos.remove(0);
            }
            info = "";
            for (String i : infos) {
                info += i;
                info += "\n";
            }
            info += "\n";
            Assert.assertEquals(info, centralNode.changeResultInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void methodChangeInfo0Test() {
        try {
            CentralNode centralNode = new CentralNode(new String[]{"-m",
                    "../Data/0-CMD/target",
                    "../Data/0-CMD/data/change_info.txt"});
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("../Data/0-CMD/data/selection-method.txt"));
            ArrayList<String> infos = new ArrayList<>();
            String info;

            while ((info = bufferedReader.readLine()) != null) {
                infos.add(info);
            }
            infos.sort(Comparator.naturalOrder());
            while(infos.get(0).equals("")){
                infos.remove(0);
            }
            info = "";
            for (String i : infos) {
                info += i;
                info += "\n";
            }
            info += "\n";
            Assert.assertEquals(info, centralNode.changeResultInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void classChangeInfo1Test() {
        try {
            CentralNode centralNode = new CentralNode(new String[]{"-c",
                    "../Data/1-ALU/target",
                    "../Data/1-ALU/data/change_info.txt"});
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("../Data/1-ALU/data/selection-class.txt"));
            ArrayList<String> infos = new ArrayList<>();
            String info;

            while ((info = bufferedReader.readLine()) != null) {
                infos.add(info);
            }
            infos.sort(Comparator.naturalOrder());
            while(infos.get(0).equals("")){
                infos.remove(0);
            }
            info = "";
            for (String i : infos) {
                info += i;
                info += "\n";
            }
            info += "\n";
            Assert.assertEquals(info, centralNode.changeResultInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void methodChangeInfo1Test() {
        try {
            CentralNode centralNode = new CentralNode(new String[]{"-m",
                    "../Data/1-ALU/target",
                    "../Data/1-ALU/data/change_info.txt"});
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("../Data/1-ALU/data/selection-method.txt"));
            ArrayList<String> infos = new ArrayList<>();
            String info;

            while ((info = bufferedReader.readLine()) != null) {
                infos.add(info);
            }
            infos.sort(Comparator.naturalOrder());
            while(infos.get(0).equals("")){
                infos.remove(0);
            }
            info = "";
            for (String i : infos) {
                info += i;
                info += "\n";
            }
            info += "\n";
            Assert.assertEquals(info, centralNode.changeResultInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void classChangeInfo2Test() {
        try {
            CentralNode centralNode = new CentralNode(new String[]{"-c",
                    "../Data/2-DataLog/target",
                    "../Data/2-DataLog/data/change_info.txt"});
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("../Data/2-DataLog/data/selection-class.txt"));
            ArrayList<String> infos = new ArrayList<>();
            String info;

            while ((info = bufferedReader.readLine()) != null) {
                infos.add(info);
            }
            infos.sort(Comparator.naturalOrder());
            while(infos.get(0).equals("")){
                infos.remove(0);
            }
            info = "";
            for (String i : infos) {
                info += i;
                info += "\n";
            }
            info += "\n";
            Assert.assertEquals(info, centralNode.changeResultInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void methodChangeInfo2Test() {
        try {
            CentralNode centralNode = new CentralNode(new String[]{"-m",
                    "../Data/2-DataLog/target",
                    "../Data/2-DataLog/data/change_info.txt"});
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("../Data/2-DataLog/data/selection-method.txt"));
            ArrayList<String> infos = new ArrayList<>();
            String info;

            while ((info = bufferedReader.readLine()) != null) {
                infos.add(info);
            }
            infos.sort(Comparator.naturalOrder());
            while(infos.get(0).equals("")){
                infos.remove(0);
            }
            info = "";
            for (String i : infos) {
                info += i;
                info += "\n";
            }
            info += "\n";
            Assert.assertEquals(info, centralNode.changeResultInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void classChangeInfo3Test() {
        try {
            CentralNode centralNode = new CentralNode(new String[]{"-c",
                    "../Data/3-BinaryHeap/target",
                    "../Data/3-BinaryHeap/data/change_info.txt"});
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("../Data/3-BinaryHeap/data/selection-class.txt"));
            ArrayList<String> infos = new ArrayList<>();
            String info;

            while ((info = bufferedReader.readLine()) != null) {
                infos.add(info);
            }
            infos.sort(Comparator.naturalOrder());
            while(infos.get(0).equals("")){
                infos.remove(0);
            }
            info = "";
            for (String i : infos) {
                info += i;
                info += "\n";
            }
            info += "\n";
            Assert.assertEquals(info, centralNode.changeResultInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void methodChangeInfo3Test() {
        try {
            CentralNode centralNode = new CentralNode(new String[]{"-m",
                    "../Data/3-BinaryHeap/target",
                    "../Data/3-BinaryHeap/data/change_info.txt"});
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("../Data/3-BinaryHeap/data/selection-method.txt"));
            ArrayList<String> infos = new ArrayList<>();
            String info;

            while ((info = bufferedReader.readLine()) != null) {
                infos.add(info);
            }
            infos.sort(Comparator.naturalOrder());
            while(infos.get(0).equals("")){
                infos.remove(0);
            }
            info = "";
            for (String i : infos) {
                info += i;
                info += "\n";
            }
            info += "\n";
            Assert.assertEquals(info, centralNode.changeResultInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void classChangeInfo4Test() {
        try {
            CentralNode centralNode = new CentralNode(new String[]{"-c",
                    "../Data/4-NextDay/target",
                    "../Data/4-NextDay/data/change_info.txt"});
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("../Data/4-NextDay/data/selection-class.txt"));
            ArrayList<String> infos = new ArrayList<>();
            String info;

            while ((info = bufferedReader.readLine()) != null) {
                infos.add(info);
            }
            infos.sort(Comparator.naturalOrder());
            while(infos.get(0).equals("")){
                infos.remove(0);
            }
            info = "";
            for (String i : infos) {
                info += i;
                info += "\n";
            }
            info += "\n";
            Assert.assertEquals(info, centralNode.changeResultInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void methodChangeInfo4Test() {
        try {
            CentralNode centralNode = new CentralNode(new String[]{"-m",
                    "../Data/4-NextDay/target",
                    "../Data/4-NextDay/data/change_info.txt"});
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("../Data/4-NextDay/data/selection-method.txt"));
            ArrayList<String> infos = new ArrayList<>();
            String info;

            while ((info = bufferedReader.readLine()) != null) {
                infos.add(info);
            }
            infos.sort(Comparator.naturalOrder());
            while(infos.get(0).equals("")){
                infos.remove(0);
            }
            info = "";
            for (String i : infos) {
                info += i;
                info += "\n";
            }
            info += "\n";
            Assert.assertEquals(info, centralNode.changeResultInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void classChangeInfo5Test() {
        try {
            CentralNode centralNode = new CentralNode(new String[]{"-c",
                    "../Data/5-MoreTriangle/target",
                    "../Data/5-MoreTriangle/data/change_info.txt"});
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("../Data/5-MoreTriangle/data/selection-class.txt"));
            ArrayList<String> infos = new ArrayList<>();
            String info;

            while ((info = bufferedReader.readLine()) != null) {
                infos.add(info);
            }
            infos.sort(Comparator.naturalOrder());
            while(infos.get(0).equals("")){
                infos.remove(0);
            }
            info = "";
            for (String i : infos) {
                info += i;
                info += "\n";
            }
            info += "\n";
            Assert.assertEquals(info, centralNode.changeResultInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void methodChangeInfo5Test() {
        try {
            CentralNode centralNode = new CentralNode(new String[]{"-m",
                    "../Data/5-MoreTriangle/target",
                    "../Data/5-MoreTriangle/data/change_info.txt"});
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("../Data/5-MoreTriangle/data/selection-method.txt"));
            ArrayList<String> infos = new ArrayList<>();
            String info;

            while ((info = bufferedReader.readLine()) != null) {
                infos.add(info);
            }
            infos.sort(Comparator.naturalOrder());
            while(infos.get(0).equals("")){
                infos.remove(0);
            }
            info = "";
            for (String i : infos) {
                info += i;
                info += "\n";
            }
            info += "\n";
            Assert.assertEquals(info, centralNode.changeResultInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
