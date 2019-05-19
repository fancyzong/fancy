package staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import IOtimer.*;
import user.*;


public class TUI_register extends JPanel implements ActionListener,KeyListener {
    JButton check=new JButton("Check");
    JButton clear=new JButton("Clear");
    JButton back=new JButton("Back");
    JLabel label_id=new JLabel("ID",JLabel.CENTER);
    JLabel label_name=new JLabel("NAME",JLabel.CENTER);
    JLabel label_email=new JLabel("E-mail",JLabel.CENTER);
    JLabel label_idnote=new JLabel("nothing to display",JLabel.CENTER);
    JLabel label_namenote=new JLabel("nothing to display",JLabel.CENTER);
    JLabel label_emailnote=new JLabel("nothing to display",JLabel.CENTER);
    JTextField text_id=new JTextField("",JTextField.CENTER);
    JTextField text_name=new JTextField("",JTextField.CENTER);
    JTextField text_email=new JTextField("",JTextField.CENTER);
    UI swich=testui.test;
    public TUI_register(){
        this.setLayout(new GridLayout(2,1));
        Panel p1=new Panel();
        p1.setLayout(new GridLayout(3,3));
        p1.add(label_name);
        p1.add(text_name);
        p1.add(label_namenote);
        p1.add(label_id);
        p1.add(text_id);
        p1.add(label_idnote);
        p1.add(label_email);
        p1.add(text_email);
        p1.add(label_emailnote);
        Panel p2=new Panel();
        Panel p3=new Panel();
        p2.setLayout(new GridLayout(1,2));
        p3.setLayout(new GridLayout(2,1));
        p3.add(clear);
        p3.add(back);
        p2.add(check);
        p2.add(p3);
        this.add(p1);
        this.add(p2);
        back.addActionListener(this);
        check.addActionListener(this);
        clear.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (check==(JButton)e.getSource()) {
            boolean flag = true;
            if (text_name.getText().length() > 20 ) {
                label_namenote.setText("20 chars limited");
                flag = false;
            }
            else if (text_name.getText().length() == 0){
                label_namenote.setText("Empty");
                flag = false;
            }
            else
                label_namenote.setText("Correct");
            if (text_id.getText().length() != 9) {
                label_idnote.setText("Only 9 numbers allowed");
                flag = false;
            }
            else {
                label_idnote.setText("Correct");
                for (int i = 0; i < text_id.getText().length(); i++) {
                    int chr = text_id.getText().charAt(i);
                    if ((chr > 57 || chr < 48)) {
                        label_idnote.setText("Only 9 numbers allowed");
                        flag = false;
                        break;
                    }
                }
            }
            if ((text_email.getText().indexOf("@") + 1 < text_email.getText().length()) && text_email.getText().indexOf("@") > 0)
                label_emailnote.setText("Correct");
            else {
                label_emailnote.setText("Format:***@***");
                flag = false;
            }
            if (label_idnote.getText().equals("Correct")) {
                Detector judgement = new Detector();
                try {
                    label_idnote.setText(judgement.useridRegister(text_id.getText()));
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
            if(label_idnote.getText()=="ID already exist")
                flag=false;
            if (flag == true) {
                try {
                    new Write_user_info(text_name.getText(), text_id.getText(), text_email.getText());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                text_id.setText("");
                text_name.setText("");
                text_email.setText("");
            }
        }
        else if (clear==(JButton)e.getSource()){
            text_id.setText("");
            text_name.setText("");
            text_email.setText("");
        }
        else {
            swich.staff();
        }
    }
    public void keyTyped(KeyEvent e){

    }
    public void keyPressed(KeyEvent e){

    }
    public void keyReleased(KeyEvent e){

    }
}
