package org.geekheight.apartment;

public enum ApartmentType {
    TWO_BHK(3),
    THREE_BHK(5);

    private final int headCount;

    ApartmentType(int headCount) {
        this.headCount = headCount;
    }

    public int getMaxHeadCount() {
        return headCount;
    }
}
