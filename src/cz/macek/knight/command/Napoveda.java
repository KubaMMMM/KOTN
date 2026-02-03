package cz.macek.knight.command;

import cz.macek.knight.character.Player;
import cz.macek.knight.main.Game;

public class Napoveda implements Command {
    @Override
    public String execute(String param, Game game) {

        Player player = game.getCurrentPlayer();

        if (!player.hasItem("poklad")) {
            return "Vydej se na východ. Na pláži u vraku lodi se nachází něco, co budeš potřebovat.";
        }

        if (!player.hasItem("zbroj")) {
            return "S nalezeným pokladem se vrať do vesnice. Kovář ti z něj může vyrobit zbroj.";
        }

        if (!player.hasItem("castKlice1")) {
            return "V lese se nachází nebezpečí, ale také něco důležitého. Prozkoumej ho.";
        }

        if (!player.hasItem("castKlice2")) {
            return "Na louce hlídá nemrtvý strážce cenný předmět. Bez něj se dál nedostaneš.";
        }

        if (!player.hasItem("stit")) {
            return "Spoj obě části klíče a odemkni zamčenou komnatu na hradě. Najdeš tam štít.";
        }

        if (!player.hasItem("mec")) {
            return "V jeskyni se skrývá silný nepřítel. Po jeho poražení získáš zbraň.";
        }

        if (!player.hasItem("lektvar")) {
            return "Ježibaba v chýši dokáže uvařit lektvar. Potřebuje k tomu zvláštní suroviny.";
        }

        if (!player.knowsWeakness()) {
            return "Na útesech se nachází zaklínač. Může ti poradit, jak draka porazit.";
        }

        return "Jsi připraven. Vydej se na cestu k drakovi a postav se mu.";
    }
}
