#Author: your.email@your.domain.com

Feature: Login and Search features
  I use this to login at Amazon.com.mx search for Samsung Galaxy S9 64GB and Alienware Aw3418DW validate prices and add products to the chart.

  
  Scenario: Tc_Login_Searching_AddingCart
    Given I navigate to the home page
    And I click Identificarse button
    And I enter the correo as "norberto.cabrera@unosquare.com" and password as "T357T357"
    And I search for "Samsung Galaxy S9 64GB" compare the price and add to chart
    Then I search for "Alienware Aw3418DW" and add to chart and compare number of products
    And I close the page
    
 