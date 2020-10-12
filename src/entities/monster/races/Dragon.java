package entities.monster.races;

import entities.monster.Monster;
import entities.monster.MonsterType;

public class Dragon extends Monster{
    public Dragon() {
        this.setName("Dragon");
        this.setBaseStrength(50);
        this.setStrength(50);
        this.setBaseDexterity(50);
        this.setDexterity(50);
        this.setBaseIntelligence(50);
        this.setIntelligence(50);
        this.setMaxHealth(1000);
        this.setHealth(1000);
        this.setLevel(1);
        this.setExperience(2000);
        this.setMonsterType(MonsterType.DRAGON);
    }
}
