package no.hvl.dat108.ShoppingList.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Shoppinglist {

    private List<ShoppingItem> items = new ArrayList<>();

    public void addItem(ShoppingItem item) {
        if(items.stream().noneMatch(i -> Objects.equals(i.getName(), item.getName())))
            items.add(item);
    }

    public List<ShoppingItem> getItems() {
        return items;
    }

    public void removeItem(String item) {
        items.removeIf(i -> Objects.equals(i.getName(), item));
    }
}
