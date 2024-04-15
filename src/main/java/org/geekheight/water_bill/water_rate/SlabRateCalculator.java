package org.geekheight.water_bill.water_rate;

import org.geekheight.water_bill.boundary.WaterRateCalculator;

import java.util.List;

public class SlabRateCalculator implements WaterRateCalculator {
    private final List<Slab> slabs;

    public SlabRateCalculator(List<Slab> slabs) {
        this.slabs = slabs;
    }

    @Override
    public int calculateTotalCost(int waterConsumed) {
        double totalCost = 0.0;
        int remainingWater = waterConsumed;

        for (Slab slab : slabs) {
            int waterInSlab = Math.min(remainingWater, slab.getUpperBound() - slab.getLowerBound());
            totalCost += waterInSlab * slab.getRate();
            remainingWater -= waterInSlab;
            if (remainingWater <= 0) {
                break;
            }
        }

        return (int) totalCost;
    }
}

