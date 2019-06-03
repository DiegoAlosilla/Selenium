package tests;

import java.io.File;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests {

	private WebDriver driver;

	@BeforeMethod
	public void setUp() {

		OperaOptions options = new OperaOptions();
		options.setBinary(new File("C:\\Program Files\\Opera\\60.0.3255.109_1\\opera.exe"));

		DesiredCapabilities caps = new DesiredCapabilities();
		System.setProperty("webdriver.opera.driver", "Drivers/operadriver.exe");
		driver = new OperaDriver(options);
		driver.manage().window().maximize();
		driver.navigate().to("https://www.facebook.com");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Test
	private void pruebaUno() {
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys("diegoalosillabc@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("091117");
		driver.findElement(By.xpath("//*[@id=\"u_0_2\"]")).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"navItem_217974574879787\"]/a/div")).getText()
				.contains("Messenger"));
	}

	@AfterMethod
	public void tearDwon() {
		driver.close();
	}

}
