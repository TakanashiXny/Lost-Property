package com.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class LoginGUI extends JFrame implements ActionListener {
    private JLabel label1, label2, label3;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton button1, button2;
    public LoginGUI() {
        super("Log In");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        label1 = new JLabel("LOST&FOUND", JLabel.CENTER);
        label1.setFont(new Font("Arial", Font.BOLD, 24));
        label2 = new JLabel("Welcome!", JLabel.CENTER);
        label2.setFont(new Font("Arial", Font.PLAIN, 18));
        label3 = new JLabel("Username", JLabel.CENTER);
        textField1 = new JTextField(10);
        passwordField1 = new JPasswordField(10);
        button1 = new JButton("Login");
        button2 = new JButton("Create Account");

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();

        panel1.add(label1);
        panel2.add(label2);
        panel3.setLayout(new GridLayout(2, 2));
        panel3.add(label3);
        panel3.add(textField1);
        panel3.add(new JLabel("Password", JLabel.CENTER));
        panel3.add(passwordField1);
        panel4.add(button1);
        panel4.add(button2);

        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);

        button1.addActionListener(this);
        button2.addActionListener(this);

        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == button1) {
            // 获取用户输入的用户名和密码
            String username = textField1.getText();
            String password = new String(passwordField1.getPassword());
            // 检查输入是否为空
            if (username.isEmpty()) {
                System.out.println("Username cannot be empty!");
            }
            if (password.isEmpty()) {
                System.out.println("Password cannot be empty!");
            }
            // 生成usernamelist和passwordlist
            File file = new File("LostProperty/src/com/backend/data/user.txt");
            List<String> usernamelist = new ArrayList<>();
            List<String> passwordlist = new ArrayList<>();
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(",");
                    usernamelist.add(parts[0]);
                    passwordlist.add(parts[1]);
                }
            }
            catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            // 检验用户名是否存在
            if (!usernamelist.contains(username)) {
                System.out.println("Username doesn't exist!");
                JOptionPane.showMessageDialog(this, "Username doesn't exist!");
            }
            // 检验username和password是否匹配
            boolean passwordCorrect = false;
            for (int i = 0; i < usernamelist.size(); i++) {
                if (username.equals(usernamelist.get(i)) && password.equals(passwordlist.get(i))) {
                    passwordCorrect = true;
                    break;
                }
            }
            //feedback
            if (passwordCorrect) {
                System.out.println("Welcome back!");
            } else {
                System.out.println("Password incorrect!");
                JOptionPane.showMessageDialog(this, "Please check your username or password");
            }

            this.dispose();
            new HomePageGUI();
        }
        else if (source == button2) {
            this.dispose();
            new RegisterGUI();
        }
    }
}