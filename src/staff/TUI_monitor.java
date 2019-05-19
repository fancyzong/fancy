package staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import IOtimer.*;
import user.*;


public class TUI_monitor extends JPanel implements ActionListener {
    JButton user=new JButton("User information");
    JButton station1=new JButton("Station ：Library ");
    JButton station2=new JButton("Station ：Informatics Teaching Laboratories");
    JButton station3=new JButton("Station ：Village Shop");
    JButton back=new JButton("Go back");
    UI swich=testui.test;
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if(user==(JButton)e.getSource()){
            try {
                new Display_user();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        if(station1==(JButton)e.getSource())
            new Display_station("Library.txt");
        if(station2==(JButton)e.getSource())
            new Display_station("Information_Teaching_Laboratories.txt");
        if(station3==(JButton)e.getSource())
            new Display_station("Village_Shop.txt");
        if (back==(JButton)e.getSource()){
            swich.staff();
        }
    }
}
