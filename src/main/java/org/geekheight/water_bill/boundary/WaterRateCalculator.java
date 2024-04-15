package org.geekheight.water_bill.boundary;

public interface WaterRateCalculator {
    int calculateTotalCost(int waterConsumed);
}

