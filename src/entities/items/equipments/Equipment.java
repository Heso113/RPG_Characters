package entities.items.equipments;

import entities.items.Item;

public abstract class Equipment extends Item{
    private int levelRequirement;
    private EquipmentType equipmentType;

    public void setLevelRequirement(int lvl) {
        this.levelRequirement = lvl;
    }

    public int getLevelRequirement() {
        return this.levelRequirement;
    }

    public void setEquipmentType (EquipmentType type) {
        this.equipmentType = type;
    }

    public EquipmentType getEquipmentType() {
        return this.equipmentType;
    }
}
