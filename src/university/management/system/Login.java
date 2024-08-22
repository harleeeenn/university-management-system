package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, cancel;
    JTextField tfusername;
    JPasswordField tfpassword;

    Login() {
        getContentPane().setBackground(new Color(245, 245, 245));
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(40, 20, 340, 200);
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1, true));
        add(panel);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(20, 20, 100, 30);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(130, 20, 180, 30);
        tfusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel.add(tfusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(20, 70, 100, 30);
        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(lblpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(130, 70, 180, 30);
        tfpassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel.add(tfpassword);

        login = new JButton("Login");
        login.setBounds(20, 140, 120, 40);
        login.setBackground(new Color(52, 152, 219));
        login.setForeground(Color.WHITE);
        login.setFont(new Font("Tahoma", Font.BOLD, 16));
        login.setFocusPainted(false);
        login.setBorder(BorderFactory.createLineBorder(new Color(52, 152, 219), 1, true));
        login.addActionListener(this);
        panel.add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(160, 140, 120, 40);
        cancel.setBackground(new Color(231, 76, 60));
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 16));
        cancel.setFocusPainted(false);
        cancel.setBorder(BorderFactory.createLineBorder(new Color(231, 76, 60), 1, true));
        cancel.addActionListener(this);
        panel.add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 20, 200, 200);
        add(image);

        setSize(650, 300);
        setLocation(500, 250);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String username = tfusername.getText();
            String password = new String(tfpassword.getPassword());

            String query = "select * from login where username='" + username + "' and password='" + password + "'";

            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    setVisible(false);
                    new Project();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    tfusername.setText("");
                    tfpassword.setText("");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}