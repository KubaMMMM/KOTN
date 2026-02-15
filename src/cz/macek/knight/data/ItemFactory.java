package cz.macek.knight.data;

import cz.macek.knight.item.*;

public class ItemFactory {

    public static Item create(String itemId, ItemData data) {

        switch (itemId) {


            case "treasure" :
            {
                return new Treasure();
            }


            case "sword" :
                    return new Weapon(
                            data.getName(),
                            data.getDamage()
                    );


            case "armor" :
                    return new Armor(
                            data.getName(),
                            data.getDefense()
                    );

            case "shield" :
                    return new Shield(
                            data.getName(),
                            data.getBlockPower()
                    );


            case "key_part_1" :
                    return new KeyPart(data.getPartNumber());

            case "key_part_2" :
                    return new KeyPart(data.getPartNumber());


            case "potion" :
                    return new Potion(data.getName());

            case "ingredient1" :
                    return new Ingredient(data.getName());

            case "ingredient2" :
                    return new Ingredient(data.getName());

            default :
                    throw new IllegalArgumentException(
                            "Neznamy item ID: " + itemId
                    );
        }
    }
}