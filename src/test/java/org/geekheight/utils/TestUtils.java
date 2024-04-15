package org.geekheight.utils;

import org.geekheight.water_bill.water_rate.Slab;

import java.util.List;
import java.util.Objects;

public class TestUtils {
    public static List<Slab> getTestSlabs() {
        return List.of(
            new Slab(0, 500, 2.0),
            new Slab(500, 1500, 3.0),
            new Slab(1500, 3000, 5.0),
            new Slab(3000, Integer.MAX_VALUE, 8.0)
        );
    }

    public static String getResourcePath(String fileName) {
        return Objects.requireNonNull(TestUtils.class.getClassLoader().getResource(fileName)).getPath();
    }
}
