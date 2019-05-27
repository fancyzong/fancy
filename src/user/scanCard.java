package user;
import IOtimer.userDetector;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

/**
 * Scan then check the users' ID.
 * Provide users with an operation interface for inputting student numbers
 * @author group 107
 * @version 4.0
 */
public class scanCard extends JPanel implements ActionListener {
    JTextField user_id=new JTextField("",JTextField.CENTER);
    JLabel label_id=new JLabel("ID",JLabel.CENTER);
    JLabel message=new JLabel("Empty",JLabel.CENTER);
    JButton check=new JButton("Check");
    JButton back=new JButton("Back");
    UI swich=integationTest.test;
    int stationId;
    /**
     * Use the constructor to lay out the module and add listeners to the buttons.
     * @param stationId Indicate the users' ID which they input
     */
    public scanCard(int stationId){
        this.stationId=stationId;
        JPanel panel1=new JPanel();
        panel1.setLayout(new GridLayout(1,2));
        panel1.add(label_id);
        panel1.add(user_id);
        JPanel panel2=new JPanel();
        panel1.setLayout(new GridLayout(1,2));
        panel2.add(check);
        panel2.add(back);
        this.setLayout(new GridLayout(3,1));
        this.add(panel1);
        this.add(message);
        this.add(panel2);
        check.addActionListener(this);
        back.addActionListener(this);
    }
    /**
     * override the function in the super class,Gives the method you need to call when you press a button.
     * one button used for checking student numbers,one button for go back to the upper layer.
     * @param e Indicate which button has been pressed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(check==(JButton)e.getSource()){
            userDetector judge = new userDetector();
            try {
                if(judge.useridScan(user_id.getText())=="ID  exist")
                    swich.bor(stationId,user_id.getText());
                else
                    message.setText(judge.useridScan(user_id.getText()));
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }
        if(back==(JButton)e.getSource())
            swich.stationSelect();
    }
}
