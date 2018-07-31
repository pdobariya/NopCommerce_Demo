package Demo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BaseTest extends BasePage {


    @BeforeMethod
    public void openBrowser(){
        String browser = "firefox";
        System.setProperty("webdriver.gecko.driver","src\\test\\Resources\\Browser_Driver\\geckodriver.exe");
        driver=new FirefoxDriver();
        driver.get("http://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }


}
