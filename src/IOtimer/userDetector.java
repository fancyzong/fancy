package IOtimer;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class userDetector {
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
                    userChangeCondi change=new userChangeCondi();
                    change.getFine(id);
                    info="Successful";
                    break;
                }
            }
            return info;

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
