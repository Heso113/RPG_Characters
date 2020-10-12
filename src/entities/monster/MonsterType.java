package entities.monster;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum MonsterType {
    GOBLIN, ORC, OGRE, DRAGON; 
    
    private static final List<MonsterType> VALUES =
    Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static MonsterType random()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}