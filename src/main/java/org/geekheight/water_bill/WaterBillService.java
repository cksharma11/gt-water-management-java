package org.geekheight.water_bill;

import org.geekheight.apartment.ApartmentType;
import org.geekheight.config.Config;
import org.geekheight.water_bill.boundary.WaterBillServiceBoundary;
import org.geekheight.water_bill.boundary.WaterRateCalculator;
import org.geekheight.water_bill.dto.WaterAllotment;
import org.geekheight.water_bill.dto.WaterRatio;

public class WaterBillService implements WaterBillServiceBoundary {
    private final WaterRateCalculator corporateWaterRateCalculator;
    private final WaterRateCalculator borewellWaterRateCalculator;
    private final WaterRateCalculator tankerWaterRateCalculator;
    private final WaterAllotment waterAllotment = new WaterAllotment();

    public WaterBillService(WaterRateCalculator corporateWaterRateCalculator,
                            WaterRateCalculator borewellWaterRateCalculator,
                            WaterRateCalculator tankerWaterRateCalculator) {
        this.corporateWaterRateCalculator = corporateWaterRateCalculator;
        this.borewellWaterRateCalculator = borewellWaterRateCalculator;
        this.tankerWaterRateCalculator = tankerWaterRateCalculator;
    }

    @Override
    public Object allotWater(ApartmentType apartmentType, WaterRatio waterRatio) {

        int apartmentWaterAllocated = calculateApartmentWaterAllotment(apartmentType);
        WaterAllotment initialWaterAllotment = calculateInitialWaterAllotment(apartmentWaterAllocated, waterRatio);
        waterAllotment.setCorporateWater(initialWaterAllotment.getCorporateWater());
        waterAllotment.setBorewellWater(initialWaterAllotment.getBorewellWater());
        return null;
    }

    @Override
    public Object addGuest(int count) {
        int guestWaterConsumption = calculateGuestWaterConsumption(count);
        waterAllotment.setTankerWater(waterAllotment.getTankerWater() + guestWaterConsumption);
        return null;
    }

    @Override
    public String bill() {
        double corporateWaterCost = corporateWaterRateCalculator.calculateTotalCost(waterAllotment.getCorporateWater());
        double borewellWaterCost = borewellWaterRateCalculator.calculateTotalCost(waterAllotment.getBorewellWater());
        double tankerWaterCost = tankerWaterRateCalculator.calculateTotalCost(waterAllotment.getTankerWater());

        int totalCost = (int) (corporateWaterCost + borewellWaterCost + tankerWaterCost);
        return waterAllotment.totalWaterAllotted() + " " + totalCost;
    }

    public WaterAllotment getWaterAllotment() {
        return this.waterAllotment;
    }

    private int calculateApartmentWaterAllotment(ApartmentType apartmentType) {
        int headCount = apartmentType.getMaxHeadCount();
        return headCount * Config.PER_DAY_WATER_CONSUMPTION * Config.DAYS_IN_MONTH;
    }

    private WaterAllotment calculateInitialWaterAllotment(int baseWaterAllotment, WaterRatio waterRatio) {
        int corporationRatio = waterRatio.corporationRatio();
        int borewellRatio = waterRatio.borewellRatio();
        int corporationWaterAllotment = baseWaterAllotment * corporationRatio / (corporationRatio + borewellRatio);
        int borewellWaterAllotment = baseWaterAllotment * borewellRatio / (corporationRatio + borewellRatio);
        return new WaterAllotment(corporationWaterAllotment, borewellWaterAllotment);
    }

    private int calculateGuestWaterConsumption(int numGuests) {
        return numGuests * Config.PER_DAY_WATER_CONSUMPTION * Config.DAYS_IN_MONTH;
    }
}

