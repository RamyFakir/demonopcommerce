package org.example.stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
public class D01_registerStepDef {

    P01_register registration = new P01_register();
    @Given("User go to register page")
    public void regPage()
    {
        registration.regLink.click();
    }

    @When("User select male gender")
    public void userSelectMaleGender() {
        registration.male.click();
    }

    @And("User enter {string} & {string}")
    public void userEnter(String firstName, String lastName) {
        registration.firsName.sendKeys(firstName);
        registration.lastName.sendKeys(lastName);

    }

    @And("User enter date of birth")
    public void userEnterDateOfBirth() {
        Select selectDay =new Select(registration.dayOfBirth);
        selectDay.selectByValue("1");

        Select selectMonth =new Select(registration.monthOfBirth);
        selectMonth.selectByValue("2");

        Select selectYear =new Select(registration.yearOfBirth);
        selectYear.selectByVisibleText("1986");
    }

    @And("User enter email")
    public void userEnter() {
        Faker fake = new Faker();
        String email = fake.internet().safeEmailAddress();
        registration.email.sendKeys(email);
    }

    @And("User enter password {string}")
    public void userEnterPassword(String password) {
        registration.password.sendKeys(password);
        registration.confirmPassword.sendKeys(password);

    }

    @And("User click on register button")
    public void userClickOnRegisterButton() {
        registration.registerButton.click();


    }

    @Then("account is created successfully")
    public void accountIsCreatedSuccessfully() {

        SoftAssert soft = new SoftAssert();
        soft.assertTrue(registration.successMsg.getText().toLowerCase().contains("your registration completed"));

        String textColor = registration.successMsg.getCssValue("color");
        soft.assertEquals(Color.fromString(textColor).asHex(),"#4cb17c");

        soft.assertAll();
    }


}
