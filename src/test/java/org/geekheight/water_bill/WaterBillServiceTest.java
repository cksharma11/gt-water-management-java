package org.geekheight.water_bill;

import static org.junit.jupiter.api.Assertions.*;

import org.geekheight.apartment.ApartmentType;
import org.geekheight.utils.TestUtils;
import org.geekheight.water_bill.boundary.WaterRateCalculator;
import org.geekheight.water_bill.dto.WaterRatio;
import org.geekheight.water_bill.water_rate.FlatRateCalculator;
import org.geekheight.water_bill.water_rate.SlabRateCalculator;
import org.junit.jupiter.api.Test;

public class WaterBillServiceTest {
    @Test
    public void testAllotWater() {
        WaterRateCalculator corporateWaterRateCalculator = new FlatRateCalculator(2.0);
        WaterRateCalculator borewellWaterRateCalculator = new FlatRateCalculator(1.5);
        WaterRateCalculator tankerWaterRateCalculator = new SlabRateCalculator(TestUtils.getTestSlabs());

        WaterBillService waterBillService = new WaterBillService(corporateWaterRateCalculator, borewellWaterRateCalculator, tankerWaterRateCalculator);

        WaterRatio waterRatio = new WaterRatio(3, 7);
        waterBillService.allotWater(ApartmentType.TWO_BHK, waterRatio);

        assertEquals(270, waterBillService.getWaterAllotment().getCorporateWater());
        assertEquals(630, waterBillService.getWaterAllotment().getBorewellWater());
    }

    @Test
    public void testAddGuest() {
        WaterRateCalculator corporateWaterRateCalculator = new FlatRateCalculator(2.0);
        WaterRateCalculator borewellWaterRateCalculator = new FlatRateCalculator(1.5);
        WaterRateCalculator tankerWaterRateCalculator = new SlabRateCalculator(TestUtils.getTestSlabs());

        WaterBillService waterBillService = new WaterBillService(corporateWaterRateCalculator, borewellWaterRateCalculator, tankerWaterRateCalculator);

        waterBillService.addGuest(5);

        assertEquals(1500, waterBillService.getWaterAllotment().getTankerWater());
    }

    @Test
    public void testBill() {
        WaterRateCalculator corporateWaterRateCalculator = new FlatRateCalculator(1.0);
        WaterRateCalculator borewellWaterRateCalculator = new FlatRateCalculator(1.5);
        WaterRateCalculator tankerWaterRateCalculator = new SlabRateCalculator(TestUtils.getTestSlabs());

        WaterBillService waterBillService = new WaterBillService(corporateWaterRateCalculator, borewellWaterRateCalculator, tankerWaterRateCalculator);

        waterBillService.allotWater(ApartmentType.TWO_BHK, new WaterRatio(3, 7));
        waterBillService.addGuest(5);

        assertEquals("2400 5215", waterBillService.bill());
    }
}
