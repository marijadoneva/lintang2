package com.lintang2.step_definitions;

import com.lintang2.utilities.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class US01_StepDefs_Marija {

    String expected;
    List<String> expectedColumnNames;
    @When("Execute query to get all IDs from users")
    public void executeQueryToGetAllIDsFromUsers() {
        DB_Util.runQuery("select count(id) from users");
        expected = DB_Util.getFirstRowFirstColumn();
    }

    @Then("verify all users has unique ID")
    public void verifyAllUsersHasUniqueID() {
        DB_Util.runQuery("select count(distinct id) from users");
        String actual = DB_Util.getFirstRowFirstColumn();

        Assert.assertEquals(expected,actual);
    }

    @When("Execute query to get all columns")
    public void executeQueryToGetAllColumns() {
        DB_Util.runQuery("select * from users");
        expectedColumnNames= DB_Util.getAllColumnNamesAsList();

    }

    @Then("verify the below columns are listed in result")
    public void verifyTheBelowColumnsAreListedInResult(List<String> actualColumnNames) {

        for (String actualColumnName : actualColumnNames) {
            System.out.println("actualColumnName = " + actualColumnName);
        }

        Assert.assertEquals(expectedColumnNames,actualColumnNames);
    }

}
