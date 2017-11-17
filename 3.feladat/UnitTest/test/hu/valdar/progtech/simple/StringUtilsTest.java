package hu.valdar.progtech.simple;

import hu.valdar.progtech.StringUtils;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class StringUtilsTest {
    private static List<String> testList;

    @BeforeClass
    public static void initialize(){
        testList = Arrays.asList("alma", "körte", null, "banán", null, "dió");
    }

    @Test
    public void testFilterTexts(){
        List<String> result = StringUtils.filterTexts("banán", testList);
        Assert.assertArrayEquals("A filterTexts metódus hibás eredményt adott vissza!", new String[]{"banán"}, result.toArray());
    }

    @Test
    public void testContainsWord(){
        Assert.assertTrue("A containsWord metódus nem működik megfelelően!", StringUtils.containsWord("banán", testList));
    }

    @Test
    public void testAllTextContains(){
        Assert.assertFalse("Az allTextContains metódus nem működik megfelelően", StringUtils.allTextContains("banán", testList));
    }

    @AfterClass
    public static void tearDown(){
        testList = null;
    }
}
