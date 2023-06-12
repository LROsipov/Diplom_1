import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;
    @Mock
    private Bun mockBun;
    @Mock
    private Ingredient mockSauce;
    @Mock
    private Ingredient mockFilling;

    @Before
    public void start() {
        MockitoAnnotations.initMocks(this);
        when(mockBun.getName()).thenReturn("step");
        when(mockBun.getPrice()).thenReturn(1f);
        when(mockSauce.getType()).thenReturn(IngredientType.SAUCE);
        when(mockSauce.getName()).thenReturn("hot");
        when(mockSauce.getPrice()).thenReturn(2f);
        when(mockFilling.getType()).thenReturn(IngredientType.FILLING);
        when(mockFilling.getName()).thenReturn("cutlet");
        when(mockFilling.getPrice()).thenReturn(3f);
        burger = new Burger();
        burger.setBuns(mockBun);
        burger.setBuns(mockBun);
        burger.addIngredient(mockSauce);
        burger.addIngredient(mockFilling);
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(mockBun);
        assertEquals(mockBun, burger.bun);
    }

    @Test
    public void getPriceTest() {
        assertEquals(7f, burger.getPrice(), 0.01);
    }

    @Test
    public void getReceiptTest() {
        String expectedReceipt = String.format(
                "(==== step ====)%n" +
                        "= sauce hot =%n" +
                        "= filling cutlet =%n" +
                        "(==== step ====)%n" +
                        "%nPrice: 7,000000%n");

        assertEquals(expectedReceipt, burger.getReceipt());
    }

    @Test
    public void removeIngredient() {
        burger.removeIngredient(1);
        burger.removeIngredient(0);

        String expectedReceipt = String.format(
                "(==== step ====)%n" +
                        "(==== step ====)%n" +
                        "%n" +
                        "Price: 2,000000%n");

        assertEquals(expectedReceipt, burger.getReceipt());
    }

}