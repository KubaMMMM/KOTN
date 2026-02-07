package cz.macek.knight.character;

import cz.macek.knight.item.Potion;
import cz.macek.knight.main.Game;

public class Witch extends Ally {

    private boolean potionGiven;

    public Witch() {
        super("Ježibaba");
        this.potionGiven = false;
    }

    @Override
    public String interact(Player player, Game game) {


        if(potionGiven){

            return "Lektvar uz mas, tak si jdi po svych";
        }

        if(!player.getBackpack().hasItem("magickaHouba") || !player.getBackpack().hasItem("obsidianoveJablko")){

            return "Nemas potrebne ingredience pro vyrobu lektvaru";
        }

        brewPotion(player);

        return "Jezibaba ti uvarila lektvar odolnosti proti ohni";

    }

    public void brewPotion(Player player) {

        Potion p = new Potion("lektvar");

        player.getBackpack().addItem(p);
        potionGiven = true;

    }
}
