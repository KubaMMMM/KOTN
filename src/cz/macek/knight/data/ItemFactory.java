package cz.macek.knight.data;

import cz.macek.knight.item.*;

public class ItemFactory {

    public static Item create(String itemId, ItemData data) {

        return switch (itemId) {


            case "treasure" ->
                    new Treasure();

            // ===== ZBRANĚ =====
            case "sword" ->
                    new Weapon(
                            data.getName(),
                            data.getDamage()
                    );

            // ===== OBRANA =====
            case "armor" ->
                    new Armor(
                            data.getName(),
                            data.getDefense()
                    );

            case "shield" ->
                    new Shield(
                            data.getName(),
                            data.getBlockPower()
                    );

            // ===== KLÍČE =====
            case "key_part_1" ->
                    new KeyPart(data.getPartNumber());

            case "key_part_2" ->
                    new KeyPart(data.getPartNumber());

            // ===== ALCHYMIE =====
            case "potion" ->
                    new Potion(data.getName());

            case "ingredient1" ->
                    new Ingredient(data.getName());

            case "ingredient2" ->
                    new Ingredient(data.getName());

            default ->
                    throw new IllegalArgumentException(
                            "Unknown item id: " + itemId
                    );
        };
    }
}