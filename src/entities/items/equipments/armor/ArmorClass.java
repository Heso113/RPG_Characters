package entities.items.equipments.armor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum ArmorClass {
    Cloth, Leather, Plate;

    private static final List<ArmorClass> VALUES =
    Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static ArmorClass random()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
