I've expanded one of my OOP exams into a small version of the Classic DOTA game.

There is a three types of heroes: Strength, Agility and Intelligence.
They start the game with base stats for the type.
You could add common items to the hero's inventory or add recipes. If a hero already have the recipe's required items - a new item is made of them.

Game commands:
(keep the correct line input as shown below, so you could use the game commands correctly)
If you put a wrong command or input - you'll get an error and you should try again.


Adding a new hero:
"Hero" + "TYPE YOUR HERO NAME" + "CHOOSE YOUR TYPE OF HERO"(Strength,Agility or Intelligence);
Example: "Hero Rhasta Intelligence" - A new intelligence hero is created - Rhasta.
"Hero Rikimaru Agility" - A new agility hero is created - Rikimaru.

Adding a new item:
"Item" + "TYPE YOUR HERO NAME" + "TYPE YOUR ITEM NAME" + "Strength Bonus(Digit)" + "Agility Bonus(Digit)" + "Intelligence Bonus(Digit)" + "HitPoints Bonus(Digit)" + "Damage Bonus(Digit)";
Example: "Item Rhasta Powerhat 10 10 30 100 50" - A new item is added to the hero. His stats are improved by the given item's specifics.


Adding a new recipe:
"Recipe" + "TYPE YOUR HERO NAME" + "TYPE YOUR RECIPE NAME" + "Strength Bonus(Digit)" + "Agility Bonus(Digit)" + "Intelligence Bonus(Digit)" + "HitPoints Bonus(Digit)" + "Damage Bonus(Digit)" + "varargs of required items(String)";
Example: "Recipe Rhasta Powerhat2 20 20 60 300 150" - A new special item is added to the hero. His stats are improved by the given item's specifics.


Attacking a hero:
"Attack" + "TYPE YOUR HERO NAME(ATTACKER))" + "TYPE THE VICTIM HERO NAME";
When an attack is made, you'll get a message with information about the victim's hitpoints.
If the attacker's damage is bigger than the victim's current hitpoints - victim is dead and removed from the game.
Example: "Attack Rhasta Rikimaru" - Rikimaru gets attacked and his life hitpoints are decreasing based on Rhasta's damage points.

Get hero stats:
"Info" + "Hero Name";
Example: "Info Rhasta"

Quit the game:
"Quit".



