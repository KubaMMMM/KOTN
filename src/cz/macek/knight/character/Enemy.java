package cz.macek.knight.character;

public class Enemy extends Character {
    protected int hp;
    protected int damage;
    protected boolean hasChargedAttack;

    public Enemy(String name, int hp, int damage) {
        super(name);
        this.hp = hp;
        this.damage = damage;
        this.lives = hp;
        this.hasChargedAttack = false;
    }

    public String attack(Player player) {
        // Útok na hráče
        return "";
    }

    public String chargeAttack() {
        // Nabíjení útoku
        return "";
    }

    public String attackCharged(Player player) {
        // Nabytý útok
        return "";
    }

    public String die() {
        // Smrt nepřítele
        return name + " zemřel!";
    }

    public boolean isAlive() {
        return lives > 0;
    }

    public void loseLife() {
        lives--;
        hp--;
    }

    public int getHP() {
        return hp;
    }

    @Override
    public String interact(Player player) {
        return name + " je nepřítel!";
    }
}
