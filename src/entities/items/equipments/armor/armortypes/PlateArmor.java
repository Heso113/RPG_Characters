package entities.items.equipments.armor.armortypes;

import entities.items.equipments.EquipmentType;
import entities.items.equipments.armor.Armor;
import entities.items.equipments.armor.ArmorClass;
import entities.items.equipments.armor.ArmorSlot;

public class PlateArmor extends Armor {
    public PlateArmor(ArmorSlot slot, String name, int lvlReq, int str, int dex, int intel, int hp) {
        this.setEquipmentType(EquipmentType.Armor);
        this.setArmorClass(ArmorClass.Cloth);
        this.setArmorSlot(slot);
        this.setName(name);
        this.setLevelRequirement(lvlReq);
        this.setBaseStrength(str);
        this.setBaseDexterity(dex);
        this.setBaseIntelligence(intel);
        this.setBaseHealth(hp);
    }
}
