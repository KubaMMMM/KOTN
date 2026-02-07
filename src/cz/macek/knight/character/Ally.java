package cz.macek.knight.character;

import cz.macek.knight.data.GameLoader;
import cz.macek.knight.main.Game;


/**
 * Abstraktní třída pro přátelské postavy.
 *
 * Spojenci mohou zadávat úkoly nebo pomáhat hráči.
 */
public abstract class Ally extends Character {

    private boolean questCompleted = false;


    public Ally(String name) {
        super(name);
    }

    @Override
    public abstract String interact(Player player, Game game);

    public boolean isQuestCompleted() {
        return questCompleted;
    }

    public void setQuestCompleted(boolean questCompleted) {
        this.questCompleted = questCompleted;
    }

    public String giveQuest() {
        // Zadání úkolu
        return "";
    }
}
