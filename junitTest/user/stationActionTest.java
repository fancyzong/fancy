package user;

import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class stationActionTest {
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

    @Test
    void stationLayout() throws FileNotFoundException {
        changer.stationBor(1,"161188586",true);
        sa.StationLayout(1,1);
    }
    @Test
    void retPerform() throws FileNotFoundException {
        changer.stationBor(1,"161187763",false);
        sa.StationLayout(1,0);
        sa.retPerform("161187763",1);
    }

    @Test
    void bosPerform() throws FileNotFoundException {
        changer.stationBor(3,"161187763",true);
        sa.StationLayout(3,1);
        sa.bosPerform("161187763",3);
    }


}