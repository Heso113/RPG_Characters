package entities.champion.classes;

import entities.champion.Champion;
import entities.champion.ClassType;

public class Mage extends Champion {
    
    public Mage(String name) {
        this.setName(name);
        this.setStrength(1);
        this.setBaseStrength(1);
        this.setDexterity(2);
        this.setBaseDexterity(2);
        this.setIntelligence(5);
        this.setBaseIntelligence(5);
        this.setHealth(100);
        this.setMaxHealth(100);
        this.setBaseHealth(100);
        this.setLevel(1);
        this.setExperience(0);
        this.setClassType(ClassType.Mage);
    }

    @Override
    public void levelUp() {
        this.setBaseHealth(this.getBaseHealth() + 15);
        this.setBaseStrength(this.getBaseStrength() + 1);
        this.setBaseDexterity(this.getBaseDexterity() + 2);
        this.setBaseIntelligence(this.getBaseIntelligence() + 5);
        this.setLevel(this.getLevel() + 1);
        this.updateStats();
        this.setHealth(this.getMaxHealth());
    }
}
