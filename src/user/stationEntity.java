package user;

/**
 * This class is an entity class represent station.
 * @author group 107
 * @version 4.0
 */

public class stationEntity {
    int stationId;
    boolean forWhat;

    /**
     *This is a constructor for the entity class named stationEntity
     * @param stationId In order to indicate which station it is
     * @param forWhat In order to indicate the user is going to pick up or return a scooter
     */
    public stationEntity(int stationId,boolean forWhat){
        this.stationId=stationId;
        this.forWhat=forWhat;
    }

    public int getStationId() {
        return stationId;
    }

    public boolean getforWhat() {
        return forWhat;
    }
}
