package ifmo.pt.lab4;

import java.util.LinkedList;

class TechnicalItem extends GenericItem {
    short warrantyTime;

    TechnicalItem(int ID, String name, float price, Category category, short warrantyTime) {
        super(ID, name, price, category);
        this.warrantyTime = warrantyTime;
    }

    @Override
    public String toString() {
        return String.format("%s | WarrantyTime: %s", super.toString(), this.warrantyTime);
    }

    @Override
    protected Object clone() {
        TechnicalItem item = new TechnicalItem(this.ID, this.name, this.price, this.category, this.warrantyTime);
        item.analogs = (LinkedList<GenericItem>) this.analogs.clone();
        return item;
    }

    // can be removed due redundancy
    @Override
    void printAll() {
        super.printAll(); // implementation use Override toString
    }
}