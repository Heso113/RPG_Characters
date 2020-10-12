import java.util.Scanner;

import entities.champion.Champion;
import entities.champion.ChampionGenerator;
import entities.champion.ChampionInfoPrinter;
import entities.champion.ClassType;
import entities.items.Item;
import entities.items.equipments.EquipmentGenerator;
import entities.items.equipments.EquipmentInfoPrinter;
import entities.items.equipments.armor.Armor;
import entities.items.equipments.armor.ArmorSlot;
import entities.items.equipments.weapon.Weapon;
import entities.items.equipments.weapon.WeaponType;
import entities.items.equipments.weapon.weapontypes.magicalweapon.MagicalWeapon;
import entities.items.equipments.weapon.weapontypes.meleeweapon.MeleeWeapon;
import entities.items.equipments.weapon.weapontypes.rangedweapon.RangedWeapon;
import entities.monster.Monster;
import entities.monster.MonsterGenerator;
import entities.monster.MonsterInfoPrinter;
import entities.monster.MonsterType;
import systems.Game;

public class Program {
    public static void main(String[] args) {
        boolean programRunning = true;
        String input;
        Scanner myScanner = new Scanner(System.in);
        while (programRunning) {
            System.out.println("Welcome to RPGCharacters");
            System.out.println("1. Run Demo");
            System.out.println("2. Play Game");
            System.out.println("3. Exit");
            input = myScanner.nextLine();
            switch (input)
            {
                case "1":
                {
                    runDemo();
                    break;
                }
                case "2":
                {
                    Game myGame = new Game();
                    myGame.run();     
                    break;               
                }
                case "3":
                {
                    programRunning = false;
                    break;
                }
            }
        }
        myScanner.close();
    }

