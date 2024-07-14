package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static praktikum.constants.Constants.*;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {

    private Bun bun;

    @Before
    public void initialize() {
        bun = new Bun (TEST_NAME_DATA, TEST_PRICE_DATA);
    }

    @Test
    public void bunNameTest() {
        Assert.assertEquals(TEST_NAME_DATA, bun.getName());
    }

    @Test
    public void bunPriceTest() {
        Assert.assertEquals(TEST_PRICE_DATA, bun.getPrice(), 0);
    }
}