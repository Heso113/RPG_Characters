# RPG_Characters
RPG_Characters is a simple program which was developed in order to familiarise myself with concepts like inheritance, polymorphism, composition and the SOLID principles.

The following is a simple class diagram which represent the base structure of the application.

<img width="729" alt="classDiagram" src="https://user-images.githubusercontent.com/21289637/95744589-d8aeeb00-0c93-11eb-976b-79b4905339ec.PNG">

## Champion Classes & Monsters
In this demo there is two types of characters: Champion(the character that represents the player) and Monster(the character representing the players foes).
Both the Champion class and the Monster class have their own stats such as strenght, dexterity, intelligence, health, etc. These stats determine how much damage a character deals, if the character is alive, etc.

### Champion classes
Currently there is three classes that the player can choose for their champion: Warrior, Ranger and Mage. Each class have different base stats and also scale differently when they level up. For example the Warrior class has the highest base healthpool and health scaling per level while having the lowest damage modifiers compared to the other classes. The mage is the opposite where he/she has great damage output but a low base healthpool and health scaling per level.
In order to boost their stats the Champions can equip items. There is two type of items that the player can equip: Weapons and Armor. 

### Monsters
At the moment there is four types of monsters: Goblin, Orc, Ogre and Dragon. Each monster type has its own basestats where Goblin is the weakest followed by the Orc, Ogre and the strongest being the Dragon. Which monster that the player will face is randomly generated when the player decides to go out of town to hunt monsters.

## Items
In the begining of this project there was ambitions to add consumable items which the player could consume during combat in order to give them a temporary boost to their stats. However due to time constraints this was not added into the demo. At the moment there is two types of items that the player can equip: weapons and armor. Each piece of equipment has a level requirement that the player will have to meet in order to equip it. The player will store their loot in their inventory which they can browse and equip items from while in town.

### Weapons
At the moment weapons only have a base damage, a weapon type(Melee, Ranged and Magical), and a level requirement. The damage of melee weapons scale with the champions strength, ranged weapons scale with dexterity and magical weapons scale with intelligence. . Each weapon type has three bases with different base damage:

| Melee     | Ranged    | Magical  | Base Damage |
| --------- |:---------:|:--------:| -----------:|
| Axe       | Slingshot | Wand     |      5      |
| Sword     | Bow       | Scepter  |      10     |
| Katana    | Crossbow  | Staff    |      15     |
 
 A fun edition which might be added in the future would be to randomize the bonuses the weapon give the champion and its name when it is created

### Armor
Armor pieces increase the players health, strength, dexterity and intelligence. Just like the weapons each armor piece's stat increase scales with its level requirement. It also matters which part of the body the armor is equipped to. It can either be equipped to the Head, Body or Legs of the champion. There is three armor types in the demo: Cloth, Leather and Plate. Each type has different base stats while also scaling differently depending on the items level. Cloth gives has a higher intelligence boost and quite low health boost compared to Plate which has high health boost while also boosting the champions strength a fair bit.


## Combat
At the moment the player has two options when in combat. They can either attack the monster or flee. For the sake of the demo only the players can deal damage at this point in time. When the monster is defeated it will drop a randomized item with a level requirement between 1-5 which will be added to the champions inventory before they return to town. 

## Demo and Game
The demo part of the application will create a champion from each class and showcase the different classes scaling with weapons and armor. It also showcases some combat where the champions defeat a Goblin followed by a Dragon. 

In the Game part of the application the player can choose which class they wish to play as. They will then start their adventure in town where they can choose to either hunt monsters to find some loot, inspect their current stats or inspect their inventory in order to equip the loot the have found while hunting monsters.
