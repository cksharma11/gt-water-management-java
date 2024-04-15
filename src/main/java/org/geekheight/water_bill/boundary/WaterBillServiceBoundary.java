package org.geekheight.water_bill.boundary;

import org.geekheight.apartment.ApartmentType;
import org.geekheight.water_bill.dto.WaterRatio;

public interface WaterBillServiceBoundary {
    Object allotWater(ApartmentType apartmentType, WaterRatio waterRatio);

    Object addGuest(int count);

    String bill();
}

