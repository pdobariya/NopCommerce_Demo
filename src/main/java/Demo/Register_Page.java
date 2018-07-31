package Demo;

import org.openqa.selenium.By;

public class Register_Page extends Utils{
    public void registerUser(){
        String email= "angel"+randomDate()+"patel@gmail.com";    // made it dynamic email address
        System.out.println(email);

        clickElement(By.id("gender-female"));   // click on gender female
        enterText(By.id("FirstName"),"angel");  // enter first name
        enterText(By.id("LastName"),"patel");  // enter last name
        //waitForElementVIsible(By.id("thanks"),20);
        enterText(By.id("Email"),email);  // enter email
        enterText(By.id("Company"),"Unique Testing");  // enter the company name
        enterText(By.id("Password"),"patel1234");  // enter password
        enterText(By.id("ConfirmPassword"),"patel1234");  // enter confirm password
        clickElement(By.id("register-button"));  // click on register

    }
    public void logOut(){
        clickElement(By.linkText("Log out"));  // click on log out

    }
    public void registerWithoutEnterTheData(){
        clickElement(By.xpath("//input[@id='register-button']"));   // click on register without entering any data
    }
    public void sendEmailToFriend(){
        clickElement(By.name("register-continue"));   // click on ragister and continue
        clickElement(By.linkText("Apple MacBook Pro 13-inch"));  // click on Apple MacBook Pro 13-inch product
        clickElement(By.xpath("//input[@value='Email a friend']"));  // click on email a friend
        enterText(By.id("FriendEmail"),"poojapatel12@gmail.com");  // enter your friend email
        enterText(By.id("PersonalMessage"),"Hello pooja , Please check this item ");  // write a massage
        clickElement(By.name("send-email"));  // click on send email
    }
    public void submitAndVerifyTheReview(){
        clickElement(By.name("register-continue"));  // click on countinue
        clickElement(By.linkText("Apple MacBook Pro 13-inch"));   // select Apple MacBook Pro 13-inch
        clickElement(By.linkText("Add your review"));  // click on add your review
        enterText(By.id("AddProductReview_Title"),"Mac Book");   //  write add review title
        enterText(By.id("AddProductReview_ReviewText"),"hello, This Item Is Amazing And I Am so Happy To Buy It");  // write a comment
        clickElement(By.id("addproductrating_4"));  // give a star  4
        clickElement(By.name("add-review"));   // click on add review





    }
}
