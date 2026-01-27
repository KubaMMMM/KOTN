package cz.macek.knight.command;

import cz.macek.knight.main.Game;

public class Prozkoumej implements Command{


    @Override
    public String execute(String param, Game game) {

        if(game.isInCombat()){
            return "nepritel vas prohledat okoli nenecha":
        }
        game.getCurrentRoom().setExamined(true);

        //TODO: "dodelat itemy a postavy"

        return "Porozhledli jste se okolo sebe a zpozorovali jste :"+ postavy,itemy;
    }
}
