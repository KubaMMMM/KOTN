package cz.macek.knight.command;

import cz.macek.knight.character.Player;
import cz.macek.knight.main.Game;

public class Inventar implements Command{
    @Override
    public String execute(String param, Game game) {

        Player player = game.getCurrentPlayer();

        String vypis = "Obsah vaseho batohu: " + "\n";

        vypis += player.getBackpack().toString();

        if(player.getBackpack().isFull()){
            vypis += "\n"+"vas batoh je plny";
        }else {
            vypis += "\n"+"v batohu mate jeste ";
            vypis += player.getBackpack().getSize()-player.getBackpack().getItems().size();
            vypis += " mist";
        }

        return vypis;
    }
}
