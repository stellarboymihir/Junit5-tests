package junit5tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

//@Disab led
public class DisabledEnabledTest {

    @Test
    @DisabledIfSystemProperty(named = "env", matches = "staging", disabledReason = "Disabled for demo of @DisabledIfSystemProperty")
    void firstMethod(){
        System.out.println("This is the first method.");
    }
    @Test
    @Disabled(value = "Disabled for demo of @Disabled.  ")
    void secondMethod(){
        System.out.println("This is the second method.");
    }
    @DisabledOnOs(value = OS.WINDOWS, disabledReason = "Disabled for demo of " + "@DisabledOnOS")
    @Test
    void thirdMethod(){
        System.out.println("This is the third method.");
    }
    @Test
    @DisabledIf(value = "provider", disabledReason = "Disabled for demo of @DisabledIf")
    void fourthMethod(){
        System.out.println("This is the fourth method.");
    }
    @Test
    void fifthMethod(){
        System.out.println("This is the fifth method.");
    }

    boolean provider(){
        return LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.TUESDAY);
    }
}
