package vending_machine.inventory;

import java.util.ArrayList;

public class ProductDispenser {

    private ArrayList<ProductType> products;

    public ProductDispenser() {
        this.products = new ArrayList<>();
    }

    public ArrayList<ProductType> getProducts() {
        return products;
    }

    public void addProduct(ProductType product) {
        products.add(product);
    }

    public boolean removeProduct(ProductType product) {
        return products.remove(product);
    }

    public void fill() {
        int count = 1;
        while (count < 21) {
            addProduct(ProductType.GINGER_BREAD_ROBBIE);
            addProduct(ProductType.ROBBIES_MOONSHINE);
            addProduct(ProductType.CARDBOARD_CRISPS);
            count++;
        }
    }
}
