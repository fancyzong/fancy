package staff;

import IOtimer.userDetector;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import static staff.Display_user.tt1;
import static staff.Display_user.tt2;
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
        table.setForeground(Color.BLACK);
        table.setFont(new Font(null, Font.PLAIN, 14));
        table.setSelectionForeground(Color.DARK_GRAY);
        table.setSelectionBackground(Color.LIGHT_GRAY);
        table.setGridColor(Color.GRAY);
        table.getTableHeader().setFont(new Font(null, Font.BOLD, 14));
        table.getTableHeader().setForeground(Color.RED);
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.setRowHeight(30);
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        table.setPreferredScrollableViewportSize(new Dimension(600, 200));
        JScrollPane scrollPane = new JScrollPane(table);
        Table.setForeground(Color.BLACK);
        Table.setFont(new Font(null, Font.PLAIN, 14));
        Table.setSelectionForeground(Color.DARK_GRAY);
        Table.setGridColor(Color.GRAY);
        Table.getTableHeader().setFont(new Font(null, Font.BOLD, 14));
        Table.getTableHeader().setForeground(Color.RED);
        Table.getTableHeader().setResizingAllowed(false);
        Table.getTableHeader().setReorderingAllowed(false);
        Table.setRowHeight(30);
        Table.getColumnModel().getColumn(0).setPreferredWidth(40);
        Table.setPreferredScrollableViewportSize(new Dimension(600, 200));
        JScrollPane ScrollPane = new JScrollPane(Table);
        panel2.add(BorderLayout.CENTER,scrollPane);
        panel2.add(BorderLayout.NORTH,tt1);
        panel1.add(BorderLayout.CENTER,ScrollPane);
        panel1.add(BorderLayout.NORTH,tt2);
        panel.add(panel2);
        panel.add(panel1);
        return panel;
    }
}
