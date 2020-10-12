package entities.items.equipments;

import java.util.Random;

import entities.champion.ClassType;
import entities.items.Item;
import entities.items.equipments.armor.*;
import entities.items.equipments.armor.armortypes.ClothArmor;
import entities.items.equipments.armor.armortypes.LeatherArmor;
import entities.items.equipments.armor.armortypes.PlateArmor;
import entities.items.equipments.weapon.*;
import entities.items.equipments.weapon.weapontypes.magicalweapon.MagicalWeapon;
import entities.items.equipments.weapon.weapontypes.magicalweapon.MagicalWeapons;
import entities.items.equipments.weapon.weapontypes.meleeweapon.MeleeWeapon;
import entities.items.equipments.weapon.weapontypes.meleeweapon.MeleeWeapons;
import entities.items.equipments.weapon.weapontypes.rangedweapon.RangedWeapon;
import entities.items.equipments.weapon.weapontypes.rangedweapon.RangedWeapons;

public class EquipmentGenerator {

    private static Random rand = new Random();

    // Returns either a random weapon or a random armor piece.
    public static Item generateRandomLoot() {
        Item newItem = null;
        EquipmentType type = EquipmentType.random();
        switch (type)
        {
            case Weapon:
            {
                newItem = EquipmentGenerator.generateWeapon();
                break;
            }
            case Armor:
            {
                newItem = EquipmentGenerator.generateArmor();
                break;
            }
        }
        return newItem;
    }

    // Returns a Armor piece where both the armor slot and the armor type is randomized.
    public static Item generateArmor() {
        Item newEquipment = null;
        ArmorClass aClass = ArmorClass.random();
        ArmorSlot aSlot = ArmorSlot.random();
        switch (aClass)
        {
            case Cloth:
            {
                newEquipment = generateClothArmor(aSlot);
                break;
            }
            case Leather:
            {
                newEquipment = generateLeatherArmor(aSlot);
                break;
            }
            case Plate:
            {
                newEquipment = generatePlateArmor(aSlot);
                break;
            }
        }

        return newEquipment;
    }
    
    // Generates and returns a random armor piece of cloth type. Also randomizes the 
    // level requirement of the item between 1-5 for the sake of this short demo.
    public static Item generateClothArmor(ArmorSlot slot) {
        Item clothItem = null;
        String name = "";
        int levelRequirement = rand.nextInt(4) + 1;
        int bonusHealth = 10 + levelRequirement * 5;
        int bonusStrength = 0;
        int bonusDexterity = 1 + levelRequirement;
        int bonusIntelligence = 3 + levelRequirement * 2;

        switch (slot)
        {
            case Head:
            {
                bonusHealth *= 0.8;
                bonusStrength *= 0.8;
                bonusDexterity *= 0.8;
                bonusIntelligence *= 0.8;
                name = "Cloth Helmet";
                clothItem = new ClothArmor(slot, name, levelRequirement, bonusStrength, bonusDexterity, bonusIntelligence, bonusHealth);
                break;
            }
            case Body:
            {
                name = "Cloth Chestpiece";
                clothItem = new ClothArmor(slot, name, levelRequirement, bonusStrength, bonusDexterity, bonusIntelligence, bonusHealth);
                break;
            }
            case Legs:
            {
                bonusHealth *= 0.6;
                bonusStrength *= 0.6;
                bonusDexterity *= 0.6;
                bonusIntelligence *= 0.6;
                name = "Cloth Leggings";
                clothItem = new ClothArmor(slot, name, levelRequirement, bonusStrength, bonusDexterity, bonusIntelligence, bonusHealth);
                break;
            }
        }

        return clothItem;
    } 
    
    // Generates and returns a random armor piece of leather type. Also randomizes the 
    // level requirement of the item between 1-5 for the sake of this short demo.
    public static Item generateLeatherArmor(ArmorSlot slot) {
        Item leatherItem = null;
        String name = "";
        int levelRequirement = rand.nextInt(4) + 1;
        int bonusHealth = 20 + levelRequirement * 8;
        int bonusStrength = 1 + levelRequirement;
        int bonusDexterity = 3 + levelRequirement * 2;
        int bonusIntelligence = 0;

        switch (slot)
        {
            case Head:
            {
                bonusHealth *= 0.8;
                bonusStrength *= 0.8;
                bonusDexterity *= 0.8;
                bonusIntelligence *= 0.8;
                name = "Leather Helmet";
                leatherItem = new LeatherArmor(slot, name, levelRequirement, bonusStrength, bonusDexterity, bonusIntelligence, bonusHealth);
                break;
            }
            case Body:
            {
                name = "Leather Chestpiece";
                leatherItem = new LeatherArmor(slot, name, levelRequirement, bonusStrength, bonusDexterity, bonusIntelligence, bonusHealth);
                break;
            }
            case Legs:
            {
                bonusHealth *= 0.6;
                bonusStrength *= 0.6;
                bonusDexterity *= 0.6;
                bonusIntelligence *= 0.6;
                name = "Leather Leggings";
                leatherItem = new LeatherArmor(slot, name, levelRequirement, bonusStrength, bonusDexterity, bonusIntelligence, bonusHealth);
                break;
            }
        }

        return leatherItem;
    }
    
