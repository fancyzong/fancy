package staff;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import IOtimer.*;
import user.*;

import javax.swing.*;


public class TUI_send_report extends JFrame {
    ArrayList<String> al=new ArrayList<String>();
    JTextArea textArea=new JTextArea();
    JScrollPane jScrollPane=new JScrollPane(textArea);
    public TUI_send_report() throws IOException {
        BufferedReader br1;
        try (FileReader fr = new FileReader("user_information.txt")) {
            br1 = new BufferedReader(fr);
            String str;
            while ((str = br1.readLine()) != null) {
                String[] strarray=str.split(" ");
                al.add(strarray[1]);
                al.add(strarray[2]);
                //System.out.println(str);
                if (!str.equals("")) {
                    FileWriter fw = new FileWriter(strarray[2] + ".txt");
                    fw.write( "");
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

        BufferedReader br;
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
