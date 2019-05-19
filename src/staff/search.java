package staff;

import IOtimer.userDetector;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class search {
    public JPanel searchDisplayUser(String userId){
        String[] columnNames={"name","ID","email","fine","condition","accumulation"};
        String[] ColumnNames={"station","user_ID","borrow","time","scooter_ID"};
        ArrayList<String> al=new ArrayList<String>();
        ArrayList<String> AL=new ArrayList<String>();
        Object[][] obj=new Object[1][6];
        Object[][] OBJ=new Object[1][5];
        JPanel panel = new JPanel();
        userDetector detector=new userDetector();
        try {
            al=detector.getLine(userId,"user_information.txt");
            for (int i=0;i<al.size();i++)
                obj[0][i]=al.get(i);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            AL=detector.getLine(userId,"usage_information.txt");
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
        return panel;
    }
}
