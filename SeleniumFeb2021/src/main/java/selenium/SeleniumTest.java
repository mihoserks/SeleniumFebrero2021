package selenium;


import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import comun.LeerProperties;

public class SeleniumTest {
public static Logger log = Logger.getLogger(SeleniumTest.class);
static LeerProperties prop = new LeerProperties();

	public static void main(String[] args) {
		//C:\Users\srv44\Feb2021\SeleniumFeb2021 \\chromedriver\\chromedriver.exe
		String rutaChrome = System.getProperty("user.dir") +"\\chromedriver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", rutaChrome);
		//Options para abrir 
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		option.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(option);
//		driver.manage().window().maximize();
		//un implicit wait que nos sirve para demorar la ejecucion 
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
		prop.getSystemProperties();
		
		String url = System.getProperty("URL");
		
	
	
		driver.get(url);
		WebElement txt_usernameById = driver.findElement(By.id("txtUsername"));
		WebElement txt_usernamebyName = driver.findElement(By.name("txtUsername"));
		WebElement txt_userNameByXpath = driver.findElement(By.xpath("//div[@id='divUsername']/input"));
//		driver.findElement(By.cssSelector(""));
//		driver.findElement(By.tagName(""));
		txt_userNameByXpath.sendKeys("Admin");
		WebElement txt_password = driver.findElement(By.id("txtPassword"));
		txt_password.sendKeys("admin123");
		WebElement btn_login = driver.findElement(By.id("btnLogin"));
		btn_login.click();
		log.info("todo fue exitoso");
		
		try {
			WebElement link_welcome = driver.findElement(By.xpath("//a[@id='welcome']"));
		
			if(link_welcome.getSize()!=null) {
				System.out.println("El Login Fue exitoso");
			}
		
		
		}catch(NoSuchElementException e) {
			System.out.println("El Login No fue exitoso");
		}
		
		
		
		
		
	}//main
	
	public String randomName() {
		String[] gente = new String[] {"Sergio","Ivan"};
		
		return "";
	}

}
