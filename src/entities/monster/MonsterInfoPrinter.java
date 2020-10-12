package entities.monster;

public class MonsterInfoPrinter {
    public static void printMonsterInfo(Monster monster) {
        System.out.println("----------------------------");
        System.out.println(monster.getName() + " details:" );
        System.out.println("----------------------------");        
        System.out.println("Class: " + monster.getMonsterType().toString());
        System.out.println("Level: " + monster.getLevel());
        System.out.println("Health: " + monster.getHealth() + "/" + monster.getMaxHealth());
        System.out.println("Strength: " + monster.getStrength());
        System.out.println("Dexterity: " + monster.getDexterity());
        System.out.println("Intelligence: " + monster.getIntelligence());
        System.out.println("XP worth: " + monster.getExperience());
        System.out.println("----------------------------");
    }
}