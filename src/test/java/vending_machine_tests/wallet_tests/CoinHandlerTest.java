package vending_machine_tests.wallet_tests;

import org.junit.Before;
import org.junit.Test;
import vending_machine.wallet.CoinBank;
import vending_machine.wallet.CoinHandler;
import vending_machine.wallet.CoinType;

import static org.junit.Assert.*;

public class CoinHandlerTest {

    private CoinHandler coinHandler;

    @Before
    public void before() {
        coinHandler = new CoinHandler();
    }

    @Test
    public void canAddValidCoin() {
        CoinType returnedCoin = coinHandler.addCoin(CoinType.TEN_PENCE);
        assertEquals(1, coinHandler.getCurrentCoins().size());
        assertNull(returnedCoin);

    }

    @Test
    public void cannotAddInvalidCoin() {
        CoinType returnedCoin = coinHandler.addCoin(CoinType.ONE_PENCE);
        assertEquals(0, coinHandler.getCurrentCoins().size());
        assertEquals(CoinType.ONE_PENCE, returnedCoin);
    }

    @Test
    public void canGetCurrentAmount() {
        coinHandler.addCoin(CoinType.ONE_POUND);
        coinHandler.addCoin(CoinType.TWENTY_PENCE);
        double currentAmount = coinHandler.getCurrentAmount();
        assertEquals(1.20, currentAmount, 0.001);
    }
}
