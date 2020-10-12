package entities.items.equipments.weapon.weapontypes.meleeweapon;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum MeleeWeapons {
    Axe, Sword, Katana;


    private static final List<MeleeWeapons> VALUES =
    Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static MeleeWeapons random()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
