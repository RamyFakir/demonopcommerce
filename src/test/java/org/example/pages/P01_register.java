package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P01_register {

    public P01_register()
    {
        PageFactory.initElements(Hooks.driver,this);
    }

    @FindBy(css = "a[href=\"/register?returnUrl=%2F\"]")
    public WebElement regLink;

    @FindBy(id="gender-male")
    public WebElement male;

    @FindBy(id="FirstName")
    public WebElement firsName;

    @FindBy(id="LastName")
    public WebElement lastName;

    @FindBy(name = "DateOfBirthDay")
    public WebElement dayOfBirth;
    @FindBy(name = "DateOfBirthMonth")
    public WebElement monthOfBirth;
    @FindBy(name = "DateOfBirthYear")
    public WebElement yearOfBirth;

    @FindBy(id="Email")
    public WebElement email;
    @FindBy(id="Password")
    public WebElement password;

    @FindBy(id="ConfirmPassword")
    public WebElement confirmPassword;

    @FindBy(id = "register-button")
    public WebElement registerButton;

    @FindBy(className = "result")
    public WebElement successMsg;

}
