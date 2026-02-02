package cz.macek.knight.character;

public class Dragon extends Enemy {

    public Dragon() {
        super("Drak", 5, 2); // víc HP než ostatní
    }

    @Override
    public String takeTurn(Player player) {

        // 🔥 1️⃣ pokud se nabíjel – ohnivý útok
        if (charging) {
            charging = false;
            return fireAttack(player);
        }

        double roll = Math.random();

        // 🔥 2️⃣ 30 % šance – začne nabíjet oheň
        if (roll < 0.3) {
            charging = true;
            return "Drak se zhluboka nadechuje… cítíš žár ohně!";
        }

        // 🔥 3️⃣ 30 % šance – ohnivý dech (hoření)
        if (roll < 0.6) {
            return fireBreath(player);
        }

        // 🐲 4️⃣ jinak běžný útok
        return clawAttack(player);
    }

    public String fireAttack(Player player) {

        int dmg = 3;

        if (player.hasFireResistance()) {
            dmg -= 1;
        }

        if (player.isDefending()) {
            dmg -= 1;
            if (player.hasShield()) {
                dmg -= player.getShield().getBlockPower();
            }
        }

        if (dmg < 0) dmg = 0;

        damage(player, dmg);

        return "Drak chrlí mohutný proud ohně a způsobuje "
                + dmg + " HP poškození!";
    }

    public String clawAttack(Player player) {

        int dmg = damage;

        if (player.isDefending()) {
            dmg -= 1;
        }

        if (dmg < 0) dmg = 0;

        damage(player, dmg);

        return "Drak tě zasáhl svými drápy za " + dmg + " HP.";
    }

    public String fireBreath(Player player) {

        int dmg = 1;

        if (!player.hasFireResistance()) {
            player.setLoosingHP(1); // začne hořet
        }

        damage(player, dmg);

        return "Drak tě zasáhl ohnivým dechem! "
                + "Utrpěl jsi " + dmg + " HP."
                + (player.hasFireResistance()
                ? ""
                : " Začínáš hořet!");
    }



    @Override
    public String interact(Player player) {
        return "Drak tě pozoruje svými žlutými očima...";
    }
}
