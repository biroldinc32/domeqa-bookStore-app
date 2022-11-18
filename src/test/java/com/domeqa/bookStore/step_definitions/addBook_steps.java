package com.domeqa.bookStore.step_definitions;


import com.domeqa.bookStore.pages.Demoqa;
import com.domeqa.bookStore.pages.ProfilePage;
import com.domeqa.bookStore.utilities.BrowserUtils;
import com.domeqa.bookStore.utilities.ConfigurationReader;
import com.domeqa.bookStore.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;

public class addBook_steps {

   Demoqa demoqa = new Demoqa();
   ProfilePage profilePage = new ProfilePage();

   @Given("User goes to web page")
   public void user_goes_to_web_page() {
      Driver.getDriver().get(ConfigurationReader.getProperty("app.url"));
      demoqa.bookStoreApplication.click();
   }
   @Then("User login to the application successfully")
   public void user_login_to_the_application_successfully() {
      demoqa.loginButton.click();
      BrowserUtils.sleep(2);
      demoqa.userInput.sendKeys(ConfigurationReader.getProperty("userName"));
      demoqa.userPassword.sendKeys(ConfigurationReader.getProperty("userPassword"));
      demoqa.loginButton.click();
   }

   @Then("select a book from the bookstore")
   public void select_a_book_from_the_bookstore() {
      BrowserUtils.waitFor(2);
      demoqa.book.click();

   }
   @Then("click add your collection button")
   public void click_add_your_collection_button() {
      JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
      jse.executeScript("window.scrollBy(0,350)");
      BrowserUtils.waitFor(3);
      demoqa.addToYourCollection.get(1).click();
      BrowserUtils.waitFor(2);
      Alert alert = Driver.getDriver().switchTo().alert();
      alert.accept();
   }
   @Then("click profile button")
   public void click_profile_button() {
      BrowserUtils.waitFor(3);
      JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
      js.executeScript("window.scrollBy(0,500)","");
      demoqa.profileButton.click();
   }
   @Then("verify that selected book is added to the collection")
   public void verify_that_selected_book_is_added_to_the_collection() {
      String expectedResult = "Git Pocket Guide";
      String actualResult = demoqa.storedBook.getText();
      Assert.assertEquals(expectedResult, actualResult);
   }

   @Then("click garbage icon and click OK button the book")
   public void click_garbage_icon_and_click_ok_button_the_book() {
      BrowserUtils.waitFor(4);
      demoqa.deleteButton.click();
      BrowserUtils.waitFor(3);
      demoqa.htmlAlertOKButton.click();

   }
   @Then("verify that the book is deleted from the collection")
   public void verify_that_the_book_is_deleted_from_the_collection() {
      String expectedResult = "No rows found";
      BrowserUtils.waitFor(3);
      Alert alert = Driver.getDriver().switchTo().alert();
      alert.accept();

     JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
     js.executeScript("window.scrollBy(0,500)","");
      Assert.assertEquals(expectedResult, demoqa.noRowsText.getText());
   }

}