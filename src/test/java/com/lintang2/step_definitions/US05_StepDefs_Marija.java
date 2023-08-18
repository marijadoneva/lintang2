package com.lintang2.step_definitions;

import com.lintang2.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class US05_StepDefs_Marija {

    String expected;

    @Given("Establish the database connection")
    public void establish_the_database_connection() {

        System.out.println("Connecting to database...");
        DB_Util.createConnection();


    }
    @When("I execute query to find most popular book genre")
    public void i_execute_query_to_find_most_popular_book_genre() {

        DB_Util.runQuery("select bc.name, count(book_category_id) from book_borrow\n" +
                "join books b on book_borrow.book_id = b.id\n" +
                "join book_categories bc on b.book_category_id = bc.id\n" +
                "group by book_category_id\n" +
                "order by count(book_category_id) desc");

        expected = DB_Util.getFirstRowFirstColumn();
    }
    @Then("verify {string} is the most popular book genre")
    public void verify_is_the_most_popular_book_genre(String actual) {

        Assert.assertEquals(expected,actual);
    }

}
