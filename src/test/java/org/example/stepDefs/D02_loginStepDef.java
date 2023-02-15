package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.example.pages.P02_login;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;


public class D02_loginStepDef {

    P02_login login = new P02_login();

      @Given("user go to login page")
        public void loginLink()
        {
           login.logLink.click();
        }
    // Positive scenario
    @When("user login with valid {string} and {string}")
    public void userLoginWithValidAnd(String email, String password)
    {
        login.Email.sendKeys(email);
        login.Pass.sendKeys(password);

    }

    @And("user press on login button")
    public void userPressOnLoginButton()
    {
        login.loginButton.click();
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully()
    {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(login.MyAccount.isDisplayed());
        soft.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/");

        soft.assertAll();
    }
   // Negative scenario
    @When("user login with invalid {string} and {string}")
    public void userLoginWithAnd(String invalidMail, String pass)
    {
        login.Email.sendKeys(invalidMail);
        login.Pass.sendKeys(pass);

    }

    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem()
    {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(login.loginFailedMessage.getText().toLowerCase().contains("login was unsuccessful"));
        String color = login.loginFailedMessage.getCssValue("color");
        color = Color.fromString(color).asHex();
        soft.assertEquals(color,"#e4434b");

        soft.assertAll();

    }


}
