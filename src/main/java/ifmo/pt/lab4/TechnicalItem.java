package ifmo.pt.lab4;

import java.util.LinkedList;

class TechnicalItem extends GenericItem {
    private short warrantyTime;

    TechnicalItem(int ID, String name, float price, Category category, short warrantyTime) {
        super(ID, name, price, category);
        this.setWarrantyTime(warrantyTime);
    }

    @Override
    public String toString() {
        return String.format("%s | WarrantyTime: %s", super.toString(), this.getWarrantyTime());
    }

    @Override
    protected Object clone() {
        TechnicalItem item = new TechnicalItem(this.getId(), this.getName(), this.getPrice(), this.getCategory(),
                this.getWarrantyTime());
        item.setAnalogs((LinkedList<GenericItem>) this.getAnalogs().clone());
        return item;
    }

    protected short getWarrantyTime() {
        return this.warrantyTime;
    }

    protected void setWarrantyTime(short warrantyTime) {
        this.warrantyTime = warrantyTime;
    }

}