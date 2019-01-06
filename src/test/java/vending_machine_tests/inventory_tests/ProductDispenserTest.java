package vending_machine_tests.inventory_tests;

import org.junit.Before;
import org.junit.Test;
import vending_machine.inventory.ProductDispenser;
import vending_machine.inventory.ProductType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ProductDispenserTest {

    private ProductDispenser productDispenser;

    @Before
    public void before() {
        productDispenser = new ProductDispenser();
    }

    @Test
    public void canAddProduct() {
        productDispenser.addProduct(ProductType.CARDBOARD_CRISPS);
        assertEquals(1, productDispenser.getProducts().size());
    }

    @Test
    public void canRemoveProduct() {
        productDispenser.addProduct(ProductType.GINGER_BREAD_ROBBIE);
        boolean result = productDispenser.removeProduct(ProductType.GINGER_BREAD_ROBBIE);
        assertEquals(0, productDispenser.getProducts().size());
        assertTrue(result);
    }

    @Test
    public void cannotRemoveProductIfProductNotThere() {
        productDispenser.addProduct(ProductType.GINGER_BREAD_ROBBIE);
        boolean result = productDispenser.removeProduct(ProductType.ROBBIES_MOONSHINE);
        assertEquals(1, productDispenser.getProducts().size());
        assertFalse(result);
    }

    @Test
    public void canFillProductDispenser() {
        productDispenser.fill();
        assertEquals(60, productDispenser.getProducts().size());
    }

    @Test
    public void canGetProductByCode() {

    }

    @Test
    public void cannotGetProductByCodeIfProductNotThere() {

    }
//
//    @Test
//    public void canCheckIfAmountIsEnoughForProductTrue() {
//
//    }
//
//    @Test
//    public void canCheckIfAmountIsEnoughForProductFalse() {
//
//    }
//
//    @Test
//    public void canCheckRemainingAmountRequiredWhereAmountIsPositive() {
//
//    }
//
//    @Test
//    public void canCheckRemainingAmountRequiredWhereAmountIsZero() {
//
//    }
//
//    @Test
//    public void canCheckRemainingAmountRequiredWhereAmountIsNegative() {
//
//    }
}
