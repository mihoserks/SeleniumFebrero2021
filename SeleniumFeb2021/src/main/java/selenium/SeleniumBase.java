package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import comun.Base;

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
	}
	
	@Test(enabled= true, priority=2)
	public void loginExitoso() {
		ingresarTexto(txt_userName,"Admin");
		ingresarTexto(txt_password,"admin123");
		click(btn_login);
		
		if (verificarElementoExiste(link_welcome) == false) {
			Assert.fail("El Login No fue exitoso");
		}
		
	}
	
	@Test(enabled= true, priority=1)
	public void loginFallido() {
		ingresarTexto(txt_userName,randomName());
		ingresarTexto(txt_password,randomNumber(3));
		click(btn_login);
		
		Assert.assertEquals(text_mensajeDeError.getText(), "Invalid credentials");
		
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
