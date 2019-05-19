package IOtimer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import staff.*;

public class timer {
    private static String userId;
    private double min;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
    static changeCondi change=new changeCondi();
    Detector detector=new Detector();
    public timer(String userId){
        this.userId=userId;
    }
    public String getUserId(){return userId;}

    public boolean judge(String endTime) throws IOException, ParseException {
        Date now = df.parse(endTime);
        Date date=df.parse(detector.getTime(userId));
        min=(now.getTime()-date.getTime())*1.0/1000/60;
        System.out.println(min+"\n");
        if (min>1) {
            change.Fine(userId);
            System.out.println("Exceed time limit");
            return false;
        }
       if (change.addAcc(userId,min)==false) {
           change.Fine(userId);
           System.out.println("Exceed time limit");
           return false;
       }
       return true;
    }

    public static void initacc() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 24);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Date time = calendar.getTime();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                try {
                    change.initAcc();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("zzzzzzz");
            }
        }, time, 1000 * 60*60*24);
    }

    public static void sendReport() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 24);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.DAY_OF_WEEK,7);

        Date time = calendar.getTime();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                System.out.println("jniunuini");
                try {
                    new TUI_send_report();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }, time, 1000 * 60*60*24*7);
    }

    public double getMin() {
        return min;
    }
}
