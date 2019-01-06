package vending_machine.wallet;

public enum CoinType {

    ONE_PENCE(0.01, false),
    TWO_PENCE(0.02, false),
    FIVE_PENCE(0.05, true),
    TEN_PENCE(0.10, true),
    TWENTY_PENCE(0.20, true),
    FIFTY_PENCE(0.50, true),
    ONE_POUND(1.00, true),
    TWO_POUND(2.00, true);

    private final double amount;
    private final boolean valid;

    CoinType(double amount, boolean valid) {
        this.amount = amount;
        this.valid = valid;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isValid() {
        return valid;
    }
}
