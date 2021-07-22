package jesusFlores;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PrimerScriptSelenium {
	
	static String url = "https://opensource-demo.orangehrmlive.com/";
	static String usuario = "Admin";
	static String password = "admin123";
	
	public static WebDriver driver;
	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		option.addArguments("--incognito");
		
		System.setProperty("webdriver.chrome.driver", "chromedriver\\chromedriver.exe");
		driver = new ChromeDriver(option);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
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
		
		driver.close(); //"Cerrar el explorador"

	}

}
