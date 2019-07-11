package example;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PetClinicTest {
	private WebDriver driver;

	@Test
	public void testPetClinic() {
		// Change the URL based on the location where Tomcat is installed and
		// application is deployed
		driver.get("http://localhost:8081/petclinic/");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertTrue(title.contains("spring"));
	}

	@BeforeTest
	public void beforeTest() {
		File file = new
		// We have used Firefox for testing; change this driver based on
		// equirements and location too
		File("E:\\docs\\devops\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(300,TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
