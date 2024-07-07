package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;

import static praktikum.constants.Constants.TEST_PRICE_DATA;
import static praktikum.constants.Constants.TEST_NAME_DATA;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private final List<Ingredient> testListIngredient = new ArrayList<>();
    private int sizeIngredientList;
    private final int count = 1;
    public float expectedPrice = (TEST_PRICE_DATA*2)+(TEST_PRICE_DATA*count);


    @Mock
    private Ingredient ingredient;

    @Mock
    private Bun bun;

    @Spy
    private Burger burger = new Burger();

    @Test
    public void addIngredientTest() {
        sizeIngredientList = burger.ingredients.size();
        burger.addIngredient(ingredient);
        Assert.assertEquals(sizeIngredientList +1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        for (int i = 0; i < count; i++) {
            testListIngredient.add(ingredient);
        }

        burger.ingredients = testListIngredient;
        sizeIngredientList = burger.ingredients.size();

        burger.removeIngredient(0);
        Assert.assertEquals(sizeIngredientList -1, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        testListIngredient.add(new Ingredient(IngredientType.FILLING, TEST_NAME_DATA, TEST_PRICE_DATA));

        for (int i = 0; i < count; i++) {
            testListIngredient.add(ingredient);
        }

        burger.ingredients = testListIngredient;
        Ingredient firstElement = burger.ingredients.get(0);
        burger.moveIngredient(0, count);
        Ingredient lastElement = burger.ingredients.get(burger.ingredients.size()-1);

        Assert.assertEquals(firstElement, lastElement);
    }

    @Test
    public void getPriceTest() {
        for (int i = 0; i < count; i++) {
            testListIngredient.add(ingredient);
        }
        burger.ingredients = testListIngredient;

        burger.setBuns(bun);
        Mockito.when(ingredient.getPrice()).thenReturn(TEST_PRICE_DATA);
        Mockito.when(bun.getPrice()).thenReturn(TEST_PRICE_DATA);

        Assert.assertEquals(expectedPrice, burger.getPrice(), 0.2);
    }

    @Test
    public void getReceiptTest() {
        testListIngredient.add(new Ingredient(IngredientType.SAUCE, TEST_NAME_DATA, TEST_PRICE_DATA));
        String expectedReceipt = "(==== " + TEST_NAME_DATA + " ====)\r\n= " + IngredientType.SAUCE.toString().toLowerCase() + " " + TEST_NAME_DATA + " =\r\n(==== " + TEST_NAME_DATA + " ====)\r\n\r\nPrice: 1,100000\r\n";

        burger.ingredients = testListIngredient;

        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn(TEST_NAME_DATA);
        burger.getReceipt();

        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
}