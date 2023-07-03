Feature: Home Appliances Cost To Use
  US01: As a resident from England
  I need to know estimate of how much electrical appliances cost to run
  So that it can help me to reduce the energy cost and save money.

  Scenario: Cost For England
    Given I am a resident from "England"
    When I add the list appliances (add at least 8 appliances) and its average usage and average rate
    Then I should get the results table with daily, weekly, monthly, and yearly cost.

  Scenario: Cost For Scotland
    Given I am a resident from "Scotland"
    When I add the list appliances (add at least 10 appliances) and its average usage and average rate
    Then I should get the results table with daily, weekly, monthly, and yearly cost.

  Scenario: Cost For Wales
    Given I am a resident from "Wales"
    When I add the list appliances (add at least 5 appliances) and its average usage and average rate
    Then I should get the results table with daily, weekly, monthly, and yearly cost.

  Scenario: Cost For Northern Ireland
    Given I am a resident from "Northern Ireland"
    When I select This advice applies to "Northern Ireland"
    Then I should get the results message as "The advice on this website doesn’t cover Northern Ireland"

