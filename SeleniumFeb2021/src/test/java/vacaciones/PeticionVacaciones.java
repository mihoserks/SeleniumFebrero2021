package vacaciones;

import java.io.File;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;

import comun.Base;
import comun.SpreadsheetUtil;
import loginHRM.Login;
import menuHRM.Menu;

public class PeticionVacaciones extends Base{

	public static Logger logger = Logger.getLogger(PeticionVacaciones.class);
	String path = System.getProperty("user.dir");
	WebDriver driver;
	String userJS, passwordJS, mensajeErrorJS;
	String userEx, passwordEx, mensajeErrorEx;
	
	
	@BeforeTest
	public void leerDatos() {
		System.setProperty("java.net.preferIPv4Stack", "true");
//		System.setProperty("Java.net.preferIPv4Stack" , "true");
		JsonNode nodeTree = readJsonFileByNode(path + "/data/json/data.json", "usuario1");
		userJS = nodeTree.path("user").asText();
		passwordJS = nodeTree.path("password").asText();
		mensajeErrorJS = nodeTree.path("mensajeError").asText();

		String fileName = path + "/data/excel/Test Data.xlsx";
		SpreadsheetUtil spreadsheet = new SpreadsheetUtil(new File(fileName));
		spreadsheet.switchToSheet("usuarios");

		userEx = spreadsheet.getCellData("User", 1);
		passwordEx = spreadsheet.getCellData("Password", 1);
		mensajeErrorEx = spreadsheet.getCellData("errorMessage", 1);

	}
	
	
	
	@Test(enabled = true, priority=1)
	public void pedirVacacionesCorrectamente()  {
		logger.info("=====================Pedir Vacaciones inicio===========================");
		driver = startWebDriver();
		page.getPage(Login.class).loginExistoso(userJS, passwordJS);
		page.getPage(Menu.class).seleccionaMenuSubMenu("Leave", "Assign Leave");
		
		
		logger.info("Usuiario Usado: "+ userJS+" Password Usado: "+ passwordJS);
		
	}
	
	@Parameters({"browser1", "url"})
	@Test(enabled = true, priority=2)
	public void pedirVacacionesCorrectamente1(String browser1, String url) throws Exception {
		logger.info("=====================Pedir Vacaciones inicio===========================");
		driver = startWebDriver(browser1, url);
		page.getPage(Login.class).loginExistoso(userJS, passwordJS);
		page.getPage(Menu.class).seleccionaMenuSubMenu("Leave", "Assign Leave");
		
		
		logger.info("Usuiario Usado: "+ userJS+" Password Usado: "+ passwordJS);
	
			closeBrowser();
		
	}
	
	@Parameters({"browser2", "url"})
	@Test(enabled = true, priority=3)
	public void pedirVacacionesCorrectamente2(String browser1, String url)  {
		logger.info("=====================Pedir Vacaciones inicio===========================");
		driver = startWebDriver(browser1, url);
		page.getPage(Login.class).loginExistoso(userJS, passwordJS);
		page.getPage(Menu.class).seleccionaMenuSubMenu("Leave", "Assign Leave");
		
		
		logger.info("Usuiario Usado: "+ userJS+" Password Usado: "+ passwordJS);
		closeBrowser();
		
	}
	
	@Parameters({"browser3", "url"})
	@Test(enabled = true, priority=4)
	public void pedirVacacionesCorrectamente3(String browser1, String url) {
		logger.info("=====================Pedir Vacaciones inicio===========================");
		driver = startWebDriver(browser1, url);
		page.getPage(Login.class).loginExistoso(userJS, passwordJS);
		page.getPage(Menu.class).seleccionaMenuSubMenu("Leave", "Assign Leave");
		
		
		logger.info("Usuiario Usado: "+ userJS+" Password Usado: "+ passwordJS);
		closeBrowser();
		
	}
	
	
	@AfterTest
	public void cerrarExplorador() {
		
		
		logger.info("=====================Pedir Vacaciones Finalizo===========================");
	}
	
	
	
}
