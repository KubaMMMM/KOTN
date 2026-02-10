package cz.macek.knight.main;

import java.util.Scanner;

class Main {
    public static void main(String[] args){


        Game game = new Game();
        game.start();

        Scanner sc = new Scanner(System.in);

        System.out.println("Hra spuštěna. Napiš 'pomoc'.");

        while (!game.getKonec()) {
            System.out.print("> ");
            String input = sc.nextLine();
            String output = game.processCommand(input);
            System.out.println(output);
        }

        System.out.println("Konec hry.");



        //TODO: udelat uzdraveni hrace?
        //TODO: opravit uhybani a obranu pri vstupu?
        //TODO: udelat UI
    }
}