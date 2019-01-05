package vending_machine.inventory;

public enum ProductType {

    ROBBIES_MOONSHINE("RM1", 1.00),
    CARDBOARD_CRISPS("CC1", 0.50),
    GINGER_BREAD_ROBBIE("GBR1", 0.65);

    private final String code;
    private final double price;

    ProductType(String code, double price) {
        this.code = code;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public double getPrice() {
        return price;
    }
}
