package user;

import java.awt.*;

import static user.station.*;
/**
 * This is used for count down as a counter
 * @author group 107
 * @version 4.0
 */


public class Mythread implements Runnable {
    /**
     * This method is used for start to count down
     */

    @Override
        public void run() {
            while (countdown>=0){
                light[userpos].setText("<html>Flash on:"+"\n"+String.valueOf(countdown)+"left<html>");
                countdown--;
                if (countdown%2==0)
                    light[userpos].setForeground(Color.red);
                else
                    light[userpos].setForeground(Color.BLACK);
                try
                {
                    Thread.sleep(1000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            if (countdown==-1) {
                message.setText("<html>Please<br>walk<br>out<br>and<br>try<br>again<html>");
                lock[userpos].setText("Lock off");
                light[userpos].setText("Flash off");
            }
        }
    /**
     * This method is called for stopping count down
     */

    public static void cancel(){
            countdown=-2;
        }
}
