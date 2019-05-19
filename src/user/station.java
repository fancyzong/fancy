package user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;

public class station extends JPanel implements ActionListener {
    static int countdown;
    static JLabel p[]=new JLabel[8];
    static JButton[] lock =new JButton[8];
    static JLabel[] light =new JLabel[8];
    static JLabel scooter[]=new JLabel[8];
    JPanel position[]=new JPanel[9];
    JPanel sp[]=new JPanel[8];
    static JLabel message=new JLabel("nothing",JLabel.CENTER);
    JButton goout=new JButton("Walk out");
    int stationId;
    String userId;
    static int userpos;
    static String borrowID="";
    boolean bor;
    UI swich=integationTest.test;
    static String station[]={"Library","Village_Shop","Information_Teaching_Laboratories"};
    static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
    stationAction sa=new stationAction();

    public station(int stationId,String userId,boolean bor)throws FileNotFoundException {
        countdown=60;
        this.stationId = stationId;
        this.userId = userId;
        this.bor=bor;
        this.setLayout(new GridLayout(1, 9));
        position[0] = new JPanel();
        position[0].setLayout(new GridLayout(2, 1));
        position[0].add(message);
        position[0].add(goout);
        goout.addActionListener(this);
        this.add(position[0]);
        for (int i = 1; i < 9; i++) {
            position[i] = new JPanel();
            sp[i-1]=new JPanel();
            ImageIcon ii = new ImageIcon("/Users/zongxuanfan/IdeaProjects/fancy/WechatIMG66.png");
            ii.setImage(ii.getImage().getScaledInstance(50, 50,  Image.SCALE_DEFAULT));
            p[i-1]=new JLabel(ii);
            lock[i - 1] = new JButton("Lock off");
            scooter[i - 1] = new JLabel("Empty",JLabel.CENTER);
            light[i - 1] = new JLabel("Flash off", JLabel.CENTER);
            position[i].setLayout(new GridLayout(3, 1));
            sp[i-1].setLayout(new GridLayout(2,1));
            sp[i-1].add(p[i-1]);
            sp[i-1].add(scooter[i-1]);
            position[i].add(sp[i-1]);
            position[i].add(light[i - 1]);
            position[i].add(lock[i - 1]);
            lock[i - 1].addActionListener(this);
            this.add(position[i]);
        }
        if (bor==true){
            sa.bosStationLayout(stationId);
        }
        else{
            sa.retStationLayout(stationId);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (lock[userpos]==(JButton)e.getSource()&&bor==true&&countdown>=0){
            sa.bosPerform(userId,stationId);
        }
        if (lock[userpos]==(JButton)e.getSource()&&bor==false&&countdown>=0){
            sa.retPerform(userId,stationId);
        }
        if (goout==(JButton)e.getSource()){
            swich.stationSelect();
        }
    }

}