    public static void runDemo() {
        System.out.println("-------------------------------");
        System.out.println("| Create and level Characters |");
        System.out.println("-------------------------------");
        System.out.println("Each class start with a basic weapon.");
        System.out.println("Lets create some champions right now!");
        Champion myWarrior = ChampionGenerator.generateChampion(ClassType.Warrior, "Achilles");
        ChampionInfoPrinter.printChampionInfo(myWarrior);
        System.out.println("Lets give Achilles 1000 experience points!");
        myWarrior.gainExperience(1000);
        ChampionInfoPrinter.printChampionInfo(myWarrior);
        System.out.println("Achilles is looking stronger already!");

        
        System.out.println("-------------------------------");
        System.out.println("|        Equip Weapons         |");
        System.out.println("-------------------------------");
        System.out.println("Weapon damage scale on weapon level and which base it is.");
        System.out.println("There is three types of weapons:");
        System.out.println("Melee: (Axe, Sword, Katana)");
        System.out.println("Ranged: (Slingshot, Bow, Crossbow)");
        System.out.println("Magical: (Wand, Scepter, Staff)");
        System.out.println("The base damage of each base is (5, 10, 15) for each type.");
        System.out.println("Lets create some weapons for our champions to equip.");


        System.out.println("Our first weapon is a melee weapon.");
        Item myMeleeWeapon = new MeleeWeapon(WeaponType.Melee, 10, "Sword", 6, 0, 0, 0, 0);
        EquipmentInfoPrinter.printWeaponInfo((Weapon)myMeleeWeapon);
        System.out.println("Lets equip it on Achilles.");
        myWarrior.equipWeapon((Weapon)myMeleeWeapon);
        ChampionInfoPrinter.printChampionInfo(myWarrior);
        System.out.println("Lets check out the ranged and magical weapons!");
        Item myRangedWeapon = new RangedWeapon(WeaponType.Ranged, 15, "Crossbow", 5, 0, 0, 0, 0);
        Item myMagicalWeapon = new MagicalWeapon(WeaponType.Magical, 15, "Staff", 1, 0, 0, 0, 0);
        EquipmentInfoPrinter.printWeaponInfo((Weapon)myRangedWeapon);
        EquipmentInfoPrinter.printWeaponInfo((Weapon)myMagicalWeapon);
       
        System.out.println("Lets create a Ranger and a Mage as well!");
        Champion myRanger = ChampionGenerator.generateChampion(ClassType.Ranger, "Aragorn");
        ChampionInfoPrinter.printChampionInfo(myRanger);
        Champion myMage = ChampionGenerator.generateChampion(ClassType.Mage, "Rand al'Thor");
        ChampionInfoPrinter.printChampionInfo(myMage);
        System.out.println("Lets equip the weapons on Aragorn and Rand al'thor.");
        myRanger.equipWeapon((Weapon)myRangedWeapon);
        myMage.equipWeapon((Weapon)myMagicalWeapon);
        System.out.println("Oh no. It seems like Aragorn is too low level to equip his weapon.");
        System.out.println("Lets level him up a bit.");
        myRanger.gainExperience(700);
        System.out.println("Lets try equiping that Crossbow again.");
        myRanger.equipWeapon((Weapon)myRangedWeapon);
        ChampionInfoPrinter.printChampionInfo(myRanger);
        ChampionInfoPrinter.printChampionInfo(myMage);
        System.out.println("Lets level up Rand al'Thor some as well.");
        myMage.gainExperience(1000);
        System.out.println("Now that should deal some damage!");

        System.out.println("-------------------------------");
        System.out.println("|        Equip Armor          |");
        System.out.println("-------------------------------");
        System.out.println("There is three types of armor.");
        System.out.println("( Cloth     Leather     Plate ).");
        System.out.println("Armor stats scale on armor type and item level.");
        System.out.println("Armor pieces can give stat boosts to: ");
        System.out.println("Strength, Dexterity, Intelligence and Health");
        System.out.println("Lets create a full set of armor for Achilles, Aragorn and Rand al'Thor.");

        Item clothHelmet = EquipmentGenerator.generateClothArmor(ArmorSlot.Head);
        Item clothChestpiece = EquipmentGenerator.generateClothArmor(ArmorSlot.Body);
        Item clothLeggings = EquipmentGenerator.generateClothArmor(ArmorSlot.Legs);
        EquipmentInfoPrinter.printArmorInfo((Armor)clothHelmet);
        EquipmentInfoPrinter.printArmorInfo((Armor)clothChestpiece);
        EquipmentInfoPrinter.printArmorInfo((Armor)clothLeggings);


        Item leatherHelmet = EquipmentGenerator.generateLeatherArmor(ArmorSlot.Head);
        Item leatherChestpiece = EquipmentGenerator.generateLeatherArmor(ArmorSlot.Body);
        Item leatherLeggings = EquipmentGenerator.generateLeatherArmor(ArmorSlot.Legs);
        EquipmentInfoPrinter.printArmorInfo((Armor)leatherHelmet);
        EquipmentInfoPrinter.printArmorInfo((Armor)leatherChestpiece);
        EquipmentInfoPrinter.printArmorInfo((Armor)leatherLeggings);

        Item plateHelmet = EquipmentGenerator.generatePlateArmor(ArmorSlot.Head);
        Item plateChestpiece = EquipmentGenerator.generatePlateArmor(ArmorSlot.Body);
        Item plateLeggings = EquipmentGenerator.generatePlateArmor(ArmorSlot.Legs);
        EquipmentInfoPrinter.printArmorInfo((Armor)plateHelmet);
        EquipmentInfoPrinter.printArmorInfo((Armor)plateChestpiece);
        EquipmentInfoPrinter.printArmorInfo((Armor)plateLeggings);

        System.out.println("Lets equip the items on Achilles, Aragorn and Rand al'Thor!");
        myWarrior.equipArmor((Armor)clothHelmet);
        myWarrior.equipArmor((Armor)clothChestpiece);
        myWarrior.equipArmor((Armor)clothLeggings);

        myRanger.equipArmor((Armor)leatherHelmet);
        myRanger.equipArmor((Armor)leatherChestpiece);
        myRanger.equipArmor((Armor)leatherLeggings);

        myMage.equipArmor((Armor)plateHelmet);
        myMage.equipArmor((Armor)plateChestpiece);
        myMage.equipArmor((Armor)plateLeggings);

        ChampionInfoPrinter.printChampionInfo(myWarrior);
        ChampionInfoPrinter.printChampionInfo(myRanger);
        ChampionInfoPrinter.printChampionInfo(myMage);

        System.out.println("Hmm... They look stronger. But I think Achilles and Rand al'Thor should swap their armor.");
        myMage.equipArmor((Armor)clothHelmet);
        myMage.equipArmor((Armor)clothChestpiece);
        myMage.equipArmor((Armor)clothLeggings);
        myWarrior.equipArmor((Armor)plateHelmet);
        myWarrior.equipArmor((Armor)plateChestpiece);
        myWarrior.equipArmor((Armor)plateLeggings);
        ChampionInfoPrinter.printChampionInfo(myWarrior);
        ChampionInfoPrinter.printChampionInfo(myMage);
        System.out.println("Looking mighty fine gentlemen!");

        System.out.println("-------------------------------");
        System.out.println("|       Combat & Loot         |");
        System.out.println("-------------------------------");
        System.out.println("When a monster is killed the champion will find a new piece of equipment.");
        System.out.println("Lets spawn a monster.");
        Monster myMonster = MonsterGenerator.generateMonster(MonsterType.GOBLIN);
        System.out.println("It seems like we spawned a " + myMonster.getName());
        System.out.println("Monster have their own stats.");
        MonsterInfoPrinter.printMonsterInfo(myMonster);
        System.out.println("Lets have Achilles fight it.");
        while (myMonster.getHealth() > 0) {
            System.out.println("The " + myMonster.getName() + " cowers in fear, unable to move.");
            myMonster.setHealth(myMonster.getHealth() - myWarrior.performAttack());
        }
        System.out.println("The " + myMonster.getName() + " was slain!");
        Item newLoot = EquipmentGenerator.generateRandomLoot();
        System.out.println("Achilles found " + newLoot.getName() + "! Amazing loot!");
        
        System.out.println("Oh no! It seems like we have drawn the attention of a dragon!");
        myMonster = MonsterGenerator.generateMonster(MonsterType.DRAGON);
        MonsterInfoPrinter.printMonsterInfo(myMonster);
        System.out.println("I think we will need all of our champions to beat this foe!");
        while (myMonster.getHealth() > 0) {
            System.out.println("The " + myMonster.getName() + " makes a scary face... Doing... nothing?");
            System.out.println("Dragon Health: " + myMonster.getHealth() + "/" + myMonster.getMaxHealth());
            myMonster.setHealth(myMonster.getHealth() - myWarrior.performAttack());
            myMonster.setHealth(myMonster.getHealth() - myRanger.performAttack());
            myMonster.setHealth(myMonster.getHealth() - myMage.performAttack());
        }
        System.out.println("The " + myMonster.getName() + " has been slain!");

        System.out.println("That conducts this demo!");
        System.out.println("Thank you for reading.\n");

    }
}