package cz.macek.knight.command;

import cz.macek.knight.item.Item;
import cz.macek.knight.main.Game;

public class Odhodit implements Command{
    @Override
    public String execute(String param, Game game) {

        if(game.getCurrentPlayer().hasItem(param)){

            Item i = game.getCurrentPlayer().getBackpack().getItem(param);
            game.getCurrentRoom().addItem(i);
            game.getCurrentPlayer().getBackpack().removeItem(i);

            return "Zahodil jste "+ i.getName()+ " v "+game.getCurrentRoom().getDescription();
        }
        return "Nemate tento predmet";
    }
}
