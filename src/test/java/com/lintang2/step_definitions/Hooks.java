package com.lintang2.step_definitions;

import com.lintang2.utilities.ConfigurationReader;
import com.lintang2.utilities.DB_Util;
import com.lintang2.utilities.Driver;
import io.cucumber.java.Scenario;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {
    @Before
    public void setUp(){

        System.out.println("this is coming from BEFORE");
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(ConfigurationReader.getProperty("library_url"));


    }

    @After
    public void tearDown(Scenario scenario){
        System.out.println("this is coming from AFTER");

        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }

        Driver.closeDriver();
    }

    @io.cucumber.java.Before("@db")
    public void setupDB(){
        System.out.println("Connecting to database...");
        DB_Util.createConnection();
    }

    @io.cucumber.java.After("@db")
    public void closeDB(){
        System.out.println("Closing DB connection...");
        DB_Util.destroy();
    }
}
