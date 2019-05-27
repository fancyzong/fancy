package staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import IOtimer.*;
import user.*;

/**
 * Data control layer, providing the operator with a fine operation interface
 * The administrator can provide a fine for the user by providing the user's id.
 * @author group 107
 * @version 4.0
 */

public class TUI_payFine extends JPanel implements ActionListener {
    JButton goback=new JButton("Back");
    JButton pay=new JButton("Pay");
    JLabel message=new JLabel("Input your ID:",JLabel.CENTER);
    JTextField Id=new JTextField("");
    UI swich=integationTest.test;

    /**
     * Use the constructor to lay out the module and add listeners to the buttons.
     */
    public TUI_payFine(){
        this.setLayout(new GridLayout(2,2));
        this.add(message);
        this.add(Id);
        this.add(pay);
        this.add(goback);
        pay.addActionListener(this);
        goback.addActionListener(this);
    }
    /**
     * override the function in the super class,Gives the method you need to call when you press a button.
     * @param e Indicate which button has been pressed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (pay ==(JButton)e.getSource()) {
            if (Id.getText().length()==0)
                message.setText("Empty");
            else {
                userDetector D=new userDetector();
                try {
                    message.setText(D.payScan(Id.getText()));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        if (goback==(JButton)e.getSource())
            swich.staff();
    }
}
