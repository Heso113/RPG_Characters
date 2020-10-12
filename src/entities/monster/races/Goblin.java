package entities.monster.races;

import entities.monster.Monster;
import entities.monster.MonsterType;

public class Goblin extends Monster {
    public Goblin() {
        this.setName("Goblin");
        this.setBaseStrength(3);
        this.setStrength(3);
        this.setBaseDexterity(8);
        this.setDexterity(8);
        this.setBaseIntelligence(1);
        this.setIntelligence(1);
        this.setMaxHealth(80);
        this.setHealth(80);
        this.setLevel(1);
        this.setExperience(50);
        this.setMonsterType(MonsterType.GOBLIN);
    }
}
