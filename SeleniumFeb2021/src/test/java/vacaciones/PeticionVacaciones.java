package vacaciones;

import java.io.File;
import java.net.SocketException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
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
	public void pedirVacacionesCorrectamente() throws Exception {
		logger.info("=====================Pedir Vacaciones inicio===========================");
		driver = startWebDriver();
		page.getPage(Login.class).loginExistoso(userJS, passwordJS);
		page.getPage(Menu.class).seleccionaMenuSubMenu("Leave", "Assign Leave");
		
		
		logger.info("Usuiario Usado: "+ userJS+" Password Usado: "+ passwordJS);
		
	}
	
	
	@AfterTest
	public void cerrarExplorador() throws SocketException, InterruptedException{
		driver.close();
		logger.info("=====================Pedir Vacaciones Finalizo===========================");
	}
	
	
	
}
