package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static praktikum.constants.Constants.*;


public class IngredientTest {

    private Ingredient ingredient;

    @Before
    public void initialize() {
        ingredient = new Ingredient (IngredientType.FILLING, TEST_NAME_DATA, TEST_PRICE_DATA);
    }

    @Test
    public void ingredientNameTest() {
        Assert.assertEquals(TEST_NAME_DATA, ingredient.getName());
    }

    @Test
    public void ingredientPriceTest() {
        Assert.assertEquals(TEST_PRICE_DATA, ingredient.getPrice(), 0);
    }
}
