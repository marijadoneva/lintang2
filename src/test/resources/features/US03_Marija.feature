@db @us3
Feature: As a data consumer, I want the UI and DB book categories are match.


  @db
  Scenario: verify book categories with DB
    Given the user logged in as "librarian"
    When the user navigates to "Books" page
    And the user clicks book categories
    Then verify book categories must match book_categories table from db

