package IOtimer;

import java.io.*;

/**
 * The information modification layer.
 * This class is mainly to write some methods for modifying some information of user_information.txt.
 * Each method needs to provide different retrieval conditions, and they also implement different modification functions.
 * @author group 107
 * @version 4.0
 */
public class userChangeCondi {
    String str="";

    /**
     * This method is called after the user picked up(borrow) a scooter successfully in order to change the user's situation that indicates the user owns a scooter now
     * @param userId A search condition to find the specific line of the user's information in the file
     * @throws IOException In order to change a specific user's information in the file
     */
    public void borUserCondi(String userId) throws IOException {
        File file=new File("/Users/zongxuanfan/IdeaProjects/fancy/user_information.txt");
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        StringBuffer buf = new StringBuffer();
        while ((str=br.readLine())!=null){
            int flag=str.indexOf(userId);
            if (flag!=-1){
                String temp=str.replace("true","false");
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
     *This method is called after the user returned a scooter successfully in order to change the user's situation that indicates the user doesn't own a scooter now
     * @param userId A search condition to find the specific line of the user's information in the file
     * @throws IOException In order to change the a specific user's attribute in the file
     */
    public void retUserCondi(String userId) throws IOException {
        File file=new File("/Users/zongxuanfan/IdeaProjects/fancy/user_information.txt");
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        StringBuffer buf = new StringBuffer();
        while ((str=br.readLine())!=null){
            int flag=str.indexOf(userId);
            if (flag!=-1){
                String temp=str.replace("false","true");
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
     * This method is called when the system change the attribute "fine situation" of the user in the uesr_information file
     * @param userId A search condition to find the specific line of the user's information in the file
     * @throws IOException In order to change the specific user's "fine status" in the file
     */
    public void Fine(String userId) throws IOException {
        File file=new File("/Users/zongxuanfan/IdeaProjects/fancy/user_information.txt");
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        StringBuffer buf = new StringBuffer();
        String temp=new String();
        temp="";
        while ((str=br.readLine())!=null){
            if (str.indexOf(userId)!=-1){
                String[] linearray=str.split(" ");
                linearray[linearray.length-3]="0";
                for (int i=0;i<linearray.length;i++)
                    temp=temp+linearray[i]+" ";
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
     * This method is called when the user is paid the fine that hee/she is supposed to pay in order to change the user's "fine status" in the file
     * @param userId A search condition to find the specific line of the user's information in the file
     * @throws IOException In order to change the file content of specific user(the user's "fine status")
     */
    public void getFine(String userId) throws IOException {
        File file=new File("/Users/zongxuanfan/IdeaProjects/fancy/user_information.txt");
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        StringBuffer buf = new StringBuffer();
        String temp=new String();
        temp="";
        while ((str=br.readLine())!=null){
            if (str.indexOf(userId)!=-1){
                String[] linearray=str.split(" ");
                linearray[linearray.length-3]="1";
                for (int i=0;i<linearray.length;i++)
                    temp=temp+linearray[i]+" ";
                //System.out.println(temp);
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
     * This method is called after the user returned a scooter in order to accumulate the usage time of the user
     * @param userId This used for search the specific line in the file for the user
     * @param min   This is used for accumulating the total usage time for the user
     * @return This is used for indicating whether the user has used scooter over time
     * @throws IOException In order to the change the "accumulation time" of the user
     */
    public boolean addAcc(String userId,double min) throws IOException {
        File file=new File("/Users/zongxuanfan/IdeaProjects/fancy/user_information.txt");
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        StringBuffer buf = new StringBuffer();
        String temp=new String();
        boolean flag=true;
        temp="";
        while ((str=br.readLine())!=null){
            if (str.indexOf(userId)!=-1){
                String[] linearray=str.split(" ");
                if (min==-1) {
                    linearray[linearray.length - 1] = "0";
                    for (int i=0;i<linearray.length;i++)
                        temp=temp+linearray[i]+" ";
                    buf.append(temp+"\r\n");
                    continue;
                }
                linearray[linearray.length-1]=String.valueOf(Double.valueOf(linearray[linearray.length-1])+min);
                if (Double.valueOf(linearray[linearray.length-1])>3) {
                    linearray[linearray.length - 1] = "0";
                    flag=false;
                }
                for (int i=0;i<linearray.length;i++)
                    temp=temp+linearray[i]+" ";
                //System.out.println(temp);
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
        return flag;
    }

    /**
     * This method is called when the system is supposed to clear the accumulation time for all registered user in the beginning of a day
     * @throws IOException I order to clear the "accumulation time" for all user in the file
     */
    public void initAcc() throws IOException {
        File file = new File("/Users/zongxuanfan/IdeaProjects/fancy/user_information.txt");
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        StringBuffer buf = new StringBuffer();
        String temp = new String();
        while ((str = br.readLine()) != null) {
            String[] linearray = str.split(" ");
            linearray[linearray.length - 1] = "0";
            for (int i = 0; i < linearray.length; i++)
                temp = temp + linearray[i] + " ";
            buf.append(temp + "\r\n");
            temp="";
        }
        br.close();
        FileOutputStream fos = new FileOutputStream(file);
        PrintWriter pw = new PrintWriter(fos);
        pw.write(buf.toString().toCharArray());
        pw.flush();
        pw.close();
    }
}
