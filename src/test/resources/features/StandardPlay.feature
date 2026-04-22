
Scenario: A new player plays the game
    Given a new player
    Then prompt a name input
    And log into the game

    Then present an option of 3 critters

    When Player picks a Level 1 CritterType1
    When Player names Critter "Bob" With XP 0

    Then load a new CritterCorral
    And Player receives Critter Bob and an Apple Tree
    And Player gets shown Critters and Garden

    When Player picks Bob
    Then Player gets prompted to Feed, Battle, or Dress

    When Player picks Feed
    Then Player gets shown all their Trees

    When Player picks a Tree
    Then Player can harvest a Tree if it has fruit


    When Player picks Battle
    Then Player gets shown 3 Arenas, all Stage 1

    When Player picks ArenaType2
    Then Bob enters the Arena
    And Bob enters a battle in the Arena
    And a Stage 1 Fight occurs against a Random foe

    When Bob Wins Stage 1 Fight
    Then Bob gains Experience Points
    And ArenaType2 goes to Stage 2

    Then Player is prompted to continue Battling or return to Bob's menu


Scenario: A Critter beats ArenaType2 Stage 5
    Given a Critter of Level




//then prompted to do something else
//Then features will be what is put out to the command line

// Serializable interface: (look it up) You can write your output to a file, and have that file re-read into the code to "re-load"/re-hydrate the code

//Commands do not always have to relate to strategy
//What's a menu option and what is a command
//have a menu item(what we print to the screen) is basically just a list of commands
//in the new HW we have CommandType
//We can have a set of all commandTypes that's the top level menu(Sleep, eat, fight)
//Given all possible commands, then player selects command type and the player selects command
//CommandType is just the top level that selects the command we want to run
//We need to add a method to command Option(String) that gives the different options within that command
//We either have to do this in HW 10 or he gives it to us
//Command only for the Critter options, the list of Critters could just be a list
//this helps us not do everything in every room
//