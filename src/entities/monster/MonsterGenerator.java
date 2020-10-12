package entities.monster;

import entities.monster.races.*;

public class MonsterGenerator {
    public static Monster generateMonster(MonsterType type) {
        Monster newMonster = null;
        switch (type) {
            case GOBLIN:
            {
                newMonster = new Goblin();
                break;
            }
            case ORC:
            {
                newMonster = new Orc();
                break;
            }
            case OGRE:
            {
                newMonster = new Ogre();
                break;
            }
            case DRAGON:
            {
                newMonster = new Dragon();
                break;
            }
            default:
                break;
        }
        return newMonster;
    }
}
