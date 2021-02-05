package entities.Items;

import entities.Items.Item;

import java.util.ArrayList;
import java.util.List;

public class Recipe extends Item {
    private List<String> requiredItems;

    public Recipe() {
        this.requiredItems = new ArrayList<>();
    }

    public List<String> getRequiredItems() {
        return this.requiredItems;
    }

    public void addToRequiredItems(String item) {
        this.requiredItems.add(item);
    }
}
