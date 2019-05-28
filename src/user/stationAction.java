package user;

import IOtimer.otherDetector;
import IOtimer.stationChangeCondi;
import IOtimer.timer;
import IOtimer.userChangeCondi;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import static user.station.*;
/**
 * This is used for react the user's operation after entering the station
 * @author group 107
 * @version 4.0
 */

public class stationAction {
    Thread thread=new Thread(new Mythread());
    /**
     * This method is used for showing the relative information after the user enter the station(to borrow the scooter)
     * @param stationId In order to indicate which station it is
     * @throws FileNotFoundException As we need pictures here to show more obviously
     */

    public void bosStationLayout(int stationId) throws FileNotFoundException {
        message.setText("<html>please<br>pick<br>up<br>scooter</html>");
        int flag = 0;
        Scanner scanner = new Scanner(new FileInputStream(station[stationId-1]+".txt"));
        while (scanner.hasNext()) {
            String str = scanner.next();
            flag++;
            if (flag % 2 == 0&&!"0".equals(str)) {
                scooter[flag / 2 - 1].setText(str);
                //Put the corresponding picture on the location of the car.
                ImageIcon ii = new ImageIcon("/Users/zongxuanfan/IdeaProjects/fancy/timg.jpeg");
                ii.setImage(ii.getImage().getScaledInstance(50, 50,  Image.SCALE_DEFAULT));
                p[flag / 2 - 1].setIcon(ii);
            }
        }
        //Get the location of the car to be borrowed.
        for (int i=0;i<8;i++){
            if (!scooter[i].getText().equals("Empty")){
                userpos=i;
                lock[i].setText("Lock on");
                light[i].setText("Flash on");
                break;
            }
        }
        thread.start();
    }
    /**
     * This method is used for showing the relative information after the user enter the station(to return the scooter)
     * @param stationId In order to indicate which station it is
     * @throws FileNotFoundException As we need pictures here to show more obviously
     */

    public void retStationLayout(int stationId) throws FileNotFoundException {
        message.setText("<html>please<br>return<br>your<br>scooter</html>");
        int flag = 0;
        Scanner scanner = new Scanner(new FileInputStream(station[stationId-1]+".txt"));
        while (scanner.hasNext()) {
            String str = scanner.next();
            flag++;
            if (flag % 2 == 0&&!"0".equals(str)) {
                scooter[flag / 2 - 1].setText(str);
                ImageIcon ii = new ImageIcon("/Users/zongxuanfan/IdeaProjects/fancy/timg.jpeg");
                ii.setImage(ii.getImage().getScaledInstance(50, 50,  Image.SCALE_DEFAULT));
                p[flag/2-1].setIcon(ii);
            }
        }
        //Get the location of the car to be returned.
        for (int i=0;i<8;i++) {
            if (scooter[i].getText().equals("Empty")) {
                userpos = i;
                lock[i].setText("Lock on");
                light[i].setText("Flash on");
                break;
            }
        }
        thread.start();
    }
    /**
     * This method is used for showing the relative information after the user do some operation in the station(to borrow the scooter)
     * @param userId To indicate which user is do the operation
     * @param stationId To indicate which station it is
     */

    public void bosPerform(String userId,int stationId){
        //start the count down
        Mythread mt=new Mythread();
        mt.cancel();
        //Change layout information
        lock[userpos].setText("Lock off");
        light[userpos].setText("Flash off");
        ImageIcon ii = new ImageIcon("/Users/zongxuanfan/IdeaProjects/fancy/111.png");
        ii.setImage(ii.getImage().getScaledInstance(50, 50,  Image.SCALE_DEFAULT));
        p[userpos].setIcon(ii);
        light[userpos].setForeground(Color.BLACK);
        borrowID=scooter[userpos].getText();
        scooter[userpos].setText("Empty");
        //Make the appropriate modifications to the documents.
        try {
            new write_usage_info(station[stationId-1],userId,"borrow",df.format(new Date()),borrowID);
            userChangeCondi t=new userChangeCondi();
            stationChangeCondi t1=new stationChangeCondi();
            t.borUserCondi(userId);
            t1.borPosCond(borrowID,station[stationId-1]+".txt");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        message.setText("<html>Please<br>walk<br>out<html>");
    }
    /**
     * This method is used for showing the relative information after the user do some operation in the station(to return the scooter)
     * @param userId To indicate which user is do the operation
     * @param stationId To indicate which station it is
     */

    public void retPerform(String userId,int stationId){
        //Cancel the countdown.
        Mythread mt=new Mythread();
        mt.cancel();
        //Calculate the user's usage time.
        double min;
        timer t=new timer(userId);
        try {
            try {
                if(!t.judge(df.format(new Date()))){
                    min=t.getMin();
                    min = (double) Math.round(min * 100) / 100;
                    message.setForeground(Color.RED);
                    message.setText("<html>"+min+"minutes<br>Exceed<br>time<br>limit<html>");
                }
                else {
                    min=t.getMin();
                    min = (double) Math.round(min * 100) / 100;
                    message.setForeground(Color.BLACK);
                    message.setText("<html>"+min+"minutes<br>Please<br>walk<br>out<html>");
                }
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //Change layout information
        lock[userpos].setText("Lock off");
        light[userpos].setText("Flash off");
        ImageIcon ii = new ImageIcon("/Users/zongxuanfan/IdeaProjects/fancy/timg.jpeg");
        ii.setImage(ii.getImage().getScaledInstance(50, 50,  Image.SCALE_DEFAULT));
        p[userpos].setIcon(ii);
        light[userpos].setForeground(Color.BLACK);
        //Get the user's borrowing time.
        otherDetector det=new otherDetector();
        try {
            borrowID=det.getMessage(userId,4);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        scooter[userpos].setText(borrowID);
        //Make the appropriate modifications to the documents.
        try {
            new write_history_info(station[stationId-1],userId,"return",df.format(new Date()),borrowID);
            userChangeCondi t2=new userChangeCondi();
            stationChangeCondi t1=new stationChangeCondi();
            t2.retUserCondi(userId);
            t1.retPosCond(borrowID,station[stationId-1]+".txt");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
