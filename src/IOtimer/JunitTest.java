package IOtimer;

import org.junit.jupiter.api.Test;
import user.station;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class JunitTest {
    @Test
    void Testfine() throws IOException {
        userChangeCondi changeCondi=new userChangeCondi();
        changeCondi.Fine("111111111");
    }
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
