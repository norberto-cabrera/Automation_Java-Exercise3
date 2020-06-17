package Framework;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
WebDriver driver;
	
	public LoginPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="ap_email")
	WebElement Correo;
	
	@FindBy(id="continue")
	WebElement Continuar;
	
	@FindBy(id="ap_password")
	WebElement Contrasena;
	
	@FindBy(id="signInSubmit")
	WebElement Iniciar_Sesion;
	
	public void login (String correo, String pass) {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(Correo));
		Correo.sendKeys(correo);
		wait.until(ExpectedConditions.visibilityOf(Continuar));
		Continuar.click();
		wait.until(ExpectedConditions.visibilityOf(Contrasena));
		Contrasena.sendKeys(pass);
		wait.until(ExpectedConditions.visibilityOf(Iniciar_Sesion));
		Iniciar_Sesion.click();
		//try {
		    //TimeUnit.SECONDS.sleep(20);
		//} catch (InterruptedException ie) {
		  //  Thread.currentThread().interrupt();
		//}
	}

}
