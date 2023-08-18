package com.lintang2.step_definitions;

import com.lintang2.pages.BookPage;
import com.lintang2.utilities.BrowserUtil;
import com.lintang2.utilities.DB_Util;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class US04_StepDefs_Marija {

    BookPage bookPage = new BookPage();
    String isbn;
    String year;
    String author;

    String bookCategory;

    String bookName;
    @When("the user searches for {string} book")
    public void the_user_searches_for_book(String bookTitle) {
        bookPage.search.sendKeys(bookTitle+ Keys.ENTER);
        this.bookName = bookTitle;
        BrowserUtil.waitFor(2);
    }
    @When("the user clicks edit book button")
    public void the_user_clicks_edit_book_button() {
        bookPage.editBook(bookName).click();

        BrowserUtil.waitFor(2);
    }


    @Then("book information must match the Database")
    public void book_information_must_match_the_database() {
        String actualBookName=bookPage.bookName.getAttribute("value");
        String actualIsbn = bookPage.isbn.getAttribute("value");
        String actualAuthor = bookPage.author.getAttribute("value");
        String actualYear = bookPage.year.getAttribute("value");


        DB_Util.runQuery("select * from books where name='"+bookName+"' and isbn=999239923");

       String expectedBookName = DB_Util.getCellValue(1,"name");
        String expectedIsbn = DB_Util.getCellValue(1,"isbn");
        String expectedYear = DB_Util.getCellValue(1,"year");
        String expectedAuthor = DB_Util.getCellValue(1,"author");

        Assert.assertEquals(expectedBookName,actualBookName);
        Assert.assertEquals(expectedAuthor,actualAuthor);
        Assert.assertEquals(expectedIsbn,actualIsbn);
        Assert.assertEquals(expectedYear,actualYear);


    }

}
