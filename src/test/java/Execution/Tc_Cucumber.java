package Execution;

import Framework.BaseClass;
import Framework.HomePage;
import Framework.LoginPage;
import Framework.NavPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Tc_Cucumber extends BaseClass{

	@Given("^I navigate to the home page$")
	public void i_navigate_to_the_home_page() throws Throwable {
		setup();
		
	    
	}

	@And("^I click Identificarse button$")
	public void i_click_Identificarse_button() throws Throwable {
		HomePage HPage = new HomePage(driver);
	    HPage.identificarse();
	    
	}


	@And("^I enter the correo as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void i_enter_the_correo_as_and_password_as(String arg1, String arg2) throws Throwable {
		LoginPage LPage = new LoginPage(driver);
        LPage.login(arg1, arg2);
	}

	@And("^I search for \"([^\"]*)\" compare the price and add to chart$")
	public void i_search_for(String arg1) throws Throwable {
		NavPage NPage = new NavPage(driver);
        NPage.Search(arg1);
        NPage.validation();
        NPage.addtochart();
        NPage.validationfinal(); 
        NPage.validationchart();
	    
	}
	
	@Then("^I search for \"([^\"]*)\" and add to chart and compare number of products$")
	public void i_search_for_and_add_to_chart_and_compare_number_of_products(String arg1) throws Throwable {
		NavPage NPage = new NavPage(driver);
		NPage.Search(arg1);
        NPage.selectitem2();
        NPage.addtochart();
        NPage.validationchart();
	}

	@And("^I close the page$")
	public void close_page() throws Throwable {
		driver.quit();
	}

}
