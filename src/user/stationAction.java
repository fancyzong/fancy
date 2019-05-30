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
import static user.stationSelect.stationName;

/**
 * This is used for react the user's operation after entering the station
 * @author group 107
 * @version 4.0
 */

public class stationAction {

    /**
     * This method is used for showing the relative information after the user do some operation in the station(to borrow the scooter)
     * @param userId To indicate which user is do the operation
     * @param stationId To indicate which station it is
     */

    public void bosPerform(String userId,int stationId){
        //start the count down
        myThread mt=new myThread();
        mt.cancel();
        //Change layout information
        lock[userpos].setText("Lock off");
        light[userpos].setText("Flash off");
        ImageIcon ii = new ImageIcon("111.png");
        ii.setImage(ii.getImage().getScaledInstance(50, 50,  Image.SCALE_DEFAULT));
        p[userpos].setIcon(ii);
        light[userpos].setForeground(Color.BLACK);
        borrowID=scooter[userpos].getText();
        scooter[userpos].setText("Empty");
        //Make the appropriate modifications to the documents.
        try {
            new writeUsageInfo(stationName[stationId-1],userId,"borrow",df.format(new Date()),borrowID);
            userChangeCondi t=new userChangeCondi();
            stationChangeCondi t1=new stationChangeCondi();
            t.UserCondi(userId,1);
            t1.PosCond(borrowID,stationName[stationId-1]+".txt",1);
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
        myThread mt=new myThread();
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
        ImageIcon ii = new ImageIcon("timg.jpeg");
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
            new writeHistoryInfo(stationName[stationId-1],userId,"return",df.format(new Date()),borrowID);
            userChangeCondi t2=new userChangeCondi();
            stationChangeCondi t1=new stationChangeCondi();
            t2.UserCondi(userId,0);
            t1.PosCond(borrowID,stationName[stationId-1]+".txt",0);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
