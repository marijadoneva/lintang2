package com.lintang2DBAutomation.step_definitions;
import com.lintang2DBAutomation.pages.US01_Page;
import com.lintang2DBAutomation.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US01_Definitions {


    US01_Page test_page = new US01_Page();


    @Given("Establish the database connection")
    public void establishTheDatabaseConnection() {
        //make a conn with library
        DB_Util.createConnection();
    }

    @When("Execute all columns")
    public void executeAllColumns() {
        String query = "Select count(distinct id) from users";
        DB_Util.runQuery(query);

        String expectedUserCount = DB_Util.getFirstRowFirstColumn();
        System.out.println(expectedUserCount);
    }

    @Then("verify the below columns are listed in result")
    public void verifyTheBelowColumnsAreListedInResult() {
        String actualUserCount = DB_Util.getFirstRowFirstColumn();
        System.out.println(actualUserCount);

        long expectedUserCount = 1;
        Assert.assertEquals(expectedUserCount,actualUserCount);
        System.out.println(actualUserCount);


    }

    @When("Execute query to get all IDs from users")
    public void executeQueryToGetAllIDsFromUsers() {

    }

    @Then("verify all users has unique ID")
    public void verifyAllUsersHasUniqueID() {

    }
}
