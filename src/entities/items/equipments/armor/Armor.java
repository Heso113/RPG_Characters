package entities.items.equipments.armor;

import entities.items.equipments.Equipment;

public abstract class Armor extends Equipment{
    private ArmorSlot armorSlot;
    private ArmorClass armorClass;

    public void setArmorSlot(ArmorSlot slot) {
        this.armorSlot = slot;
    }

    public ArmorSlot getArmorSlot() {
        return this.armorSlot;
    }

    public void setArmorClass(ArmorClass ac) {
        this.armorClass = ac;
    }

    public ArmorClass getArmorClass() {
        return this.armorClass;
    }
    
}
