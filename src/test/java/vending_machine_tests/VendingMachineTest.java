package vending_machine_tests;

import org.junit.Before;
import org.junit.Test;
import vending_machine.VendingMachine;
import vending_machine.wallet.CoinType;

import static org.junit.Assert.assertEquals;


public class VendingMachineTest {

    private VendingMachine vendingMachine;

    @Before
    public void before() {
        vendingMachine = new VendingMachine();
        vendingMachine.getCoinBank().addFloat();
        vendingMachine.getProductDispenser().fill();
    }

    @Test
    public void canAddCoin() {
        vendingMachine.addCoin(CoinType.FIFTY_PENCE);
        assertEquals(1, vendingMachine.getCoinHandler().getCurrentCoins().size());
        assertEquals(0.50, vendingMachine.getCoinHandler().getCurrentAmount(), 0.001);
    }
}
