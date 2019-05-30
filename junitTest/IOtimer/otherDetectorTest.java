package IOtimer;

import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * use TDD technology:Junit to test the function of otherDetector class
 * @author group 107
 * @version 1.0
 */

class otherDetectorTest {
    otherDetector  od=new otherDetector();

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
     * test the method stationCondition().
     * @throws FileNotFoundException read the station file.
     */

    @Test
    void stationCondition() throws FileNotFoundException {
        od.stationCondition("Library",1);
        od.stationCondition("Library",0);
        od.stationCondition("Information_Teaching_Laboratories",1);
        od.stationCondition("Information_Teaching_Laboratories",0);
        od.stationCondition("Village_Shop",1);
        od.stationCondition("Village_Shop",0);
    }
    /**
     * test the method getMessage().
     * @throws FileNotFoundException read the station file.
     */
    @Test
    void getMessage() throws IOException {
        od.getMessage("161188586",4);
        od.getMessage("161188586",5);
    }
}