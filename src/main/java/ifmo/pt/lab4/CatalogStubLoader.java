package ifmo.pt.lab4;

class CatalogStubLoader implements CatalogLoader {

    @Override
    public void load(ItemCatalog catalog) {
        GenericItem item1 = new GenericItem("Sony TV", 23_000, Category.GENERAL);
        FoodItem item2 = new FoodItem("Bread", 12, null, new Date(), (short) 10);
        catalog.addItem(item1, item2);
    }

}