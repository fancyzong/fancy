package IOtimer;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Detector {
    public String useridRegister(String id) throws FileNotFoundException {
        if(id.length()!=0) {
            int flag = 0;
            String info = "Correct";
            Scanner scanner = new Scanner(new FileInputStream("user_information.txt"));
            while (scanner.hasNext()) {
                String str = scanner.next();
                flag++;
                //System.out.println(str+flag%5);
                //System.out.println(id);
                if (flag % 6 == 2 && id.equals(str))
                    info = "ID already exist";
            }
            return info;
        }
        else
            return "empty";
    }
    public String useridScan(String id) throws FileNotFoundException {
        if(id.length()!=0) {
            int flag = 0;
            int cond=0;
            String info = "ID not exist";
            Scanner scanner = new Scanner(new FileInputStream("user_information.txt"));
            while (scanner.hasNext()) {
                String str = scanner.next();
                flag++;
                //System.out.println(str+flag%5);
                //System.out.println(id);
                if (flag % 6 == 2 && id.equals(str))
                    cond=flag;
                if (flag-cond==2&&"1".equals(str)&&cond!=0)
                    info = "ID  exist";
                if (flag-cond==2&&"0".equals(str)&&cond!=0)
                    info = "Your account is disabled";
            }
            return info;
        }
        else
            return "empty";
    }
    public boolean userCondition(String id) throws FileNotFoundException {
            int flag = 0;
            int label=0;
            boolean cond=true;
            Scanner scanner = new Scanner(new FileInputStream("user_information.txt"));
            while (scanner.hasNext()) {
                String str = scanner.next();
                flag++;
                if ( id.equals(str))
                    label=flag;
                if(flag-label==3&&"false".equals(str))
                    cond=false;
            }
            return cond;
    }

    public boolean stationCondition1(String stationName) throws FileNotFoundException {
        int flag = 0;
        int counter=0;
        Scanner scanner = new Scanner(new FileInputStream(stationName+".txt"));
        while (scanner.hasNext()) {
            String str = scanner.next();
            flag++;
            if ( flag%2==1&&"true".equals(str))
                counter++;
        }
        if (counter==0)
            return false;
        else
            return true;
    }
    public boolean stationCondition2(String stationName) throws FileNotFoundException {
        int flag = 0;
        int counter=0;
        Scanner scanner = new Scanner(new FileInputStream(stationName+".txt"));
        while (scanner.hasNext()) {
            String str = scanner.next();
            flag++;
            if ( flag%2==1&&"false".equals(str))
                counter++;
        }
        if (counter==0)
            return false;
        else
            return true;
    }
    public  String readFromLast(String userId) throws IOException {
        File f=new File("/Users/zongxuanfan/IdeaProjects/fancy/usage_information.txt");
        RandomAccessFile raf=new RandomAccessFile(f,"r");
        long start=raf.getFilePointer();
        long end=start+raf.length()-1;
        String line="";
        raf.seek(end);
        int c=-1;
        String borrowId="";
        while(end>start){
            end--;
            raf.seek(end);
            c=raf.read();
            //System.out.println(end);
            if (c=='\n'||c=='\r'||end==0){
                raf.seek(end+1);
                line=raf.readLine();
               // System.out.println(line);
                if (line.indexOf(userId)!=-1){
                    String[] linearray=line.split(" ");
                    borrowId=linearray[linearray.length-1];
                    break;
                }
            }

        }
        return borrowId;
    }
    public String payScan(String id) throws IOException {
            int flag = 0;
            int cond=0;
            String info = "ID not exist";
            Scanner scanner = new Scanner(new FileInputStream("user_information.txt"));
            while (scanner.hasNext()) {
                String str = scanner.next();
                flag++;
                //System.out.println(str+flag%5);
                //System.out.println(id);
                if (flag % 6 == 2 && id.equals(str) )
                    cond = flag;
                if (cond!=0)
                    info="You don't need to pay";
                if (flag-cond==2&&"0".equals(str)&&cond!=0){
                    changeCondi change=new changeCondi();
                    change.getFine(id);
                    info="Successful";
                    break;
                }
            }
            return info;

    }
    public String getTime(String userId) throws IOException {
        BufferedReader br;
        FileReader fr = new FileReader("usage_information.txt");
            br = new BufferedReader(fr);
            String str;
            String temp=new String();
            while ((str = br.readLine()) != null) {
                if (str.indexOf(userId) != -1) {
                    String[] linearray = str.split(" ");
                    temp = linearray[3];
                    break;
                }
            }
        return temp;
    }
    public ArrayList<String> getLine(String userId, String filename) throws IOException {
        BufferedReader br;
        ArrayList<String> arrayList=new ArrayList<String>();
        FileReader fr = new FileReader(filename);
        br = new BufferedReader(fr);
        String str;
        while ((str = br.readLine()) != null) {
            if (str.indexOf(userId) != -1) {
                String [] linearray = str.split(" ");
                for(int i=0;i<linearray.length;i++)
                    arrayList.add(linearray[i]);
                break;
            }
        }
        return arrayList;
    }

}
