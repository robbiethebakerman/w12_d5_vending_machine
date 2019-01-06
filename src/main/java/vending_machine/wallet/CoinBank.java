package vending_machine.wallet;

import java.util.ArrayList;

public class CoinBank {

    private ArrayList<CoinType> coins;

    public CoinBank() {
        this.coins = new ArrayList<>();
    }

    public ArrayList<CoinType> getCoins() {
        return coins;
    }

    public void addCoin(CoinType coin) {
        coins.add(coin);
    }

    public boolean removeCoin(CoinType coin) {
        return coins.remove(coin);
    }

    public void addFloat() {
        int count = 1;
        while (count < 21) {
            addCoin(CoinType.FIVE_PENCE);
            addCoin(CoinType.TEN_PENCE);
            addCoin(CoinType.TWENTY_PENCE);
            addCoin(CoinType.FIFTY_PENCE);
            addCoin(CoinType.ONE_POUND);
            addCoin(CoinType.TWO_POUND);
            count++;
        }
    }

    public void addFloat(
            int numberOfFivePences,
            int numberOfTenPences,
            int numberOfTwentyPences,
            int numberOfFiftyPences,
            int numberOfOnePounds,
            int numberOfTwoPounds
    ) {
        int fivePenceCount = 1;
        while (fivePenceCount < numberOfFivePences + 1) {
            addCoin(CoinType.FIVE_PENCE);
            fivePenceCount++;
        }

        int tenPenceCount = 1;
        while (tenPenceCount < numberOfTenPences + 1) {
            addCoin(CoinType.TEN_PENCE);
            tenPenceCount++;
        }

        int twentyPenceCount = 1;
        while (twentyPenceCount < numberOfTwentyPences + 1) {
            addCoin(CoinType.TWENTY_PENCE);
            twentyPenceCount++;
        }

        int fiftyPenceCount = 1;
        while (fiftyPenceCount < numberOfFiftyPences +1) {
            addCoin(CoinType.FIFTY_PENCE);
            fiftyPenceCount++;
        }

        int onePoundCount = 1;
        while (onePoundCount < numberOfOnePounds + 1) {
            addCoin(CoinType.ONE_POUND);
            onePoundCount++;
        }

        int twoPoundCount = 1;
        while (twoPoundCount < numberOfTwoPounds +1 ) {
            addCoin(CoinType.TWO_POUND);
            twoPoundCount++;
        }
    }

// Can do the above method using an ArrayList instead(or even array), and loop over the array.
// Just need to increment a total count outside of the while loop

}
