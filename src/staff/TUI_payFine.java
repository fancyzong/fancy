package staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import IOtimer.*;
import user.*;


public class TUI_payFine extends JPanel implements ActionListener {
    JButton goback=new JButton("Back");
    JButton pay=new JButton("Pay");
    JLabel message=new JLabel("Input your ID:",JLabel.CENTER);
    JTextField Id=new JTextField("");
    UI swich=integationTest.test;
    public TUI_payFine(){
        this.setLayout(new GridLayout(2,2));
        this.add(message);
        this.add(Id);
        this.add(pay);
        this.add(goback);
        pay.addActionListener(this);
        goback.addActionListener(this);
    }
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
