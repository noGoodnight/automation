import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class JarPackageTest {
    @Test
    public void jarTestC0() throws IOException {
        Runtime run = Runtime.getRuntime();
        String command = "cmd.exe /c java -jar C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Demo\\testSelection.jar -c " +
                "C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Data\\0-CMD\\target " +
                "C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Data\\0-CMD\\data\\change_info.txt";
        Process process = run.exec(command);
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(getContent("C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Data\\0-CMD\\data\\selection-class.txt"),
                getContent("C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Project\\selection-class.txt"));
    }

    @Test
    public void jarTestM0() throws IOException {
        Runtime run = Runtime.getRuntime();
        String command = "cmd.exe /c java -jar C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Demo\\testSelection.jar -m " +
                "C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Data\\0-CMD\\target " +
                "C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Data\\0-CMD\\data\\change_info.txt";
        Process process = run.exec(command);
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(getContent("C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Data\\0-CMD\\data\\selection-method.txt"),
                getContent("C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Project\\selection-method.txt"));
    }

    @Test
    public void jarTestC1() throws IOException {
        Runtime run = Runtime.getRuntime();
        String command = "cmd.exe /c java -jar C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Demo\\testSelection.jar -c " +
                "C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Data\\1-ALU\\target " +
                "C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Data\\1-ALU\\data\\change_info.txt";
        Process process = run.exec(command);
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(getContent("C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Data\\1-ALU\\data\\selection-class.txt"),
                getContent("C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Project\\selection-class.txt"));
    }

    @Test
    public void jarTestM1() throws IOException {
        Runtime run = Runtime.getRuntime();
        String command = "cmd.exe /c java -jar C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Demo\\testSelection.jar -m " +
                "C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Data\\1-ALU\\target " +
                "C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Data\\1-ALU\\data\\change_info.txt";
        Process process = run.exec(command);
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(getContent("C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Data\\1-ALU\\data\\selection-method.txt"),
                getContent("C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Project\\selection-method.txt"));
    }

    @Test
    public void jarTestC2() throws IOException {
        Runtime run = Runtime.getRuntime();
        String command = "cmd.exe /c java -jar C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Demo\\testSelection.jar -c " +
                "C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Data\\2-DataLog\\target " +
                "C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Data\\2-DataLog\\data\\change_info.txt";
        Process process = run.exec(command);
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(getContent("C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Data\\2-DataLog\\data\\selection-class.txt"),
                getContent("C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Project\\selection-class.txt"));
    }

    @Test
    public void jarTestM2() throws IOException {
        Runtime run = Runtime.getRuntime();
        String command = "cmd.exe /c java -jar C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Demo\\testSelection.jar -m " +
                "C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Data\\2-DataLog\\target " +
                "C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Data\\2-DataLog\\data\\change_info.txt";
        Process process = run.exec(command);
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(getContent("C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Data\\2-DataLog\\data\\selection-method.txt"),
                getContent("C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Project\\selection-method.txt"));
    }

    @Test
    public void jarTestC3() throws IOException {
        Runtime run = Runtime.getRuntime();
        String command = "cmd.exe /c java -jar C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Demo\\testSelection.jar -c " +
                "C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Data\\3-BinaryHeap\\target " +
                "C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Data\\3-BinaryHeap\\data\\change_info.txt";
        Process process = run.exec(command);
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(getContent("C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Data\\3-BinaryHeap\\data\\selection-class.txt"),
                getContent("C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Project\\selection-class.txt"));
    }

    @Test
    public void jarTestM3() throws IOException {
        Runtime run = Runtime.getRuntime();
        String command = "cmd.exe /c java -jar C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Demo\\testSelection.jar -m " +
                "C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Data\\3-BinaryHeap\\target " +
                "C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Data\\3-BinaryHeap\\data\\change_info.txt";
        Process process = run.exec(command);
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(getContent("C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Data\\3-BinaryHeap\\data\\selection-method.txt"),
                getContent("C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Project\\selection-method.txt"));
    }

    @Test
    public void jarTestC4() throws IOException {
        Runtime run = Runtime.getRuntime();
        String command = "cmd.exe /c java -jar C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Demo\\testSelection.jar -c " +
                "C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Data\\4-NextDay\\target " +
                "C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Data\\4-NextDay\\data\\change_info.txt";
        Process process = run.exec(command);
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(getContent("C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Data\\4-NextDay\\data\\selection-class.txt"),
                getContent("C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Project\\selection-class.txt"));
    }

    @Test
    public void jarTestM4() throws IOException {
        Runtime run = Runtime.getRuntime();
        String command = "cmd.exe /c java -jar C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Demo\\testSelection.jar -m " +
                "C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Data\\4-NextDay\\target " +
                "C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Data\\4-NextDay\\data\\change_info.txt";
        Process process = run.exec(command);
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(getContent("C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Data\\4-NextDay\\data\\selection-method.txt"),
                getContent("C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Project\\selection-method.txt"));
    }

    @Test
    public void jarTestC5() throws IOException {
        Runtime run = Runtime.getRuntime();
        String command = "cmd.exe /c java -jar C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Demo\\testSelection.jar -c " +
                "C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Data\\5-MoreTriangle\\target " +
                "C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Data\\5-MoreTriangle\\data\\change_info.txt";
        Process process = run.exec(command);
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(getContent("C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Data\\5-MoreTriangle\\data\\selection-class.txt"),
                getContent("C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Project\\selection-class.txt"));
    }

    @Test
    public void jarTestM5() throws IOException {
        Runtime run = Runtime.getRuntime();
        String command = "cmd.exe /c java -jar C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Demo\\testSelection.jar -m " +
                "C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Data\\5-MoreTriangle\\target " +
                "C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Data\\5-MoreTriangle\\data\\change_info.txt";
        Process process = run.exec(command);
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(getContent("C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Data\\5-MoreTriangle\\data\\selection-method.txt"),
                getContent("C:\\南大软院\\自动化\\大作业\\自动化测试实践\\经典大作业\\automation\\Project\\selection-method.txt"));
    }

    public String getContent(String path) {
        BufferedReader bufferedReader = null;
        String content = "";
        ArrayList<String> lines = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(path));

            while ((content = bufferedReader.readLine()) != null) {
                lines.add(content);
            }
            lines.sort(Comparator.naturalOrder());
            while (lines.get(0).equals("")) {
                lines.remove(0);
            }
            content = "";
            for (String line : lines) {
                content += line;
                content += "\n";
            }
            return content;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }
}
