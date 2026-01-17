package cz.macek.knight.character;

public class Dragon extends Enemy {

    public Dragon() {
        super("Drak", 3, 1);
    }

    public String fireAttack(Player player) {
        // Ohnivý útok
        return "";
    }

    @Override
    public String interact(Player player) {
        return "Drak tě pozoruje svými žlutými očima...";
    }
}
