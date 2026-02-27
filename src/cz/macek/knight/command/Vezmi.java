package cz.macek.knight.command;

import cz.macek.knight.character.Player;
import cz.macek.knight.item.Armor;
import cz.macek.knight.item.Item;
import cz.macek.knight.item.Shield;
import cz.macek.knight.item.Weapon;
import cz.macek.knight.main.Game;
import cz.macek.knight.world.CastleRoom;

import java.util.ArrayList;



public class Vezmi implements Command{

    /**
     * prikaz co se pokusi pridat do inventare vec z mistnosti
     *
     * pokud ma plny inventar pouze se vypise informace o plnosti
     * pokud je hrac v boji nemuze sbirat
     * @param param jmeno predmetu co chceme brat
     * @param game aktuální hra
     * @return zda byla vec uspesne sebrana nebo jestle ne a nebo jestli ma plny inv
     */
    @Override
    public String execute(String param, Game game) {

        ArrayList<Item> items = game.getCurrentRoom().getItemsList();

        for(Item i : items){

            if(game.getCurrentRoom().containsEnemy()){
                return "v mistnositi ti nekdi nedovoli sebrat tuto vec";
            }

            if(i.getName().equals(param)){

                if(game.getCurrentPlayer().getBackpack().isFull()){
                    return "Mate plny inventar";
                }

                if (game.getCurrentRoom() instanceof CastleRoom castle
                        && !castle.getUnlocked()) {
                    return "Komnata je zamčená.";
                }

                Player player = game.getCurrentPlayer();

                if (i instanceof Weapon w) {
                    player.setWeapon(w);
                    game.getCurrentRoom().removeItem(i);
                    return "Vybavil jsi zbraň: " + w.getName();
                }

                if (i instanceof Armor a) {
                    player.setArmor(a);
                    game.getCurrentRoom().removeItem(i);
                    return "Oblékl jsi zbroj: " + a.getName();
                }

                if (i instanceof Shield s) {
                    player.setShield(s);
                    game.getCurrentRoom().removeItem(i);
                    return "Vybavil jsi štít: " + s.getName();
                }

                game.getCurrentPlayer().getBackpack().addItem(i);
                game.getCurrentRoom().removeItem(i);
                return "Sebrali jste "+ i.getName()+ ".";
            }


        }
        return "Nikde v okoli se "+ param+ " nenachazi.";
    }
}
