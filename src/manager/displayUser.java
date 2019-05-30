package manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


/**
 * The display set layer.
 * This class is mainly to set the appearance of the UI(for user)
 * @author group 107
 * @version 4.0
 */

public class displayUser implements ActionListener {
    JFrame jf=new JFrame();
    JFrame search=new JFrame();
    JButton button=new JButton("search");
    JTextField textField=new JTextField();

    /**
     * Constructor lays out two windows.
     * One for displaying the data of users, one frame for search the data of one user
     * @throws FileNotFoundException Read the data from user_information.txt and usage_information.txt
     */
    public displayUser() throws FileNotFoundException {
        JPanel Panel = new JPanel(new GridLayout(1,3));
        Panel.add(textField);
        Panel.add(button);
        button.addActionListener(this);
        search.add(Panel);
        jf.setLocation(500,320);
        jf.setTitle("User information");
        jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        jf.setVisible(true);
        search.setLocation(300,300);
        search.setTitle("User information");
        search.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        search.setSize(200,100);
        search.setVisible(true);
        String[] columnNames={"name","ID","email","fine","condition","accumulation"};
        String[] ColumnNames={"station","user_ID","borrow","time","scooter_ID"};
        fulfil ff=new fulfil();
        JTable table = new JTable(ff.fullfillobject(6,"user_information.txt"), columnNames);
        JTable Table = new JTable(ff.fullfillobject(5,"usage_information.txt"), ColumnNames);
        fulfil ff1=new fulfil();
        jf.setLayout(new GridLayout(2,1));
        jf.add(ff1.setTable(table,"user basic information"));
        jf.add(ff1.setTable(Table,"usage information"));
        jf.pack();
    }
    /**
     * override the function in the super class,Gives the method you need to call when you press a button.
     * the button design for search the data of a specific user.
     * @param e Indicate which button has been pressed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (button==(JButton)e.getSource()){
            search s=new search();
            jf.setContentPane(s.searchDisplayUser(textField.getText()));

            jf.pack();
        }
    }
}

