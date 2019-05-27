package user;

import IOtimer.otherDetector;
import IOtimer.userDetector;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

/**
 * The user will choose to return/borrow cars or go back  after select the station and scan their ID.
 * The system will automatically detect if the user is borrowing or returning the car.
 * Run different code based on the results
 * @author group 107
 * @version 4.0
 */
public class borrowOrreturn extends JPanel implements ActionListener {
    JButton back=new JButton("Back");
    JButton bor=new JButton("Borrow/Return");
    JLabel title=new JLabel("........",JLabel.CENTER);
    UI changer=integationTest.test;
    int stationId;
    String userid;
    /**
     * Use the constructor to lay out the module and add listeners to the buttons.
     * @param stationId  Indicate which station the user choose
     * @param user_id Indicate the user's ID
     */
    public borrowOrreturn(int stationId,String user_id){
        this.stationId=stationId;
        this.userid=user_id;
        this.setLayout(new GridLayout(3,1));
        this.add(title);
        this.add(bor);
        this.add(back);
        back.addActionListener(this);
        bor.addActionListener(this);
    }
    /**
     * override the function in the super class,Gives the method you need to call when you press a button.
     * one button for checking the user's data and station data, one button for going back to the upper layer.
     * @param e Indicate which button has been pressed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(bor==(JButton)e.getSource()){
            userDetector judg1=new userDetector();
            otherDetector judg2=new otherDetector();
            try {
                if(judg1.userCondition(userid)==true){
                    if(stationId==1){
                        if (judg2.stationCondition1("Library")==false)
                            title.setText("No scooster");
                        else changer.stationBor(stationId,userid,true);

                    }
                    else if (stationId==2){
                        if (judg2.stationCondition1("Village_Shop")==false)
                            title.setText("No scooster");
                        else changer.stationBor(stationId,userid,true);
                    }
                    else if (stationId==3){
                        if (judg2.stationCondition1("Information_Teaching_Laboratories")==false)
                            title.setText("No scooster");
                        else changer.stationBor(stationId,userid,true);
                    }
                }
                else {
                    if(stationId==1){
                        if (judg2.stationCondition2("Library")==false)
                            title.setText("No vacancy");
                        else changer.stationBor(stationId,userid,false);

                    }
                    else if (stationId==2){
                        if (judg2.stationCondition2("Village_Shop")==false)
                            title.setText("No vacancy");
                        else changer.stationBor(stationId,userid,false);
                    }
                    else if (stationId==3){
                        if (judg2.stationCondition2("Information_Teaching_Laboratories")==false)
                            title.setText("No vacancy");
                        else changer.stationBor(stationId,userid,false);
                    }
                }
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }
        if (back==(JButton)e.getSource())
            changer.scanCard(stationId);
    }
}
