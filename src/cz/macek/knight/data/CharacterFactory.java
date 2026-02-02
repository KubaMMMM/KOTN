package cz.macek.knight.data;

import cz.macek.knight.character.*;
import cz.macek.knight.character.Character;

public class CharacterFactory {

    public static Character create(String charId) {

        return switch (charId) {

            // ===== FINÁLNÍ BOSS =====
            case "dragon" ->
                    new Dragon(); // (3 HP, 2 DMG)

            // ===== SILNÍ NEPŘÁTELÉ =====
            case "ogre" ->
                    new Enemy("Zlobr", 2, 2);

            // ===== STŘEDNÍ NEPŘÁTELÉ =====
            case "imp" ->
                    new Enemy("Imp", 2, 1);

            case "undead" ->
                    new Enemy("Nemrtvý strážce", 2, 1);

            // ===== SPOJENCI =====
            case "blacksmith" ->
                    new Blacksmith();

            case "witch" ->
                    new Witch();

            case "wizard" ->
                    new Wizard();

            default ->
                    throw new IllegalArgumentException(
                            "Unknown character id: " + charId
                    );
        };
    }
}