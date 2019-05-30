package user;

import IOtimer.otherDetector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;

import static user.stationSelect.stationName;

/**
 * This is used for showing the situation of a specific station that the user is chose previously
 * @author group 107
 * @version 4.0
 */

public class station extends JPanel implements ActionListener {
    otherDetector od=new otherDetector();
    setLayout setLayout=new setLayout();
    retureUser ru=new retureUser();
    borrowUser bu=new borrowUser();
    stationEntity se;
    static int countdown;
    static JLabel p[];
    static JButton[] lock;
    static JLabel[] light;
    static JLabel scooter[];
    static JPanel sp[];
    static JLabel message=new JLabel("nothing",JLabel.CENTER);
    JButton goout=new JButton("Walk out");
    int stationId;
    int stationSize;
    String userId;
    static int userpos;
    static String borrowID="";
    boolean bor;
    UI swich=integationTest.test;
    static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
    /**
     * This method is used for showing the situation of a specific station
     * @param stationId In order to indicate which station it is showing about
     * @param userId In order to indicate which user is in the station
     * @param bor In order to show whether the user is to borrow or return a scooter
     * @throws FileNotFoundException As we have use pictures for indicating more obviously
     */

    public station(int stationId,String userId,boolean bor) throws IOException {
        countdown=60;
        this.stationId = stationId;
        this.userId = userId;
        this.bor=bor;
        stationSize=od.getstationsize(stationName[stationId-1]+".txt");
        p=new JLabel[stationSize];
        lock =new JButton[stationSize];
        light =new JLabel[stationSize];
        scooter=new JLabel[stationSize];
        sp=new JPanel[stationSize];
        se=new stationEntity(stationId,bor);
        this.setLayout(new GridLayout(1, stationSize+1));
        JPanel jPanel=new JPanel();
        jPanel.setLayout(new GridLayout(2, 1));
        jPanel.add(message);
        jPanel.add(goout);
        goout.addActionListener(this);
        this.add(jPanel);
        for (int i=1;i<stationSize+1;i++){
            this.add(setLayout.beforeLayout(i));
            lock[i-1].addActionListener(this);
        }

        if (se.getforWhat()==true){
            bu.borLayout(se.getStationId());
        }
        else{
            ru.retLayout(se.getStationId());
        }
    }
    /**
     * This method is used foe listen the action of the user
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (lock[userpos]==(JButton)e.getSource()&&se.getforWhat()==true&&countdown>=0){
            bu.borrowScooter(userId,se.getStationId());
        }
        if (lock[userpos]==(JButton)e.getSource()&&se.getforWhat()==false&&countdown>=0){
            ru.returnScooter(userId,se.getStationId());
        }
        if (goout==(JButton)e.getSource()){
            swich.stationSelect();
        }
    }

}
