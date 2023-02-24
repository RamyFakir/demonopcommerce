package org.example.pages;

import io.cucumber.java.en.When;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P03_homePage {
    public P03_homePage()
    {
        PageFactory.initElements(Hooks.driver,this);
    }

    //Currency
    @FindBy(id="customerCurrency")
    public WebElement currency;
    public String currencySelect= "span[class=\"price actual-price\"]";

    // Search
    @FindBy(id="small-searchterms")
    public WebElement searchBox;

    @FindBy(css = "button[type=\"submit\"]")
    public WebElement searchButton;

    public String searchSelector="h2[class=\"product-title\"]";

    @FindBy(className = "picture")
    public WebElement picture;

    @FindBy(css = "span[class=\"value\"]")
    public WebElement sku;
    // Sliders

    @FindBy(css = "a[href=\"https://demo.nopcommerce.com/\"]")
    public WebElement slider1;

    @FindBy(css = "a[href=\"https://demo.nopcommerce.com/\"]")
    public WebElement slider2;

    // hover over


    // Follow us

    @FindBy(css = "a[href=\"http://www.facebook.com/nopCommerce\"]")
    public WebElement facebook;

    @FindBy(css = "a[href=\"https://twitter.com/nopCommerce\"]")
    public WebElement twitter;

    @FindBy(css = "a[href=\"/news/rss/1\"]")
    public WebElement rss;

    @FindBy(css = "a[href=\"http://www.youtube.com/user/nopCommerce\"]")
    public WebElement youtube;

    // Wishlist
    @FindBy(css = "div[data-productid=\"18\"] button[class=\"button-2 add-to-wishlist-button\"]")
    public WebElement heart;

    @FindBy(className = "content")
    public WebElement message;

    @FindBy(css = "div[id=\"bar-notification\"] div[class=\"bar-notification success\"]")
    public WebElement bar;

    @FindBy(className = "wishlist-label")
    public WebElement wishl;

    @FindBy(css = "input[class=\"qty-input\"]")
    public WebElement qty;


}


