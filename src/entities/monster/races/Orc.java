package entities.monster.races;

import entities.monster.Monster;
import entities.monster.MonsterType;

public class Orc extends Monster {
    public Orc() {
        this.setName("Orc");
        this.setBaseStrength(10);
        this.setStrength(10);
        this.setBaseDexterity(10);
        this.setDexterity(10);
        this.setBaseIntelligence(3);
        this.setIntelligence(3);
        this.setMaxHealth(160);
        this.setHealth(160);
        this.setLevel(1);
        this.setExperience(100);
        this.setMonsterType(MonsterType.ORC);
    }
}
