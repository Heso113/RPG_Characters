package entities.champion;

import java.util.LinkedList;
import java.util.List;

import entities.attributes.CharacterAttributes;
import entities.items.*;
import entities.items.equipments.armor.*;
import entities.items.equipments.weapon.*;

public abstract class Champion extends CharacterAttributes {
    private ClassType type;
    private Item equippedItems[] = new Item[4];
    private List<Item> baggedArmor = new LinkedList<Item>();
    private List<Item> baggedWeapons = new LinkedList<Item>();

    public void setClassType(ClassType t) {
        this.type = t;
    }

    public ClassType getClassType() {
        return this.type;
    }

    public void setItem(Item item, int slot) {
        this.equippedItems[slot] = item;
    }

    public Item[] getEquippedItem() {
        return this.equippedItems;
    }

    public List<Item> getBaggedArmor() {
        return this.baggedArmor;
    }

    public void addArmorToBag(Item item) {
        this.baggedArmor.add(item);
    }

    public List<Item> getBaggedWeapons() {
        return this.baggedWeapons;
    }

    public void addWeaponToBag(Item item) {
        this.baggedWeapons.add(item);
    }

    // Equips the given weapon if the Champion meets the required level for the specific weapon.
    // If the weapon piece is equiped the updateStats function will be called to ensure that the champions 
    // stats are correct.
    public boolean equipWeapon(Weapon weapon) {
        if (weapon.getLevelRequirement() <= this.getLevel()) {
            this.equippedItems[0] = weapon;
            this.updateStats();
            return true;
        }
        else {
            System.out.println(this.getName() + " does not meet the level requirement for the " + weapon.getName());
        }
        return false;
    }

    // Equips the weapon in the player inventory at the given index if the player is high enough level to equip it.
    // The function will also store the already equipped weapon in the players inventory if they have a weapon equipped already.
    public void equipWeaponFromBag(int index) {
        try {
            Weapon weaponToEquip = (Weapon)(this.baggedWeapons.get(index));
            if (this.getLevel() >= weaponToEquip.getLevelRequirement()) {
                if (this.equippedItems[0] != null) {
                    this.baggedWeapons.set(index, this.equippedItems[0]);
                }
                else {
                    this.baggedWeapons.remove(index);
                }
                this.equippedItems[0] = weaponToEquip;
                this.updateStats();
            }
            else {
                System.out.print(this.getName() + " does not meet the level requirement for that item.");
            }
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds.");
        }
    }

    // Equips the given Armor piece if the Champion meets the required level for the specific Armor piece.
    // If the armor piece is equiped the updateStats function will be called to ensure that the champions 
    // stats are correct.
    public boolean equipArmor(Armor armor) {
        boolean didEquip = false;
        if (armor.getLevelRequirement() <= this.getLevel()) {
            switch (armor.getArmorSlot())
            {
                case Head:
                {
                    this.equippedItems[1] = armor;
                    this.updateStats();
                    didEquip = true;
                    break;
                }
                case Body:
                {
                    this.equippedItems[2] = armor;
                    this.updateStats();
                    didEquip = true;
                    break;
                }
                case Legs:
                {
                    this.equippedItems[3] = armor;
                    this.updateStats();
                    didEquip = true;
                    break;
                }
            }
        }
        return didEquip;
    }

