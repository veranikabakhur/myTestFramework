package com.allbirds.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver ldriver){
        this.driver = ldriver;

    }

    @FindBy (name = "customer[email]") WebElement username;
    @FindBy (id = "CustomerPassword") WebElement password;
    @FindBy (xpath = "//input[@value='Sign In']") WebElement loginButton;

    @FindBy (id = "FirstName") WebElement firstName;
    @FindBy (id = "LastName1") WebElement lastName;
    @FindBy (id = "Email") WebElement email;
    @FindBy (id = "CreatePassword") WebElement createPassword;
    @FindBy (id = "CustomerPasswordConfirmation") WebElement confirmPassword;
    @FindBy (xpath = "//input[@value='Register']") WebElement registerButton;


    public void createAccount (String firstNameApp, String lastNameApp, String emailApp, String createPasswordApp, String confirmPasswordApp) {
        firstName.sendKeys(firstNameApp);
        lastName.sendKeys(lastNameApp);
        email.sendKeys(emailApp);
        createPassword.sendKeys(createPasswordApp);
        confirmPassword.sendKeys(confirmPasswordApp);
        registerButton.click();
    }

    public void logIn (String usernameApp, String passwordApp){
        username.sendKeys(usernameApp);
        password.sendKeys(passwordApp);
        loginButton.click();
    }





}
