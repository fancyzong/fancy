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
     * When the user borrows/return the scooter, call this function before entering the station to see if there is a scooter/empty position at the station.
     * @param stationName Indicate which stations the user selected.
     * @param condition Determine which retrieval method is based on the value of the condition.
     * @return Indicates if there is a car in the station.
     * @throws FileNotFoundException Read information from the station file.
     */
    public boolean stationCondition(String stationName,int condition) throws FileNotFoundException {
        int flag = 0;
        int counter=0;
        String content="false";
        if (condition==1)
            content="true";
        Scanner scanner = new Scanner(new FileInputStream(stationName+".txt"));
        while (scanner.hasNext()) {
            String str = scanner.next();
            flag++;
            if ( flag%2==1&&content.equals(str))
                counter++;
        }
        if (counter==0)
            return false;
        else
            return true;
    }



    /**
     * It is called when we need some specific message,for example: finds the user's borrowing time, which is used to calculate the user's car time.
     * @param userId Search condition,indicates which user’s borrowing time is to be checked.
     * @param position Determine the location of the target information.
     * @return Indicate the user’s borrowing time
     * @throws IOException Read information from usage_information.txt file
     */
    public String getMessage(String userId,int position) throws IOException {
        BufferedReader br;
        FileReader fr = new FileReader("usage_information.txt");
        br = new BufferedReader(fr);
        String str;
        String temp=new String();
        while ((str = br.readLine()) != null) {
            if (str.indexOf(userId) != -1) {
                String[] linearray = str.split(" ");
                temp = linearray[position];
                break;
            }
        }
        return temp;
    }

    /**
     * The size of the station (how many cars can be accommodated) is obtained by detecting the number of lines in the file.
     * @param file indicate which file i want to read
     * @return the size of station
     * @throws IOException read station file
     */
    public int getstationsize(String file) throws IOException {
        BufferedReader br;
        FileReader fr = new FileReader(file);
        br = new BufferedReader(fr);
        int size=0;
        while(br.readLine()!=null){
            size++;
        }
        return size;
    }
}
