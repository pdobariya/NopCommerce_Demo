package Demo;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Clothing_Page extends Utils {
    public void priceHighToLow(){
        SoftAssert softAssert=new SoftAssert();  // object of softasser
        //selectByValue(By.id("products-orderby"),"http://demo.nopcommerce.com/clothing?orderby=11");
        selectByVisibleText(By.id("products-orderby"),"Price: High to Low");   // click on high to low product
        selectByVisibleText(By.id("products-pagesize"),"3");  // click on 3 per page
        System.out.println("Total Product Is 3");   // print
        List<WebElement> _countProducts=driver.findElements(By.xpath("/html/body/div[6]/div[3]/div[2]/div[2]/div/div[2]/div[3]/div/div")); // xpath of whole body
        System.out.println(_countProducts.size());  // print
        int size=_countProducts.size();  // counting the product
        WebElement abc=_countProducts.get(0);  //  storing value of produc

        String fristRowPrice=_countProducts.get(0).getText(); //  getting text from body
        String secondRowPrice=_countProducts.get(size-1).getText();   //
        double fristPrice=Double.parseDouble(fristRowPrice.replaceAll("[^0-9.]",""));  // remove everything except degite
        double secondPrice=Double.parseDouble(secondRowPrice.replaceAll("[^0-9.]",""));   //remove everything except degite
        Assert.assertTrue(fristPrice>secondPrice,"not soretd by high to low");   //  assert




    }

}
