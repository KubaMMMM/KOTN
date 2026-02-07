package cz.macek.knight.command;

import cz.macek.knight.item.Item;
import cz.macek.knight.main.Game;
import cz.macek.knight.world.CastleRoom;

import java.util.ArrayList;

public class Vezmi implements Command{
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

                game.getCurrentPlayer().getBackpack().addItem(i);
                game.getCurrentRoom().removeItem(i);
                return "Sebrali jste "+ i.getName()+ ".";
            }


        }
        return "Nikde v okoli se "+ param+ " nenachazi.";
    }
}
