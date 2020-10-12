package entities.monster;

import entities.attributes.CharacterAttributes;

public abstract class Monster extends CharacterAttributes {
    private MonsterType type;

    public void setMonsterType(MonsterType t) {
        this.type = t;
    }

    public MonsterType getMonsterType() {
        return this.type;
    }
}
