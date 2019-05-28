package IOtimer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import staff.*;

/**
 * The time control layer, write some methods related to time calculation.
 * There are also functions that are similar to the time trigger function.
 * @author group 107
 * @version 2.0
 */
public class timer {
    private static String userId;
    private double min;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
    static userChangeCondi change=new userChangeCondi();
    otherDetector detector=new otherDetector();
    public timer(String userId){ this.userId=userId; }
    public String getUserId(){return userId;}

    /**
     * Calculate the time of using the bicycle to determine if a fine is needed
     * In both cases, you need to be fined: more than half an hour of use one time, more than two hours a day.
     * @param endTime Indicates when the user borrowed the car
     * @return Indicate whether it was fined
     * @throws IOException Modify the data of user_informatiuon.txt
     * @throws ParseException An exception is thrown when the time format is not uniform with the specified time format.
     */
    public boolean judge(String endTime) throws IOException, ParseException {
        Date now = df.parse(endTime);
        Date date=df.parse(detector.getMessage(userId,3));
        min=(now.getTime()-date.getTime())*1.0/1000/60;
        System.out.println(min+"\n");
        if (min>1) {
            change.Fine(userId,1);
            System.out.println("Exceed time limit");
            return false;
        }
       if (change.addAcc(userId,min)==false) {
           change.Fine(userId,1);
           System.out.println("Exceed time limit");
           return false;
       }
       return true;
    }

    /**
     * Time trigger function。
     * The trigger period is one day and the trigger time is 24 .
     * Used to initialize user usage time.
     */
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
                //System.out.println("zzzzzzz");
            }
        }, time, 1000 * 60*60*24);
    }
    /**
     * Time trigger function
     * The trigger period is one week and the trigger time is 24 on Saturday.
     * Used to send mail to each user.
     */
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
                //System.out.println("jniunuini");
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
