package user;

import java.io.FileNotFoundException;

/**
 * Provide an interface to the borrowUser class
 * @author group 107
 * @version 4.0
 */
public interface borInterface{
    public void borrowScooter(String userId, int stationId);
    public void borLayout(int stationId) throws FileNotFoundException;
}
