package vending_machine_tests;

import org.junit.Before;
import org.junit.Test;
import vending_machine.VendingMachine;
import vending_machine.inventory.ProductType;
import vending_machine.wallet.CoinType;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class VendingMachineTest {

    private VendingMachine vendingMachine;
    private VendingMachine emptyVendingMachine;

    @Before
    public void before() {
        vendingMachine = new VendingMachine();
        vendingMachine.getCoinBank().addFloat();
        vendingMachine.getProductDispenser().fill();
        emptyVendingMachine = new VendingMachine();
        emptyVendingMachine.getCoinBank().addFloat();
    }

    @Test
    public void canShowCurrentAmount() {
        assertEquals(0.00, vendingMachine.showCurrentAmount(), 0.001);
    }

    @Test
    public void canAddCoin() {
        vendingMachine.addCoin(CoinType.FIFTY_PENCE);
        assertEquals(1, vendingMachine.getCoinHandler().getCurrentCoins().size());
        assertEquals(0.50, vendingMachine.showCurrentAmount(), 0.001);
    }

    @Test
    public void canReturnCurrentCoins() {
        vendingMachine.addCoin(CoinType.FIFTY_PENCE);
        vendingMachine.addCoin(CoinType.TEN_PENCE);
        vendingMachine.addCoin(CoinType.FIVE_PENCE);
        ArrayList<CoinType> returnedCoins = vendingMachine.returnCurrentCoins();
        assertEquals(3, returnedCoins.size());
        assertEquals(0, vendingMachine.getCoinHandler().getCurrentCoins().size());
        assertEquals(0, vendingMachine.showCurrentAmount(), 0.001);
    }

    @Test
    public void canBuyProductIfEnoughMoneyInserted() {
        vendingMachine.addCoin(CoinType.ONE_POUND);
        ProductType boughtProduct = vendingMachine.buyProduct("RM1");
        assertEquals(59, vendingMachine.getProductDispenser().getProducts().size());
        assertEquals(121, vendingMachine.getCoinBank().getCoins().size());
        assertEquals(0, vendingMachine.showCurrentAmount(), 0.001);
        assertEquals(ProductType.ROBBIES_MOONSHINE, boughtProduct);
    }

    @Test
    public void cannotBuyProductIfNotEnoughMoneyInserted() {
        vendingMachine.addCoin(CoinType.FIVE_PENCE);
        ProductType boughtProduct = vendingMachine.buyProduct("RM1");
        assertEquals(60, vendingMachine.getProductDispenser().getProducts().size());
        assertEquals(120, vendingMachine.getCoinBank().getCoins().size());
        assertEquals(0.05, vendingMachine.showCurrentAmount(), 0.001);
        assertNull(boughtProduct);
    }

    @Test
    public void cannotBuyProductIfProductNotThere() {
        emptyVendingMachine.addCoin(CoinType.TWO_POUND);
        ProductType boughtProduct = emptyVendingMachine.buyProduct("RM1");
        assertEquals(0, emptyVendingMachine.getProductDispenser().getProducts().size());
        assertEquals(120, emptyVendingMachine.getCoinBank().getCoins().size());
        assertEquals(2.00, emptyVendingMachine.showCurrentAmount(), 0.001);
        assertNull(boughtProduct);
    }
}
