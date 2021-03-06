
package ru.itmo.client;

import java.util.Date;

import ru.itmo.exceptions.CatalogLoadException;
import ru.itmo.exceptions.ItemAlreadyExistsException;
import ru.itmo.stocklist.*;

public class App {
    public static void main(String[] args) {
        var catalog = new ItemCatalog();

        try {
            catalog.addItem(new GenericItem(), new GenericItem(), new GenericItem(), new GenericItem(),
                    new GenericItem(), new GenericItem(), new GenericItem(), new GenericItem(), new GenericItem(),
                    new GenericItem());
        } catch (ItemAlreadyExistsException e) {
            e.printStackTrace();
        }

        catalog.printItems();

        long begin = new Date().getTime();
        for (int i = 0; i < 100_000; i++) {
            catalog.findItemById(10);
        }
        long end = new Date().getTime();
        System.out.println("In HashMap: " + (end - begin));

        begin = new Date().getTime();
        for (int i = 0; i < 100_000; i++) {
            catalog.findItemByIdAL(10);
        }
        end = new Date().getTime();
        System.out.println("In ArrayList: " + (end - begin));

        try {
            CatalogLoader loader = new CatalogStubLoader();
            loader.load(catalog);
            catalog.printItems();
        } catch (CatalogLoadException e) {
            e.printStackTrace();
        }

        try {
            CatalogLoader fileLoader = new CatalogFileLoader("list.lst");
            fileLoader.load(catalog);
            catalog.printItems();
        } catch (CatalogLoadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
