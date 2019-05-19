package staff;

import java.io.FileWriter;
import java.io.IOException;
import IOtimer.*;
import user.*;


public class Write_user_info {
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
