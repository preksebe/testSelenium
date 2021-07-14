Feature: The checkout function up to filling the address


  Scenario:The user checksOut with products in the cart
    Given The user is on pearson assessments
    And The user is signed in
    And the user added One product to the card
    And the user goes on the cart page
    When the user clicks on the checkout button
    Then the user is taken to the account selection page
    When The user selects myAccount
    And the user clicks on the NEXT button
    Then the user is taken to the billing Address page
    When the user fills the billing address
    And the user clicks on the Submit Address NEXT button
    And the user clicks on the SHipping Method NEXT button
    And the credit card info modal appears
    And the user fills in the credit card info
    And the user checks the terms and conditions checkbox
    Then The place order button is clickable

