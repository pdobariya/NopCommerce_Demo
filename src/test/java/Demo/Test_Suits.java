package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Suits extends BaseTest{
    Register_Page register_page=new Register_Page();
    HomePage homePage=new HomePage();
    Utils utils=new Utils();

    String registerComfirmExpectedMSG="Your registration completed";
    String productToSearch="Laptop";
    DropDown_Currency dropDown_currency=new DropDown_Currency();
    Clothing_Page clothing_page=new Clothing_Page();
    Book_Page book_page=new Book_Page();
    String expectedResult = "Thank you";
    @Test
    public void userShouldBeAbleToOrderBookAndCheckOutSuccessfully(){
        homePage.navigateToBookPage();
        book_page.orderBookAndCheckOut();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(),expectedResult);
        Assert.assertEquals(driver.findElement(By.xpath("//strong")).getText(),"Your order has been successfully processed!");
        System.out.println("your msg has been sent");
        }
        @Test
    public void userShouldBeAbleToSelectSortByPriceHighToLow(){
        homePage.navigateToClothingPage();
        clothing_page.priceHighToLow();
    }
    @Test
    public  void userCanSeeConvertedCurrenceyInEuro(){
        dropDown_currency.selectEuroCurrency();
        System.out.println("Currency change in euro");
        }
        @Test
    public void userCanSeeProductReviewIsSuccessfullyAdded(){
        homePage.navigateToRegisterPage();
        register_page.registerUser();
        register_page.submitAndVerifyTheReview();
        System.out.println("Your Review has been Sent Successfully");
        }
    @Test
    public void userShouldAbleToSendEmailToFriendAndSeeTheMessageSuccessfully(){
        homePage.navigateToRegisterPage();
       register_page.registerUser();
        register_page.sendEmailToFriend();
        utils.asserEquals(By.className("result"),"Your message has been sent.");
        System.out.println("Your message has been sent.");
    }
    @Test
    public void userShouldAbleToClearTheProductListAndVerifyTheErrorMassageSuccessfully() throws InterruptedException {
        homePage.compareTheProduct();
        homePage.ClearTheListOfProductComparing();
        utils.asserEquals(By.className("no-data"),"You have no items to compare.");
        System.out.println("You have no items to compare. (pass)");
        }
        @Test
    public void userShouldAbleToCompareTheProductSuccessfully() throws InterruptedException {
        homePage.compareTheProduct();
        utils.asserEquals(By.xpath("//h1"),"Compare products");
        System.out.println("You Have Compare Your Product Successfully ");
    }
    @Test
    public void userShouldAbleToSeeAppleICamAddInShoppingCart(){
       homePage.addToCardItem();
        System.out.println("Your Item Is Added in Cart Successfully");

    }
    @Test
    public void userShouldVisibleAllTheRedErrorMassageOnRagisterPageWhithoutInsertTheData(){
        homePage.navigateToRegisterPage();
        register_page.registerWithoutEnterTheData();
        utils.asserEquals(By.xpath("//span[2]/span"),"First name is required.");
        utils.asserEquals(By.xpath("//div[3]/span[2]/span"),"Last name is required.");
        utils.asserEquals(By.xpath("//div[5]/span[2]/span"),"Email is required.");
        utils.asserEquals(By.xpath("//div[4]/div[2]/div/span[2]/span"),"Password is required.");
        utils.asserEquals(By.xpath("//div[4]/div[2]/div[2]/span[2]/span"),"Password is required.");
        System.out.println("Your Test Case Is Pass");
    }
    @Test
    public void userShouldAbleToSeeItemInWhishlistCartSucessfully(){

       homePage.clickOnWishListItem();
        System.out.println(driver.findElement(By.cssSelector("p.content")).getText());
        utils.assertTrue(By.cssSelector("p.content"),"The product has been added to your wishlist");
        System.out.println("The product has been added to your wishlist");
    }
    @Test
    public void userShouldBeLogOutSuccessfully(){
        homePage.navigateToRegisterPage();
        register_page.registerUser();
        register_page.logOut();
        String actualLOginButtenText=driver.findElement(By.className("ico-login")).getText();
        System.out.println(actualLOginButtenText);
        Assert.assertEquals(actualLOginButtenText,"Log in");
    }
    @Test
    public void userShouldBeAbleToSearchProductSuccessfully(){
        homePage.searchProduct(productToSearch);
        String expectedUrlAfterSearch = "http://demo.nopcommerce.com/search?q="+"product name";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrlAfterSearch);
        System.out.println("Laptop");
    }
    @Test
    public void userShouldBeAbleToRegisterSuccessfully(){
        homePage.navigateToRegisterPage();
        register_page.registerUser();
        String acualMsg=driver.findElement(By.cssSelector("div.result")).getText();
        Assert.assertEquals(acualMsg,registerComfirmExpectedMSG);
        System.out.println("Your registration completed");
    }

}
