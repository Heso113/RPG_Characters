package entities.items.equipments.weapon;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum WeaponType {
    Melee, Ranged, Magical;


    private static final List<WeaponType> VALUES =
    Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static WeaponType random()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}