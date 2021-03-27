package comun;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.Reporter;

public class Base {
	static LeerProperties prop = new LeerProperties();
	static WebDriver driver;
	static String path = System.getProperty("user.dir");
	
	/**
	 * @author Sergio
	 * @Date 27-03-2021
	 * @Description Este metodo Inicializa el web driver con lo que tenemos en el data.properties 
	 * @param N/A
	 * **/
	public WebDriver startWebDriver() {
		try {
			prop.getSystemProperties();

			String browser = System.getProperty("BROWSER");
			String url = System.getProperty("URL");
			switch (browser) {

			case "chrome":
				System.setProperty("webdriver.chrome.driver", path + "\\chromedriver\\chromedriver.exe");
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--start-maximized");
				option.addArguments("--incognito");
				driver = new ChromeDriver(option);
				driver.get(url);
				break;
			case "firefox":
				System.setProperty("webdriver.gecko.driver", path + "\\geckodriver\\geckodriver.exe");
				FirefoxOptions foption = new FirefoxOptions();
				foption.addArguments("--start-maximized");
				foption.addArguments("--incognito");
				driver = new FirefoxDriver(foption);
				driver.get(url);
				break;
			case "edge":
				System.setProperty("webdriver.edge.driver", path + "\\edgedriver\\msedgedriver.exe");
				EdgeOptions eoptions = new EdgeOptions();
				eoptions.addArguments("--start-maximized");
				eoptions.addArguments("--incognito");
				driver = new EdgeDriver(eoptions);
				driver.get(url);
				break;

			default:
				System.out.println("El driver [ " + browser + " ] no esta configurado para funcionar en este proyecto");
			}// end switch

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
			Reporter.log("El web Driver fue inicializado [ " + browser + " ]", true);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("El driver no puede ser inicializado");
		}

		return driver;
	}// end startWebDriver
	
	/**
	 * @author Sergio
	 * @Date 27-03-2021
	 * @Description Este metodo genera un nombre random 
	 * @param N/A
	 * **/
	public String randomName() {
		String[] people = new String[] { "Sergio", "Ivan", "John", "Marcus", "Henry", "Ismael", "Nishant", "Rakesh",
				"Carlos", "Felix", "Miriam", "Diana", "Adriana", "Alejandro", "Gaby", "Caro", "Melisa", "Aimee",
				"Nataly", "Fernando", "Thomas", "Fidel", "Javier", "Ricardo", "Monica", "Nidia", "Eddy", "Evert", "Ben",
				"Anu", "Shan", "Prathap","Rosa","Azucena" };
		
		List<String> names = Arrays.asList(people);
		
		Collections.shuffle(names);
		
		int index = new Random().nextInt(names.size());
		String randomName = names.get(index);
		
		return randomName;
	}
	
	
	/**
	 * @author Sergio
	 * @Date 27-03-2021
	 * @Description Este metodo genera un correo electronico unico 
	 * @param N/A
	 * **/
	public static String randomEmail() {
		Date date = new Date();
		
		List<String> names = new ArrayList<>();
		names.add("Sergio");
		names.add("Ivan");
		names.add("John");
		names.add("Marcus");
		names.add("Henry");
		names.add("Ismael");
		names.add("Nishant");
		names.add("Rakesh");
		names.add("Carlos");
		names.add("Felix");
		names.add("Miriam");
		names.add("Diana");
		names.add("Adriana");
		names.add("Alejandro");
		names.add("Gaby");
		names.add("Caro");
		names.add("Melisa");
		names.add("Aimee");
		names.add("Nataly");
		names.add("Fernando");
		names.add("Thomas");
		names.add("Fidel");
		names.add("Javier");
		names.add("Ricardo");
		names.add("Monica");
		names.add("Nidia");
		names.add("Eddy");
		names.add("Evert");
		names.add("Ben");
		names.add("Anu");
		names.add("Shan");
		names.add("Prathap");
		names.add("Rosa");
		names.add("Azucena");
		Collections.shuffle(names);
		
		int index = new Random().nextInt(names.size());
		DateFormat formatt = new SimpleDateFormat("HHmmssddMMyyyy");
		
		String randomName = names.get(index);

		return randomName+formatt.format(date)+"@gmail.com";
	}
	
	/**
	 * @author Sergio
	 * @Date 27-03-2021
	 * @Description Este metodo genera un numero random del tamaño que recibe por parametro 
	 * @param int
	 * **/
	public static String randomNumber(int length) {
		StringBuilder str = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < length; i++) {
			str.append(random.nextInt(10));
		}
		return str.toString();

	}//end 
	
	/**
	 * @author Sergio
	 * @Date 27-03-2021
	 * @Description Este metodo ingresa un texto en un WebElement
	 * @param WebElement
	 * @param String
	 * **/
	public void ingresarTexto(WebElement object, String texto) {
		try {	
				object.clear();
				object.sendKeys(texto);
				Reporter.log("El texto  se ingreso correctamente [ "+texto+" ]", true);
			
			
		}catch(NoSuchElementException e) {
			Reporter.log("El Texto no se pudo ingresar, web element no encontrado");
			Assert.fail("El Texto no se pudo ingresar, web element no encontrado");
		}
	}// ingresarTexto
	
	/**
	 * @author Sergio
	 * @Date 27-03-2021
	 * @Description Este metodo da click en un WebElement
	 * @param WebElement
	 **/
	public void click(WebElement object) {
		try {
			object.click();
			Reporter.log("Se dio click en el web element correctamente", true);

		} catch (NoSuchElementException e) {
			Reporter.log("No fue posible hacer click");
			Assert.fail("No fue posible hacer click");
		}
	}// end click

	/**
	 * @author Sergio
	 * @Date 27-03-2021
	 * @Description verifica que un WebElement exista
	 * @param WebElement
	 **/
	public boolean verificarElementoExiste(WebElement object) {
		try {
			object.getSize();
			Reporter.log("El Elemento existe", true);
			return true;
		} catch (NoSuchElementException e) {
			Reporter.log("El Elemento No existe");
			return false;
		}
	}//end verificarElementoExiste
}
