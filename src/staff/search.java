package staff;

import IOtimer.userDetector;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The get-input layer.
 * This class is mainly to set the UI for the user's input
 * @author group 107
 * @version 4.0
 */
public class search {
    /**
     * This method is called when the manager want to get the information to form a chart
     * @param userId In order to search the user's information
     * @return
     */
    public JPanel searchDisplayUser(String userId){
        String[] columnNames={"name","ID","email","fine","condition","accumulation"};
        String[] ColumnNames={"station","user_ID","borrow","time","scooter_ID"};
        ArrayList<String> al=new ArrayList<String>();
        ArrayList<String> AL=new ArrayList<String>();
        Object[][] obj=new Object[1][6];
        Object[][] OBJ=new Object[1][5];
        JPanel panel2 = new JPanel(new BorderLayout());
        JPanel panel1=new JPanel(new BorderLayout());
        JPanel panel = new JPanel(new GridLayout(2,1));
        userDetector detector=new userDetector();
        try {
            al=detector.getLine(userId,"user_information.txt");
            for (int i=0;i<al.size();i++)
                obj[0][i]=al.get(i);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            AL=detector.getLine(userId,"usage_information.txt");
            for (int i=0;i<AL.size();i++)
                OBJ[0][i]=AL.get(i);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        JTable table = new JTable(obj, columnNames);
        JTable Table = new JTable(OBJ, ColumnNames);
        fulfil ff1=new fulfil();
        panel.add(ff1.setTable(table,"user basic information"));
        panel.add(ff1.setTable(Table,"usage information"));
        return panel;
    }
}
