package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

	public static void main(String[] args) {
							//C:\Users\srv44\Feb2021\SeleniumFeb2021 \\chromedriver\\chromedriver.exe
		String rutaChrome = System.getProperty("user.dir") +"\\chromedriver\\chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver", rutaChrome);
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/");
		
		

	}

}
