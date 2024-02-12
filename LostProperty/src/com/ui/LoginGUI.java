package com.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

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
            // 进行一些验证和处理，如查询数据库，判断是否匹配等
            // 这里省略了具体的实现，您可以根据您的需求进行修改
            // 如果登录成功，就提示用户，并跳转到主页面
            // 如果登录失败，就提示用户，并显示错误信息
            this.dispose();
            new HomePageGUI();
        }
        else if (source == button2) {
            this.dispose();
            new RegisterGUI();
        }
    }
}