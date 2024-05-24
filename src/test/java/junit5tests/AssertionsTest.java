package junit5tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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

}
