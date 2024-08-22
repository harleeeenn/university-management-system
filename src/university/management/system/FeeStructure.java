package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FeeStructure extends JFrame {
    
    FeeStructure() {
        setSize(1000, 700);
        setLocation(250, 50);
        setLayout(null);
        
        getContentPane().setBackground(new Color(238, 238, 238));
        
        JLabel heading = new JLabel("Fee Structure");
        heading.setBounds(50, 10, 400, 40);
        heading.setFont(new Font("Serif", Font.BOLD, 36));
        heading.setForeground(new Color(70, 70, 70));
        add(heading);
        
        JTable table = new JTable();
        table.setFont(new Font("Serif", Font.PLAIN, 16));
        table.setRowHeight(30);
        table.getTableHeader().setFont(new Font("Serif", Font.BOLD, 16));
        table.getTableHeader().setBackground(new Color(52, 152, 219));
        table.getTableHeader().setForeground(Color.WHITE);
        table.setGridColor(new Color(189, 195, 199));
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 60, 1000, 600);
        add(jsp);
        
        JButton back = new JButton("Back");
        back.setBounds(850, 20, 100, 30);
        back.setBackground(new Color(231, 76, 60));
        back.setForeground(Color.WHITE);
        back.setFocusPainted(false);
        back.setFont(new Font("Serif", Font.BOLD, 15));
        back.addActionListener(e -> setVisible(false));
        add(back);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new FeeStructure();
    }
}