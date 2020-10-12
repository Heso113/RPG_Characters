package entities.attributes;

public abstract class CharacterAttributes extends BaseAttributes {
    private int strength;
    private int dexterity;
    private int intelligence;
    private int maxHealth;
    private int health;
    private int level;
    private int experience;

    public void setStrength(int str) {
        this.strength = str;
    }

    public int getStrength() {
        return this.strength;
    }

    public void setDexterity(int dex) {
        this.dexterity = dex;
    }

    public int getDexterity() {
        return this.dexterity;
    }

    public void setIntelligence(int intel) {
        this.intelligence = intel;
    }

    public int getIntelligence() {
        return this.intelligence;
    }

    public void setMaxHealth(int hp) {
        this.maxHealth = hp;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public void setHealth(int hp) {
        this.health = hp;
    }

    public int getHealth() {
        return this.health;
    }

    public void setLevel(int lvl) {
        this.level = lvl;
    }

    public int getLevel() {
        return this.level;
    }

    public void setExperience(int xp) {
        this.experience = xp;
    }

    public int getExperience() {
        return this.experience;
    }    
}