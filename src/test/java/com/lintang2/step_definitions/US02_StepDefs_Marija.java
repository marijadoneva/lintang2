package com.lintang2.step_definitions;

import com.lintang2.pages.BookPage;
import com.lintang2.utilities.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.bouncycastle.cert.dane.DANEEntryStoreBuilder;
import org.junit.Assert;

import java.awt.print.Book;

public class US02_StepDefs_Marija {

    BookPage bookPage = new BookPage();
    String actualBorrowedBooks;

    @When("the librarian gets borrowed books number")
    public void the_librarian_gets_borrowed_books_number() {

        actualBorrowedBooks= bookPage.borrowedBooks.getText();
    }
    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {
        DB_Util.runQuery("SELECT COUNT(*) FROM book_borrow\n" +
                "WHERE is_returned=0");
        String expectedBorrowedBooks = DB_Util.getFirstRowFirstColumn();
        Assert.assertEquals(expectedBorrowedBooks,actualBorrowedBooks);
    }
}
