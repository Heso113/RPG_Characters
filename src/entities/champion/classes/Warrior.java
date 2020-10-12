package entities.champion.classes;

import entities.champion.Champion;
import entities.champion.ClassType;

public class Warrior extends Champion {
    

    public Warrior(String name) {
        this.setName(name);
        this.setStrength(10);
        this.setBaseStrength(10);
        this.setDexterity(3);
        this.setBaseDexterity(3);
        this.setIntelligence(1);
        this.setBaseIntelligence(1);
        this.setHealth(150);
        this.setMaxHealth(150);
        this.setBaseHealth(150);
        this.setLevel(1);
        this.setExperience(0);
        this.setClassType(ClassType.Warrior);
    }

    public void levelUp() {
        this.setBaseHealth(this.getBaseHealth() + 30);
        this.setBaseStrength(this.getBaseStrength() + 5);
        this.setBaseDexterity(this.getBaseDexterity() + 2);
        this.setBaseIntelligence(this.getBaseIntelligence() + 1);
        this.setLevel(this.getLevel() + 1);
        this.updateStats();
        this.setHealth(this.getMaxHealth());
    }
}
