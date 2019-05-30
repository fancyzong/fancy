package manager;

import javax.swing.*;
import java.io.IOException;

/**
 * The display set layer.
 * This class is mainly to set the appearance of the UI(for station)
 * @author group 107
 * @version 4.0
 */
public class displayStation  extends JFrame {
    static JButton[] scooters=new JButton[8];
    /**
     * Use the constructor to lay out the frame.
     * @param  name Decide which station to view.
     */
    public displayStation(String name) throws IOException {
        this.setLocationRelativeTo(null);
        this.setTitle("Station information");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(400,100);
        this.setVisible(true);
       fulfil ff=new fulfil();
       this.add(ff.fullfillstation(name));
    }
}
