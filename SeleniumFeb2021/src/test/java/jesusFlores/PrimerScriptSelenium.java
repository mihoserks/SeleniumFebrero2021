package jesusFlores;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PrimerScriptSelenium {
	
	public static WebDriver driver;
	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		option.addArguments("--incognito");
		System.setProperty("webdriver.chrome.driver", "chromedriver\\chromedriver.exe");
	
	driver = new ChromeDriver(option);
	driver.get("https://opensource-demo.orangehrmlive.com/");
	driver.close();
	}

}
