package user;

import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * use TDD technology:Junit to test the function of stationAction class
 * @author group 107
 * @version 1.0
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class stationActionTest {
    setLayout setLayout=new setLayout();
    stationAction sa=new stationAction();
    UI changer=integationTest.test;
    @BeforeEach
    void setUp() {
        System.out.println("before:begin test");
    }

    @AfterEach
    void tearDown() {
        System.out.println("after:end test");
    }

    @BeforeAll
    public static void beforeClass(){
        System.out.println("before class:begin this class*************");
    }

    @AfterAll
    public static void afterClass(){
        System.out.println("after class:end this class--------------");
    }
    /**
     * test the method bosPerform().
     * @throws FileNotFoundException A series of operations on files.
     */
    @Order(1)
    @Test
    void bosPerform() throws IOException {
        changer.stationBor(1,"161187763",true);
        setLayout.StationLayout(1,1);
        sa.bosPerform("161187763",1);
    }
    /**
     * test the method retPerform().
     * @throws FileNotFoundException A series of operations on files.
     */
    @Order(2)
    @Test
    void retPerform() throws IOException {
        changer.stationBor(1,"161187763",false);
        setLayout.StationLayout(1,0);
        sa.retPerform("161187763",1);
    }
}