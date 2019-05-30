package user;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static user.station.*;
import static user.stationSelect.stationName;

/**
 * Layout the dynamic GUI of the entire system.
 * Make our system pages more flexible and reliable.
 * @author group 107
 * @version 4.0
 */

public class setLayout {
    //Thread thread=new Thread(new myThread());
    /**
     * This method is used for showing the relative information after the user enter the station(to borrow the scooter or to return the scooter)
     * @param stationId In order to indicate which station it is
     * @param condition Determine which layout method is based on the value of the condition.
     * @throws FileNotFoundException As we need pictures here to show more obviously
     */

    public void StationLayout(int stationId,int condition) throws FileNotFoundException {
        Thread thread=new Thread(new myThread());
        message.setForeground(Color.BLACK);
        if(condition==1)
            message.setText("<html>please<br>pick<br>up<br>scooter</html>");
        else
            message.setText("<html>please<br>return<br>your<br>scooter</html>");
        int flag = 0;
        Scanner scanner = new Scanner(new FileInputStream(stationName[stationId-1]+".txt"));
        while (scanner.hasNext()) {
            String str = scanner.next();
            flag++;
            if (flag % 2 == 0&&!"0".equals(str)) {
                scooter[flag / 2 - 1].setText(str);
                //Put the corresponding picture on the location of the car.
                ImageIcon ii = new ImageIcon("timg.jpeg");
                ii.setImage(ii.getImage().getScaledInstance(50, 50,  Image.SCALE_DEFAULT));
                p[flag / 2 - 1].setIcon(ii);
            }
        }
        //Get the location of the car to be borrowed.
        for (int i=0;i<8;i++){
            if(condition==1) {
                if (!scooter[i].getText().equals("Empty")) {
                    userpos = i;
                    lock[i].setText("Lock on");
                    light[i].setText("Flash on");
                    break;
                }
            }
            else {
                if (scooter[i].getText().equals("Empty")) {
                    userpos = i;
                    lock[i].setText("Lock on");
                    light[i].setText("Flash on");
                    break;
                }
            }
        }
        thread.start();
    }

    /**
     * The user invokes this method when selecting a station.
     * The layout of the operation interface of the selected station is laid out.
     * @param station contains all station information
     * @return module of GUI
     */
    public static JPanel setStationLayout(JButton station[]){
        JPanel panel=new JPanel(new GridLayout(stationName.length,1));
        for (int i=0;i<stationName.length;i++) {
            station[i] = new JButton(stationName[i]);
            panel.add(station[i]);
        }
        return panel;
    }

    /**
     * The most basic layout of the station's operator interface.
     * @param i Indicates which location of the station is currently being laid out.
     * @return module of GUI
     */
    public JPanel beforeLayout(int i){
        JPanel jPanel=new JPanel();
        sp[i-1]=new JPanel();
        ImageIcon ii = new ImageIcon("111.png");
        ii.setImage(ii.getImage().getScaledInstance(50, 50,  Image.SCALE_DEFAULT));
        p[i-1]=new JLabel(ii);
        lock[i - 1] = new JButton("Lock off");
        scooter[i - 1] = new JLabel("Empty",JLabel.CENTER);
        light[i - 1] = new JLabel("Flash off", JLabel.CENTER);
        jPanel.setLayout(new GridLayout(3, 1));
        sp[i-1].setLayout(new GridLayout(2,1));
        sp[i-1].add(p[i-1]);
        sp[i-1].add(scooter[i-1]);
        jPanel.add(sp[i-1]);
        jPanel.add(light[i - 1]);
        jPanel.add(lock[i - 1]);
        return jPanel;
    }
}
