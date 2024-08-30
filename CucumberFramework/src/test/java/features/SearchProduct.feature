# new feature
# Tags: optional

Feature: Search and Place order for products

  Scenario: search experience for product search in both home and offer pages
    Given user is on GreenCart Landing Page
    When when user with search with first 3 character "tom" and fetch the exact product
    Then user search with short name "tom" in offer page
    And validate product name in offer page matches with landing page