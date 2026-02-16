package cz.macek.knight.main;


import java.util.Scanner;

public class UI  {

    private Game game;



    public UI() {
    this.game = new Game();

    }

    public void gameStart(){

        System.out.println(game.start());

        Scanner sc = new Scanner(System.in);



        while (!game.getKonec()) {
            System.out.print("> ");
            String input = sc.nextLine();
            String output = game.processCommand(input);
            System.out.println(output+"\n");
        }

        System.out.println("Konec hry.");

    }

}
