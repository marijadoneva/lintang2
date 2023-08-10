package com.lintang2.step_definitions;

import com.lintang2.pages.BasePage;
import com.lintang2.pages.BookPage;
import com.lintang2.utilities.BrowserUtil;
import com.lintang2.utilities.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class US3_StepDefs {

    BookPage bookPage = new BookPage();
    List<String> actualBookCategories;


    @When("the user clicks book categories")
    public void the_user_clicks_book_categories() {

        bookPage.bookCategoriesDropdown.click();


        actualBookCategories = BrowserUtil.getAllSelectOptions(bookPage.bookCategoriesDropdown);


        actualBookCategories.remove(0);


        for (String actualBookCategory : actualBookCategories) {

            System.out.println(actualBookCategory);
        }

    }
    @Then("verify book categories must match book_categories table from db")
    public void verify_book_categories_must_match_book_categories_table_from_db() {

       DB_Util.runQuery("select name from book_categories");
       List<String> expectedBookCategories = DB_Util.getColumnDataAsList("name");
        for (String expectedBookCategory : expectedBookCategories) {
            System.out.println(expectedBookCategory);
        }

        Assert.assertEquals(expectedBookCategories,actualBookCategories);
    }



}
