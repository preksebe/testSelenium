Feature: Sign in function with the functionality of the checkbox,
  pearson logo,store button, forgot pw,search icon display,
  and an emailField check.

  Scenario:The user signs in on pearson assessments.
    Given The user is on pearson assessments
    And The user closes the popups
    And The user maximises the window
    When The user clicks on the sign in Button
    Then The user is taken to the login page
    When The user inputs the login data
    And The user clicks on the login button
    Then The user is logged into pearson assessments
