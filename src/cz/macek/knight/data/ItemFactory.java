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
                            1 // +1 dmg (drak má 2)
                    );

            // ===== OBRANA =====
            case "armor" ->
                    new Armor(
                            data.getName(),
                            1 // sníží dmg o 1
                    );

            case "shield" ->
                    new Shield(
                            data.getName(),
                            1 // blokuje silné útoky
                    );

            // ===== KLÍČE =====
            case "key_part_1" ->
                    new KeyPart(1);

            case "key_part_2" ->
                    new KeyPart(2);

            // ===== ALCHYMIE =====
            case "potion" ->
                    new Potion(data.getName());

            case "ingredient1" ->
                    new Ingredient(data.getName(), "alchemy");

            case "ingredient2" ->
                    new Ingredient(data.getName(), "alchemy");

            default ->
                    throw new IllegalArgumentException(
                            "Unknown item id: " + itemId
                    );
        };
    }
}