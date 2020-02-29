
package ru.billing.client;

import java.util.Date;
import ru.billing.stocklist.*;

public class App {
    public static void main(String[] args) {
        System.out.println("Exercise 1");
        var catalog = new ItemCatalog();

        catalog.addItem(new GenericItem(), new GenericItem(), new GenericItem(), new GenericItem(), new GenericItem(),
                new GenericItem(), new GenericItem(), new GenericItem(), new GenericItem(), new GenericItem());

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

        System.out.println("Exercise 2");
        CatalogLoader loader = new CatalogStubLoader();
        loader.load(catalog);

        catalog.printItems();
    }
}
