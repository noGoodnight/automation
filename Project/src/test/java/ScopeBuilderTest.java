import com.ibm.wala.ipa.callgraph.AnalysisScope;
import com.ibm.wala.shrikeCT.InvalidClassFileException;
import org.junit.Test;

import java.io.IOException;

public class ScopeBuilderTest {
    @Test
    public void scopeBuilderTest() throws IOException, InvalidClassFileException {
        AnalysisScope scope = new ScopeBuilder("C:/南大软院/自动化/大作业/自动化测试实践/经典大作业/automation/Data/0-CMD/target").getScope();
        System.out.println(scope);
        System.out.println("Done!");
    }
}
