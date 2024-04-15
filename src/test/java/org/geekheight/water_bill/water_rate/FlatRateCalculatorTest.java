package org.geekheight.water_bill.water_rate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlatRateCalculatorTest {
    @Test
    public void calculateTotalCost() {
        FlatRateCalculator flatRateCalculator = new FlatRateCalculator(1.0);
        int totalCost = flatRateCalculator.calculateTotalCost(1000);
        assertEquals(1000, totalCost);
    }

    @Test
    public void calculateTotalCostDecimalRate() {
        FlatRateCalculator flatRateCalculator = new FlatRateCalculator(1.5);
        int totalCost = flatRateCalculator.calculateTotalCost(1000);
        assertEquals(1500, totalCost);
    }
}
