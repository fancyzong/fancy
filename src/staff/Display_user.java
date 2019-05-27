package staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


/**
 * The display set layer.
 * This class is mainly to set the appearance of the UI(for user)
 * @author group 107
 * @version 4.0
 */

public class Display_user implements ActionListener {
    JFrame jf=new JFrame();
    JFrame search=new JFrame();
    static JLabel tt1=new JLabel("user history");
    static JLabel tt2=new JLabel("Vehicle information that the user is using");
    JButton button=new JButton("search");
    JTextField textField=new JTextField();
    public Display_user() throws FileNotFoundException {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel panel1=new JPanel(new BorderLayout());
        JPanel Panel = new JPanel(new GridLayout(1,3));
        Panel.add(textField);
        Panel.add(button);
        button.addActionListener(this);
        search.add(Panel);
        jf.setLocation(500,320);
        jf.setTitle("User information");
        jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        jf.setVisible(true);
        search.setLocation(300,300);
        search.setTitle("User information");
        search.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        search.setSize(200,100);
        search.setVisible(true);
        //setSize(200,300);
        String[] columnNames={"name","ID","email","fine","condition","accumulation"};
        String[] ColumnNames={"station","user_ID","borrow","time","scooter_ID"};
        fullfill ff=new fullfill();
        JTable table = new JTable(ff.fullfillobject(6,"user_information.txt"), columnNames);
        JTable Table = new JTable(ff.fullfillobject(5,"usage_information.txt"), ColumnNames);
        table.setForeground(Color.BLACK);                   // 字体颜色
        table.setFont(new Font(null, Font.PLAIN, 14));      // 字体样式
        table.setSelectionForeground(Color.DARK_GRAY);      // 选中后字体颜色
        table.setSelectionBackground(Color.LIGHT_GRAY);     // 选中后字体背景
        table.setGridColor(Color.GRAY);                     // 网格颜色

        // 设置表头
        table.getTableHeader().setFont(new Font(null, Font.BOLD, 14));  // 设置表头名称字体样式
        table.getTableHeader().setForeground(Color.RED);                // 设置表头名称字体颜色
        table.getTableHeader().setResizingAllowed(false);               // 设置不允许手动改变列宽
        table.getTableHeader().setReorderingAllowed(false);             // 设置不允许拖动重新排序各列

        // 设置行高
        table.setRowHeight(30);

        // 第一列列宽设置为40
        table.getColumnModel().getColumn(0).setPreferredWidth(70);

        // 设置滚动面板视口大小（超过该大小的行数据，需要拖动滚动条才能看到）
        table.setPreferredScrollableViewportSize(new Dimension(600, 200));

        // 把 表格 放到 滚动面板 中（表头将自动添加到滚动面板顶部）
        JScrollPane scrollPane = new JScrollPane(table);

        Table.setForeground(Color.BLACK);                   // 字体颜色
        Table.setFont(new Font(null, Font.PLAIN, 14));      // 字体样式
        Table.setSelectionForeground(Color.DARK_GRAY);      // 选中后字体颜色
        Table.setSelectionBackground(Color.LIGHT_GRAY);     // 选中后字体背景
        Table.setGridColor(Color.GRAY);                     // 网格颜色

        // 设置表头
        Table.getTableHeader().setFont(new Font(null, Font.BOLD, 14));  // 设置表头名称字体样式
        Table.getTableHeader().setForeground(Color.RED);                // 设置表头名称字体颜色
        Table.getTableHeader().setResizingAllowed(false);               // 设置不允许手动改变列宽
        Table.getTableHeader().setReorderingAllowed(false);             // 设置不允许拖动重新排序各列

        // 设置行高
        Table.setRowHeight(30);

        // 第一列列宽设置为40
        Table.getColumnModel().getColumn(3).setPreferredWidth(120);

        // 设置滚动面板视口大小（超过该大小的行数据，需要拖动滚动条才能看到）
        Table.setPreferredScrollableViewportSize(new Dimension(600, 200));

        // 把 表格 放到 滚动面板 中（表头将自动添加到滚动面板顶部）
        JScrollPane ScrollPane = new JScrollPane(Table);

        // 添加 滚动面板 到 内容面板
        panel.add(BorderLayout.CENTER,scrollPane);
        panel.add(BorderLayout.NORTH,tt1);
        panel1.add(BorderLayout.CENTER,ScrollPane);
        panel1.add(BorderLayout.NORTH,tt2);
        jf.setLayout(new GridLayout(2,1));
        jf.add(panel);
        jf.add(panel1);
        jf.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (button==(JButton)e.getSource()){
            search s=new search();
            jf.setContentPane(s.searchDisplayUser(textField.getText()));

            jf.pack();
        }
    }
}

