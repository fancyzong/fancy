package user;

import staff.SUI;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

import staff.SUI;
import staff.TUI_monitor;
import staff.TUI_payFine;
import staff.TUI_register;

public class UI extends JFrame {
    JPanel panel=new JPanel();
    public void init(){
        this.setLocationRelativeTo(null);
        this.setTitle("Scooter Sharing System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        setSize(200,300);
        panel=new FUI();
        this.add(panel);
    }
    public void staff(){
        setSize(350,300);
        this.setTitle("Staff");
        this.remove(panel);
        panel=new SUI();
        this.add(panel);
        this.validate();
        repaint();
    }
    public void monitor(){
        setSize(200,400);
        this.setTitle("Monitor");
        this.remove(panel);
        panel=new TUI_monitor();
        this.add(panel);
        this.validate();
        repaint();
    }
    public void register(){
        this.setSize(470,300);
        this.setTitle("Register");
        this.remove(panel);
        panel=new TUI_register();
        this.add(panel);
        this.validate();
        repaint();
    }
    public void FUI(){
        setSize(200,300);
        this.setTitle("Scooter Sharing System");
        this.remove(panel);
        panel=new FUI();
        this.add(panel);
        this.validate();
        repaint();
    }
    public void stationSelect(){
        setSize(200,400);
        this.setTitle("Station selection");
        this.remove(panel);
        panel=new stationSelect();
        this.add(panel);
        this.validate();
        repaint();
    }
    public void scanCard(int stationId) {
        setSize(300, 200);
        this.setTitle("Scan Card");
        this.remove(panel);
        panel = new scanCard(stationId);
        this.add(panel);
        this.validate();
        repaint();
    }
    public void bor(int stationId,String userid) {
        setSize(200, 300);
        this.setTitle("Borrow Or Return");
        this.remove(panel);
        panel = new borrowOrreturn(stationId,userid);
        this.add(panel);
        this.validate();
        repaint();
    }
    public void stationBor(int stationId,String userid,boolean cond) {
        /*this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);*/
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
    public void payFine() {
        setSize(300, 200);
        this.setTitle("Pay a fine");
        this.remove(panel);
        panel = new TUI_payFine();
        this.add(panel);
        this.validate();
        repaint();
    }
}
