@smoke
Feature: User Verification And Add Book to Collection and Delete All Books

  Scenario Outline: Adding Book to Collection and Delete All Books
  Given  User create an account with using "<userName>" and "<password>"
  And    User generate a token with using "<userName>" and "<password>"
  And    User get authorized with using "<userName>" and "<password>"


    Examples:
      | userName         | password              |ISBN Number  |
      | biroldinc18      | te85paTkLMpXP@XE      |9781449325862|

