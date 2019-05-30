package manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import user.*;

/**
 * A display module that we uses a constructor to generate.
 * Staff will operate with this panel,this module provides access to four functions for staff management.
 * @author group 107
 * @version 4.0
 */

public class SUI extends JPanel implements ActionListener {
    user u=new user();
    JButton register=new JButton("Register");
    JButton goback=new JButton("Go back");
    JButton monitor=new JButton("Monitor");
    JButton send_weekly_report=new JButton("Send weekly report");
    JButton payFine=new JButton("Pay a fine");
    UI swich=integationTest.test;

    /**
     * Use the constructor to lay out the module and add listeners to the buttons.
     */
    public SUI(){
        this.setLayout(new GridLayout(3,1));
        JPanel panel1=new JPanel(new GridLayout(1,2));
        JPanel panel2=new JPanel(new GridLayout(1,2));
        panel1.add(register);
        panel1.add(monitor);
        panel2.add(send_weekly_report);
        panel2.add(payFine);
        this.add(panel1);
        this.add(panel2);
        this.add(goback);
        payFine.addActionListener(this);
        goback.addActionListener(this);
        register.addActionListener(this);
        monitor.addActionListener(this);
        send_weekly_report.addActionListener(this);
    }

    /**
     * override the function in the super class,Gives the method you need to call when you press a button.
     * @param e Indicate which button has been pressed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(register==(JButton)e.getSource()){
            u.register();
        }
        else if (goback==(JButton)e.getSource()){
            swich.FUI();
        }
        else if (monitor==(JButton)e.getSource()){
            swich.monitor();
        }
        else if (send_weekly_report==(JButton)e.getSource()){
            try {
                new TUI_send_report();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        else swich.payFine();
    }
}
