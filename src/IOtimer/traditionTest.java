package IOtimer;

import user.station;

import javax.swing.*;
import java.io.IOException;

/**
 * Used to demonstrate traditional testing methods
 * @author group 107
 * @version 1.0
 */
public class traditionTest {
    public static void main(String[] args) throws IOException{
        JFrame jf=new JFrame();
        jf.setLocationRelativeTo(null);
        jf.setTitle("station");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setSize(800, 300);
        JPanel panel = new station(1,"111111111",true);
        jf.add(panel);

        userDetector judge = new userDetector();
        System.out.println(judge.useridScan("111111111"));
    }
}
