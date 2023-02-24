package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class D06_homeSlidersStepDef {
    P03_homePage slider = new P03_homePage();
    @When("user click on first slider")
    public void userClickOnFirstSlider() {
        slider.slider1.click();
    }

    @Then("url changes to {string}")
    public void urlChangesTo(String url)
    {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.urlToBe(url));

    }


}
