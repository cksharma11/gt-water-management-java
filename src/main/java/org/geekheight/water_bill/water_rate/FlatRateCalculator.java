package org.geekheight.water_bill.water_rate;

import org.geekheight.water_bill.boundary.WaterRateCalculator;

public class FlatRateCalculator implements WaterRateCalculator {
    private final double rate;

    public FlatRateCalculator(double rate) {
        this.rate = rate;
    }

    @Override
    public int calculateTotalCost(int waterConsumed) {
        return (int) (waterConsumed * rate);
    }
}
