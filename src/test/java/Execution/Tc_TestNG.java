package Execution;

import org.testng.annotations.Test;

import Framework.BaseClass;
import Framework.HomePage;
import Framework.LoginPage;
import Framework.NavPage;


public class Tc_TestNG extends BaseClass {

	@Test
	public void Tc_Login_Searching_AddingCart() {
		//Click on "Identificarse" button
		HomePage HPage = new HomePage(driver);
	    HPage.identificarse();
	    
	    //Login with valid Credentials
	    LoginPage LPage = new LoginPage(driver);
        LPage.login(config_data[2], config_data[3]);
        
        //Searching_Validations_AddingCart
        NavPage NPage = new NavPage(driver);
        NPage.Search(config_data[4]);
        NPage.validation();
        NPage.addtochart();
        NPage.validationfinal(); 
        NPage.validationchart();
        NPage.Search(config_data[5]);
        NPage.selectitem2();
        NPage.addtochart();
        NPage.validationchart();
	}

}
