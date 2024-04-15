package org.geekheight.water_bill.dto;

import java.util.Objects;

public class WaterRatio {
    private final int corporationRatio;
    private final int borewellRatio;

    public WaterRatio(int corporationRatio, int borewellRatio) {
        this.corporationRatio = corporationRatio;
        this.borewellRatio = borewellRatio;
    }

    public int getCorporationRatio() {
        return corporationRatio;
    }

    public int getBorewellRatio() {
        return borewellRatio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaterRatio that = (WaterRatio) o;
        return corporationRatio == that.corporationRatio && borewellRatio == that.borewellRatio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(corporationRatio, borewellRatio);
    }
}
