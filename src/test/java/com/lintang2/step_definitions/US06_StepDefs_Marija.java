package com.lintang2.step_definitions;

import com.lintang2.pages.BookPage;
import com.lintang2.utilities.BrowserUtil;
import com.lintang2.utilities.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class US06_StepDefs_Marija {

    BookPage bookPage = new BookPage();
    String bookName;
    String author;

    @When("the librarian click to add book")
    public void the_librarian_click_to_add_book() {
        bookPage.addBookButton.click();
    }
    @When("the librarian enter book name {string}")
    public void the_librarian_enter_book_name(String bookName) {
        bookPage.bookName.sendKeys(bookName);
        this.bookName=bookName;
    }
    @When("the librarian enter ISBN {string}")
    public void the_librarian_enter_isbn(String isbnNumber) {
        bookPage.isbn.sendKeys(isbnNumber);
    }
    @When("the librarian enter year {string}")
    public void the_librarian_enter_year(String year) {
        bookPage.year.sendKeys(year);
    }
    @When("the librarian enter author {string}")
    public void the_librarian_enter_author(String author) {
        bookPage.author.sendKeys(author);
        this.author=author;
    }
    @When("the librarian choose the book category {string}")
    public void the_librarian_choose_the_book_category(String bookCategory) {
       BrowserUtil.selectByVisibleText(bookPage.bookCategoriesDropdownNewBook, bookCategory);
       BrowserUtil.waitFor(5);
    }

    @When("the librarian click to save changes")
    public void the_librarian_click_to_save_changes() {
        bookPage.saveButton.click();
    }
    @Then("verify {string} message is displayed")
    public void verifyMessageIsDisplayed(String expectedMsg) {
        String actualMsg = bookPage.toastMsg.getText();
        Assert.assertEquals(expectedMsg, actualMsg);
    }
    @Then("verify {string} information must match with DB")
    public void verify_information_must_match_with_db(String expectedBookName) {

        DB_Util.runQuery("select name, isbn, year, author from books\n" +
                "where name='"+ bookName + "' and author='"+author+"'\n" +
                "order by id desc");
        String actualBookName = DB_Util.getFirstRowFirstColumn();
        Assert.assertEquals(expectedBookName,actualBookName);
    }



}
