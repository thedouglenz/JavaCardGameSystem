JavaCardGameSystem
==================


A card game system written in Java upon which it is possible to build various games

<h2>Classes in this project</h2>

**Deck** <br>
A deck of cards. Contains the shuffle operation, print deck, peek top card, peek bottom card, remove top card, and deal hand

**Hand** <br>
A player's hand. Contains remove first card (for games like War), print hand, get size, and add to hand

**Card** <br>
A single playing card consists of a value and a suit

**Player** <br>
A card game player. Players have hands, and operations like play card

**Table** <br>
Represents the game table with a varying number of "sides" that players sit on, useful for games where players lay cards in front of them as part of gameplay.

**WarGame** <br>
A game to test the functionality of deck, card, player, and hand manipulation.
Various classes are associated with just this game including WarGUI, WarController.

**PokerHandEvaluator5Card** <br>
A poker hand evaluator for hands that have 5 cards.

Compile and run GUITest.java or WarGame.java

This project can be opened in Eclipse or IntelliJ, the project file is in IntelliJ's format.

Optionally, compile and run from the terminal:

javac GUITest.java<br>
java GUITest

javac WarGame.java<br>
java WarGame

**Assets** <br>
All card images are provided in Cards/assets/. They are named as such: <br>
8 of Clubs => c8.png <br>
King of Hearts => h13.png

