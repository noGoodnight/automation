import com.ibm.wala.ipa.callgraph.AnalysisScope;
import com.ibm.wala.shrikeCT.InvalidClassFileException;
import com.ibm.wala.types.ClassLoaderReference;
import com.ibm.wala.util.config.AnalysisScopeReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ScopeBuilder {
    private AnalysisScope scope;

    public ScopeBuilder(String targetPath) throws IOException, InvalidClassFileException {
        ClassLoader classLoader;
        ArrayList<File> srcClasses;
        ArrayList<File> testClasses;

        if (targetPath.endsWith("/")) {
            targetPath = targetPath.substring(0, targetPath.length() - 1);
        }
        classLoader = AnalysisScope.class.getClassLoader();
        scope = AnalysisScopeReader.readJavaScope("scope.txt", new File("exclusion.txt"), classLoader);
        srcClasses = getFiles(targetPath + "/classes");
        testClasses = getFiles(targetPath + "/test-classes");

        for (File file : srcClasses) {
            scope.addClassFileToScope(ClassLoaderReference.Application, file);
        }
        for (File file : testClasses) {
            scope.addClassFileToScope(ClassLoaderReference.Application, file);
        }
    }

    public AnalysisScope getScope() {
        return scope;
    }

    public ArrayList<File> getFiles(String root) {
        File target;
        ArrayList<File> result;
        String[] paths;

        result = new ArrayList<>();
        target = new File(root);
        paths = target.list();
        if (paths == null) {
            return null;
        }

        for (String path : paths) {
            File tempFile = new File(root + "/" + path);
            if (tempFile.isDirectory()) {
                ArrayList<File> temp = getFiles(root + "/" + path);
                if (temp != null) {
                    result.addAll(temp);
                }
            } else {
                result.add(tempFile);
            }
        }

        return result;
    }
}
