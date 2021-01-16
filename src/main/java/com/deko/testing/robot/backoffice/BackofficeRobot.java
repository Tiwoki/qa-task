package com.deko.testing.robot.backoffice;

import com.deko.testing.robot.BaseRobot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BackofficeRobot extends BaseRobot {

    public BackofficeRobot(WebDriver driver) { super(driver);}

    @FindBy(name = "LoginForm")
    private WebElement loginForm;

    @FindBy(xpath = "//*[@placeholder = 'Username']")
    private WebElement usernameField;

    @FindBy(xpath = "//*[@placeholder = 'Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@class = \"btn btn-link forgotten-link\"]")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//*[contains(text(), 'Sign In')]")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@class = 'message-container']")
    private WebElement signInError;

    //todo: locate this webelement which will need to be used in later methods and tests.
    @FindBy()
    private WebElement resetPasswordField;

    //todo: locate this webelement which will need to be used in later methods and tests.
    @FindBy(xpath = "//*[contains(text(), 'Reset')]")
    private WebElement resetButton;

    //todo: locate this webelement which will need to be used in later methods and tests.
    @FindBy()
    private WebElement resetSignInButton;

    //todo: locate this webelement which will need to be used in later methods and tests.
    @FindBy()
    private WebElement resetSuccessText;

    @FindBy(xpath = "//*[@id=\"page-content-wrapper\"]/div[1]/div/div[2]/div[1]/h4")
    private WebElement successfulLogin;

    @FindBy(id = "top-bar")
    private WebElement backOfficeDashboardTopBar;

    private final String baseUrl = "https://release.dekopay.org/backoffice/v2/#/"; //insert provided test url here

    public BackofficeRobot openBackofficeLoginPage(){
        goTo(baseUrl);
        wait.until(ExpectedConditions.visibilityOf(this.loginForm));
        return this;
    }

    public BackofficeRobot fillLoginUsername(String username){
        type(usernameField, username);
        return this;
    }

    public BackofficeRobot fillLoginPassword(String password){
        type(passwordField, password);
        return this;
    }

    public BackofficeRobot submitLoginForm() {
        click(signInButton);
        //    waitUntilNotVisible(signInButton);
        return this;
    }

    public BackofficeRobot clickForgottenPasswordLink(){
        click(forgotPasswordLink);
        waitUntilURLContains("reset");
        return this;
    }

    public BackofficeRobot resetPassword(){
        //todo: Complete this method
        return this;
    }

    public boolean verifySignInError(String text){
        //todo: Complete this method, so that tests can pass in expected error text
        if (WebElementContains(signInError, text)) {
            return true;
        }
        return false;
    }

    public boolean verifyBackofficeUrl(){
        if (verifyURLContains("backoffice")){
            return true;
        }
        return false;
    }

    public boolean verifySuccessfulLogin(String text){
        //todo: Complete this verify method, to be used by test class
        if (WebElementContains(successfulLogin, text)) {
            return true;
        }
        return false;
    }

    public boolean verifyResetPasswordSuccess(){
        //todo: Complete this verify method, to be used by test class
        return false;
    }
}
