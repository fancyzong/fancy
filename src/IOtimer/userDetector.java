package IOtimer;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Information acquisition layer,check if the user is in the file(if registered).
 * Each method is a unique method given different search conditions
 * @author group 107
 * @version 4.0
 */
public class userDetector {
    /**
     * This method is called when a new user want to register. It used for checking if the user is registered or not
     * @param id This is used for search the file to find whether there is a user has the same id already
     * @return In order to indicate the checking result
     * @throws FileNotFoundException As we need to search the user_formation.txt for checking
     */
    public String useridRegister(String id) throws FileNotFoundException {
        if(id.length()!=0) {
            int flag = 0;
            String info = "Correct";
            Scanner scanner = new Scanner(new FileInputStream("user_information.txt"));
            while (scanner.hasNext()) {
                String str = scanner.next();
                flag++;
                if (flag % 6 == 2 && id.equals(str))
                    info = "ID already exist";
            }
            return info;
        }
        else
            return "empty";
    }

    /**
     * This method is called when a user want to enter a station or when the user want to pay the fine.
     * It aimed to check if the user is registered and legal
     * @param id It is used for searching the relative information
     * @param condition Determine which retrieval method is based on the value of the condition.
     * @return  In order to indicate the user's next operation
     * @throws FileNotFoundException As we need to search the user_information.txt
     */
    public String Scan(String id,int condition) throws IOException {
        if(id.length()!=0) {
            int flag = 0;
            int cond=0;
            String info = "ID not exist";
            Scanner scanner = new Scanner(new FileInputStream("user_information.txt"));
            while (scanner.hasNext()) {
                String str = scanner.next();
                flag++;
                if (flag % 6 == 2 && id.equals(str))
                    cond = flag;
                if (condition==1) {
                    if (flag - cond == 2 && "1".equals(str) && cond != 0)
                        info = "ID  exist";
                    if (flag - cond == 2 && "0".equals(str) && cond != 0)
                        info = "Your account is disabled";
                }
                else {
                    if (cond!=0)
                        info="You don't need to pay";
                    if (flag-cond==2&&"0".equals(str)&&cond!=0){
                        userChangeCondi change=new userChangeCondi();
                        change.Fine(id,0);
                        info="Successful";
                        break;
                    }
                }
            }
            return info;
        }
        else
            return "empty";
    }

    /**
     * This method is called when the system needs to check whether the user's status is legal
     * @param id In order to search the specific user's information in the file
     * @return In order to indicate the user's condition
     * @throws FileNotFoundException As we need to search the file
     */
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

    /**
     * This method is called when we need to get a specific line in a specific file
     * @param userId    Used for search
     * @param filename  Used for search specific file
     * @return  The specific information
     * @throws IOException As we need to read file
     */
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
