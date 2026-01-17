package cz.macek.knight.item;

public class Shield extends Item {
    private int blockPower;

    public Shield(String name, int blockPower) {
        super(name, true);
        this.blockPower = blockPower;
    }

    public int getBlockPower() {
        return blockPower;
    }
}