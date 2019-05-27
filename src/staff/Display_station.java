package staff;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * The display set layer.
 * This class is mainly to set the appearance of the UI(for station)
 * @author group 107
 * @version 4.0
 */
public class Display_station  extends JFrame {
    JButton[] scooters=new JButton[8];
    public Display_station(String name){
        this.setLayout(new GridLayout(1,8));
        this.setLocationRelativeTo(null);
        this.setTitle("Station information");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(400,100);
        this.setVisible(true);
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
                    this.add(scooters[i]);
                    i++;
                    continue;
                }
                scooters[i]=new JButton();
                scooters[i].setText(linearray[linearray.length-1]);
                this.add(scooters[i]);
                i++;
            }

            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
