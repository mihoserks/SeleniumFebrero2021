package loginHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import comun.Base;

public class Login extends Base{
	
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
	
	
	/**
	 * @Description Metodo para hacer un login exitosos y validar que estemos dentro
	 * @author sergio Ramones
	 * @date 10/04/2021
	 * @param String, Sting
	 * 
	 */
	public void loginExistoso(String user, String password) {
		
		ingresarTexto(txt_userName, user);
		ingresarTexto(txt_password, password);
		click(btn_login);
		takeScreenShot();
		waitForElement(link_welcome);
		if (verificarElementoExiste(link_welcome) == false) {
			Assert.fail("El Login No fue exitoso");

		}
	}// end method
	
	
	/**
	 * @Description Metodo para hacer un login exitosos y validar que estemos dentro
	 * @author sergio Ramones
	 * @date 10/04/2021
	 * @param String, Sting
	 * 
	 */
	public void loginError(String user, String password, String mensajeError) {
		highlighElement(txt_userName);
		ingresarTexto(txt_userName, user);
		highlighElement(txt_password);
		ingresarTexto(txt_password, password);
		highlighElement(btn_login);
		click(btn_login);
		
		highlighElement(text_mensajeDeError);
		takeScreenShot();
		Assert.assertEquals(text_mensajeDeError.getText(), mensajeError);

	}// end method
	
	
	

}
