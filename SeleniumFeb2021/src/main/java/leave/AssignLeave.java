package leave;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import comun.Base;

public class AssignLeave extends Base{

	@FindBy(name="assignleave[txtEmployee][empName]")
	WebElement txt_name;
	
	@FindBy(id="assignleave_txtLeaveType")
	WebElement dp_leaveType;
	
	
	@FindBy(id="assignleave_txtFromDate")
	WebElement txt_fromDate;
	
	@FindBy(id="assignleave_txtToDate")
	WebElement txt_toDate;
	
	@FindBy(id="assignleave_duration_duration")
	WebElement dp_duration_duration;
	
	@FindBy(id="assignleave_txtComment")
	WebElement txt_comment;
	
	@FindBy(id="assignBtn")
	WebElement btn_assign;
	
	@FindBy(xpath="//div[@id='leaveBalanceConfirm']//p")
	WebElement text_mensaje;
	
	@FindBy(id="confirmOkButton")
	WebElement btn_ok;
	
	@FindBy(id="confirmCancelButton")
	WebElement btn_cancel;
	
	@FindBy(xpath="//div[@class='box single']//h1")
	WebElement text_header;
	
	
	/**
	 * @Description selecciona unsa vacaciones validas
	 * @Author Sergio Ramones
	 * @Date 17/04/2021
	 * @Parameter N/A
	 * @return N/A
	 * @throws StaleElementReferenceException, NoSuchElementException
	 */
	public void pedirVacacionesValidas(String name, String leaveType, String fromDate, String toDate, String Duration, String comment, String mensajeEsperado) {
		ingresarTexto(txt_name, name);
		click(dp_leaveType);
		selectDropdownByValue(dp_leaveType, leaveType);
		ingresarTexto(txt_fromDate, fromDate); 
		ingresarTexto(txt_toDate, toDate);
		selectDropdownByValue(dp_duration_duration, Duration);
		ingresarTexto(txt_comment, comment);
		takeScreenShot();
		click(btn_assign);

		if(verificarElementoExiste(text_header)==true) {
			Reporter.log("Las vacaciones fueron pedidas exitosamente", true);
			takeScreenShot();
		}else {
			Assert.fail("Las vacaciones no pudieron ser  pedidas exitosamente");
		}
	}
	
}
