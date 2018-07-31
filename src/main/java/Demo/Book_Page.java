package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class Book_Page extends Utils {
    public void orderBookAndCheckOut() {
        selectByVisibleText(By.id("products-orderby"), "Name: A to Z");     // click on book
        clickElement(By.xpath("//input[@value='Add to cart']"));    // click add to cart
        clickElement(By.className("cart-label"));       // click on shpoping cart button
        clickElement(By.id("termsofservice"));     //  click on agree times and condition
        clickElement(By.id("checkout"));    // click on check out
        clickElement(By.xpath("//div[3]/input"));    // click on check out as a guest
        enterText(By.id("BillingNewAddress_FirstName"), "angel");    // enter first name
        enterText(By.id("BillingNewAddress_LastName"), "doshi");    // anter last name
        enterText(By.id("BillingNewAddress_Email"), "angeldoshi2@gmail.com");      //enter email address
        selectByVisibleText(By.id("BillingNewAddress_CountryId"), "United Kingdom");    //enter country name
        enterText(By.id("BillingNewAddress_City"), "london");    // enter city name
        enterText(By.id("BillingNewAddress_Address1"), "51,carpenders park");     // enter address
        enterText(By.id("BillingNewAddress_ZipPostalCode"), "ha0 2hl");     // enter postcode
        enterText(By.id("BillingNewAddress_PhoneNumber"), "07518367875");    // enter mobile number
        clickElement(By.xpath("//input[@value='Continue']"));    // click on countinue
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {     // 3 second sleep
            e.printStackTrace();
        }
        System.out.println("fill the details");
        clickElement(By.xpath("(//input[@value='Continue'])[3]"));     //click on continue
        clickElement(By.id("paymentmethod_1"));     // click on credit card
        clickElement(By.xpath("(//input[@value='Continue'])[4]"));  //click on countinue
        enterText(By.id("CardholderName"), "angel");   //  click on card holdername
        enterText(By.id("CardNumber"), "4532461796446428");  //click on card number
        selectByVisibleText(By.id("ExpireYear"), "2022");   // select expire year
        enterText(By.id("CardCode"), "502");    //enter card code number
        clickElement(By.xpath("(//input[@value='Continue'])[5]"));   // click on countinue

                try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickElement(By.xpath("//input[@value='Confirm']"));      //click on confirm
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("your order details is completed");   //

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  // implicity wait
       // String actualMsg = driver.findElement(By.tagName("body")).getText();  // store get text in actualmsg
        //System.out.println(driver.getCurrentUrl());
        //Assert.assertTrue(actualMsg.contains("Thank you"));  // assert
    }
}
