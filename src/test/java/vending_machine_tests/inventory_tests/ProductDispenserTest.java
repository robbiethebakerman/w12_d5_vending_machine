package vending_machine_tests.inventory_tests;

import org.junit.Before;
import org.junit.Test;
import vending_machine.inventory.ProductDispenser;
import vending_machine.inventory.ProductType;

import static org.junit.Assert.*;

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
        productDispenser.fill();
        ProductType returnedProduct = productDispenser.getProductByCode("RM1");
        assertEquals(ProductType.ROBBIES_MOONSHINE, returnedProduct);
        assertEquals(59, productDispenser.getProducts().size());
    }

    @Test
    public void cannotGetProductByCodeIfProductNotThere() {
        productDispenser.addProduct(ProductType.CARDBOARD_CRISPS);
        assertEquals(1, productDispenser.getProducts().size());
        ProductType returnedProduct = productDispenser.getProductByCode("RM1");
        assertNull(returnedProduct);
        assertEquals(1, productDispenser.getProducts().size());
    }

    @Test
    public void canCheckIfAmountIsEnoughForProductTrue() {
        assertTrue(productDispenser.checkAmountEnoughForProduct(ProductType.GINGER_BREAD_ROBBIE, 1.00));
    }

    @Test
    public void canCheckIfAmountIsEnoughForProductFalse() {
        assertFalse(productDispenser.checkAmountEnoughForProduct(ProductType.GINGER_BREAD_ROBBIE, 0.64));
    }

    @Test
    public void canCheckRemainingAmountRequiredWhereAmountIsPositive() {
        double remainingAmount = productDispenser.checkRemainingAmount(ProductType.GINGER_BREAD_ROBBIE, 0.50);
        assertEquals(0.15, remainingAmount, 0.001);
    }

    @Test
    public void canCheckRemainingAmountRequiredWhereAmountIsZero() {
        double remainingAmount = productDispenser.checkRemainingAmount(ProductType.GINGER_BREAD_ROBBIE, 0.65);
        assertEquals(0, remainingAmount, 0.001);
    }

    @Test
    public void canCheckRemainingAmountRequiredWhereAmountIsNegative() {
        double remainingAmount = productDispenser.checkRemainingAmount(ProductType.GINGER_BREAD_ROBBIE, 0.70);
        assertEquals(-0.05, remainingAmount, 0.001);
    }
}
