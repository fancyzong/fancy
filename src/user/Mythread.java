package user;

import java.awt.*;

import static user.station.*;

public class Mythread implements Runnable {

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
        public static void cancel(){
            countdown=-2;
        }
}
