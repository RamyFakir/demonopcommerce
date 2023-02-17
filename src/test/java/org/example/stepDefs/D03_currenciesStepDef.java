package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class D03_currenciesStepDef {
    P03_homePage currency = new P03_homePage();
    @When("user change currency to Euro")
    public void userClickOnCurrencyDropdownMenu()
    {
        Select droplist = new Select(currency.currency);
        droplist.selectByVisibleText("Euro");

    }

    @Then("currency changes to Euro")
    public void currencyChangesToEuro()
    {   List<WebElement> list =Hooks.driver.findElements(By.cssSelector(currency.currencySelect));
        for(int i=0;i<4;i++){
            String element = list.get(i).getText();
            Assert.assertTrue(element.contains("€"));
        }



    }


}
