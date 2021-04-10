package selenium;

import java.io.File;
import java.net.SocketException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;

import comun.Base;
import comun.SpreadsheetUtil;

public class SeleniumBase extends Base{
	WebDriver driver;
	
	
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
	public void initDriver() {
		driver = startWebDriver();
		PageFactory.initElements(driver, this);
//		page.getPage(SeleniumBase.class);
	}
	
	@Test(enabled = true, priority = 2)
	public void loginExitoso() throws SocketException, InterruptedException   {

		JsonNode nodeTree = readJsonFileByNode(System.getProperty("user.dir") + "/data/json/data.json", "usuario1");

		String userJson = nodeTree.path("user").asText();
		String passwordJson = nodeTree.path("password").asText();

		ingresarTexto(txt_userName, userJson);
		ingresarTexto(txt_password, passwordJson);
		click(btn_login);
		takeScreenShot();
		
		if (verificarElementoExiste(link_welcome) == false) {
			Assert.fail("El Login No fue exitoso");
			
		}

		
			closeBrowser();
	
	}
	
	@Test(enabled= true, priority=1)
	public void loginFallido(){

		String fileName = System.getProperty("user.dir") + "/data/excel/Test Data.xlsx";

		SpreadsheetUtil spreadsheet = new SpreadsheetUtil(new File(fileName));
		spreadsheet.switchToSheet("usuarios");

		String user = spreadsheet.getCellData("User", 2);
		String password = spreadsheet.getCellData("Password", 1);

		ingresarTexto(txt_userName, user);
		ingresarTexto(txt_password, password);
		highlighElement(txt_userName);
		highlighElement(txt_password);
		highlighElement(btn_login);
		click(btn_login);

		Assert.assertEquals(text_mensajeDeError.getText(), spreadsheet.getCellData("errorMessage", 1));
		highlighElement(text_mensajeDeError);

	}
	
	
//	@Test(enabled = true, priority=3)
//	public void LoginFallido() {
//		txt_userName.sendKeys("Sergio");
//		Reporter.log("El usuario fue ingresado correctamente");
//		txt_password.sendKeys("Admin12345");
//		Reporter.log("El password fue ingresado correctamente");
//		btn_login.click();
//		Reporter.log("se dio click en el boton de login");
//		Assert.assertEquals(text_mensajeDeError.getText(), "Invalid credentials");
//		Reporter.log(text_mensajeDeError.getText(),true);
//	}
}
