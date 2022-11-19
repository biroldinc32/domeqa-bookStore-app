@smoke
Feature: User Verification And Add Book to Collection and Delete All Books
@wip
  Scenario Outline: Adding Book to Collection and Delete All Books
  Given  User create an account with using "<userName>" and "<password>"
  And    User generate a token with using "<userName>" and "<password>"
  And    User get authorized with using "<userName>" and "<password>"
  When   User add book which "<ISBN Number>" number book to the collection
  Then   User confirm that book is added to collection and delete all books from the collection

    Examples:
      | userName         | password             |ISBN Number  |
      | biroldinc18      | te85paTkLMpXP@XE      |9781449325862|

