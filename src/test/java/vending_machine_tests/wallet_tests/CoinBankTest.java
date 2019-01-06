package vending_machine_tests.wallet_tests;

import org.junit.Before;
import org.junit.Test;
import vending_machine.wallet.CoinBank;
import vending_machine.wallet.CoinType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CoinBankTest {

    private CoinBank coinBank;

    @Before
    public void before() {
        coinBank = new CoinBank();
    }

    @Test
    public void canAddCoin() {
        coinBank.addCoin(CoinType.ONE_PENCE);
        assertEquals(1, coinBank.getCoins().size());
    }

    @Test
    public void canRemoveCoin() {
        coinBank.addCoin(CoinType.ONE_PENCE);
        boolean result = coinBank.removeCoin(CoinType.ONE_PENCE);
        assertEquals(0, coinBank.getCoins().size());
        assertTrue(result);
    }

    @Test
    public void cannotRemoveCoinIfCoinNotThere() {
        coinBank.addCoin(CoinType.ONE_PENCE);
        boolean result = coinBank.removeCoin(CoinType.TWO_PENCE);
        assertEquals(1, coinBank.getCoins().size());
        assertFalse(result);
    }

    @Test
    public void canAddFloatWithDefaultValues() {
        coinBank.addFloat();
        assertEquals(120, coinBank.getCoins().size());
    }

    @Test
    public void canAddFloatWithCustomValues() {
        coinBank.addFloat(30, 30, 15, 10, 5, 2);
        assertEquals(92, coinBank.getCoins().size());
    }
}
