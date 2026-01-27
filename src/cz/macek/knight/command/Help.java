package cz.macek.knight.command;

import cz.macek.knight.main.Game;

public class Help implements Command{
    @Override
    public String execute(String param, Game game) {
        return  "\uF0B7 jdi <světová strana(S,J,V,Z)> – přesune hráče do jiné lokace\n" +
                "\uF0B7 prozkoumej – detailně prohledá aktuální lokaci\n" +
                "\uF0B7 vezmi <předmět> – sebere předmět\n" +
                "\uF0B7 pouzij <předmět> – použije předmět z inventáře\n" +
                "\uF0B7 mluv <postava> – zahájí interakci s NPC\n" +
                "\uF0B7 utok – provede útok v boji\n" +
                "\uF0B7 obrana – brání se proti útoku\n" +
                "\uF0B7 uhnout – pokusí se vyhnout útoku\n" +
                "\uF0B7 inventar - zobrazí obsah inventáře\n" +
                "\uF0B7 pomoc - zobrazí seznam všech dostupných příkazů\n" +
                "\uF0B7 napoveda - poskytne radu specifickou pro aktuální situaci nebo lokaci\n" +
                "\uF0B7 konec – ukončí hru\n";
    }
}
