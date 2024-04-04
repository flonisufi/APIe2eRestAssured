@Test

Feature: End to End API


  Scenario: Login Account
    Given User Payload with email "flonisufi1@gmail.com" and password "Pakokosare1"
    When User calls with Post and Login API http request
    Then The API call got success with status code 200

    Scenario: Create a Product
      Given User give params for a Product
      When User calls with Post and Create API http request
      Then The API Create call got success with status code 201

      Scenario: Create Order
        Given User Payload for an order
        When User calls with Post and Create Order http request
        Then The API Order call got success with status code 201

        Scenario: Delete Product
          Given User Delete a product
          When User call with Delete with http request
          Then The API Delete call got success with message
