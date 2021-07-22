package jesusFlores;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PrimerScriptTestNG {
	WebDriver driver;
	String url = "https://opensource-demo.orangehrmlive.com/";
	String usuario = "Admin";
	String password = "admin123";
	String browserName = "Chrome";
	
	@BeforeTest
	public void startWebDriver() {
		switch (browserName) {
		case "Chrome":
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--start-maximized");
			option.addArguments("--incognito");
			System.setProperty("webdriver.chrome.driver", "chromedriver\\chromedriver.exe");
			driver = new ChromeDriver(option);
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			break;
		case "edge":
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--incognito");
			System.setProperty("webdriver.edge.driver", "edgedriver\\msedgedriver.exe");
			driver = new EdgeDriver(options);
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			break;
		case "firefox":
			FirefoxOptions option2 = new FirefoxOptions();
			option2.addArguments("\"--start-maximized\"");
			option2.addArguments("--incognito");
			System.setProperty("webdriver.gecko.driver", "geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver(option2);
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			break;
		default:
			Reporter.log("El explorador no existe", true);
		}//end switch
	}
	@Test
	public void login() {
		driver.findElement(By.id("txtUsername")).sendKeys(usuario);
		driver.findElement(By.xpath("//input[@name=\"txtPassword\"]")).sendKeys(password);
		driver.findElement(By.name("Submit")).submit();
		
		try {
			if (driver.findElement(By.id("spanMessage"))!=null) {
				System.out.println("El login no fue existoso");
			} 
			else {
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("El login fue exitoso");
		}
		
	}//end login
	
	@AfterTest
	public void closeBrowser() {
		driver.close(); //"Cerrar el explorador"
	} 

}
