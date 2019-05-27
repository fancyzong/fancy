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
    JButton station1=new JButton("Library");
    JButton station2=new JButton("Village Shop");
    JButton station3=new JButton("Information Teaching Laboratories");
    JButton back=new JButton("Go back");
    UI swich=integationTest.test;
    /**
     * Use the constructor to lay out the module and add listeners to the buttons.
     */
    public stationSelect(){
        this.setLayout(new GridLayout(4,1));
        this.add(station1);
        this.add(station2);
        this.add(station3);
        this.add(back);
        station1.addActionListener(this);
        station2.addActionListener(this);
        station3.addActionListener(this);
        back.addActionListener(this);
    }
    /**
     * override the function in the super class,Gives the method you need to call when you press a button.
     * The buttons represent three stations,one button for go back to the upper layer
     * @param e Indicate which button has been pressed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(station1==(JButton)e.getSource()){
            swich.scanCard(1);
        }
        else if (station2==(JButton)e.getSource()){
            swich.scanCard(2);
        }
        else if (station3==(JButton)e.getSource()){
            swich.scanCard(3);
        }
        else if (back==(JButton)e.getSource()){
            swich.FUI();
        }
    }
}
