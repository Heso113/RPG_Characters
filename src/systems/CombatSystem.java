package systems;

import java.util.Scanner;

import entities.champion.*;
import entities.items.Item;
import entities.items.equipments.Equipment;
import entities.items.equipments.EquipmentGenerator;
import entities.items.equipments.EquipmentInfoPrinter;
import entities.items.equipments.EquipmentType;
import entities.items.equipments.armor.Armor;
import entities.monster.*;
import entities.monster.MonsterType;

public class CombatSystem {

    //Returns true if the player survives. Returns false if the player dies.
    //Generates a piece of loot if the monster is slain and adds it to the players inventory/bag.
    public static boolean doCombat(Champion player, Scanner scanner) {
        boolean isPlayerAlive = true;
        boolean combatActive = true;
        Monster monster = MonsterGenerator.generateMonster(MonsterType.random());
        String playerInput = "";
        System.out.println("You encounter a " + monster.getName());
        while (combatActive) 
        {
            System.out.println(player.getName() + ": " + player.getHealth() + "/" + player.getMaxHealth() + " Health");
            System.out.println(monster.getName() + ": " + monster.getHealth() + "/" + monster.getMaxHealth() + " Health");
            System.out.println("\n\n");
            System.out.println("1. Attack");
            System.out.println("2. Flee");
            System.out.print("Your choice: ");
            playerInput = scanner.nextLine();
            switch(playerInput) 
            {
                case "1":
                {
                    int playerDamage = player.performAttack();
                    monster.setHealth(monster.getHealth() - playerDamage);
                    if (player.getHealth() <= 0) {
                        isPlayerAlive = false;
                    }
                    else if (monster.getHealth() <= 0){
                        player.gainExperience(monster.getExperience());
                        Item newItem = EquipmentGenerator.generateRandomLoot();
                        if (((Equipment)newItem).getEquipmentType() == EquipmentType.Weapon) {
                            System.out.println("Weapon added to bag.");
                            player.addWeaponToBag(newItem);
                        } else {
                            System.out.println("Armor added to bag.");
                            player.addArmorToBag(newItem);
                            System.out.println(player.getBaggedArmor().size());
                            EquipmentInfoPrinter.printArmorInfo((Armor)newItem);
                        }
                        System.out.println("You slayed the " + monster.getName() + " and found a " + newItem.getName() + ".");
                        System.out.println("You add the new item to your inventory and return to town.");
                        combatActive = false;
                    }
                    break;
                }
                case "2":
                {
                    combatActive = false;
                    System.out.println("You flee back to town!");
                    break;
                }
                default:
                {
                    System.out.println("Invalid Choice. Try again.");
                    break;
                }
            }
        }
        return isPlayerAlive;
    }
}
