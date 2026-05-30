@allo
Feature: Allo iphone scraper

  Scenario: Save first 3 iphones to database

    Given Open allo.ua

    When Search for "iphone"

    And Collect first 3 products

    Then Save products to DB if absent