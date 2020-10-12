package entities.items.equipments.weapon.weapontypes.magicalweapon;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum MagicalWeapons {
    Wand, Scepter, Staff;


    private static final List<MagicalWeapons> VALUES =
    Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static MagicalWeapons random()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
