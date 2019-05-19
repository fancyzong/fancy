package user;

import user.UI;

import javax.servlet.ServletContextEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import IOtimer.timer;

public class testui {
    public static UI test=new UI();
    public static void main(String[] args) throws IOException {
        /*Detector judgement=new Detector();
    String a="ssss";
        try {
            a=judgement.userid("111111111");
            System.out.println(a);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();}
            */
    timer.initacc();
    timer.sendReport();
    test.init();
       /*double x=10*1.0/7;

       System.out.println(x);*/
        //long time=System.currentTimeMillis();
        //System.out.println(time);
        //Detector detector=new Detector();
        //String bor=new String();
        //bor=detector.readFromLast("111121111");
        //System.out.println(bor);
       //changeCondi t=new changeCondi();
        //t.changeCondi("111111111");
        //t.changeFine("111111111");

}

}
