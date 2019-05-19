package user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import staff.*;
import IOtimer.Detector;
import IOtimer.changeCondi;
import IOtimer.timer;

public class station extends JPanel implements ActionListener {
    static int countdown;
    JLabel p[]=new JLabel[8];
    Thread thread=new Thread(new Mythread());
    static JButton[] lock =new JButton[8];
    static JLabel[] light =new JLabel[8];
    JLabel scooter[]=new JLabel[8];
    JPanel position[]=new JPanel[9];
    JPanel sp[]=new JPanel[8];
    static JLabel message=new JLabel("nothing",JLabel.CENTER);
    JButton goout=new JButton("Walk out");
    int stationId;
    String userId;
    static int userpos;
    static String borrowID="";
    boolean bor;
    UI swich=testui.test;
    String station[]={"Library","Village_Shop","Information_Teaching_Laboratories"};
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");

    public station(int stationId,String userId,boolean bor)throws FileNotFoundException {
        countdown=60;
        this.stationId = stationId;
        this.userId = userId;
        this.bor=bor;
        this.setLayout(new GridLayout(1, 9));
        position[0] = new JPanel();
        position[0].setLayout(new GridLayout(2, 1));
        position[0].add(message);
        position[0].add(goout);
        goout.addActionListener(this);
        this.add(position[0]);
        for (int i = 1; i < 9; i++) {
            position[i] = new JPanel();
            sp[i-1]=new JPanel();
            ImageIcon ii = new ImageIcon("/Users/zongxuanfan/IdeaProjects/fancy/WechatIMG66.png");
            ii.setImage(ii.getImage().getScaledInstance(50, 50,  Image.SCALE_DEFAULT));
            p[i-1]=new JLabel(ii);
            lock[i - 1] = new JButton("Lock off");
            scooter[i - 1] = new JLabel("Empty",JLabel.CENTER);
            light[i - 1] = new JLabel("Flash off", JLabel.CENTER);
            position[i].setLayout(new GridLayout(3, 1));
            sp[i-1].setLayout(new GridLayout(2,1));
            sp[i-1].add(p[i-1]);
            sp[i-1].add(scooter[i-1]);
            position[i].add(sp[i-1]);
            position[i].add(light[i - 1]);
            position[i].add(lock[i - 1]);
            lock[i - 1].addActionListener(this);
            this.add(position[i]);
        }
            if (bor==true){
                message.setText("<html>please<br>pick<br>up<br>scooter</html>");
                int flag = 0;
                Scanner scanner = new Scanner(new FileInputStream(station[stationId-1]+".txt"));
                while (scanner.hasNext()) {
                    String str = scanner.next();
                    flag++;
                    if (flag % 2 == 0&&!"0".equals(str)) {
                        scooter[flag / 2 - 1].setText(str);
                        ImageIcon ii = new ImageIcon("/Users/zongxuanfan/IdeaProjects/fancy/timg.jpeg");
                        ii.setImage(ii.getImage().getScaledInstance(50, 50,  Image.SCALE_DEFAULT));
                        p[flag / 2 - 1].setIcon(ii);
                    }
                }
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
            else{
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (lock[userpos]==(JButton)e.getSource()&&bor==true&&countdown>=0){
            Mythread.cancel();
            lock[userpos].setText("Lock off");
            light[userpos].setText("Flash off");
            ImageIcon ii = new ImageIcon("/Users/zongxuanfan/IdeaProjects/fancy/WechatIMG66.png");
            ii.setImage(ii.getImage().getScaledInstance(50, 50,  Image.SCALE_DEFAULT));
            p[userpos].setIcon(ii);
            light[userpos].setForeground(Color.BLACK);
            borrowID=scooter[userpos].getText();
            scooter[userpos].setText("Empty");
            try {
                new write_usage_info(station[stationId-1],userId,"borrow",df.format(new Date()),borrowID);
                changeCondi t=new changeCondi();
                t.borUserCondi(userId);
                t.borPosCond(borrowID,station[stationId-1]+".txt");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            message.setText("<html>Please<br>walk<br>out<html>");

        }
        if (lock[userpos]==(JButton)e.getSource()&&bor==false&&countdown>=0){
            Mythread.cancel();
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

            lock[userpos].setText("Lock off");
            light[userpos].setText("Flash off");
            ImageIcon ii = new ImageIcon("/Users/zongxuanfan/IdeaProjects/fancy/timg.jpeg");
            ii.setImage(ii.getImage().getScaledInstance(50, 50,  Image.SCALE_DEFAULT));
            p[userpos].setIcon(ii);
            light[userpos].setForeground(Color.BLACK);
            Detector det=new Detector();
            try {
                borrowID=det.readFromLast(userId);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            scooter[userpos].setText(borrowID);
            try {
                new write_history_info(station[stationId-1],userId,"return",df.format(new Date()),borrowID);
                changeCondi cc=new changeCondi();
                cc.retUserCondi(userId);
                cc.retPosCond(borrowID,station[stationId-1]+".txt");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            //message.setText("<html>Please<br>walk<br>out<html>");
        }
        if (goout==(JButton)e.getSource()){
            swich.stationSelect();
        }
    }
    static class Mythread implements Runnable{

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


}
