package cz.macek.knight.data;

import cz.macek.knight.character.*;
import cz.macek.knight.character.Character;

public class CharacterFactory {

    public static Character create(String charId) {

         switch (charId) {


            case "dragon":
                   return new Dragon(); // (3 HP, 2 DMG)


            case "ogre" :
                    return new Enemy("zlobr", 2, 2);


            case "imp" :
                    return new Enemy("imp", 2, 1);

            case "undead" :
                    return new Enemy("nemrtvyStrazce", 2, 1);


            case "blacksmith" :
                    return new Blacksmith();

            case "witch" :
                    return new Witch();

            case "wizard" :
                    return new Wizard();

            case "guard":
                    return new Guard("straznik");

            default :
                    throw new IllegalArgumentException(
                            "Neznamy charakter ID: " + charId
                    );
        }
    }
}