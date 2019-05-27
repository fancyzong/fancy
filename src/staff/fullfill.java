package staff;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * The generate layer.
 * This class is mainly to generate a chart to show the interested information of user to manager
 * @author group 107
 * @version 4.0
 */
public class fullfill {
    /**
     * This method is called when the manager want to view the specific information of the user(what the chart is to be formed depends on the choice of the manager)
     * @param col This is the column of the chart needs
     * @param file This the file name of the information source that used to generate the chart
     * @return  This is what we find after searching the file
     * @throws FileNotFoundException
     */
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
