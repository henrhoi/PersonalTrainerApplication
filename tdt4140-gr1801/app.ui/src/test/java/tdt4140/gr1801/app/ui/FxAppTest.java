
package tdt4140.gr1801.app.ui;

import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

public class FxAppTest extends ApplicationTest {
	
	@BeforeClass
	public static void headless() {
		if (Boolean.valueOf(System.getProperty("gitlab-ci", "false"))) {
			System.setProperty("prism.verbose", "true"); // optional
			System.setProperty("java.awt.headless", "true");
			System.setProperty("testfx.robot", "glass");
			System.setProperty("testfx.headless", "true");
			System.setProperty("glass.platform", "Monocle");
			System.setProperty("monocle.platform", "Headless");
			System.setProperty("prism.order", "sw");
			System.setProperty("prism.text", "t2k");
			System.setProperty("testfx.setup.timeout", "2500");
		}
	}

//	@Override
//    public void start(Stage stage) throws Exception {
//		System.out.println(getClass().getResource("FxLogin.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("FxLogin.fxml"));
//        Scene scene = new Scene(root); //Crasher her
//        stage.setScene(scene);
//        stage.show();
//    }

    @Test
    public void testFxApp() {
    }
}

