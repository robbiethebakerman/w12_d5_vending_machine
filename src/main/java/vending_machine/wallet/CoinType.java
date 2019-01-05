package vending_machine.wallet;

public enum CoinType {

    ONEPENCE(0.01, false),
    TWOPENCE(0.02, false),
    FIVEPENCE(0.05, true),
    TENPENCE(0.10, true),
    TWENTYPENCE(0.20, true),
    FIFTYPENCE(0.50, true),
    ONEPOUND(1.00, true),
    TWOPOUND(2.00, true);

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
