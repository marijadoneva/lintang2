Feature:Books module
  As a students, I should be able to borrow book

  Scenario: Student borrow new book
    Given the user logged in as "student"
    And the user navigates to "Books" page
    And the user searches for "Head First Java" book

    When the user clicks Borrow Book
    Then verify that book is shown in "Borrowing Books” page
    And verify logged student has some book in database

