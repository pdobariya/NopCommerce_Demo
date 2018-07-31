package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class DropDown_Currency extends Utils{
    SoftAssert softAssert=new SoftAssert();

    public void selectEuroCurrency() {
        String currencySelected = "Euro";    // stored euro in astring
        String currencySymbol = "";   // stored blank in string
        selectByValue(By.id("customerCurrency"), "/changecurrency/6?returnurl=%2F");   // click on currency
        System.out.println("currency is changed");  // print
        if (currencySelected.equalsIgnoreCase("US Dollar")) {
            currencySymbol = "$";
        } else {
            currencySelected = "€";
        }
        //String currencyType = "$";
        List<WebElement> itemProduct = driver.findElements(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div")); //make object of itemproduct

        System.out.println(itemProduct.size());
        for (WebElement currency : itemProduct) {   // item product in currency
            String price = currency.findElement(By.xpath("div/div[2]/div[3]/div[1]/span")).getText(); //  price get text
            System.out.println(price);
            String symbolOfPrice = price.substring(0, 1);  // will so saparate first letter
          //  System.out.println(symbolOfPrice);
            softAssert.assertEquals(symbolOfPrice, currencySymbol);   // asser
        }

        //softAssert.assertAll();
    }}
