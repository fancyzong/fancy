package user;


import IOtimer.timer;
/**
 * This is used for count down as a counter
 * @author group 107
 * @version 4.0
 */

public class integationTest {
    public static UI test=new UI();
    /**
     * This main driver is used to start the whole system
     * @param args It is not used here.
     */

    public static void main(String[] args){
        timer.initacc();
        timer.sendReport();
        test.init();
    }

}
