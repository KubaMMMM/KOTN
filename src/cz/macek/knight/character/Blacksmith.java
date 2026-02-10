package cz.macek.knight.character;

import cz.macek.knight.item.Armor;
import cz.macek.knight.main.Game;

public class Blacksmith extends Ally {

    public Blacksmith() {
        super("kovar");
    }

    @Override
    public String interact(Player player, Game game) {
        if (player.getArmor() != null) {
            return "Zbroj už máš. Víc ti teď pomoci nemohu.";
        }

        if (!player.hasItem("poklad")) {
            return "Bez peněz ti zbroj nevyrobím. Na pláži je prý vrak lodi…";
        }

        // výroba zbroje
       craftArmor(player);

        return "Kovář ti z pokladu vyrobil pevnou zbroj.";
    }

    public void craftArmor(Player player){
        player.setArmor(new Armor("zbroj", 1));
        player.getBackpack().removeItem(player.getBackpack().getItem("poklad"));
    }

   }


