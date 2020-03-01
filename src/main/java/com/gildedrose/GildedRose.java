package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void daily_update() {
        Arrays.stream(items).forEach(this::updateSellInAndQuality);
    }

    private void updateSellInAndQuality(Item item) {
        switch (item.name){
            case "Aged Brie":
                if (item.sellIn>0) item.updateQuality(1);
                else item.updateQuality(2);
                item.updateSellIn(-1);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                if (item.sellIn>=11) item.updateQuality(1);
                else if(item.sellIn>=6) item.updateQuality(2);
                else if (item.sellIn>0) item.updateQuality(3);
                else item.setQualityToZero();
                item.updateSellIn(-1);
                break;
            case "Sulfuras, Hand of Ragnaros":
                break;
            default:
                if (item.sellIn>0) item.updateQuality(-1);
                else item.updateQuality(-2);
                item.updateSellIn(-1);
                break;
        }
    }
}
