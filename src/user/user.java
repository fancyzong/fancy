package user;

import IOtimer.userDetector;

import java.io.IOException;

/**
 * This class is an entity class represent user
 * @author group 107
 * @version 4.0
 */

public class user {
    UI changer=integationTest.test;
    private String email;
    private String name;
    private String ID;
    /**
     * This method is called when the user want to pay fine
     * @param id This is the user's ID
     * @return This a String as the return
     * @throws IOException As this method needs to do operation to a file
     */

    public String payIt(String id) throws IOException {
        userDetector D=new userDetector();
        return D.Scan(id,0);
    }

    /**
     * Perform user's card swipe behavior.
     */
    public void scanCard(){
        changer.stationSelect();
    }

    /**
     * Perform user's registration behavior.
     */
    public void register(){
        changer.register();
    }
    /**
     * This is a constructor to construct user object
     * @param email This is one of the parameters of the user's attribute
     * @param name This is one of the parameters of the user's attribute
     * @param ID This is one of the parameters of the user's attribute
     */

    public user(String email,String name,String ID){
        this.email=email;
        this.name=name;
        this.ID=ID;
    }
    public user(){

    }

    public String getEmail() {
        return email;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }


}
