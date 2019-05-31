package user;

import manager.SUI;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;

import manager.TUI_monitor;
import manager.TUI_pay_fine;
import manager.TUI_register;
/**
 * This class is used to show the GUI
 * @author group 107
 * @version 4.0
 */
public class UI extends JFrame {
    JPanel panel=new JPanel();

    /**
     * The interface to select the user's identity.
     */
    public void init(){
        this.setLocationRelativeTo(null);
        this.setTitle("Scooter Sharing System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        setSize(400,300);
        panel=new FUI();
        this.add(panel);
    }

    /**
     * Remove the previous interface and enter the management interface.
     */
    public void staff(){
        setSize(350,300);
        this.setTitle("Staff");
        this.remove(panel);
        panel=new SUI();
        this.add(panel);
        this.validate();
        repaint();
    }

    /**
     * Remove the previous interface and enter an interface that detects the user and the station.
     */
    public void monitor(){
        setSize(400,300);
        this.setTitle("Monitor");
        this.remove(panel);
        panel=new TUI_monitor();
        this.add(panel);
        this.validate();
        repaint();
    }

    /**
     * Remove the previous interface and enter the interface where the administrator registers user information.
     */
    public void register(){
        this.setSize(470,300);
        this.setTitle("Register");
        this.remove(panel);
        panel=new TUI_register();
        this.add(panel);
        this.validate();
        repaint();
    }

    /**
     * Remove the previous interface and enter the beginning interface.
     */
    public void FUI(){
        setSize(400,300);
        this.setTitle("Scooter Sharing System");
        this.remove(panel);
        panel=new FUI();
        this.add(panel);
        this.validate();
        repaint();
    }

    /**
     * Remove the previous interface and enter the interface to select the station.
     */
    public void stationSelect(){
        setSize(200,400);
        this.setTitle("Station selection");
        this.remove(panel);
        panel=new stationSelect();
        this.add(panel);
        this.validate();
        repaint();
    }

    /**
     * Remove the previous interface and enter the interface inputting user ID.
     * @param stationId indicate which station we select.
     */
    public void scanCard(int stationId) {
        setSize(300, 200);
        this.setTitle("Scan Card");
        this.remove(panel);
        panel = new scanCard(stationId);
        this.add(panel);
        this.validate();
        repaint();
    }

    /**
     * Remove the previous interface and enter the interface judging the condition of user and station.
     * @param stationId indicate which station we select.
     * @param userid user ID
     */
    public void bor(int stationId,String userid) {
        setSize(200, 300);
        this.setTitle("Borrow Or Return");
        this.remove(panel);
        panel = new borrowOrReturn(stationId,userid);
        this.add(panel);
        this.validate();
        repaint();
    }

    /**
     * Remove the previous interface and enter the interface borrowing or returning a scooter.
     * @param stationId indicate which station we select.
     * @param userid user ID
     * @param cond Judging whether to borrow or return a car.
     * @throws IOException manny operation with file.
     */
    public void stationBor(int stationId,String userid,boolean cond) throws IOException {
        setLocation(300,300);
        setSize(800, 300);
        this.setTitle("station");
        this.remove(panel);
        try {
            panel = new station(stationId,userid,cond);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        this.add(panel);
        this.validate();
        repaint();
    }

    /**
     * Remove the previous interface and enter the interface provided to pay fine for exceeding specific time.
     */
    public void payFine() {
        setSize(300, 200);
        this.setTitle("Pay a fine");
        this.remove(panel);
        panel = new TUI_pay_fine();
        this.add(panel);
        this.validate();
        repaint();
    }
}
