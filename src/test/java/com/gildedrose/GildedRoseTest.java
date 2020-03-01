package com.gildedrose;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {


    @Test
    public void sell_in_for_Sulfuras_Hand_of_Ragnaros_should_not_change_by_daily_update() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1, 5) };

        GildedRose app = new GildedRose(items);
        app.update_quality();
        assertEquals(1, app.items[0].sell_in);
    }

    @Test
    public void all_item_sell_in_should_reduce_one_except_Sulfuras_Hand_of_Ragnaros() {
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);
        app.update_quality();
        assertEquals(9, app.items[0].sell_in);
        assertEquals(1, app.items[1].sell_in);
        assertEquals(4, app.items[2].sell_in);
        assertEquals(14, app.items[3].sell_in);
        assertEquals(2, app.items[4].sell_in);
    }

    @Test
    public void the_min_quality_for_normal_item_can_be_zero() {
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 1, 0), //
                new Item("Elixir of the Mongoose", 2, 0), //
                new Item("Conjured Mana Cake", 3, 0) };
        GildedRose app = new GildedRose(items);
        app.update_quality();
        assertEquals(0, app.items[0].quality);
        assertEquals(0, app.items[1].quality);
        assertEquals(0, app.items[2].quality);
    }

    @Test
    public void the_max_quality_for_Aged_Brie_and_Backstage_passes_can_be_fifty() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 2, 50), //
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 50)};
        GildedRose app = new GildedRose(items);
        app.update_quality();
        assertEquals(50, app.items[0].quality);
        assertEquals(50, app.items[1].quality);
    }

    @Test
    public void quality_for_Sulfuras_Hand_of_Ragnaros_should_not_change_by_daily_update() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1, 5) };

        GildedRose app = new GildedRose(items);
        app.update_quality();
        assertEquals(5, app.items[0].quality);
    }

    @Test
    public void quality_should_reduce_one_by_daily_update_for_normal_item_when_sell_in_greater_than_zero() {
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 1, 10), //
                new Item("Elixir of the Mongoose", 2, 10), //
                new Item("Conjured Mana Cake", 3, 10) };
        GildedRose app = new GildedRose(items);
        app.update_quality();
        assertEquals(9, app.items[0].quality);
        assertEquals(9, app.items[1].quality);
        assertEquals(9, app.items[2].quality);
    }

    @Test
    public void quality_should_reduce_two_by_daily_update_for_normal_item_when_sell_in_not_greater_than_zero() {
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 0, 10), //
                new Item("Elixir of the Mongoose", -1, 10), //
                new Item("Conjured Mana Cake", -2, 10) };
        GildedRose app = new GildedRose(items);
        app.update_quality();
        assertEquals(8, app.items[0].quality);
        assertEquals(8, app.items[1].quality);
        assertEquals(8, app.items[2].quality);
    }

    @Test
    public void quality_should_increase_one_by_daily_update_for_Aged_Brie_when_sell_in_greater_than_zero() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 1, 10)}; //
        GildedRose app = new GildedRose(items);
        app.update_quality();
        assertEquals(11, app.items[0].quality);
    }
    @Test
    public void quality_should_increase_one_by_daily_update_for_Aged_Brie_when_sell_in_not_greater_than_zero() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 0, 10), //
                new Item("Aged Brie", -1, 10)}; //
        GildedRose app = new GildedRose(items);
        app.update_quality();
        assertEquals(12, app.items[0].quality);
        assertEquals(12, app.items[1].quality);
    }

    @Test
    public void quality_shouldincrease_one_by_daily_update_for_Backstage_passes_when_sell_in_greater_or_equal_to_eleven() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10), //
                new Item("Backstage passes to a TAFKAL80ETC concert", 12, 10)}; //
        GildedRose app = new GildedRose(items);
        app.update_quality();
        assertEquals(11, app.items[0].quality);
        assertEquals(11, app.items[1].quality);
    }

    @Test
    public void quality_shouldincrease_two_by_daily_update_for_Backstage_passes_when_sell_in_greater_or_equal_to_six_and_less_than_11() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10), //
                new Item("Backstage passes to a TAFKAL80ETC concert", 6, 10)}; //
        GildedRose app = new GildedRose(items);
        app.update_quality();
        assertEquals(12, app.items[0].quality);
        assertEquals(12, app.items[1].quality);
    }

    @Test
    public void quality_shouldincrease_two_by_daily_update_for_Backstage_passes_when_sell_in_less_than_6() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10)}; //
        GildedRose app = new GildedRose(items);
        app.update_quality();
        assertEquals(13, app.items[0].quality);
    }
}

