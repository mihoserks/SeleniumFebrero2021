package vacaciones;

import java.io.File;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;

import comun.Base;
import comun.SpreadsheetUtil;
import leave.AssignLeave;
import loginHRM.Login;
import menuHRM.Menu;

public class PeticionVacaciones extends Base{

	public static Logger logger = Logger.getLogger(PeticionVacaciones.class);
	String path = System.getProperty("user.dir");
	WebDriver driver;
	String userJS, passwordJS, mensajeErrorJS;
	String userEx, passwordEx, mensajeErrorEx;
	String PORTAL_USERNAME, PORTAL_PASSWORD;
	
	
	@BeforeTest
	public void leerDatos() {
		System.setProperty("java.net.preferIPv4Stack", "true");
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
		logger.info("Usuiario Usado: "+ userJS+" Password Usado: "+ passwordJS);
		driver = startWebDriver();
		PORTAL_USERNAME = System.getProperty("PORTAL_USERNAME");
		PORTAL_PASSWORD = System.getProperty("PORTAL_PASSWORD");
		page.getPage(Login.class).loginExistoso(PORTAL_USERNAME, PORTAL_PASSWORD);
		page.getPage(Menu.class).seleccionaMenuSubMenu("Leave", "Assign Leave");
		page.getPage(AssignLeave.class).pedirVacacionesValidas("Orange Test", "US - Personal", "2021-04-19", "2021-04-19", "Full Day", "Comentario", "Employee does not have sufficient leave balance for leave request. Click OK to confirm leave assignment.");
		page.getPage(Menu.class).cerrarSession();

		
		
		
	}

	
	@AfterTest
	public void close() {
		closeBrowser();
	}

	
	
}
