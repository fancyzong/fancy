package manager;

import IOtimer.otherDetector;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static manager.displayStation.scooters;
import static user.stationSelect.stationName;

/**
 * The generate layer.
 * This class is mainly to generate a chart to show the interested information of user to manager
 * @author group 107
 * @version 4.0
 */
public class fulfil {
    /**
     * This method is called when the manager want to view the specific information of the user(what the chart is to be formed depends on the choice of the manager)
     * @param col This is the column of the chart needs
     * @param file This the file name of the information source that used to generate the chart
     * @return This is what we find after searching the file
     * @throws FileNotFoundException read the data of user_information.txt file.
     */
    public Object[][] fullfillobject(int col,String file) throws FileNotFoundException {
        ArrayList<String> al=new ArrayList<String>();
        Scanner scanner = new Scanner(new FileInputStream(file));
        while (scanner.hasNext())
            al.add(scanner.next());
        int rows=al.size()/col;
        Object[][] obj=new Object[rows][col];
        for (int i=0;i<rows;i++){
            for (int j=0;j<col;j++)
                obj[i][j]=al.get((i*col)+j);
        }
        return obj;
    }

    /**
     * The information reading layer is called when the station information needs to be viewed.
     * @param name indicate which station i want to view.
     * @return Generate corresponding modules based on the information of the station.
     */
    public JPanel fullfillstation(String name) throws IOException {
        otherDetector od=new otherDetector();
        int stationSize=od.getstationsize(name);
        JButton[] scooter=new JButton[stationSize];
        JPanel jp=new JPanel(new GridLayout(1,stationSize));
        BufferedReader br;
        try (FileReader fr = new FileReader(name)) {
            br = new BufferedReader(fr);
            String str;
            int i=0;
            while ((str = br.readLine()) != null) {
                String[] linearray=str.split(" ");
                if (linearray[linearray.length-1].equals("0")){
                    scooter[i]=new JButton();
                    scooter[i].setText("NULL");
                    jp.add(scooter[i]);
                    i++;
                    continue;
                }
                scooter[i]=new JButton();
                scooter[i].setText(linearray[linearray.length-1]);
                jp.add(scooter[i]);
                i++;
            }

            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jp;
    }

    /**
     * Generate a corresponding table for a specific text.
     * @param table the table which i want to fulfil
     * @param title The meaning of the form.
     * @return Place the table and title in the panel and return the panel.
     */
    public JPanel setTable(JTable table,String title){
        JLabel tt1=new JLabel(title);
        JPanel panel = new JPanel(new BorderLayout());
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
        panel.add(BorderLayout.CENTER,scrollPane);
        panel.add(BorderLayout.NORTH,tt1);
        return panel;
    }
}
