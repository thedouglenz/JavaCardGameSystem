JavaCardGameSystem
==================

A card game system written in Java upon which it is possible to build various games

Deck 

A deck of cards. Contains the shuffle operation, print deck, peek top card, peek bottom card, remove top card, and deal hand

Hand 

A player's hand. Contains remove first card (for games like War), print hand, get size, and add to hand

Card 

A single playing card consists of a value and a suit

Player 

A card game player. Players have hands, and operations like play card

WarGame

A game to test the functionality of deck, card, player, and hand manipulation.
Various classes are associated with just this game including WarGUI, WarController.


Compile and run GUITest.java or WarGame.java

This project can be opened in Eclipse or IntelliJ, the project file is in IntelliJ's format.

Optionally, compile and run from the terminal:

javac GUITest.java

java GUITest

javac WarGame.java

java WarGame

