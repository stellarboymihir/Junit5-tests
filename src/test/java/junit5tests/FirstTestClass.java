package junit5tests;

import org.junit.jupiter.api.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FirstTestClass {

    @BeforeAll
    void beforeAll(){
        System.out.println("--This is the before all method.");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("--This is the before each method.");
    }

    @AfterAll
    void afterAll(){
        System.out.println("--This is the after all method.");
    }

    @AfterEach
    void afterEach(){
        System.out.println("--This is the after each method.");
    }

    @Test
    void firstMethod(){
        System.out.println("This is the first Method.");
    }



    @Test
    @DisplayName("US1234 - TC12 - This method is the second one.")
    void secondMethod(){
        System.out.println("This is the second Method.");
    }
}
