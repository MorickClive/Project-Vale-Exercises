Feature: Google Search Animals

  Scenario Outline: Googling Animals
    Given I can load google
    When I search for "<animal>"
    And I navigate to images
    Then I should be able to see pictures of "<animal>"
  Examples:
    | animal			|
    |    kitten   |
    |    opossum  |
    |    parrot		|