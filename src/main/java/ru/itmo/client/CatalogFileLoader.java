package ru.itmo.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

import ru.itmo.exceptions.CatalogLoadException;
import ru.itmo.exceptions.ItemAlreadyExistsException;
import ru.itmo.stocklist.FoodItem;
import ru.itmo.stocklist.ItemCatalog;

class CatalogFileLoader implements CatalogLoader {
    private String filename;

    public CatalogFileLoader(String filename) {
        this.filename = filename;
    }

    @Override
    public void load(ItemCatalog catalog) throws CatalogLoadException {
        var file = new File(filename);
        String line;
        try {
            var scanner = new Scanner(new FileInputStream(file));
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (line.length() == 0)
                    break;
                String[] itemFields = line.split(";");
                var name = itemFields[0];
                var price = Float.parseFloat(itemFields[1]);
                var expires = Short.parseShort(itemFields[2]);
                var item = new FoodItem(name, price, null, new Date(), expires);
                catalog.addItem(item);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new CatalogLoadException();
        } catch (ItemAlreadyExistsException e) {
            e.printStackTrace();
            throw new CatalogLoadException();
        }
    }

}