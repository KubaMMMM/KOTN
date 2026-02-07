package cz.macek.knight.item;

public class KeyPart extends Item {
    private int partNumber;

    public KeyPart(int partNumber) {
        super("castKlice" + partNumber);
        this.partNumber = partNumber;
    }

    public int getPartNumber() {
        return partNumber;
    }
}
