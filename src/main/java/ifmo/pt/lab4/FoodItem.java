package ifmo.pt.lab4;

import java.util.Date;
import java.util.LinkedList;

class FoodItem extends GenericItem {

    Date dateOfIncome;
    short expires;

    FoodItem(int ID, String name, float price, Category category, Date dateOfIncome, short expires) {
        super(ID, name, price, category);
        this.dateOfIncome = dateOfIncome;
        this.expires = expires;
    }

    public FoodItem(String name, float price, FoodItem analog, Date date, short expires) {
        this.name = name;
        this.price = price;
        this.addAnalog(analog);
        this.dateOfIncome = date;
        this.expires = expires;
    }

    public FoodItem(String name, float price, short expires) {
        this(name, price, null, null, expires);
    }

    public FoodItem(String name) {
        this(name, 0f, null, null, (short) 32);
    }

    @Override
    public String toString() {
        return String.format("%s | DateOfIncome: %s | Expires: %s", super.toString(), this.dateOfIncome, this.expires);
    }

    @Override
    protected Object clone() {
        FoodItem item = new FoodItem(this.ID, this.name, this.price, this.category, this.dateOfIncome, this.expires);
        item.analogs = (LinkedList<GenericItem>) this.analogs.clone();
        return item;
    }

}