package com.lintang2.pages;

import com.lintang2.utilities.ConfigurationReader;
import com.lintang2.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "inputEmail")
    public WebElement emailBox;

    @FindBy(id = "inputPassword")
    public WebElement passwordBox;

    @FindBy(tagName = "button")
    public WebElement loginButton;



    public void login(String userType){

        String username=ConfigurationReader.getProperty(userType+"_username");
        String password= ConfigurationReader.getProperty("password");


        emailBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();

    }

    public void login(String username,String password){

        emailBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();

    }
}
