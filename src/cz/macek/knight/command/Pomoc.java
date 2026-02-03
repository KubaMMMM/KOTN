package cz.macek.knight.command;

import cz.macek.knight.main.Game;

public class Pomoc implements Command{
    @Override
    public String execute(String param, Game game) {
        return
                "Dostupné příkazy:\n" +
                        "----------------------------------\n" +
                        "jdi <S|J|V|Z> – přesune tě do sousední lokace daným směrem\n" +
                        "prozkoumej – prohlédne aktuální lokaci, postavy a předměty\n" +
                        "vezmi <předmět> – sebere předmět z aktuální lokace\n" +
                        "odhodit <předmět> – odhodí předmět z inventáře do lokace\n" +
                        "pouzij <předmět> – použije předmět z inventáře (např. lektvar)\n" +
                        "mluv <postava> – promluví s postavou v lokaci\n" +
                        "utok – provede útok na nepřítele v boji\n" +
                        "obrana – brání se proti příštímu útoku nepřítele\n" +
                        "uhnout – pokusí se vyhnout útoku nepřítele\n" +
                        "inventar – zobrazí obsah tvého batohu\n" +
                        "napoveda – poskytne radu, co dělat dál\n" +
                        "pomoc – zobrazí tento seznam příkazů\n" +
                        "konec – ukončí hru\n";
    }
}
