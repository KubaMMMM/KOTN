package cz.macek.knight.command;

import cz.macek.knight.item.Item;
import cz.macek.knight.item.Potion;
import cz.macek.knight.main.Game;

import java.util.ArrayList;

public class Pouzij implements Command{
    @Override
    public String execute(String param, Game game) {

        ArrayList<Item> inv = game.getCurrentPlayer().getBackpack().getItems();

        for(Item i : inv){

            if(i.getName().equals("Potion")){

                Potion lektvar = (Potion) i;

                lektvar.use(game.getCurrentPlayer());
                return "Vypil jste lektvar a po pocatecnim paleni v krku se citite plny sily, jak kdyby vam srdce horelo.";
            }
            return "Dany predmet nelze pouzit";
        }
        return "CHYBA V METODE POUZIJ";
    }
}
