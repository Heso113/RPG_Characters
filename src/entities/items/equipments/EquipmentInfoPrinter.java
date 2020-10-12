package entities.items.equipments;

import entities.items.equipments.armor.*;
import entities.items.equipments.weapon.*;

public class EquipmentInfoPrinter {
    public static void printWeaponInfo(Weapon weapon) {
        System.out.println("----------------------------");
        System.out.println("\n" + weapon.getName() + " details:" );        
        System.out.println("----------------------------");       
        System.out.println("Weapon Type: " + weapon.getWeaponType().toString());
        System.out.println("Level requirement: " + weapon.getLevelRequirement());
        System.out.println("Damage: " + weapon.getWeaponDamage());
        System.out.println("----------------------------");
    }
    public static void printArmorInfo(Armor armor) {
        System.out.println("----------------------------");
        System.out.println("\n" + armor.getName() + " details:" ); 
        System.out.println("----------------------------");       
        System.out.println("Equipment Type: " + armor.getArmorSlot().toString());
        System.out.println("Level requirement: " + armor.getLevelRequirement());
        System.out.println("Strength bonus: " + armor.getBaseStrength());
        System.out.println("Dexterity bonus: " + armor.getBaseDexterity());
        System.out.println("Intelligence bonus: " + armor.getBaseIntelligence());
        System.out.println("Health bonus: " + armor.getBaseHealth());
        System.out.println("----------------------------");
    }
}
