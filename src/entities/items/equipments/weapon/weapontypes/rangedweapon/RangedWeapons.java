package entities.items.equipments.weapon.weapontypes.rangedweapon;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum RangedWeapons {
    Slingshot, Bow, Crossbow;


    private static final List<RangedWeapons> VALUES =
    Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static RangedWeapons random()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
