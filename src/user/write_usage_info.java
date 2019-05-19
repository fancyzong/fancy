package user;

import java.io.FileWriter;
import java.io.IOException;

public class write_usage_info {
    public write_usage_info(String stationId,String userId,String cond,String time,String scooterId) throws IOException {
        FileWriter fw = new FileWriter("usage_information.txt", true);
        fw.write(stationId + " ");
        fw.write(userId + " ");
        fw.write(cond + " ");
        fw.write(time + " ");
        fw.write(scooterId + "\n");
        fw.close();
    }
}
