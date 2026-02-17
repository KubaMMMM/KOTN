package cz.macek.knight.world;

import cz.macek.knight.character.Player;
import cz.macek.knight.item.Item;

import java.util.ArrayList;


public class CastleRoom extends Room {

    private boolean isUnlocked;

    public CastleRoom(String description) {
        super(description);
        this.isUnlocked = false;
    }

    @Override
    public ArrayList<Item> getItemsList() {
        if (this instanceof CastleRoom castle && !castle.getUnlocked()) {
            return new ArrayList<>(); // nic tam není vidět
        }
        return super.getItemsList();
    }


    public String getDescription() {

        if(isUnlocked){
            return clearedDescription;
        }

        return description;
    }

    public String vypisEntit() {
        StringBuilder sb = new StringBuilder();

        if(isUnlocked){

        for (int i = 0; i < characterList.size(); i++) {

            if (i == characterList.size() - 1) {
                sb.append(characterList.get(i) + " ");

            } else {
                sb.append(characterList.get(i) + ", ");
            }
        }

        for (int i = 0; i < itemsList.size(); i++) {

            if (i == itemsList.size() - 1) {
                sb.append(itemsList.get(i) + " ");
            } else {
                sb.append(itemsList.get(i) + ", ");
            }
        }

            if(sb.length() == 0){
                return "nic";
            }

            return sb.toString();
        }
        return "zamcena komnata";
    }

    public void unlock() {
        this.isUnlocked = true;
    }

    public boolean getUnlocked() {
        return isUnlocked;
    }
}
 

