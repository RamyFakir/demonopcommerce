package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class D05_hoverCategoriesStepDef {
    P03_homePage hover = new P03_homePage();
    String subCat;
    @When("user hover over random category")
    public void userHoverOverRandomCategory() throws InterruptedException {
        Actions actions=new Actions(Hooks.driver);
        List<WebElement> mainLinks = Hooks.driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li"));
        int min = 0;
        int max = 2;
        int selectedCategory =(int)Math.floor(Math.random()*(max-min+1)+min);
        actions.moveToElement(mainLinks.get(selectedCategory)).perform();
        String selectedCategoryText = mainLinks.get(selectedCategory).getText();
        String[] sub = selectedCategoryText.split("\n");
        int subMin = 1;
        int subMax = 3;
        int subSelectedCategory =(int)Math.floor(Math.random()*(subMax-subMin+1)+subMin);
        subCat= Hooks.driver.findElement(By.partialLinkText(sub[subSelectedCategory])).getText();
        Hooks.driver.findElement(By.partialLinkText(sub[subSelectedCategory])).click();
        //System.out.println(subCat);
        //System.out.println("selected category is : " +selectedCategoryText);
        //System.out.println("sub selected category is: " + Hooks.driver.findElement(By.cssSelector("div[class=\"page-title\"] h1")).getText());
        //Thread.sleep(2000);
    }

    @Then("confirm the sub category title")
    public void confirmTheSubCategoryTitle()
    {
        String pageTitle = Hooks.driver.findElement(By.cssSelector("div[class=\"page-title\"] h1")).getText();
        Assert.assertTrue(pageTitle.toLowerCase().contains(subCat.toLowerCase()));
    }
}
