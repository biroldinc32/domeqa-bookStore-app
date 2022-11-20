
Feature: https://demoqa.com Book Store Application

  Background: User goes to the application page and login
    Given User goes to web page
    And User login to the application successfully
@wip
  Scenario: Users should be able to add a book theirs Collection
    When select a book from the bookstore
    And click add your collection button
    And click profile button
    Then verify that selected book is added to the collection

  Scenario: Users should be able to delete a book from their Collection
    Then select a book from the bookstore
    Then click add your collection button
    Then click profile button
    And click garbage icon and click OK button the book
    And verify that the book is deleted from the collection