package user;

import java.io.FileNotFoundException;

/**
 * This is an entity class that represents the people who want to borrow a bike.
 * Compared with ordinary users, there are a way to borrow the car.
 * @author group 107
 * @version 4.0
 */
public class borrowUser extends user implements borInteface{
    public borrowUser(){
        super();
    }

    /**
     * Perform the operation of borrowing a bike.
     * @param userId user's id
     * @param stationId indicate which station to return scooter
     */
    public void borrowScooter(String userId,int stationId){
        stationAction sa=new stationAction();
        sa.bosPerform(userId,stationId);
    }
    /**
     * Performing a layout operation(when borrow a scooter)
     * @param stationId indicate which station used to layout
     * @throws FileNotFoundException read the station file
     */
    public void borLayout(int stationId) throws FileNotFoundException {
        stationAction sa=new stationAction();
        sa.StationLayout(stationId,1);
    }
}
