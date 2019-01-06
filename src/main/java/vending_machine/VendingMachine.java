package vending_machine;

import vending_machine.inventory.ProductDispenser;
import vending_machine.inventory.ProductType;
import vending_machine.wallet.CoinBank;
import vending_machine.wallet.CoinHandler;
import vending_machine.wallet.CoinType;

import java.util.ArrayList;

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

    public double showCurrentAmount() {
        return coinHandler.getCurrentAmount();
    }

    public ArrayList<CoinType> returnCurrentCoins() {
        return coinHandler.emptyCurrentCoins();
    }

    public ProductType buyProduct(String code) {
        ProductType boughtProduct = productDispenser.getProductByCode(code);
        if (boughtProduct == null) {
            return boughtProduct;
        } else if (!productDispenser.checkAmountEnoughForProduct(boughtProduct, this.showCurrentAmount())) {
            productDispenser.addProduct(boughtProduct);
            return null;
        } else {
            for (CoinType coin : coinHandler.getCurrentCoins()) {
                coinBank.addCoin(coin);
            }
            coinHandler.emptyCurrentCoins();
            return boughtProduct;
        }
    }
}


// Would probably have been better to add a property, double remainingAmount,
// which is updated when user tries to buy product,
// and use this to return correct change or show remaining amount.
// Then when a product is bought, just add all current coins to CoinBank,
// then return change from CoinBank as needed.