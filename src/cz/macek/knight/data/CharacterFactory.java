package cz.macek.knight.data;

import cz.macek.knight.character.*;
import cz.macek.knight.character.Character;

public class CharacterFactory {

    public static Character create(String charId) {

         switch (charId) {


            case "dragon":
                   return new Dragon(); // (3 HP, 2 DMG)


            case "ogre" :
                    return new Enemy("Zlobr", 2, 2);


            case "imp" :
                    return new Enemy("Imp", 2, 1);

            case "undead" :
                    return new Enemy("Nemrtvý strážce", 2, 1);


            case "blacksmith" :
                    return new Blacksmith();

            case "witch" :
                    return new Witch();

            case "wizard" :
                    return new Wizard();

            default :
                    throw new IllegalArgumentException(
                            "Unknown character id: " + charId
                    );
        }
    }
}