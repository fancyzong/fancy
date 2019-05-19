package staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import IOtimer.userDetector;




public class Display_user implements ActionListener {
    JFrame jf=new JFrame();
    JFrame search=new JFrame();
    JButton button=new JButton("search");
    JTextField textField=new JTextField();
    public Display_user() throws FileNotFoundException {
        ArrayList<String> al=new ArrayList<String>();
        ArrayList<String> AL=new ArrayList<String>();
        JPanel panel = new JPanel();
        JPanel Panel = new JPanel(new GridLayout(1,2));
        Panel.add(textField);
        Panel.add(button);
        button.addActionListener(this);
        search.add(Panel);
        jf.setLocationRelativeTo(null);
        jf.setTitle("User information");
        jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        jf.setVisible(true);
        search.setLocationRelativeTo(null);
        search.setTitle("User information");
        search.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        search.setSize(200,100);
        search.setVisible(true);
        //setSize(200,300);
        String[] columnNames={"name","ID","email","fine","condition","accumulation"};
        String[] ColumnNames={"station","user_ID","borrow","time","scooter_ID"};
        Scanner scanner = new Scanner(new FileInputStream("user_information.txt"));
        while (scanner.hasNext())
            al.add(scanner.next());
        int rows=al.size()/6;
        Object[][] obj=new Object[rows][6];
        for (int i=0;i<rows;i++){
            for (int j=0;j<6;j++)
                obj[i][j]=al.get((i*6)+j);
        }
        scanner = new Scanner(new FileInputStream("usage_information.txt"));
        while (scanner.hasNext())
            AL.add(scanner.next());
        rows=AL.size()/5;
        Object[][] OBJ=new Object[rows][5];
        for (int i=0;i<rows;i++){
            for (int j=0;j<5;j++)
                OBJ[i][j]=AL.get((i*5)+j);
        }
        JTable table = new JTable(obj, columnNames);
        JTable Table = new JTable(OBJ, ColumnNames);
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
        Table.setPreferredScrollableViewportSize(new Dimension(400, 200));

        // 把 表格 放到 滚动面板 中（表头将自动添加到滚动面板顶部）
        JScrollPane ScrollPane = new JScrollPane(Table);

        // 添加 滚动面板 到 内容面板
        panel.setLayout(new GridLayout(2,1));
        panel.add(scrollPane);
        panel.add(ScrollPane);
        jf.setContentPane(panel);

        jf.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (button==(JButton)e.getSource()){
            String[] columnNames={"name","ID","email","fine","condition","accumulation"};
            String[] ColumnNames={"station","user_ID","borrow","time","scooter_ID"};
            ArrayList<String> al=new ArrayList<String>();
            ArrayList<String> AL=new ArrayList<String>();
            Object[][] obj=new Object[1][6];
            Object[][] OBJ=new Object[1][5];
            JPanel panel = new JPanel();
            userDetector detector=new userDetector();
            try {
                al=detector.getLine(textField.getText(),"user_information.txt");
                for (int i=0;i<al.size();i++)
                    obj[0][i]=al.get(i);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                AL=detector.getLine(textField.getText(),"usage_information.txt");
                for (int i=0;i<AL.size();i++)
                    OBJ[0][i]=AL.get(i);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            JTable table = new JTable(obj, columnNames);
            JTable Table = new JTable(OBJ, ColumnNames);
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
            table.getColumnModel().getColumn(0).setPreferredWidth(40);

            // 设置滚动面板视口大小（超过该大小的行数据，需要拖动滚动条才能看到）
            table.setPreferredScrollableViewportSize(new Dimension(400, 200));

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
            Table.getColumnModel().getColumn(0).setPreferredWidth(40);

            // 设置滚动面板视口大小（超过该大小的行数据，需要拖动滚动条才能看到）
            Table.setPreferredScrollableViewportSize(new Dimension(400, 200));

            // 把 表格 放到 滚动面板 中（表头将自动添加到滚动面板顶部）
            JScrollPane ScrollPane = new JScrollPane(Table);

            // 添加 滚动面板 到 内容面板
            panel.setLayout(new GridLayout(2,1));
            panel.add(scrollPane);
            panel.add(ScrollPane);
            jf.setContentPane(panel);

            jf.pack();
        }
    }
}

