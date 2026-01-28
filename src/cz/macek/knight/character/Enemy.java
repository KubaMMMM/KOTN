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

        player.damage(damage);
        return "Nepritel vas poskodil za "+ damage+ "HP";
    }

    public String chargeAttack() {
        hasChargedAttack = true;
        return "Nepritel chysta silny utok ktery dalsi kolo pouzije";
    }

    public String attackCharged(Player player) {

        if(hasChargedAttack){
            player.damage(damage+1);
            return "Nepritel vas tezce uderil za "+damage+1+ "HP";
        }

        return "CHYBA NENI CAHGENUTY ATTACK";
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
