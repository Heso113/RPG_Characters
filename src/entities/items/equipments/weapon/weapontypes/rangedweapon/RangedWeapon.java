package entities.items.equipments.weapon.weapontypes.rangedweapon;

import entities.items.equipments.EquipmentType;
import entities.items.equipments.weapon.Weapon;
import entities.items.equipments.weapon.WeaponType;

public class RangedWeapon extends Weapon {
    public RangedWeapon(WeaponType type, int dmg, String name, int lvlReq, int str, int dex, int intel, int hp) {
        this.setEquipmentType(EquipmentType.Weapon);
        this.setWeaponType(type);
        this.setWeaponDamage(dmg + (3 * lvlReq));
        this.setName(name);
        this.setLevelRequirement(lvlReq);
        this.setBaseStrength(str);
        this.setBaseDexterity(dex);
        this.setBaseIntelligence(intel);
        this.setBaseHealth(hp);
    }
}
