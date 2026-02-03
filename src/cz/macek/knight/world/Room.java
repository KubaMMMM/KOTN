package cz.macek.knight.world;

import cz.macek.knight.character.Character;
import cz.macek.knight.character.Enemy;
import cz.macek.knight.item.Item;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Room {
    private Room roomNorth;
    private Room roomSouth;
    private Room roomEast;
    private Room roomWest;
    private String description;
    private ArrayList<Item> itemsList;
    private ArrayList<Character> characterList;
    private boolean examined;

    public Room(String description) {
        this.description = description;
        this.itemsList = new ArrayList<>();
        this.characterList = new ArrayList<>();
        this.examined = false;
    }

    public ArrayList<Enemy> getEnemies(){

        ArrayList<Enemy> enemies = new ArrayList<>();

        for(Character ch : characterList){

            if(ch instanceof Enemy){
                enemies.add((Enemy)ch);
            }
        }
        return enemies;
    }


    public boolean containsEnemy(){

        for(Character ch : characterList){

            if(ch instanceof Enemy){
                return true;
            }
        }
        return false;
    }


    public Room getRoomNorth() {
        return roomNorth;
    }

    public void setRoomNorth(Room roomNorth) {
        this.roomNorth = roomNorth;
    }

    public Room getRoomSouth() {
        return roomSouth;
    }

    public void setRoomSouth(Room roomSouth) {
        this.roomSouth = roomSouth;
    }

    public Room getRoomEast() {
        return roomEast;
    }

    public void setRoomEast(Room roomEast) {
        this.roomEast = roomEast;
    }

    public Room getRoomWest() {
        return roomWest;
    }

    public void setRoomWest(Room roomWest) {
        this.roomWest = roomWest;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Item> getItemsList() {
        return itemsList;
    }

    public void setItemsList(ArrayList<Item> itemsList) {
        this.itemsList = itemsList;
    }

    public ArrayList<Character> getCharacterList() {
        return characterList;
    }

    public void setCharacterList(ArrayList<Character> characterList) {
        this.characterList = characterList;
    }

    public boolean isExamined() {
        return examined;
    }

    public void addCharacter(Character character) {
        characterList.add(character);
    }
    public void addItem(Item item) {

        itemsList.add(item);
    }

    public void removeCharacter(Character character) {
        characterList.remove(character);
    }
    public void removeItem(Item item) {

        itemsList.remove(item);
    }



    public void setExamined() {
        this.examined = true;
    }


    public void setExamined(boolean value) {
        this.examined = value;
    }

    public Character getCharacter(String name) {

        for(Character ch : characterList){

            if(ch.getName().equals(name)){
                return ch;
            }
        }

        return null;
    }

    public String getDescription() {
        return description;
    }



}
