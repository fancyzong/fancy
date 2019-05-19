package user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FUI extends JPanel implements ActionListener {
     JButton user=new JButton("User");
     JButton manager=new JButton("Staff");
     JLabel title=new JLabel("Who are you?",JLabel.CENTER);
    UI changer=testui.test;
    public FUI(){
        this.setLayout(new GridLayout(3,1));
        this.add(title);
        this.add(user);
        this.add(manager);
        user.addActionListener(this);
        manager.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(manager==(JButton)e.getSource()){
            changer.staff();
        }
        if(user==(JButton)e.getSource()){
            changer.stationSelect();
        }
    }
}
