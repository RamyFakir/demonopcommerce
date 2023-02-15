package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P02_login {

    public P02_login()
    {
        PageFactory.initElements(Hooks.driver,this);
    }

    @FindBy(css = "a[class=\"ico-login\"]")
    public WebElement logLink;

    @FindBy(id="Email")
    public WebElement Email;

    @FindBy(id="Password")
    public WebElement Pass;

    @FindBy(css = "button[class=\"button-1 login-button\"]")
    public WebElement loginButton;

    @FindBy(css ="a[href=\"/customer/info\"]")
    public WebElement MyAccount;

    @FindBy(css = "div[class=\"message-error validation-summary-errors\"]")
    public WebElement loginFailedMessage;

}
