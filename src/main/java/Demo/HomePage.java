package Demo;

import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;


public class HomePage extends Utils {
    public void navigateToBookPage(){
        driver.get("http://demo.nopcommerce.com/books");
    }    // navigate to book page method


    public void navigateToClothingPage(){
        driver.get("http://demo.nopcommerce.com/clothing");
    }  //  navigate to clothing page
    public void navigateToRegisterPage(){    //  navigate To Register Page

        clickElement(By.linkText("Register"));  // click on ragister
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public void userOnRagisteredPage(){    // method of ragistered page
        driver.get("http://demo.nopcommerce.com/registerresult/1");   // get url
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  // implicity wait
    }

    public void searchProduct(String productName){   // method of serch product

        clickElement(By.id("small-searchterms"));  // click on serch box
        enterText(By.id("small-searchterms"),productName);  // enter the product name
        clickElement(By.xpath("//input[@value='Search']"));  // click on serch
    }
    public void compareTheProduct() throws InterruptedException {
        clickElement(By.xpath("//input[@value='Add to compare list']"));  // click on compare list of the 1st product
        Thread.sleep(3000);
        clickElement(By.xpath("(//input[@value='Add to compare list'])[2]"));  // click on compare list of the 2nd product
        clickElement(By.linkText("product comparison")); // click on product comparison


    }
    public void ClearTheListOfProductComparing(){
        clickElement(By.className("clear-list"));  // click on clear list

    }
    public void addToCardItem() {
        clickElement(By.xpath("//a[contains(text(),'Electronics')]"));  //  click on electronics
        clickElement(By.linkText("Camera & photo"));  // click on camera &  photo
        String prodcutSelected = driver.findElement(By.xpath("//div[2]/div/div[2]/h2/a")).getText();  // store the get text value in product serch
        clickElement(By.xpath("(//input[@value='Add to cart'])[2]"));  // click add to cart
        System.out.println("Item is added in shopping cart");
        asserEquals(By.className("content"), "The product has been added to your shopping cart"); // assert
//        clickElement(By.className("close"));
        waitForElementVIsible(By.linkText("shopping cart"), 10);  // wait to click for visible  shoping cart
        clickElement(By.linkText("shopping cart"));   // click on shoping cart
        waitForElementVIsible(By.cssSelector("a.product-name"), 10);  // wait for visible text

        String productInBasket = driver.findElement(By.cssSelector("a.product-name")).getText();   // storing value in product in bascket

        Assert.assertEquals(productInBasket, prodcutSelected);  // assert
    }
    public void clickOnWishListItem(){
        driver.getCurrentUrl().contains("http://demo.nopcommerce.com/");  //   get url
        clickElement(By.xpath("(//input[@value='Add to wishlist'])[3]"));  // click on wishlist
        waitForElementVIsible(By.cssSelector("p.content"),10); // wait for visible text
    }


    }
