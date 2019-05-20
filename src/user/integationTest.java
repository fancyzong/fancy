package user;


import IOtimer.timer;

public class integationTest {
    public static UI test=new UI();
    public static void main(String[] args){
        timer.initacc();
        timer.sendReport();
        test.init();
    }

}
