package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.*;
import static praktikum.constants.Constants.TEST_FILLING_DATA;
import static praktikum.constants.Constants.TEST_SAUCE_DATA;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final IngredientType ingredientType;
    private final String actual;

    public IngredientTypeTest(IngredientType ingredientType, String actual) {
        this.ingredientType = ingredientType;
        this.actual = actual;
    }

    @Parameterized.Parameters
    public static Object[][] ingredientTypeData() {
        return new Object[][] {
                {SAUCE, TEST_SAUCE_DATA},
                {FILLING, TEST_FILLING_DATA},
        };
    }

    @Test
    public void valueOf() {
        assertEquals(ingredientType, IngredientType.valueOf(actual));
    }
}