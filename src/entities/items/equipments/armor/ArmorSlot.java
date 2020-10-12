package entities.items.equipments.armor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum ArmorSlot {
    Head, Body, Legs;

    private static final List<ArmorSlot> VALUES =
    Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static ArmorSlot random()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
