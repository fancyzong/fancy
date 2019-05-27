package IOtimer;

import java.io.*;
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
     * @throws IOException Modify the data of station file.
     */
    public void borPosCond(String scootId,String station) throws IOException {
        File file=new File("/Users/zongxuanfan/IdeaProjects/fancy/"+station);
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        StringBuffer buf = new StringBuffer();
        while ((str=br.readLine())!=null){
            int flag=str.indexOf(scootId);
            if (flag!=-1){
                String temp=str.replace("true "+scootId,"false 0");
                buf.append(temp+"\r\n");
            }
            else
                buf.append(str+"\r\n");
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
     * Modify the data in the station file to eliminate the marking of the borrowed bicycle.
     * @param scootId A search condition that determines the location of the marker.
     * @param station The retrieval condition is used to determine which station file to modify
     * @throws IOException Modify the data of station file.
     */
    public void retPosCond(String scootId,String station) throws IOException {
        int number=0;
        File file=new File("/Users/zongxuanfan/IdeaProjects/fancy/"+station);
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        StringBuffer buf = new StringBuffer();
        while ((str=br.readLine())!=null){
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
        File file=new File("/Users/zongxuanfan/IdeaProjects/fancy/usage_information.txt");
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
}
