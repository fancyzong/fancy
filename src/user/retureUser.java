package user;

import java.io.FileNotFoundException;

/**
 * This is an entity class that represents the people who want to return bike.
 * Compared with ordinary users, there are a way to return the car.
 * @author group 107
 * @version 4.0
 */
public class retureUser extends user implements retInteface{
    public retureUser(){
        super();
    }

    /**
     * Performing a return operation
     * @param userId user's id
     * @param stationId indicate which station to return scooter
     */
    public void returnScooter(String userId,int stationId){
        stationAction sa=new stationAction();
        sa.retPerform(userId,stationId);
    }

    /**
     * Performing a layout operation(when return a scooter)
     * @param stationId indicate which station used to layout
     * @throws FileNotFoundException read the station file
     */
    public void retLayout(int stationId) throws FileNotFoundException {
        stationAction sa=new stationAction();
        sa.StationLayout(stationId,0);
    }
}
