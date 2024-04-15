package org.geekheight.water_bill.water_rate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

public class SlabRateCalculatorTest {
    private final List<Slab> slabs = List.of(
            new Slab(0, 500, 2.0),
            new Slab(500, 1500, 3.0),
            new Slab(1500, 3000, 5.0),
            new Slab(3000, Integer.MAX_VALUE, 8.0)
    );

    @Test
    public void calculateTotalWaterCostOneSlab() {
        SlabRateCalculator slabRate = new SlabRateCalculator(slabs);
        int totalCost = slabRate.calculateTotalCost(500);
        assertEquals(1000, totalCost);
    }

    @Test
    public void calculateTotalWaterCostOneSlabPlus1() {
        SlabRateCalculator slabRate = new SlabRateCalculator(slabs);
        int totalCost = slabRate.calculateTotalCost(501);
        assertEquals(1003, totalCost);
    }

    @Test
    public void calculateTotalCostFewSlabs() {
        SlabRateCalculator slabRate = new SlabRateCalculator(slabs);
        int totalCost = slabRate.calculateTotalCost(1500);
        assertEquals(4000, totalCost);
    }

    @Test
    public void calculateTotalWaterCostAllSlabs() {
        SlabRateCalculator slabRate = new SlabRateCalculator(slabs);
        int totalCost = slabRate.calculateTotalCost(3500);
        assertEquals(15500, totalCost);
    }
}
