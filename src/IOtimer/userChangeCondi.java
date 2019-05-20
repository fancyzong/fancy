package IOtimer;

import java.io.*;


public class userChangeCondi {
    String str="";
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
