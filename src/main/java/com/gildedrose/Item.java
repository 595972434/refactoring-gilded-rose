package com.gildedrose;

public class Item {

    private final int MAX_QUALITY = 50;
    private final int MIN_QUALITY = 0;
    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void updateSellIn(int increment) {
        sellIn += increment;
    }

    public void updateQuality(int increment) {
        quality += increment;
        if (quality > MAX_QUALITY) quality = MAX_QUALITY;
        if (quality < MIN_QUALITY) quality = MIN_QUALITY;
    }

    public void setQualityToZero() {
        quality = 0;
    }
}
