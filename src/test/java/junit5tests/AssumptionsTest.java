package junit5tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assumptions.*;

public class AssumptionsTest {

    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {1, 5, 6})

    void intValues(int theParam){
        assumeTrue(theParam > 4);
        System.out.println("theParam = " + theParam);
    }


    @ParameterizedTest
    @CsvSource(value = {"MahendraSingh, Dhoni", "Virat, Kolhi", "Rohit, Sharma"})

    void csvSource_StringString(String param1, String param2){
        assumeFalse(param1.equals("MahendraSingh"), "The assumption " +
                "failed for the following param2: " + param2);
        System.out.println("param1 = " + param1 +  ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"Mihir, 24, true", "Tejas, 23, False", "Rohan, 15, True"})

    void csvSource_StringIntBoolean(String param1, int param2, boolean param3){
        assumingThat(param2 > 20, () -> System.out.println("This code ran."));
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }


}
