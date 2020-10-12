package entities.champion;

import entities.items.equipments.armor.Armor;
import entities.items.equipments.weapon.Weapon;

public class ChampionInfoPrinter {

    public static void printChampionInfo(Champion champ) {
        System.out.println("---------------------------------");
        System.out.println(champ.getName() + " details:" );     
        System.out.println("---------------------------------");   
        System.out.println("Class: " + champ.getClassType().toString());
        System.out.println("Level: " + champ.getLevel());
        System.out.println("Health: " + champ.getHealth() + "/" + champ.getMaxHealth());
        System.out.println("Strength: " + champ.getStrength());
        System.out.println("Dexterity: " + champ.getDexterity());
        System.out.println("Intelligence: " + champ.getIntelligence());
        System.out.println("XP to next level: " + (champ.calculateExperienceRequiredToLevelUp() - champ.getExperience()));
        System.out.println("---------------------------------");
        System.out.println("Equipped items: ");
        System.out.println("---------------------------------");
        if (champ.getEquippedItem()[0] != null) {
            Weapon currentWeapon = (Weapon)champ.getEquippedItem()[0];
            System.out.println("Weapon: " + champ.getEquippedItem()[0].getName() + " (Level " + currentWeapon.getLevelRequirement() + ")");
        }
        else {
            System.out.println("Weapon: no weapon equipped.");
        }
        Armor currentArmor;
        if (champ.getEquippedItem()[1] != null) {
            currentArmor = (Armor)champ.getEquippedItem()[1];
            System.out.println("Head: " + champ.getEquippedItem()[1].getName() + " (Level " + currentArmor.getLevelRequirement() + ")");
        }
        else {
            System.out.println("Head: no head armor equipped.");
        }
        if (champ.getEquippedItem()[2] != null) {
            currentArmor = (Armor)champ.getEquippedItem()[2];
            System.out.println("Body: " + champ.getEquippedItem()[2].getName() + " (Level " + currentArmor.getLevelRequirement() + ")");
        }
        else {
            System.out.println("Body: no body armor equipped.");
        }
        if (champ.getEquippedItem()[3] != null) {
            currentArmor = (Armor)champ.getEquippedItem()[3];
            System.out.println("Legs: " + champ.getEquippedItem()[3].getName() + " (Level " + currentArmor.getLevelRequirement() + ")");
        }
        else {
            System.out.println("Legs: no leg armor equipped.");
        }
        System.out.println("---------------------------------");

    }
}
