package entities.champion.classes;

import entities.champion.Champion;
import entities.champion.ClassType;

public class Ranger extends Champion {
    public Ranger(String name) {
        this.setName(name);
        this.setStrength(5);
        this.setBaseStrength(5);
        this.setDexterity(10);
        this.setBaseDexterity(10);
        this.setIntelligence(2);
        this.setBaseIntelligence(2);
        this.setHealth(120);
        this.setMaxHealth(120);
        this.setBaseHealth(120);
        this.setLevel(1);
        this.setExperience(0);
        this.setClassType(ClassType.Ranger);
    }

    public void levelUp() {
        this.setBaseHealth(this.getBaseHealth() + 20);
        this.setBaseStrength(this.getBaseStrength() + 2);
        this.setBaseDexterity(this.getBaseDexterity() + 5);
        this.setBaseIntelligence(this.getBaseIntelligence() + 1);
        this.setLevel(this.getLevel() + 1);
        this.updateStats();
        this.setHealth(this.getMaxHealth());
    }
}
