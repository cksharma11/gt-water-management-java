package org.geekheight.water_bill.dto;

public class WaterAllotment {
    private int corporateWater;
    private int borewellWater;
    private int tankerWater;

    public WaterAllotment() {}

    public WaterAllotment(int corporateWater, int borewellWater) {
        this.corporateWater = corporateWater;
        this.borewellWater = borewellWater;
    }

    public int getCorporateWater() {
        return corporateWater;
    }

    public void setCorporateWater(int corporateWater) {
        this.corporateWater = corporateWater;
    }

    public int getBorewellWater() {
        return borewellWater;
    }

    public void setBorewellWater(int borewellWater) {
        this.borewellWater = borewellWater;
    }

    public int getTankerWater() {
        return tankerWater;
    }

    public void setTankerWater(int tankerWater) {
        this.tankerWater = tankerWater;
    }

    public int totalWaterAllotted() {
        return corporateWater + borewellWater + tankerWater;
    }
}

