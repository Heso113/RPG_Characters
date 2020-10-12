package entities.attributes;

public abstract class BaseAttributes {
    private int baseStrength;
    private int baseDexterity;
    private int baseIntelligence;
    private int baseHealth;
    private String name;

    public void setBaseStrength(int str) {
        this.baseStrength = str;
    }

    public int getBaseStrength() {
        return this.baseStrength;
    }

    public void setBaseDexterity(int dex) {
        this.baseDexterity = dex;
    }

    public int getBaseDexterity() {
        return this.baseDexterity;
    }

    public void setBaseIntelligence(int intel) {
        this.baseIntelligence = intel;
    }

    public int getBaseIntelligence() {
        return this.baseIntelligence;
    }

    public void setBaseHealth(int hp) {
        this.baseHealth = hp;
    }

    public int getBaseHealth() {
        return this.baseHealth;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getName() {
        return this.name;
    }

}
