package vending_machine.wallet;

import java.util.ArrayList;

public class CoinHandler {

    private ArrayList<CoinType> currentCoins;

    public CoinHandler() {
        this.currentCoins = new ArrayList<>();
    }

    public ArrayList<CoinType> getCurrentCoins() {
        return currentCoins;
    }


    public CoinType addCoin(CoinType coin) {
        if (coin.isValid()) {
            currentCoins.add(coin);
            return null;
        } else {
            return coin;
        }
    }

    public double getCurrentAmount() {
        double currentAmount = 0;
        for (CoinType coin : currentCoins) {
            currentAmount += coin.getAmount();
        }
        return currentAmount;
    }
}
