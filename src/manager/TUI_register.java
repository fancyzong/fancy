package manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import user.*;

/**
 * The information control layer provides the operator with the operation interface of the registered user.
 * The operator needs to provide three data types: mailbox, name and student number.
 * When the data meets certain specifications, it can be written.
 * @author group 107
 * @version 4.0
 */
public class TUI_register extends JPanel implements ActionListener,KeyListener {
    JButton check=new JButton("Check");
    JButton clear=new JButton("Clear");
    JButton back=new JButton("Back");
    static JLabel label_id=new JLabel("ID",JLabel.CENTER);
    static JLabel label_name=new JLabel("NAME",JLabel.CENTER);
    static JLabel label_email=new JLabel("E-mail",JLabel.CENTER);
    static JLabel label_idnote=new JLabel("nothing to display",JLabel.CENTER);
    static JLabel label_namenote=new JLabel("nothing to display",JLabel.CENTER);
    static JLabel label_emailnote=new JLabel("nothing to display",JLabel.CENTER);
    static JTextField text_id=new JTextField("",JTextField.CENTER);
    static JTextField text_name=new JTextField("",JTextField.CENTER);
    static JTextField text_email=new JTextField("",JTextField.CENTER);
    UI swich=integationTest.test;
    registerFunction rf=new registerFunction();
    /**
     * Use the constructor to lay out the module and add listeners to the buttons.
     */
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
    /**
     * override the function in the super class,Gives the method you need to call when you press a button.
     * @param e Indicate which button has been pressed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (check==(JButton)e.getSource()) {
            rf.check();
        }
        else if (clear==(JButton)e.getSource()){
            rf.clear();
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
