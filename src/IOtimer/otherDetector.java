package IOtimer;

import java.io.*;
import java.util.Scanner;

public class otherDetector {
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
}
