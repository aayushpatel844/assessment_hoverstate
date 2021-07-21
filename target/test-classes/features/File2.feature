Feature: I want to search for a customer
  As a service advisor
  I want to search for a customer
  so I can sell or redeem a product


  Background: Logged in as a service advisor
    Given I navigate to "https://knrstn-cas-stg1.pegacloud.net/prweb"
    When I type my credentials
      | uid | Advisor1         |
      | pw  | JGJRTW1KZzlyLQ== |
    And I click on [login]
    Then I am logged into the "Service Lane"

  @regression
  Scenario Outline: I want to search for a customer using various search criteria
    Given the following search criteria:
      | VIN | Name | Phone | Email | Contract Number |
    When I search by "<field>" and "<search string>"
    Then I can locate contracts associated with 'John Locke'

    Examples:
      | field           | search string     |
      | VIN             | 5XXGT4L37KG367983 |
      | Name            | John Locke        |
      | Phone           | 1234567890        |
      | Email           | jl@jl.net         |
      | Contract Number | MS4005            |

  @regression
  Scenario Outline: I want a response when no products are associated with my search
    Given the following search criteria:
      | VIN | Name | Phone | Email | Contract Number |
    When I search by "<field>" and "<search string>"
    But there are no products associated with my search
    Then I will see "<response>"

    Examples:
      | field           | search string       | response                                                                   |
      | VIN             | 5XXGT4L37KG367985   | VIN failed to decode please try to re-enter or contact Kornerstone Support |
      | Name            | Timber Wolfe        | No products are available                                                  |
      | Phone           | 701-878-9999        | No products are available                                                  |
      | Email           | email9999@email.net | No products are available                                                  |
      | Contract Number | MS01                | No products are available                                                  |
