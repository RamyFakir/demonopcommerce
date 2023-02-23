package org.example.stepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D08_WishlistStepDef {
   P03_homePage wishlist = new P03_homePage();
    @When("user click on the wishlist button")
    public void userClickOnTheWishlistButton() {
       wishlist.heart.click();
    }

    @Then("a success message {string} appears")
    public void aSuccessMessageAppears(String successMessage)
    {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(wishlist.message.getText().toLowerCase().contains(successMessage));

        soft.assertAll();
    }

    @And("the message has a green background")
    public void theMessageHasAGreenBackground()
    { SoftAssert soft = new SoftAssert();
        String color = wishlist.bar.getCssValue("background-color");
        color = Color.fromString(color).asHex();
        soft.assertEquals(color,"#4bb07a");
        soft.assertAll();
    }

    @Then("after success message disappears user click on wishlist")
    public void afterSuccessMessageDisappearsUserClickOnWishlist()
    {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.invisibilityOf(wishlist.bar));
        wishlist.wishl.click();
    }
    @And("Qty is more than zero")
    public void qtyIsMoreThanZero()
    {
        String qty = wishlist.qty.getDomAttribute("value");
        Assert.assertTrue(Integer.parseInt(qty)>0);
    }

}
