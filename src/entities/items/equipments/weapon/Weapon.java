package entities.items.equipments.weapon;

import entities.items.equipments.Equipment;

public abstract class Weapon extends Equipment {
    private WeaponType weaponType;
    private int weaponDamage;

    public void setWeaponType(WeaponType type) {
        this.weaponType = type;
    }

    public WeaponType getWeaponType() {
        return this.weaponType;
    }

    public void setWeaponDamage(int dmg) {
        this.weaponDamage = dmg;
    }

    public int getWeaponDamage() {
        return this.weaponDamage;
    }
}
