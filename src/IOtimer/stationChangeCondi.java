package IOtimer;

import java.io.*;

import static manager.TUI_send_report.al;

/**
 * The information modification layer.
 * This class is mainly to write some methods for modifying some information of the text document
 * during the process of borrowing,returning a scooter.
 * Each method is a special method given different search conditions
 * @author group 107
 * @version 4.0
 */
public class stationChangeCondi {
    private String str="";

    /**
     * This method is called when the user borrows a bicycle.
     * Modify the data in the station file to mark the bicycle that the user borrowed.
     * @param scootId A search condition that determines the location of the marker.
     * @param station The retrieval condition is used to determine which station file to modify.
     * @param condition Determine which retrieval method is based on the value of the condition.
     * @throws IOException Modify the data of station file.
     */
    public void PosCond(String scootId,String station,int condition) throws IOException {
        int number=0;
        File file=new File(station);
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        StringBuffer buf = new StringBuffer();
        while ((str=br.readLine())!=null){
            if (condition==1) {
                int flag = str.indexOf(scootId);
                if (flag != -1) {
                    String temp = str.replace("true " + scootId, "false 0");
                    buf.append(temp + "\r\n");
                } else
                    buf.append(str + "\r\n");
            }
            else {
                if ("false 0".equals(str)){
                    number++;
                    if (number==1) {
                        String temp = str.replace("false 0", "true " + scootId);
                        buf.append(temp + "\r\n");
                    }
                    else
                        buf.append(str+"\r\n");
                }
                else
                    buf.append(str+"\r\n");
            }
        }
        br.close();
        FileOutputStream fos = new FileOutputStream(file);
        PrintWriter pw = new PrintWriter(fos);
        pw.write(buf.toString().toCharArray());
        pw.flush();
        pw.close();
    }



    /**
     * This method is called when the user returns a bicycle.
     * @param userId A search condition that Indicates the location of the line of information to delete.
     * @return The line of information to be deleted is returned and written as data for another document.
     * @throws IOException Delete the data of usage_information
     */
    public String deleteLine(String userId) throws IOException {
        File file=new File("usage_information.txt");
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        StringBuffer buf = new StringBuffer();
        String temp = null;
        while ((str=br.readLine())!=null){
            if (str.indexOf(userId)!=-1) {
                temp = str;
                continue;
            }
            buf.append(str+"\r\n");
        }
        br.close();
        FileOutputStream fos = new FileOutputStream(file);
        PrintWriter pw = new PrintWriter(fos);
        pw.write(buf.toString().toCharArray());
        pw.flush();
        pw.close();
        return temp;
    }
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
                if(!str.equals("")) {
                    String[] strarray = str.split(" ");
                    al.add(strarray[1]);
                    al.add(strarray[2]);
                    //System.out.println(str);
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
            while ((str = br.readLine()) != null) {
                if (!str.equals("")) {
                    String[] strarray = str.split(" ");
                    for (int i = 0; i < al.size(); i++) {
                        if (al.get(i).equals(strarray[1])) {
                            if (!str.equals("")) {
                                FileWriter fw = new FileWriter(al.get(i + 1) + ".txt", true);
                                fw.write(str + "\n");
                                fw.close();
                                break;
                            }
                        }
                    }
                }
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
    }
}
