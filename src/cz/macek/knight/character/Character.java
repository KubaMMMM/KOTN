package cz.macek.knight.character;

import cz.macek.knight.world.Room;


public abstract class Character {
    protected Room position;
    protected String name;
    protected int lives;

    public Character(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String interact(Player player);

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
}