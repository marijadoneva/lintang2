package com.lintang2.pages;

import com.lintang2.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BookPage extends BasePage{

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> allRows;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement search;

    @FindBy(id = "book_categories")
    public WebElement mainCategoryElement;

    @FindBy(name = "name")
    public WebElement bookName;


    @FindBy(xpath = "(//input[@type='text'])[4]")
    public WebElement author;


    @FindBy(name = "year")
    public WebElement year;

    @FindBy(name = "isbn")
    public WebElement isbn;

    @FindBy(id = "description")
    public WebElement description;

    @FindBy(xpath = "//a[.=' Add Book']")
    public WebElement addBookButton;

    @FindBy(id = "book_group_id")
    public WebElement bookCategoriesDropdownNewBook;

    @FindBy(id="borrowed_books")
    public WebElement borrowedBooks;



    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@class='toast-message']")
    public WebElement toastMsg;

    @FindBy(xpath = "//div[@class='toast-message']")
    public WebElement borrowBook;


    public WebElement editBook(String book) {
        String xpath = "//td[3][.='" + book + "']/../td/a";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

}
