package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import comun.LeerProperties;

public class SeleniumPageFactory {
	static LeerProperties prop = new LeerProperties();
	static WebDriver driver;
	static String path = System.getProperty("user.dir");
	
	
	@FindBy(id="txtUsername")
	WebElement txt_userName;
	
	@FindBy(css = "input#txtPassword")
	WebElement txt_password;
	
	@FindBy(id="btnLogin")
	WebElement btn_login;
	
	@FindBy(id="spanMessage")
	WebElement text_mensajeDeError;
	
	@FindBy(xpath="//a[@id='welcome']")
	WebElement link_welcome;
	
	@BeforeTest
	public void startWebDriver() {
		try {
			prop.getSystemProperties();
			
			String browser = System.getProperty("BROWSER");
			String url = System.getProperty("URL");
			switch (browser) {
			
			case "chrome":
				System.setProperty("webdriver.chrome.driver",  path + "\\chromedriver\\chromedriver.exe");
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--start-maximized");
				option.addArguments("--incognito");
				driver = new ChromeDriver(option);
				driver.get(url);
				break;
			case "firefox": 
				System.setProperty("webdriver.gecko.driver",  path + "\\geckodriver\\geckodriver.exe");
				FirefoxOptions foption = new FirefoxOptions();
				foption.addArguments("--start-maximized");
				foption.addArguments("--incognito");
				driver = new FirefoxDriver(foption);
				driver.get(url);
				break;
			case "edge":
				System.setProperty("webdriver.edge.driver", path+"\\edgedriver\\msedgedriver.exe");
				EdgeOptions eoptions = new EdgeOptions();
				eoptions.addArguments("--start-maximized");
				eoptions.addArguments("-inprivate");
				driver = new  EdgeDriver(eoptions);
				driver.get(url);
				break;
				
			default: System.out.println("El driver [ "+browser+" ] no esta configurado para funcionar en este proyecto");
			}//end switch
			PageFactory.initElements(driver, this);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
			Reporter.log("El web Driver fue inicializado [ "+browser+" ]", true );
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("El driver no puede ser inicializado");
			}
}//end startWebDriver
	
	
	
	@Test(enabled = true, priority=3)
	public void LoginFallido() {
		txt_userName.sendKeys("Sergio");
		Reporter.log("El usuario fue ingresado correctamente");
		txt_password.sendKeys("Admin12345");
		Reporter.log("El password fue ingresado correctamente");
		btn_login.click();
		Reporter.log("se dio click en el boton de login");
		Assert.assertEquals(text_mensajeDeError.getText(), "Invalid credentials");
		Reporter.log(text_mensajeDeError.getText(),true);
	}
	
	
	
	
	
}
