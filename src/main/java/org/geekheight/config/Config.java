package org.geekheight.config;

import org.geekheight.water_bill.water_rate.Slab;

import java.util.Arrays;
import java.util.List;

public class Config {
    public static final List<Slab> TANKER_WATER_SLAB_RATE = Arrays.asList(
            new Slab(0, 500, 2.0),
            new Slab(500, 1500, 3.0),
            new Slab(1500, 3000, 5.0),
            new Slab(3000, Integer.MAX_VALUE, 8.0)
    );

    public static final double BOREWELL_WATER_RATE = 1.5;
    public static final double CORPORATE_WATER_RATE = 1.0;
    public static final int DAYS_IN_MONTH = 30;
    public static final int PER_DAY_WATER_CONSUMPTION = 10;
}

