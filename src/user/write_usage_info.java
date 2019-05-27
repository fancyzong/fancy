package user;

import java.io.FileWriter;
import java.io.IOException;

/**
 * This class is used to record history information
 * when the user borrow or lend a car successfully
 * which include the stationid, userid,condition(borrow or lend),borrow or lend time and scooterid
 * @author group 107
 * @version 1.0
 */
public class write_usage_info {
    /**
     * Use the constructor to perform a file write operation.
     * @param stationId Indicate the station which the user choose
     * @param userId Indicate the user's ID which the user input
     * @param cond Indicate whether the user is borrow or lend the car
     * @param time Indicate the time that the user borrow or lend the car
     * @param scooterId Indicate the ID of the scooter which the user borrow or lend
     * @throws IOException Write the history information into the  usage_information.txt
     */
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
