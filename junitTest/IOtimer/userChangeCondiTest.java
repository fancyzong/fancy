package IOtimer;

import org.junit.jupiter.api.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class userChangeCondiTest {
    userChangeCondi ucc=new userChangeCondi();
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
    void userCondi() throws IOException {
        ucc.UserCondi("161188586",1);
        ucc.UserCondi("161188586",0);
        ucc.UserCondi("161187763",1);
        ucc.UserCondi("161187763",0);
    }

    @Test
    void fine() throws IOException {
        ucc.Fine("161188586",1);
        ucc.Fine("161188586",0);
        ucc.Fine("161187763",1);
        ucc.Fine("161187763",0);
    }

    @Test
    void addAcc() throws IOException {
        ucc.addAcc("161188586",0.5);
        ucc.addAcc("161187763",0.7);
    }

    @Test
    void initAcc() throws IOException {
        ucc.initAcc();
    }
}