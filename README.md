# CISC471-BattleHub

Download BattleHub.jar for a standalone executable.

Made with libgdx and Java 1.8

Images used are for demostration purposes only and copyright rights are reserved for their respective owners.

------------------------------------------------------------------------------------------------
To compile:

1. Download as ZIP
2. Extract the contents
3. Open Eclipse
4. Go to File -> Import -> Import Existing Gradle Project
5. When prompted for the Project root directory select the folder with the extracted contents of the zip file
6. If there are no errors hit Finish
7. Extract the contents of this folder into the Assets folder /CISC471-BattleHub/core/assets https://drive.google.com/file/d/19J1CcaVqYHU0DaWn3Sje6NiGTOolVpBO/view?usp=sharing

-------------------------------------------------------------------------------------------------
User requirements:
 
The player is able to engage in combat with different kinds of opponents.
The combat is against 1 opponent at a time.
The player can customize their character (select class and name.)
The player moves on to the next level after reaching the goal.
The game logs and displays the last 7 interactions with the opponents in battle.
The user is able to see their current health, attack, defense and speed. 
The user is able to select any attack from a list of four.
The list of attacks can be updated with new attacks after leveling up.
The user can flee from battles.
If the user is defeated the level is restarted and all defeated enemies respawn.
The game saves player progress. The player can resume from the point they saved after exiting the game.

System requirements:

Display:
  The game should display images on the screen to represent characters and the map.
  The game should handle different perspectives like menus, map traversal and battles. 
Textbox:
  The game displays predefined text on screen.
  A dialogue box keeps track of the last 10 enemy and system interactions.
  The game displays health points for both the player and opponents.
  The game displays the player’s attack, defense, exp. and speed.
Input:
  The game is able to handle user input (Keyboard and mouse.)
  The game allows the user to select skills from a menu to attack or flee the battle.
  The game allows the player to decide what skills can be learned and/or replaced after leveling up.
Movement:
  For simplicity, movement is based on a grid.
  Player’s character can’t move outside the boundaries of the grid.
  The player can’t move into designated grid spaces, such as walls or obstacles.
  There will be grid spaces with special effects, such as healing.
  The player engages in battle after stepping into a grid space with an enemy.
Other:
  Being able to choose an elemental class at the start of the game.
  The game loops after defeating the last level. 
  Persistence of data. The player can save their progress, quit at any time and resume from the same level.
