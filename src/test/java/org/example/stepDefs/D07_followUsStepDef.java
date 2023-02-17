package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.Assert;

import java.util.ArrayList;

public class D07_followUsStepDef {

    P03_homePage followUs = new P03_homePage();


    @When("user opens facebook link")
    public void userOpensFacebookLink()
    {
        followUs.facebook.click();
    }

    @Then("{string} is opened in new tab")
    public void followUsIsOpenedInNewTab(String follow) throws InterruptedException {
        Thread.sleep(2000);
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());

        //4- switch driver from tab0 to tab1
        Hooks.driver.switchTo().window(tabs.get(1));
        System.out.println(Hooks.driver.getCurrentUrl());
        //5- getCurrentUrl and assert it contains facebook.com
        Thread.sleep(1000);
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains(follow));


    }

    @When("user opens twitter link")
    public void userOpensTwitterLink()
    {
        followUs.twitter.click();
    }

    @When("user opens rss link")
    public void userOpensRssLink() 
    {
        followUs.rss.click();
    }

    @When("user opens youtube link")
    public void userOpensYoutubeLink()
    {
        followUs.youtube.click();
    }
}
