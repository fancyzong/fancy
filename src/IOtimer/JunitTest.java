package IOtimer;

import org.junit.jupiter.api.Test;
import user.station;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * use Juint to test a method in other module.
 * just give two methods for example,
 * Testfine to test function of fining those who use the car for more than the time limit,
 * Teststation to test function of producing the panel of station.
 * @author group 107
 * @version 1.0
 */

public class JunitTest {
    /**
     * test the method of Fine in the class userChangeCondi
     * @throws IOException write new information to the user_information.txt
     */
    @Test
    void Testfine() throws IOException {
        userChangeCondi changeCondi=new userChangeCondi();
        changeCondi.Fine("111111111",1);
    }
    /**
     * test the instructor in the class station
     * @throws FileNotFoundException read information from the station file
     */
    @Test
    void Teststation() throws FileNotFoundException {
        JFrame jf=new JFrame();
        jf.setLocationRelativeTo(null);
        jf.setTitle("station");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setSize(800, 300);
        JPanel panel = new station(1,"111111111",true);
        jf.add(panel);
    }
}
