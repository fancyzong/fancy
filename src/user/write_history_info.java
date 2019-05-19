package user;

import java.io.FileWriter;
import java.io.IOException;
import IOtimer.stationChangeCondi;

public class write_history_info {
    public write_history_info(String stationId,String userId,String cond,String time,String scooterId) throws IOException {
        FileWriter fw = new FileWriter("history.txt",true);
        stationChangeCondi cc=new stationChangeCondi();
        fw.write(cc.deleteLine(userId)+"\n");
        fw.write(stationId+" ");
        fw.write(userId+" ");
        fw.write(cond+" ");
        fw.write(time+" ");
        fw.write(scooterId+"\n");
        fw.close();
    }
}
