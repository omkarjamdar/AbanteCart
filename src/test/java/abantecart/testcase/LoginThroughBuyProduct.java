package abantecart.testcase;



import org.openqa.selenium.By;
import org.testng.annotations.Test;



import abantecart.utility.Utilities;



public class LoginThroughBuyProduct extends SetupDriver
{



@Test(priority=1)
public void login()
{
driver.get("http://localhost/public_html/");
Utilities util = new Utilities();
util.userLogin("Shetty_3579", "asdf1234", driver);
driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
HomePageTest H = new HomePageTest(driver);
H.searchBar();
}

@Test(priority=2)
public void productPage()
{
ProductPageTest Product = new ProductPageTest(driver);
Product.verifyAddToCart();
}

@Test(priority=3)
public void cartPage()
{
CartPageTest cart = new CartPageTest(driver);
cart.proccedToCheckout();

}

@Test(priority=4)
public void checkoutPage()
{
CheckoutConfirmOrderTest checkout = new CheckoutConfirmOrderTest(driver);
checkout.verifyConfirmOrderBtn();
}
}