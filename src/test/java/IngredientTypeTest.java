import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertNotNull;

public class IngredientTypeTest {
    @Test
    public void sauceNotNullTest() {
        assertNotNull("Don't even want ketchup!?", IngredientType.SAUCE);
    }

    @Test
    public void fillingNotNullTest() {
        assertNotNull("Falafel is amazing today! Or Meat?", IngredientType.FILLING);
    }
}