package ru.itmo.stocklist;

import java.util.HashMap;

import ru.itmo.exceptions.ItemAlreadyExistsException;

import java.util.ArrayList;

public class ItemCatalog {
    private HashMap<Integer, GenericItem> catalog = new HashMap<Integer, GenericItem>();
    private ArrayList<GenericItem> ALCatalog = new ArrayList<GenericItem>();

    public void addItem(GenericItem item) throws ItemAlreadyExistsException {
        if (catalog.containsKey(item.getId())) {
            throw new ItemAlreadyExistsException();
        }

        catalog.put(item.getId(), item);
        ALCatalog.add(item);
    }

    public void addItem(GenericItem... items) throws ItemAlreadyExistsException {
        for (var item : items) {
            this.addItem(item);
        }
    }

    public void printItems() {
        for (GenericItem i : ALCatalog) {
            System.out.println(i);
        }
    }

    public GenericItem findItemById(int id) {
        return catalog.getOrDefault(id, null);
    }

    public GenericItem findItemByIdAL(int id) {
        for (GenericItem item : ALCatalog) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}