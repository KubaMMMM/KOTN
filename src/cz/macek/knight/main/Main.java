package cz.macek.knight.main;

import cz.macek.knight.data.GameLoader;
import cz.macek.knight.world.Room;

import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // 1️⃣ Načtení světa
        Map<String, Room> rooms = GameLoader.loadRooms("world.json");

        // 2️⃣ Nastavení startovní místnosti
        Room currentRoom = rooms.get("vesnice");

        if (currentRoom == null) {
            System.out.println("CHYBA: Startovní místnost neexistuje!");
            return;
        }

        System.out.println("Hra spuštěna.");
        System.out.println("Startovní místnost:");
        System.out.println(currentRoom.getDescription());

        // 3️⃣ Jednoduchý testovací loop
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine().toLowerCase();

            if (command.equals("konec")) {
                System.out.println("Konec hry.");
                break;
            }

            if (command.equals("jdi s")) {
                if (currentRoom.getRoomNorth() != null) {
                    currentRoom = currentRoom.getRoomNorth();
                } else {
                    System.out.println("Tímto směrem se jít nedá.");
                }
            } else if (command.equals("jdi j")) {
                if (currentRoom.getRoomSouth() != null) {
                    currentRoom = currentRoom.getRoomSouth();
                } else {
                    System.out.println("Tímto směrem se jít nedá.");
                }
            } else if (command.equals("jdi v")) {
                if (currentRoom.getRoomEast() != null) {
                    currentRoom = currentRoom.getRoomEast();
                } else {
                    System.out.println("Tímto směrem se jít nedá.");
                }
            } else if (command.equals("jdi z")) {
                if (currentRoom.getRoomWest() != null) {
                    currentRoom = currentRoom.getRoomWest();
                } else {
                    System.out.println("Tímto směrem se jít nedá.");
                }
            } else {
                System.out.println("Neznámý příkaz.");
            }

            System.out.println("Nacházíš se v místnosti:");
            System.out.println(currentRoom.getDescription());
        }

        scanner.close();
    }
}
