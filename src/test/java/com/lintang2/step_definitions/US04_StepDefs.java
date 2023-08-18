package com.lintang2.step_definitions;

import com.lintang2.pages.BookPage;
import com.lintang2.utilities.BrowserUtil;
import com.lintang2.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.junit.Assert;


import java.util.List;
import java.util.Map;

public class US04_StepDefs {
    BookPage bookPage = new BookPage();
    @Given("the user navigates to {string} page")
    public void the_user_navigates_to_page(String moduleName) {
        bookPage.navigateModule(moduleName);
        BrowserUtil.waitFor(2);
    }



String cleaneBookName;
    @When("the user searches for {string} book")
    public void the_user_searches_for_book(String bookName) {
cleaneBookName = bookName;
bookPage.bookSearch(bookName);



    }
    @When("the user clicks edit book button")
    public void the_user_clicks_edit_book_button() {

        bookPage.editBook(cleaneBookName).click();
    }
    @Then("book information must match the Database")
    public void book_information_must_match_the_database() {
        String queryForSpecificBook = "SELECT * from books where name='Clean Code';";
        DB_Util.runQuery(queryForSpecificBook);
        Map<String, String> mapDataFromDB = DB_Util.getRowMap(1);
        System.out.println(mapDataFromDB);

        //get the name from DB
        String name_db = mapDataFromDB.get("name");
        //get name from ui
        BrowserUtil.waitFor(3);

        String name_ui = bookPage.getBookInfo("Book Name");
        Assert.assertEquals(name_db,name_ui);
        //get year from db
        String year_db = mapDataFromDB.get("year");
        //get year from ui
        String year_ui = bookPage.getBookInfo("Year");
        Assert.assertEquals(year_db,year_ui);

    }
}
