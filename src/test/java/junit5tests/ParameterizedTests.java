package junit5tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedTests {
    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {1, 5, 6})
    void intValues(int theParam){
        System.out.println("theParam = " + theParam);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"firstString", "secondString"})
    void stringValues(String theParam){
        System.out.println("the Param = " + theParam);
    }


    @ParameterizedTest
    @CsvSource(value = {"MahendraSingh, Dhoni", "Virat, Kolhi", "Rohit, Sharma"})
    void csvSource_StringString(String param1, String param2){
        System.out.println("param1 = " + param1 +  ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"Mihir, 24, true", "Tejas, 23, False", "Rohan, 21, True"})
        void csvSource_StringIntBoolean(String param1, int param2, boolean param3){
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }

    @ParameterizedTest
    @CsvSource(value = {"Mahendra Singh, 'CSK'", "Virat Kolhi, 'RCB'" , "Rohit Sharma,'Mumbai, Indians'"})
    void csvSource_StringWithComma(String param1, String param2){
        System.out.println("param1: "+ param1 + ", param2: " + param2 );
    }

    @ParameterizedTest
    @CsvSource(value = {"Lionel?Messi", "Cristiano?Ronaldo"}, delimiter = '?')
    void csvSource_StringWithDelimiter(String param1, String param2){
        System.out.println("param1: " + param1 + ", param2: " + param2);
    }

}
