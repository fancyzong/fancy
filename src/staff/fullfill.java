package staff;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class fullfill {
    public Object[][] fullfillobject(int col,String file) throws FileNotFoundException {
        ArrayList<String> al=new ArrayList<String>();
        Scanner scanner = new Scanner(new FileInputStream(file));
        while (scanner.hasNext())
            al.add(scanner.next());
        int rows=al.size()/col;
        Object[][] obj=new Object[rows][col];
        for (int i=0;i<rows;i++){
            for (int j=0;j<col;j++)
                obj[i][j]=al.get((i*col)+j);
        }
        return obj;
    }
}
