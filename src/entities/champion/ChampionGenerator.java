package entities.champion;

import entities.champion.classes.*;
import entities.items.equipments.EquipmentGenerator;

public class ChampionGenerator {

    public static Champion generateChampion(ClassType type, String name) {
        Champion newChampion = null;
        switch (type) {
            case Warrior:
            {
                newChampion = new Warrior(name);
                break;
            }
            case Ranger:
            {
                newChampion = new Ranger(name);
                break;
            }
            case Mage:
            {
                newChampion = new Mage(name);
                break;
            }
            default:
                break;
        }
        newChampion.getEquippedItem()[0] = EquipmentGenerator.generateStarterWeapon(newChampion.getClassType());
        return newChampion;
    }
}
