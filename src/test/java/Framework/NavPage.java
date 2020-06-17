package Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class NavPage {

	
WebDriver driver;
String pricetxt;
String detpricetxt;
String finalpricetxt;
String itemstxt;
	
	public NavPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="twotabsearchtextbox")
	WebElement Search;
	
	@FindBy(xpath="//div//div//div//div[2]//div[1]//input[1]")
	WebElement Magnifier;
	
	@FindBy(xpath="//span[@class='a-price-whole'][contains(text(),'14,848')]")
	WebElement price;
	
	@FindBy(xpath="//span[@class='a-price-fraction'][contains(text(),'57')]")
	WebElement cents;
	
	
	@FindBy(xpath="//span[contains(text(),'Samsung Galaxy - Smartphone desbloqueado, Galaxy S')]")
	WebElement item1;
	
	@FindBy(id="price_inside_buybox")
	WebElement detprice;
	
	@FindBy(id="add-to-cart-button")
	WebElement cart;
	
	@FindBy(xpath="//div[@class='a-row a-spacing-micro']//span[@class='a-color-price hlb-price a-inline-block a-text-bold'][contains(text(),'$14,848.57')]")
	WebElement finalprice;
	
	@FindBy(id="nav-cart-count")
	WebElement items;
	
	@FindBy(xpath="//span[contains(text(),'Alienware AW2518HF Gaming Monitor de 25\", 1920 x 1')]")
	WebElement item2;
	
	public void Search (String Search1) {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(Search));
		Search.sendKeys(Search1);
		wait.until(ExpectedConditions.visibilityOf(Magnifier));
		Magnifier.click();
	}
	
	public void validation () {
	    WebDriverWait wait=new WebDriverWait(driver, 20);
	    try {
	    	wait.until(ExpectedConditions.visibilityOf(price));
			wait.until(ExpectedConditions.visibilityOf(cents));
			pricetxt = "$" + price.getText() + "." + cents.getText();
			wait.until(ExpectedConditions.visibilityOf(item1));
			item1.click();
			wait.until(ExpectedConditions.visibilityOf(detprice));
			detpricetxt = detprice.getText();
			System.out.println("First Validation");
			System.out.println("El Precio es: " + pricetxt);
			System.out.println("El Precio detalle es: " + detpricetxt);
			if(pricetxt.equals(detpricetxt))
			{
				System.out.println("El Precio es el mismo");	
			}
			else
			{
				System.out.println("El Precio es diferente");
			}
			Assert.assertEquals(pricetxt, detpricetxt, "El Precio es diferente");
	    } catch (Exception e) {
	    	System.out.println("El elemento no fue encontrado");
	    	Assert.fail("El elemento no fue encontrado");
	    }
		
	}
	
	
	public void addtochart () {
	    WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(cart));
		cart.click();
	}
	
	public void validationfinal () {
	    WebDriverWait wait=new WebDriverWait(driver, 20);
		try {
			wait.until(ExpectedConditions.visibilityOf(finalprice));
			finalpricetxt = finalprice.getText();
			System.out.println("\nSecond Validation");
			System.out.println("El Precio es: " + pricetxt);
			System.out.println("El Precio final es: " + finalpricetxt);
			if(pricetxt.equals(finalpricetxt))
			{
				System.out.println("El Precio es el mismo");	
			}
			else
			{
				System.out.println("El Precio es diferente");
			}
			Assert.assertEquals(pricetxt, finalpricetxt, "El Precio es diferente");
		} catch (Exception e) {
			System.out.println("El elemento no fue encontrado");
	    	Assert.fail("El elemento no fue encontrado");
		}
	}
	
	public void selectitem2 () {
		try {
			WebDriverWait wait=new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(item2));
			item2.click();
		} catch (Exception e) {
	    	System.out.println("El elemento no fue encontrado");
	    	Assert.fail("El elemento no fue encontrado");
	    }
	}
		
	
	public void validationchart () {
		  WebDriverWait wait=new WebDriverWait(driver, 20);
		  wait.until(ExpectedConditions.visibilityOf(items));
		  itemstxt = items.getText();
		  if(itemstxt.contains("1"))
		  {
			System.out.println("El Carrito solo contiene 1 elemento");
			Assert.assertTrue(itemstxt.contains("1"), "El Carrito no contiene 1 elemento");
		  }
		  else
		  {
			if(itemstxt.contains("2"))
			  {
				System.out.println("El Carrito contiene 2 elementos");
				Assert.assertTrue(itemstxt.contains("2"), "El Carrito no contiene 2 elementos");
			  }
		  }
	}
}
	
