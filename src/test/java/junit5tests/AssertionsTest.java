package junit5tests;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasItem;

public class AssertionsTest {
    @Test
    void assertsEqualsTest(){
        Assertions.assertEquals("firstString", "secondString",
                "The String values are not equal.");


    }

    @Test
    void assertEqualsListTest(){
        List<String> actualValues = Arrays.asList("firstString",
                "secondString", "thirdString");
        List<String> expectedValues = Arrays.asList("firstString",
                "secondString");
        Assertions.assertEquals(expectedValues, actualValues);
    }

    @Test
    void assertArraysEqualsTest(){
        int[] expectedValues = {1, 2, 3};
        int[] actualValues = {1,4, 3};
       Assertions.assertArrayEquals(expectedValues, actualValues);
    }
    @Test
    void assertTrueTest(){
        Assertions.assertFalse(false);
        Assertions.assertTrue(false, "This boolean condition did not evaluate to true");
    }

    @Test
    void assertThrowsTest(){
        Assertions.assertThrows(NullPointerException.class, null);
    }

    @Test
    void assertAllTest(){
        Assertions.assertAll(
                () -> Assertions.assertEquals("firstString", "secondString",
                        "The String values are not equal."),
                () -> Assertions.assertThrows(NullPointerException.class, null),
                () -> Assertions.assertTrue(false, "This boolean condition did not evaluate to true")


        );
    }

    @Test
    void assertForMapTest(){
        Map<String, Integer> theMap = new HashMap<>();
        theMap.put("firstKey", 1);
        theMap.put("secondKey", 2);
        theMap.put("thirdKey", 3);

        assertThat(theMap, Matchers.hasValue(2));
        assertThat(theMap, Matchers.hasKey("secondKey1"));
    }

    @Test
    void assertForList(){
        List<String> theList = Arrays.asList("firstString", "secondString", "thirdString");


        assertThat(theList, hasItem("thirdStrings"));
    }

    @Test
    void assertAnyOf(){
        List<String> theList = Arrays.asList("firstString", "secondString", "thirdString");

        assertThat(theList, Matchers.anyOf(hasItem("thirdString"), hasItem("noString")));
    }

    @Test
    void assertForContainsAnyOrder(){
        List<String> theList = Arrays.asList("firstString", "secondString", "thirdString");

        assertThat(theList, containsInAnyOrder("firstString", "thirdString","secondString"));

    }
}
