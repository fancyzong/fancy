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
    otherDetector od=new otherDetector();
    /**
     * This method is called after the user picked up(borrow) a scooter successfully in order to change the user's situation that indicates the user owns a scooter now
     * @param userId A search condition to find the specific line of the user's information in the file
     * @param condition Determine which retrieval method is based on the value of the condition.
     * @throws IOException In order to change a specific user's information in the file
     */
    public void UserCondi(String userId,int condition) throws IOException {
        String temp;
        BufferedReader br=od.configure();
        File file=new File("user_information.txt");
        StringBuffer buf = new StringBuffer();
        while ((str=br.readLine())!=null){
            int flag=str.indexOf(userId);
            if (flag!=-1){
                if (condition==1)
                    temp=str.replace("true","false");
                else
                    temp=str.replace("false","true");
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
     * @param condition Determine which retrieval method is based on the value of the condition.
     * @throws IOException In order to change the specific user's "fine status" in the file
     */
    public void Fine(String userId,int condition) throws IOException {
        BufferedReader br=od.configure();
        File file=new File("user_information.txt");
        StringBuffer buf = new StringBuffer();
        String temp=new String();
        temp="";
        while ((str=br.readLine())!=null){
            if (str.indexOf(userId)!=-1){
                String[] linearray=str.split(" ");
                if (condition==1)
                    linearray[linearray.length-3]="0";
                else
                    linearray[linearray.length-3]="1";
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
     * This method is called after the user returned a scooter in order to accumulate the usage time of the user
     * @param userId This used for search the specific line in the file for the user
     * @param min   This is used for accumulating the total usage time for the user
     * @return This is used for indicating whether the user has used scooter over time
     * @throws IOException In order to the change the "accumulation time" of the user
     */
    public boolean addAcc(String userId,double min) throws IOException {
        BufferedReader br=od.configure();
        File file=new File("user_information.txt");
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
                if (Double.valueOf(linearray[linearray.length-1])>120) {
                    linearray[linearray.length - 1] = "0";
                    flag=false;
                }
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
        return flag;
    }

    /**
     * This method is called when the system is supposed to clear the accumulation time for all registered user in the beginning of a day
     * @throws IOException I order to clear the "accumulation time" for all user in the file
     */
    public void initAcc() throws IOException {
        BufferedReader br=od.configure();
        File file=new File("user_information.txt");
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
