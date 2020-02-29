package ifmo.pt.lab4;

import java.util.LinkedList;

class GenericItem {
    private int ID;
    static int currentID = 0;
    private LinkedList<GenericItem> analogs = new LinkedList<GenericItem>();
    private String name;
    private float price;
    private Category category = Category.GENERAL;

    protected GenericItem(int ID, String name, float price, Category category) {
        this.setId(ID);
        this.setName(name);
        this.setPrice(price);
        this.setCategory(category);
    }

    public GenericItem(String name, float price, Category category) {
        this(GenericItem.currentID++, name, price, category);
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

    protected int getId() {
        return this.ID;
    }

    protected void setId(int id) {
        this.ID = id;
    }

    protected String getName() {
        return this.name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected float getPrice() {
        return this.price;
    }

    protected void setPrice(float price) {
        this.price = price;
    }

    protected Category getCategory() {
        return this.category;
    }

    protected void setCategory(Category category) {
        this.category = category;
    }

    protected LinkedList<GenericItem> getAnalogs() {
        return this.analogs;
    }

    protected void setAnalogs(LinkedList<GenericItem> analogs) {
        this.analogs = analogs;
    }
}