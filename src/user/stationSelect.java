package user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Select one station to return or lend cars
 * @author group 107
 * @version 4.0
 */
public class stationSelect extends JPanel implements ActionListener {
    public static String[] stationName ={"Library","Village_Shop","Information_Teaching_Laboratories",};
    setLayout setLayout=new setLayout();
    JButton[] station=new JButton[stationName.length];
    JButton back=new JButton("Go back");
    UI swich=integationTest.test;
    /**
     * Use the constructor to lay out the module and add listeners to the buttons.
     */
    public stationSelect(){
        this.setLayout(new BorderLayout());
       this.add("Center",setLayout.setStationLayout(station));
        this.add("South",back);
        station[0].addActionListener( this);
        station[1].addActionListener( this);
        station[2].addActionListener( this);
        back.addActionListener(this);
    }
    /**
     * override the function in the super class,Gives the method you need to call when you press a button.
     * The buttons represent three stations,one button for go back to the upper layer
     * @param e Indicate which button has been pressed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(station[0]==(JButton)e.getSource()){
            swich.scanCard(1);
        }
        else if (station[1]==(JButton)e.getSource()){
            swich.scanCard(2);
        }
        else if (station[2]==(JButton)e.getSource()){
            swich.scanCard(3);
        }
        else if (back==(JButton)e.getSource()){
            swich.FUI();
        }
    }
}