    // Equips the armor piece in the player inventory at the given index if the player is high enough level
    // to equip it. The function will also store the already equipped item in the players inventory if they have
    // something equipped already.
    public void equipArmorFromBag(int index) {
        try {
            Armor armorToEquip = (Armor)(this.baggedArmor.get(index));
            if (this.getLevel() >= armorToEquip.getLevelRequirement()) {
                switch (armorToEquip.getArmorSlot())
                {
                    case Head:
                    {
                        if (this.equippedItems[1] != null) {
                            this.baggedArmor.set(index, this.equippedItems[1]);
                        }
                        else {
                            this.baggedArmor.remove(index);
                        }
                        this.equippedItems[1] = armorToEquip;
                        break;
                    }
                    case Body:
                    {
                        if (this.equippedItems[2] != null) {
                            this.baggedArmor.set(index, this.equippedItems[2]);
                        }
                        else {
                            this.baggedArmor.remove(index);
                        }
                        this.equippedItems[2] = armorToEquip;
                        break;
                    }
                    case Legs:
                    {
                        if (this.equippedItems[3] != null) {
                            this.baggedArmor.set(index, this.equippedItems[3]);
                        }
                        else {
                            this.baggedArmor.remove(index);
                        }
                        this.equippedItems[3] = armorToEquip;
                        break;
                    }
                }
                this.updateStats();
            }
            else {
                System.out.print(this.getName() + " does not meet the level requirement for that item.");
            }
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds.");
        }
    }

    // Calculate the active Strength, Dexterity, Intelligence and Health based on the champions base stats
    // and their equipped items.
    public void updateStats() {
       int str = this.getBaseStrength();
       int dex = this.getBaseDexterity();
       int intel = this.getBaseIntelligence();
       int health = this.getBaseHealth();
       for (int i = 0; i < this.equippedItems.length; i++) {
            if (this.equippedItems[i] != null) {
                str += equippedItems[i].getBaseStrength();
                dex += equippedItems[i].getBaseDexterity();
                intel += equippedItems[i].getBaseIntelligence();
                health += equippedItems[i].getBaseHealth();
            }
       } 
       this.setStrength(str);
       this.setDexterity(dex);
       this.setIntelligence(intel);
       this.setMaxHealth(health);
    }

    // Gives experience to the Champion. If the total amount of experience required to level up is reached
    // a call will be made to the levelUp function in the champion class.
    public void gainExperience(int xp) {
        int xpRequiredToLevelUp = this.calculateExperienceRequiredToLevelUp();
        int experienceToAdd = xp;
        this.setExperience(this.getExperience() + experienceToAdd);
        while (this.getExperience() >= xpRequiredToLevelUp) {
            this.setExperience(this.getExperience() - xpRequiredToLevelUp);
            this.levelUp();
            xpRequiredToLevelUp = this.calculateExperienceRequiredToLevelUp();
            System.out.println("Level Up! " + this.getName() + " is now level " + this.getLevel() + "!");
        }
    }

    
    // Returns the amount of experience required to level up at the champions current level.
    // Required amount: 100 xp base level 1. Increases with 10% per level.
    public int calculateExperienceRequiredToLevelUp() {
        int xpRequired = 100;
        for (int i = 1; i < this.getLevel(); i++) {
            xpRequired = Math.round((float)(xpRequired * 1.1));
        }
        return xpRequired;
    }
    
    // Returns the amount of damage the champion will deal with their next attack.
    // Calculated based on what kind of weapon the champion have equipped.
    // Returns 0 of no weapon is equipped (Should never happen!).
    public int performAttack() {
        int dmg = 0;
        Item playerWeapon = this.equippedItems[0];
        if (playerWeapon != null) {
            switch (((Weapon)playerWeapon).getWeaponType()) {
                case Melee:
                {
                    dmg = ((Weapon)playerWeapon).getWeaponDamage() + this.getStrength() * 2;
                    System.out.println(this.getName() + " swings their weapon furiously dealing " + dmg + " points of damage.");
                    break;
                }
                case Ranged:
                {
                    dmg = ((Weapon)playerWeapon).getWeaponDamage() + (int)(this.getDexterity() * 1.5);
                    System.out.println(this.getName() + " fires a well placed projectile dealing " + dmg + " points of damage.");
                    break;
                }
                case Magical:
                {
                    dmg = ((Weapon)playerWeapon).getWeaponDamage() + this.getIntelligence() * 3;
                    System.out.println(this.getName() + " casts a powerfull spell dealing " + dmg + " points of damage.");
                    break;
                }
            }
        }else {
            dmg = 0;
        }
        return dmg;
    }

    public abstract void levelUp();
}
