package IOtimer;

import java.io.*;

public class stationChangeCondi {
    private String str="";
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
