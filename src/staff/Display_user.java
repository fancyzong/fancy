package staff;

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

public class Display_user implements ActionListener {
    JFrame jf=new JFrame();
    JFrame search=new JFrame();
    static JLabel tt1=new JLabel("user history");
    static JLabel tt2=new JLabel("Vehicle information that the user is using");
    JButton button=new JButton("search");
    JTextField textField=new JTextField();

    /**
     * Constructor lays out two windows.
     * One for displaying the data of users, one frame for search the data of one user
     * @throws FileNotFoundException Read the data from user_information.txt and usage_information.txt
     */
    public Display_user() throws FileNotFoundException {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel panel1=new JPanel(new BorderLayout());
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
        //setSize(200,300);
        String[] columnNames={"name","ID","email","fine","condition","accumulation"};
        String[] ColumnNames={"station","user_ID","borrow","time","scooter_ID"};
        fullfill ff=new fullfill();
        JTable table = new JTable(ff.fullfillobject(6,"user_information.txt"), columnNames);
        JTable Table = new JTable(ff.fullfillobject(5,"usage_information.txt"), ColumnNames);
        table.setForeground(Color.BLACK);                   // font color
        table.setFont(new Font(null, Font.PLAIN, 14));      // Font style
        table.setSelectionForeground(Color.DARK_GRAY);      // font color after being selected
        table.setSelectionBackground(Color.LIGHT_GRAY);     // font background after being selected
        table.setGridColor(Color.GRAY);                     // Grid color

        // Setting header
        table.getTableHeader().setFont(new Font(null, Font.BOLD, 14));  //Set the header name font style
        table.getTableHeader().setForeground(Color.RED);                // Set the header name font color
        table.getTableHeader().setResizingAllowed(false);               // Settings do not allow manual change of column width
        table.getTableHeader().setReorderingAllowed(false);             // Setting does not allow dragging to reorder columns

        // Set line height
        table.setRowHeight(30);

        // The first column width is set to 40
        table.getColumnModel().getColumn(0).setPreferredWidth(70);

        // Set the size of the scroll panel viewport (more than the row data of this size, you need to drag the scroll bar to see)
        table.setPreferredScrollableViewportSize(new Dimension(600, 200));

        // Place the table in the scroll panel (the header will be automatically added to the top of the scroll panel)
        JScrollPane scrollPane = new JScrollPane(table);

        Table.setForeground(Color.BLACK);
        Table.setFont(new Font(null, Font.PLAIN, 14));
        Table.setSelectionForeground(Color.DARK_GRAY);
        Table.setSelectionBackground(Color.LIGHT_GRAY);
        Table.setGridColor(Color.GRAY);
        Table.getTableHeader().setFont(new Font(null, Font.BOLD, 14));
        Table.getTableHeader().setForeground(Color.RED);
        Table.getTableHeader().setResizingAllowed(false);
        Table.getTableHeader().setReorderingAllowed(false);
        Table.setRowHeight(30);
        Table.getColumnModel().getColumn(3).setPreferredWidth(120);
        Table.setPreferredScrollableViewportSize(new Dimension(600, 200));
        JScrollPane ScrollPane = new JScrollPane(Table);
        panel.add(BorderLayout.CENTER,scrollPane);
        panel.add(BorderLayout.NORTH,tt1);
        panel1.add(BorderLayout.CENTER,ScrollPane);
        panel1.add(BorderLayout.NORTH,tt2);
        jf.setLayout(new GridLayout(2,1));
        jf.add(panel);
        jf.add(panel1);
        jf.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (button==(JButton)e.getSource()){
            search s=new search();
            jf.setContentPane(s.searchDisplayUser(textField.getText()));

            jf.pack();
        }
    }
}