    // Generates and returns a random armor piece of plate type. Also randomizes the 
    // level requirement of the item between 1-5 for the sake of this short demo.
    public static Item generatePlateArmor(ArmorSlot slot) {
        Item plateItem = null;
        String name = "";
        int levelRequirement = rand.nextInt(4) + 1;
        int bonusHealth = 30 + levelRequirement * 12;
        int bonusStrength = 3 + levelRequirement * 2;
        int bonusDexterity = 1 + levelRequirement;
        int bonusIntelligence = 0;

        switch (slot)
        {
            case Head:
            {
                bonusHealth *= 0.8;
                bonusStrength *= 0.8;
                bonusDexterity *= 0.8;
                bonusIntelligence *= 0.8;
                name = "Plate Helmet";
                plateItem = new PlateArmor(slot, name, levelRequirement, bonusStrength, bonusDexterity, bonusIntelligence, bonusHealth);
                break;
            }
            case Body:
            {
                name = "Plate Chestpiece";
                plateItem = new PlateArmor(slot, name, levelRequirement, bonusStrength, bonusDexterity, bonusIntelligence, bonusHealth);
                break;
            }
            case Legs:
            {
                bonusHealth *= 0.6;
                bonusStrength *= 0.6;
                bonusDexterity *= 0.6;
                bonusIntelligence *= 0.6;
                name = "Plate Leggings";
                plateItem = new PlateArmor(slot, name, levelRequirement, bonusStrength, bonusDexterity, bonusIntelligence, bonusHealth);
                break;
            }
        }

        return plateItem;
    }

    // Generates and returns a random weapon from the different WeaponTypes. Also randomizes the 
    // level requirement of the item between 1-5 for the sake of this short demo.
    public static Item generateWeapon() {
        Item newEquipment = null;
        String name = "";
        int damage = 0;
        int levelRequirement = rand.nextInt(4) + 1;
        int strengthBonus = 0;
        int dexterityBonus = 0;
        int intelligenceBonus = 0;
        int healthBonus = 0;
        WeaponType type = WeaponType.random();
        switch (type) 
        {
            case Melee:
            {
                MeleeWeapons weapon = MeleeWeapons.random();
                name = weapon.toString();
                levelRequirement = rand.nextInt(5);
                switch (weapon) 
                {
                    case Axe:
                    {
                        damage = 5;
                        break;
                    }
                    case Sword:
                    {
                        damage = 10;
                        break;
                    }
                    case Katana:
                    {
                        damage = 15;
                        break;
                    }
                }
                newEquipment = new MeleeWeapon(type, damage, name, levelRequirement, strengthBonus, dexterityBonus, intelligenceBonus, healthBonus);
                break;
            }
            case Ranged:
            {
                RangedWeapons weapon = RangedWeapons.random();
                name = weapon.toString();
                levelRequirement = rand.nextInt(5);
                switch (weapon)
                {
                    case Slingshot:
                    {
                        damage = 5;
                        break;
                    }
                    case Bow:
                    {
                        damage = 10;
                        break;
                    }
                    case Crossbow:
                    {
                        damage = 15;
                        break;
                    }
                }
                newEquipment = new RangedWeapon(type, damage, name, levelRequirement, strengthBonus, dexterityBonus, intelligenceBonus, healthBonus);
                break;
            }
            case Magical:
            {
                MagicalWeapons weapon = MagicalWeapons.random();
                name = weapon.toString();
                levelRequirement = rand.nextInt(5);
                switch (weapon) 
                {
                    case Wand:
                    {
                        damage = 5;
                        break;
                    }
                    case Scepter:
                    {
                        damage = 10;
                        break;
                    }
                    case Staff:
                    {
                        damage = 15;
                        break;
                    }
                }
                newEquipment = new MagicalWeapon(type, damage, name, levelRequirement, strengthBonus, dexterityBonus, intelligenceBonus, healthBonus);
                break;
            }
        }
        return newEquipment;
    }

    public static Item generateStarterWeapon(ClassType type) { 
        Item starterWeapon = null;
        switch (type)
        {
            case Warrior:
            {   
                starterWeapon = new MeleeWeapon(WeaponType.Melee, 5, MeleeWeapons.Axe.toString(), 1, 0, 0, 0, 0);
                break;
            }
            case Ranger:
            {
                starterWeapon = new RangedWeapon(WeaponType.Ranged, 5, RangedWeapons.Slingshot.toString(), 1, 0, 0, 0, 0);
                break;
            }
            case Mage:
            {
                starterWeapon = new MagicalWeapon(WeaponType.Magical, 5, MagicalWeapons.Wand.toString(), 1, 0, 0, 0, 0);
                break;
            }
        }
        
        return starterWeapon;
    }
}
