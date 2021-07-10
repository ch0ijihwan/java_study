import org.junit.jupiter.api.*;

/**
 * @author : Eunmo Hong
 * @since : 2020/08/13
 */

class StudyTest {

    @Test
    void create1() {
        Study study = new Study();

        System.out.println("create1. study");
    }

    @Test
    void create2() {
        System.out.println("create2(), study");
    }

    @Disabled
    @Test
    void Disable() {
        System.out.println("Disabled");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("BeforeAll");
    }


    @AfterAll
    static void afterAll() {
        System.out.println("AfterAll");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("BeforeEach");
    }

    @AfterEach
    void afterEach() {
        System.out.println("AfterEach");
    }
}