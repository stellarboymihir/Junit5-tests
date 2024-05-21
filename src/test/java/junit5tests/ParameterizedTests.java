package junit5tests;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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

    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/params/shoppinglist.csv", "src/test/resources/params/shoppingList2.csv"}, numLinesToSkip = 1)
    void csvSource_StringIntDoubleStringString(String name, int price, Double quantity, String UOF, String provider){
        System.out.println("The name: " + name + ", price: " + price + ", quantity: " + quantity + ", unit of measure: " + UOF + ", provider: " + provider);
    }

    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/params/shoppinglist3.csv"}, numLinesToSkip = 1, delimiterString = "__")
    void csvSource_StringIntDoubleStringStringSpecificDelimiter(String name, int price, Double quantity, String UOF, String provider){
        System.out.println("The name: " + name + ", price: " + price + ", quantity: " + quantity + ", unit of measure: " + UOF + ", provider: " + provider);
    }

    @ParameterizedTest
    @MethodSource(value = "sourceString")
    void methodSource_String(String param1){
        System.out.println("param1: " + param1);
    }

    List<String> sourceString(){
        return Arrays.asList("tomato", "carrot", "cabbage");
    }

    @ParameterizedTest
    @MethodSource(value = "sourceStringAsSteam")
    void methodSource_StringStream(String param1){
        System.out.println("param1: " + param1);
    }

    Stream<String> sourceStringAsSteam(){
//        processing
        return Stream.of("beetroot", "apple", "pear");
    }

    @ParameterizedTest
    @MethodSource(value = "sourceList_StringDouble")
    void methodSource_StringDoubleList(String param1, double param2){
        System.out.println("param1: " + param1 + ", param2: " + param2);
    }

    List<Arguments> sourceList_StringDouble(){
//         processing
        return Arrays.asList(arguments("tomato", 2.0),
                arguments("carrot", 4.5), arguments("cabbage", 7.8));

    }

    @ParameterizedTest
    @MethodSource(value = "junit5tests.ParamProvider#sourceStream_StringDouble")
    void methodSource_StringDoubleStream(String param1, double param2){
        System.out.println("param1: " + param1 + ", param2: " + param2);
    }



}
