package staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import user.*;

/**
 * Information query layer,it provides an interface to the staff for querying information.
 * The information that can be queried contains the scooters layout of three stations and
 * some basic information and usage information of the user.
 * @author group 107
 * @version 4.0
 */

public class TUI_monitor extends JPanel implements ActionListener {
    JButton user=new JButton("User information");
    JButton station1=new JButton("Station ：Library ");
    JButton station2=new JButton("Station ：Informatics Teaching Laboratories");
    JButton station3=new JButton("Station ：Village Shop");
    JButton back=new JButton("Go back");
    UI swich=integationTest.test;
    /**
     * Use the constructor to lay out the module and add listeners to the buttons.
     */
    public TUI_monitor() {
        this.setLayout(new GridLayout(5,1));
        this.add(user);
        this.add(station1);
        this.add(station2);
        this.add(station3);
        this.add(back);
        user.addActionListener(this);
        station1.addActionListener(this);
        station2.addActionListener(this);
        station3.addActionListener(this);
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
        if(station1==(JButton)e.getSource())
            new displayStation("Library.txt");
        if(station2==(JButton)e.getSource())
            new displayStation("Information_Teaching_Laboratories.txt");
        if(station3==(JButton)e.getSource())
            new displayStation("Village_Shop.txt");
        if (back==(JButton)e.getSource()){
            swich.staff();
        }
    }
}
