package ifmo.pt.lab4;

import java.util.LinkedList;

class GenericItem {
    public int ID;
    static int currentID = 0;
    public LinkedList<GenericItem> analogs = new LinkedList<GenericItem>();
    public String name;
    public float price;
    public Category category = Category.GENERAL;

    public GenericItem(int ID, String name, float price, Category category) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public GenericItem(String name, float price, Category category) {
        this.ID = GenericItem.currentID++;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public GenericItem(String name, float price, GenericItem analog) {
        this(name, price, Category.GENERAL);
        this.addAnalog(analog);
    }

    public GenericItem() {
        this("Untitled", 0f, Category.GENERAL);
    }

    void addAnalog(GenericItem analog) {
        this.analogs.push(analog);
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %-20s | Price: %5.2f | Category: %s", ID, name, price, category);
    }

    @Override
    protected Object clone() {
        GenericItem item = new GenericItem(this.ID, this.name, this.price, this.category);
        return item;
    }

    void printAll() {
        System.out.println(this.toString());
    }

}