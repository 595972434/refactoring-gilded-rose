package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    private final int MAX_QUALITY = 50;
    private final int MIN_QUALITY = 0;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void daily_update() {
        Arrays.stream(items).forEach(this::updateSellInAndQuality);
    }

    private void updateSellInAndQuality(Item item) {
        if (!item.name.equals("Aged Brie")
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.quality > MIN_QUALITY) {
                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    item.quality -= 1;
                }
            }
        } else {
            if (item.quality < MAX_QUALITY) {
                item.quality += 1;

                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.sellIn < 11) {
                        if (item.quality < MAX_QUALITY) {
                            item.quality += 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < MAX_QUALITY) {
                            item.quality += 1;
                        }
                    }
                }
            }
        }

        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn -= 1;
        }

        if (item.sellIn < 0) {
            if (!item.name.equals("Aged Brie")) {
                if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.quality > MIN_QUALITY) {
                        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                            item.quality -= 1;
                        }
                    }
                } else {
                    item.quality = MIN_QUALITY;
                }
            } else {
                if (item.quality < MAX_QUALITY) {
                    item.quality += 1;
                }
            }
        }
    }
}
