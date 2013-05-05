package test.util;

import java.io.File;

import org.junit.runners.model.InitializationError;

import com.xtremelabs.robolectric.RobolectricConfig;
import com.xtremelabs.robolectric.RobolectricTestRunner;

public class SQLTestRunner extends PathTestRunner {
    private static final String DB_FILE = "/home/egetzner/appagainsthumanity/HumanityTest/testdata/test.db";
    
    public SQLTestRunner(Class testClass) throws InitializationError {
          super(testClass, new RobolectricConfig(new File(".")), new SQLiteMap(DB_FILE));
    
    }
}
