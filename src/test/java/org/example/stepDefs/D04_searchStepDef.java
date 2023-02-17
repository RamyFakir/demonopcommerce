package org.example.stepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D04_searchStepDef {
    P03_homePage search = new P03_homePage();
    String product;
    @When("user enter {string}")
    public void userEnter(String productName)
    { //search.searchBox.click();
        search.searchBox.sendKeys(productName);
        product=productName;

    }

    @And("user click on search button")
    public void userClickOnSearchButton()
    {
        search.searchButton.click();
    }

     @Then("current url contains {string}")
    public void currentUrlContains(String expectedUrl)
    {
        SoftAssert soft = new SoftAssert();
        String currentUrl = Hooks.driver.getCurrentUrl();
        soft.assertTrue(currentUrl.toLowerCase().contains(expectedUrl));


        soft.assertAll();
    }

    @And("relevant product objects appear")
    public void relevantProductObjectsAppear() {
        SoftAssert soft = new SoftAssert();
        int size = Hooks.driver.findElements(By.cssSelector(search.searchSelector)).size();
        System.out.println(size);
        for (int i=0;i<size;i++){
            String text=Hooks.driver.findElements(By.cssSelector(search.searchSelector)).get(i).getText().toLowerCase();
            System.out.println(text);
            soft.assertTrue(text.contains(product));
        }
        soft.assertAll();
    }

    @And("user click on relevant product")
    public void userClickOnRelevantProduct()
    {
        search.picture.click();
    }

    @Then("product sku is the same as what user entered")
    public void productSkuIsTheSameAsWhatUserEntered()
    {
        Assert.assertTrue(product.contains(search.sku.getText().toUpperCase()));
        System.out.println(product);
        System.out.println(search.sku.getText());
    }


}
