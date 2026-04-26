Feature: Fight in a advanced, nuanced way
  A battle should go until one of the critters reaches 0 health
  Attack: They can either use a normal strike, or a special attack if they have one
    As critters level up, these moves will gain additional properties based on the critter type
  Dodge: They can dodge but it costs health
    Dodging has diminishing returns
    The first three times you dodge, you don't get hit
    Afterwards, the chance to get hit increases with each successive dodge

  Scenario: Two critters fight each other
    Given a Minitaur named Manny with a Fixed Die of 4
    And a NecroBones named Osteo with a Fixed Die of 4

    When a Battle occurs
    And Manny attacks
    And Osteo attacks

    Then Manny has health (initial health)
    And Osteo has health (initial health - type advantage))

  Scenario: Two critters fight, with one Velociraptor who can dodge
    Given a Minitaur named Manny with a Fixed of 4
    And a Velociraptor named Blue with a Fixed Die of 4

    When a Battle occurs
    And Manny attacks
    And Blue dodges

    Then Manny has health (initial health)
    And Blue has health (initial health)

  Scenario: A level 5 minitaur fights and rolls a 5 or 6, stunning its opponent
    Given a level 5 Minitaur named Manny with a Fixed Die of 6
    And a level 4 NecroBones named Osteo with a Fixed Die of 4

    When a Battle occurs
    And Manny attacks
    And Osteo attacks
    Then Osteo is stunned

    When a Battle occurs
    And Manny attacks
    And Osteo attacks
    Then Osteo has health (initial health - 6)

  Scenario: A level 5 velociraptor fights and dodges, increasing its next attack
    Given a level 5 Velociraptor named Blue with a Fixed Die of 4
    And a level 5 Minitaur named Manny with a Fixed Die of 4

    When a Battle occurs
    And Blue dodges
    And Osteo attacks

    Then a Battle occurs
    And Blue attacks
    And Osteo attacks
    Then Osteo has health (initial health - dodge damage bonus)

  Scenario: A level 5 necrobones fights and steals 1 damage from its opponent each time it attacks resetting on block

