package staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import user.*;


public class SUI extends JPanel implements ActionListener {
    JButton register=new JButton("Register");
    JButton goback=new JButton("Go back");
    JButton monitor=new JButton("Monitor");
    JButton send_weekly_report=new JButton("Send weekly report");
    JButton payFine=new JButton("Pay a fine");
    UI swich=integationTest.test;
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
    @Override
    public void actionPerformed(ActionEvent e) {
        if(register==(JButton)e.getSource()){
            swich.register();
        }
        else if (goback==(JButton)e.getSource()){
            swich.FUI();
        }
        else if (monitor==(JButton)e.getSource()){
            swich.monitor();
        }
        else if (send_weekly_report==(JButton)e.getSource()){
            try {
                TUI_send_report tsr=new TUI_send_report();
                tsr.sendreport();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        else swich.payFine();
    }
}
