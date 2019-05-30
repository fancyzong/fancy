package user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Choose whether they are users or staffs.
 * Provide different portals for different users.
 * @author group 107
 * @version 1.0
 */
public class FUI extends JPanel implements ActionListener {
    user u=new user();
     JButton user=new JButton("User");
     JButton manager=new JButton("Manager");
     JLabel title=new JLabel("Who are you?",JLabel.CENTER);
    UI changer=integationTest.test;
    /**
     * Use the constructor to lay out the module and add listeners to the buttons.
     */
    public FUI(){
        this.setLayout(new GridLayout(3,1));
        this.add(title);
        this.add(user);
        this.add(manager);
        user.addActionListener(this);
        manager.addActionListener(this);
    }
    /**
     * override the function in the super class,Gives the method you need to call when you press a button.
     * one button for user, one button for staff.
     * @param e Indicate which button has been pressed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(manager==(JButton)e.getSource()){
            changer.staff();
        }
        if(user==(JButton)e.getSource()){
            u.scanCard();
        }
    }
}
