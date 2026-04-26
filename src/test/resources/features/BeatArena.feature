Scenario: Player Battles through Arena and gets a hat

    Given a Critter Minitaur "Manny" of level 1
    When Player picks Battle
    Then Player gets shown 3 Arenas, all Stage 1

    When Player picks ArenaType2
    Then Manny enters the Arena
    And Manny enters a battle in the Arena
    And a Stage 1 Fight occurs against a Random foe

    When Manny Wins Stage 1 Fight
    Then Manny gains __ Experience Points
    And ArenaType2 goes to Stage 2

    When Player picks Battle
    Then Player gets shown 3 Arenas, ArenaType2 is Stage 2, others are Stage 1

    When Player picks ArenaType2
    Then Manny enters a battle in the Arena
    And a Stage 2 Fight occurs against a Random foe

    When Manny Wins Stage 1 Fight
    Then Manny gains __ Experience Points
    And Player gets a __ Tree
    And ArenaType2 goes to Stage 2

