package bindings;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wipro.pageObjects.AccountLogoutPage;
import com.wipro.pageObjects.HomePage;
import com.wipro.pageObjects.LoginPage;
import com.wipro.pageObjects.MyAccountPage;
import com.wipro.utilities.PageActions;
import com.wipro.utilities.ReadConfigFile;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksClass {
	ReadConfigFile readConfig = new ReadConfigFile();
	public static WebDriver driver;
	public static WebDriverWait wait;

	@Before
	public void setUp() {
		String requiredBrowser = readConfig.getPropertyFromPropertiesFile("browser");
		// System.out.println(requiredBrowser);
		if (requiredBrowser.equalsIgnoreCase("edge")) {
			// System.out.println(readConfig.getPropertyFromPropertiesFile("edgePath"));
			System.setProperty("webdriver.edge.driver", readConfig.getPropertyFromPropertiesFile("edgePath"));
			driver = new EdgeDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", readConfig.getPropertyFromPropertiesFile("chromePath"));
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get(readConfig.getApplicationUrl());
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, PageActions.class);
		PageActions.setDriver(HooksClass.driver, HooksClass.wait);
		PageFactory.initElements(driver, HomePage.class);
		PageFactory.initElements(driver, LoginPage.class);
		PageFactory.initElements(driver, MyAccountPage.class);
		PageFactory.initElements(driver, AccountLogoutPage.class);
	}

//	@After
//	public void tearDown(Scenario scenario) {
//
//	if (scenario.isFailed()) {
//
//	 captureScreenshot(scenario);
//
//	 byte[] screenshot2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//
//
//
//	 scenario.attach(screenshot2, "image/png", "Screenshot");
//
//
//
//	}
//
//
//
//	driver.quit();
//
//	}
	@After
	public void tearDown() {
		driver.quit();
	}
}
