package manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import user.*;

import static user.stationSelect.stationName;

/**
 * Information query layer,it provides an interface to the staff for querying information.
 * The information that can be queried contains the scooters layout of three stations and
 * some basic information and usage information of the user.
 * @author group 107
 * @version 4.0
 */

public class TUI_monitor extends JPanel implements ActionListener {
    JButton user=new JButton("User information");
    JButton[] station=new JButton[stationName.length];
    JButton back=new JButton("Go back");
    UI swich=integationTest.test;
    /**
     * Use the constructor to lay out the module and add listeners to the buttons.
     */
    public TUI_monitor() {
        this.setLayout(new GridLayout(1,2));
        JPanel jPanel=new JPanel(new GridLayout(2,1));
        jPanel.add(user);
        jPanel.add(back);
        this.add(setLayout.setStationLayout(station));
        this.add(jPanel);
        user.addActionListener(this);
        station[0].addActionListener( this);
        station[1].addActionListener( this);
        station[2].addActionListener( this);
        back.addActionListener(this);
    }
    /**
     * override the function in the super class,Gives the method you need to call when you press a button.
     * @param e Indicate which button has been pressed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(user==(JButton)e.getSource()){
            try {
                new displayUser();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        if(station[0]==(JButton)e.getSource()) {
            try {
                new displayStation(stationName[0]+".txt");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if(station[1]==(JButton)e.getSource()) {
            try {
                new displayStation(stationName[1]+".txt");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if(station[2]==(JButton)e.getSource()) {
            try {
                new displayStation(stationName[2]+".txt");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if (back==(JButton)e.getSource()){
            swich.staff();
        }
    }
}
