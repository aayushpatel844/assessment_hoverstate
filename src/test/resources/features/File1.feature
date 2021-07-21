Feature: I want sell a Pre-paid maintenace contract
  As a service advisor
  I want to sell a PPM contract
  so I can redeem or not redeem a product

  Background: Logged in as a service advisor
    Given I navigate to "https://knrstn-cas-stg1.pegacloud.net/prweb"
    When I type my credentials
      | uid | Advisor1         |
      | pw  | JGJRTW1KZzlyLQ== |
    And I click on [login]
    Then I am logged into the "Service Lane"

  @regressionFF
  Scenario: I want to initiate a sell contract
    When I search for a customer by "vin" "2C4RC1GG0KR714176"
    But no contracts correspond to that VIN
    Then a "Sell Contract" is available (renders)
    And I can select the following products:
      | AC Delco | BioPledge | AC Delco Synthetic |

  @regressionFF
  Scenario Outline: I want to sell a contract for each product offered
    Given I have a sell contract for "vin" "5XXGT4L37KG367983"
    And I have the following customer information:
      | John Locke | 123 Test Way | Fairfax | VA | 12345 | jl@jl.net | 1234567890 |
    When I select a "<Product>"
    And I type a "<RO Number>"
    And I click [sell]
    Then a "Sale Successful" modal pops-up
    And I can confirm the "<Service Description>" "<Redeemed>" "<Available>" & "<Price>" information
    Examples:
      | Product            | RO Number | Service Description | Redeemed | Available | Price | Response                |
      | AC Delco           | R1        | Oil Change          | 0        | 3         | 35.00 | redeem post sell        |
      | AC Delco Synthetic | R2        | Oil Change          | 0        | 3         | 45.00 | do not redeem post sell |
      | BioPledge          | R3        | BioPledge           | 0        | 3         | 85.00 | do not redeem post sell |

  @regressionF2
  Scenario: I want to redeem a product
    Given I have sold a "AC Delco" contract for "vin" "5XXGT4L37KG367983"
    And the 'Sale Successful' modal currently displays
    When I select the checkbox for "Oil Change"
    And I click [Redeem]
    Then the "Service Redemption Successful" modal appears
    And I can confirm I have "made X sale this month"
    And I can confirm I am "on track to get X sales this month"
    When I click [OK]
    Then I am returned to the "Service Lane"

  @regressionF2
  Scenario: I do not want to redeem a product after a sell
    Given I have sold a "AC Delco Synthetic" contract for 'vin' '5XXGT4L37KG367983'
    And the 'Sale Successful' modal currently displays
    When I select the checkbox for "Oil Change"
    And I click 'No, sell contract without redemption' link
    And I click [OK]
    Then I am returned to the "Service Lane"


#  New VIN : 1FMCU9DGXAKC46617
#    5XXGT4L37KG367983 -- Not use
#  - JM3TCACY6L0420272
#  - JM1NDAL79L0414293
#   - 5FNYF6H0XMB028534
#  1G11Z5S32LU103375
#  2C4RC1GG0KR714176
