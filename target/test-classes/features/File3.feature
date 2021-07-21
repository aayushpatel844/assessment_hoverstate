Feature: I want to review contract details and redeem add-on product only
  As a service advisor
  I want to be able to review "Contract Details"
  so I can sell or redeem a product

  Background: Logged in as a service advisor
    Given I navigate to "https://knrstn-cas-stg1.pegacloud.net/prweb"
    When I type my credentials
      | uid | Advisor1  |
      | pw  | JGJRTW1KZzlyLQ== |
    And I click on [login]
    Then I am logged into the "Service Lane"

  @regression
  Scenario: I want to confirm John Locke's prepaid services for AC Delco Synthetic product
    Given I searched for 'name' 'Mikel Jon'
    And I confirm 2 contracts have been found
    When I select the 'AC Delco Synthetic' contract
    Then "Contract Details" display
    And I can confirm 'Oil Change' and 'Car Wash' are available for redemption
    And I can confirm "Oil Change" has 0 Redeemed and 3 Available
    And I can confirm 'Car Wash' has 0 Redeemed and 24 Available

  @regression
  Scenario: I want to redeem Car Wash
    Given I have selected 'AC Delco Synthetic'
    And "Contract Details" display
    When I select 'Car Wash' as a "Prepaid Service" to redeem
    And I type RO number as 'R4'
    And I click [Redeem]
    Then I can confirm 'Service Redeemed' has replaced the [redeem] button
    And I can confirm 'Car Wash' now shows 1 has been Redeemed
    And I can confirm 'Car Wash' now shows 23 are Available
    And I can confirm 'Car Wash' now shows in "Redemption History" with RO Number as 'R4'