package user;

import java.io.FileNotFoundException;

/**
 * Provide an interface to the returnUser class
 * @author group 107
 * @version 4.0
 */
public interface retInterface{
    public void returnScooter(String userId,int stationId);
    public void retLayout(int stationId) throws FileNotFoundException;
}
