package IOtimer;

import java.io.*;
import java.util.Scanner;

/**
 * Information acquisition layer,acquisition of information other than user in the file.
 * Each method is a special method given different search conditions
 * @author group 107
 * @version 4.0
 */
public class otherDetector {
    /**
     * When the user borrows the scooter, call this function before entering the station to see if there is a car at the station.
     * @param stationName Indicate which stations the user selected.
     * @return Indicates if there is a car in the station.
     * @throws FileNotFoundException Read information from the station file.
     */
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

    /**
     * When the user returns the scooter, call this function before entering the station to see if there is a empty position at the station.
     * @param stationName Indicate which stations the user selected.
     * @return  Indicates if there is a empty position in the station.
     * @throws FileNotFoundException Read information from the station file.
     */
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

    /**
     * It is called when the user returns the car, and finds the user's scooter ID, which is used to indicate in the station GUI
     * @param userId search condition,indicates which user’s scooter ID is to be checked.
     * @return Indicate the user’s scooter ID
     * @throws IOException Read information from usage_information.txt file
     */
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
            if (c=='\n'||c=='\r'||end==0){
                raf.seek(end+1);
                line=raf.readLine();
                if (line.indexOf(userId)!=-1){
                    String[] linearray=line.split(" ");
                    borrowId=linearray[linearray.length-1];
                    break;
                }
            }

        }
        return borrowId;
    }

    /**
     * It is called when the user returns the car, and finds the user's borrowing time, which is used to calculate the user's car time.
     * @param userId Search condition,indicates which user’s borrowing time is to be checked.
     * @return Indicate the user’s borrowing time
     * @throws IOException Read information from usage_information.txt file
     */
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
