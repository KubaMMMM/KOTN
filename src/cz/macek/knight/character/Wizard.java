package cz.macek.knight.character;

import cz.macek.knight.main.Game;
import cz.macek.knight.world.Room;

public class Wizard extends Ally {

    public Wizard() {
        super("zaklinac");
    }

    @Override
    public String interact(Player player, Game game) {

        if(player.knowsWeakness()){
            return "Zaklinac: Drak uz nema dalsi slabiny.";
        }

        if(!game.isOgreDefeated()){
            return "Zaklinac: Kdyz zbavis jeskyni u pole obra tak ti prozradim drakovu slabinu.";
        }

        revealWeakness(player);
        return "Zaklicnac ti prozradil drakovo slabe misto";

    }

    public void revealWeakness(Player player) {

        player.setKnowsWeakness(true);
    }
}