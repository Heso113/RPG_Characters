package entities.items.equipments.weapon.weapontypes.meleeweapon;

import entities.items.equipments.EquipmentType;
import entities.items.equipments.weapon.Weapon;
import entities.items.equipments.weapon.WeaponType;

public class MeleeWeapon extends Weapon{
    public MeleeWeapon(WeaponType type, int dmg, String name, int lvlReq, int str, int dex, int intel, int hp) {
        this.setEquipmentType(EquipmentType.Weapon);
        this.setWeaponType(type);
        this.setWeaponDamage(dmg + (2 * lvlReq));
        this.setName(name);
        this.setLevelRequirement(lvlReq);
        this.setBaseStrength(str);
        this.setBaseDexterity(dex);
        this.setBaseIntelligence(intel);
        this.setBaseHealth(hp);
    }
}
