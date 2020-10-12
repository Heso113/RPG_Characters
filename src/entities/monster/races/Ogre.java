package entities.monster.races;

import entities.monster.Monster;
import entities.monster.MonsterType;

public class Ogre extends Monster {
    public Ogre() {
        this.setName("Ogre");
        this.setBaseStrength(25);
        this.setStrength(25);
        this.setBaseDexterity(5);
        this.setDexterity(5);
        this.setBaseIntelligence(1);
        this.setIntelligence(1);
        this.setMaxHealth(300);
        this.setHealth(300);
        this.setLevel(1);
        this.setExperience(250);
        this.setMonsterType(MonsterType.OGRE);
    }
}
