Feature: Manage DVD store inventory

  Scenario: Create new title in DVD store. We need title of DVD and price category. The number for every movie is created by system in ascending order.
    Given Movie administration is started
    When  User presses new movie button
    Then  User has to enter movie title
    And   User has to enter price category
    And   Movie number should be 1

