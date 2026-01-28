package cz.macek.knight.command;

import cz.macek.knight.item.Item;
import cz.macek.knight.main.Game;

import java.util.ArrayList;

public class Vezmi implements Command{
    @Override
    public String execute(String param, Game game) {

        ArrayList<Item> items = game.getCurrentRoom().getItemsList();

        for(Item i : items){

            if(i.getName().equals(param)){
                game.getCurrentPlayer().getBackpack().addItem(i);
                game.getCurrentRoom().removeItem(i);
                return "Sebrali jste "+ i.getName()+ ".";
            }


        }
        return "Nikde v okoli se "+ param+ " nenachazi.";
    }
}
