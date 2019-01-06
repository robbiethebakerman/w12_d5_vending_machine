package vending_machine;

import vending_machine.inventory.ProductDispenser;
import vending_machine.wallet.CoinBank;
import vending_machine.wallet.CoinHandler;
import vending_machine.wallet.CoinType;

public class VendingMachine {

    private CoinBank coinBank;
    private CoinHandler coinHandler;
    private ProductDispenser productDispenser;

    public VendingMachine() {
        this.coinBank = new CoinBank();
        this.coinHandler = new CoinHandler();
        this.productDispenser = new ProductDispenser();
    }

    public CoinBank getCoinBank() {
        return coinBank;
    }

    public CoinHandler getCoinHandler() {
        return coinHandler;
    }

    public ProductDispenser getProductDispenser() {
        return productDispenser;
    }


    public CoinType addCoin(CoinType coin) {
        return coinHandler.addCoin(coin);
    }
}
