package staff;

import java.io.*;
import java.util.ArrayList;
/**
 * The information reading layer classifies and organizes the information in the document.
 * Classified according to different user IDs,
 * Generate a text file for each user to simulate sending a message.
 * @author group 107
 * @version 4.0
 */

import javax.swing.*;


public class TUI_send_report extends JFrame {
    ArrayList<String> al=new ArrayList<String>();
    JTextArea textArea=new JTextArea();
    JScrollPane jScrollPane=new JScrollPane(textArea);

    /**
     * Generate an empty document for each user based on the user information in the user_information.txt.
     * @throws IOException Read user_information.txt file and produce many new documents
     */
    public void clearReport() throws IOException {
        BufferedReader br1;
        try (FileReader fr = new FileReader("user_information.txt")) {
            br1 = new BufferedReader(fr);
            String str;
            while ((str = br1.readLine()) != null) {
                String[] strarray = str.split(" ");
                al.add(strarray[1]);
                al.add(strarray[2]);
                //System.out.println(str);
                if (!str.equals("")) {
                    FileWriter fw = new FileWriter(strarray[2] + ".txt");
                    fw.write("");
                    fw.flush();
                    fw.close();
                }
            }
            br1.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Write the information in history.txt to the corresponding text according to the ID.
     * A window is generated to indicate that the message was sent successfully.
     * @throws IOException Read the data of history.txt
     */
    public void sendreport() throws IOException {
        BufferedReader br;
        clearReport();
        try (FileReader fr = new FileReader("history.txt")) {
            br = new BufferedReader(fr);
            String str;
            String temp;
            while ((str = br.readLine()) != null) {
                String[] strarray=str.split(" ");
                for (int i=0;i<al.size();i++){
                    if (al.get(i).equals(strarray[1])){
                        if (!str.equals("")) {
                            FileWriter fw = new FileWriter(al.get(i+1) + ".txt", true);
                            fw.write(str + "\n");
                            fw.close();
                            break;
                        }
                    }
                }
                //System.out.println(str);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileWriter fw1 = new FileWriter("history.txt");
        fw1.write("");
        fw1.flush();
        fw1.close();
        textArea.setEditable(false);
        jScrollPane.setBounds(37, 13, 292, 443);
        this.setLocationRelativeTo(null);
        this.setTitle("Send email");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setSize(150,150);
        this.setVisible(true);
        for (int i=0;i<al.size();i++){
            if (i%2==1)
                textArea.setText(textArea.getText()+al.get(i)+"   sent"+"\n");
        }
        this.setContentPane(jScrollPane);
    }
}
