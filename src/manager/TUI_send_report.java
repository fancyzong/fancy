package manager;

import IOtimer.stationChangeCondi;

import java.io.IOException;
import java.util.ArrayList;
/**
 * The information reading layer classifies and organizes the information in the document.
 * Classified according to different user IDs,
 * Generate a text file for each user to simulate sending a message.
 * @author group 107
 * @version 4.0
 */

import javax.swing.*;

/**
 * This class is called when the report is sent manually.
 * Write information to the corresponding text while generating a friendly friendly interface.
 * @author group 107
 * @version 4.0
 */
public class TUI_send_report extends JFrame {
    public static ArrayList<String> al;
    JTextArea textArea=new JTextArea();
    JScrollPane jScrollPane=new JScrollPane(textArea);
    stationChangeCondi scc=new stationChangeCondi();
    public TUI_send_report() throws IOException {
        al=new ArrayList<String>();
        scc.sendreport();
        textArea.setEditable(false);
        jScrollPane.setBounds(37, 13, 292, 443);
        this.setLocationRelativeTo(null);
        this.setTitle("Send email");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setSize(400,300);
        this.setVisible(true);
        for (int i=0;i<al.size();i++){
            if (i%2==1)
                textArea.setText(textArea.getText()+al.get(i)+"   sent"+"\n");
        }
        this.setContentPane(jScrollPane);
    }
}
