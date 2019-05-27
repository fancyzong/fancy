package staff;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Information writing layer,call this function after the registered user succeeds.
 * Write user information to user_information.txt.
 * @author group 107
 * @version 1.0
 */

public class Write_user_info {
    /**
     * Use the constructor to perform a file write operation.
     * @param name user's name
     * @param id user's student number
     * @param email user's email
     * @throws IOException modify the data of user)information.txt
     */
    public Write_user_info(String name,String id,String email) throws IOException {
        FileWriter fw = new FileWriter("user_information.txt",true);
        fw.write(name+" ");
        fw.write(id+" ");
        fw.write(email+" ");
        fw.write("1"+" ");
        fw.write(String.valueOf(true)+" ");
        fw.write("0"+"\n");
        fw.close();
    }
}
