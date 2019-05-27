package staff;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static staff.Display_station.scooters;

/**
 * The generate layer.
 * This class is mainly to generate a chart to show the interested information of user to manager
 * @author group 107
 * @version 4.0
 */
public class fullfill {
    /**
     * This method is called when the manager want to view the specific information of the user(what the chart is to be formed depends on the choice of the manager)
     * @param col This is the column of the chart needs
     * @param file This the file name of the information source that used to generate the chart
     * @return  This is what we find after searching the file
     * @throws FileNotFoundException
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
    public JPanel fullfillstation(String name){
        JPanel jp=new JPanel(new GridLayout(1,8));
        BufferedReader br;
        try (FileReader fr = new FileReader(name)) {
            br = new BufferedReader(fr);
            String str;
            int i=0;
            while ((str = br.readLine()) != null) {
                String[] linearray=str.split(" ");
                if (linearray[linearray.length-1].equals("0")){
                    scooters[i]=new JButton();
                    scooters[i].setText("NULL");
                    jp.add(scooters[i]);
                    i++;
                    continue;
                }
                scooters[i]=new JButton();
                scooters[i].setText(linearray[linearray.length-1]);
                jp.add(scooters[i]);
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
}
