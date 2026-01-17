package cz.macek.knight.item;

public class KeyPart extends Item {
    private int partNumber;

    public KeyPart(int partNumber) {
        super("Část klíče " + partNumber, true);
        this.partNumber = partNumber;
    }

    public int getPartNumber() {
        return partNumber;
    }
}
