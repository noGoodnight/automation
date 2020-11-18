import com.ibm.wala.ipa.callgraph.AnalysisScope;
import com.ibm.wala.shrikeCT.InvalidClassFileException;
import org.junit.Test;

import java.io.IOException;

public class ScopeBuilderTest {
     @Test
     public void scopeBuilderTest() throws IOException, InvalidClassFileException {
         AnalysisScope scope = new ScopeBuilder("../Data/0-CMD/target").getScope();
         System.out.println(scope);
         System.out.println("Done!");
     }
}
