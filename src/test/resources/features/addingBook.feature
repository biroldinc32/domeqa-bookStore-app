
Feature: https://demoqa.com Book Store Application
  Adding a book to Collection

  Background: User goes to the application page and login
    Given User goes to web page
    Then User login to the application successfully

  Scenario: Users should be able to add a book theirs Collection
    Then select a book from the bookstore
    Then click add your collection button
    Then click profile button
    And verify that selected book is added to the collection

  Scenario: Users should be able to delete a book from their Collection
    Then select a book from the bookstore
    Then click add your collection button
    Then click profile button
    And click garbage icon and click OK button the book
    And verify that the book is deleted from the collection