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


    public ProductType getProductByCode(String code) {
        ProductType foundProduct = null;
        for (ProductType product : products) {
            if (code.equals(product.getCode())) {
                foundProduct = product;
                products.remove(product);
                return foundProduct;
            }
        }
        return foundProduct;
    }

    public boolean checkAmountEnoughForProduct(ProductType product, double amount) {
        if (product.getPrice() <= amount) {
            return true;
        }
        return false;
    }

    public double checkRemainingAmount(ProductType product, double amount) {
        return product.getPrice() - amount;
    }
}
