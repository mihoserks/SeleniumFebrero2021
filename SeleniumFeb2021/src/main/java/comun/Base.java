package comun;

import java.io.File;
import java.io.IOException;
import java.net.SocketException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Base {


	static LeerProperties prop = new LeerProperties();
	static WebDriver driver;
	static String path = System.getProperty("user.dir");
	public static InitPages page;
	
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
				foption.addArguments("-private");
				driver = new FirefoxDriver(foption);
				driver.get(url);
				break;
			case "edge":
				System.setProperty("webdriver.edge.driver", path + "\\edgedriver\\msedgedriver.exe");
				EdgeOptions eoptions = new EdgeOptions();
				eoptions.addArguments("--start-maximized");
				eoptions.addArguments("-inprivate");
				driver = new EdgeDriver(eoptions);
				driver.get(url);
				break;

			default:
				System.out.println("El driver [ " + browser + " ] no esta configurado para funcionar en este proyecto");
			}// end switch
			page = new InitPages(driver);
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
	 * @throws N/A
	 * @Description Click webElement with JScript.
	 * @Author Sergio Ramones
	 * @Date 09/04/2021
	 * @Parameter WebElement 
	 * @return N/A
	 */
	public void clickJScript(WebElement button) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", button);
	}
	
	/**
	 * @throws Exception
	 * @Description get text from the webElement
	 * @Author Sergio Ramones
	 * @Date 09/04/2021
	 * @Parameter WebElement, String
	 * @return N/A
	 */
	public String getText(WebElement element) throws Exception {
		String text = "no text yet";
		try {
			
			scroll(element);
			text = element.getText();
			Reporter.log("Text got form application is: " + text, true);
		} catch (Exception e) {
			Assert.fail("It's not possible to get the text: " + text);
			e.printStackTrace();
		}
		return text;
	}

	/**
	 * @author Sergio
	 * @Date 27-03-2021
	 * @Description verifica que un WebElement exista
	 * @param WebElement
	 **/
	public boolean verificarElementoExiste(WebElement object)  {
		try {
			object.getSize();
			Reporter.log("El Elemento existe", true);
			return true;
		} catch (NoSuchElementException e) {
			Reporter.log("El Elemento No existe");
			return false;
		}
	}//end verificarElementoExiste
	
	/**
	 * @Description scroll to web element
	 * @author Sergio.Ramones
	 * @Date 09/04/2021
	 * @parameter WebElement
	 * */
	public void scroll(WebElement webElement) throws Exception {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
			Reporter.log("Element was scroll into View",true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//
	
	
	/**
	 * @Description scroll to web element
	 * @author Sergio.Ramones
	 * @Date 09/04/2021
	 * @parameter WebElement
	 * */
	public static void highlighElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);

	}
	
	
	/**
	 * @Description verify element is present 
	 * @author Sergio.Ramones
	 * @Date 09/04/2021
	 * @parameter WebElement
	 * */
	public void elementIsVisible(WebElement webElement) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.visibilityOf(webElement));
			
			Reporter.log("Element is present in the page", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Description verify element is present 
	 * @author Sergio.Ramones
	 * @Date 09/04/2021
	 * @parameter text
	 * */
	public void titleIsPresent(String text) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.titleIs(text));
			
			Reporter.log("title is present in the page", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Description verify element is present 
	 * @author Sergio.Ramones
	 * @Date 09/04/2021
	 * @parameter N/A
	 * */
	   public void takeScreenShot() {
	  
		   	String path = System.getProperty("user.dir");
		   	path = path + "\\test-output\\screenshot\\";
	    	
		   	Calendar calendar = Calendar.getInstance();
	         SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
	         
	         File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    
	            try {
	                FileUtils.copyFile(scrFile, new File(path+"Screen_"+formater.format(calendar.getTime())+".png"));
	                System.out.println("***Placed screen shot in "+path+" ***");
	          
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	    }
	   
	   
	   /**
		 * @throws Exception
		 * @Description Read JSON file
		 * @Author Sergio Ramones
		 * @Date 09/04/2021
		 * @Parameter String, String
		 * @return JsonNode
		 * @implNote nodeTree.path("fieldName").asText()
		 */
		 public static JsonNode readJsonFileByNode(String jsonpath, String nodeName) {
			 JsonNode nodeTree = null;
			 try {
			 ObjectMapper mapper = new ObjectMapper();
			 JsonNode root = mapper.readTree(new File(jsonpath));
			 // Get Name
			 nodeTree = root.path(nodeName);
			 } catch (JsonGenerationException e) {
		            e.printStackTrace();
		        } catch (JsonMappingException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
			 return nodeTree;
		 }
		 
			/**
			 * @Description open New tab 
			 * @author Sergio.Ramones
			 * @Date 09/04/2021
			 * @parameter N/A
			 * */
		public void openNewtab() {
			((JavascriptExecutor)driver).executeScript("window.open()");
		}
		
		/**
		 * @throws Exception
		 * @Description change to the tab with the index
		 * @Author Sergio Ramones
		 * @Date 09/04/2021
		 * @Parameter int
		 * @return N/A
		 */
		public void switchToTab(int index) {
			 ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		     driver.switchTo().window(tab.get(index));
		}
		
		/**
		 * @Description navigate to URL
		 * @Author Sergio Ramones
		 * @Date 09/04/2021
		 * @Parameter String
		 * @return N/A
		 */
		public void navigateToURL(String url)  {
			driver.navigate().to(url);
			
		}
		
		/**
		 * @Description refresh the page and wait until load
		 * @Author Sergio Ramones
		 * @Date 09/04/2021
		 * @Parameter N/A
		 * @return N/A
		 */
		public void refreshPage() {
			driver.navigate().refresh();
		}
		
		/** 
		 * @throws Exception
		 * @Description click in the webElement
		 * @Author Sergio Ramones
		 * @Date 04/08/2021
		 * @Parameter List WebElement, text
		 * @return N/A
		 */
		public void selectElementByValue(List<WebElement> element, String text) throws Exception {
			try {
				elementIsVisible(element.get(0));
				for (int i = 0; i <= element.size(); i++) {

					if (i >= element.size()) {
						Assert.fail("The Text is not in the list: " + text);
						break;
					}

					if (element.get(i).getText().contains(text)) {
						scroll(element.get(i));
						click(element.get(i));
						break;
					}

				} // end for
				Reporter.log("The Element in the list was selected: " + text);

			} catch (Exception e) {
				Reporter.log("The Element is not the list: " + text);
				e.printStackTrace();
			}
		}
		
		
		/**
		 * @Description close browser
		 * @Author Sergio Ramones
		 * @Date 09/04/2021
		 * @Parameter N/A
		 * @return N/A
		 * @throws SocketException InterruptedException
		 */
		public void closeBrowser() throws SocketException, InterruptedException {

			Thread.sleep(2000);
			if (driver != null) {

//					driver.close();
				driver.quit();
				Thread.sleep(2000);
				Reporter.log("Driver was quited ", true);
			} else {
				Reporter.log("Driver was not found ", true);
			}

		}// end method
		 

	
}
