package cz.macek.knight.character;

public abstract class Ally extends Character {

    private boolean questCompleted = false;

    public Ally(String name) {
        super(name);
    }

    @Override
    public abstract String interact(Player player);

    public boolean isQuestCompleted() {
        return questCompleted;
    }

    public void setQuestCompleted(boolean questCompleted) {
        this.questCompleted = questCompleted;
    }

    public String giveQuest() {
        // Zadání úkolu
        return "";
    }
}
