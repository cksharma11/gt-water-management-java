package org.geekheight.water_bill.water_rate;

public class Slab {
    private final int lowerBound;
    private final int upperBound;
    private final double rate;

    public Slab(int lowerBound, int upperBound, double rate) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.rate = rate;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public double getRate() {
        return rate;
    }
}


