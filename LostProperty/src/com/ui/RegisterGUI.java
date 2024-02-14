package com.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;

public class RegisterGUI extends JFrame implements ActionListener {
    private JLabel label1, label2, label3;
    private JTextField textField1;
    private JPasswordField passwordField1, passwordField2;
    private JButton button1, button2;

    public RegisterGUI() {
        super("Register");
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
        passwordField2 = new JPasswordField(10);
        button1 = new JButton("Register");
        button2 = new JButton("Return to login");

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();

        panel1.add(label1);
        panel2.add(label2);
        panel3.setLayout(new GridLayout(3, 2));
        panel3.add(label3);
        panel3.add(textField1);
        panel3.add(new JLabel("Password", JLabel.CENTER));
        panel3.add(passwordField1);
        panel3.add(new JLabel("Confirm Password", JLabel.CENTER));
        panel3.add(passwordField2);
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
        new RegisterGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == button1) {

            String username = textField1.getText();
            String password = new String(passwordField1.getPassword());
            String confirmPassword = new String(passwordField2.getPassword());

            if (username.isEmpty()) {
                System.out.println("Username cannot be empty!");
            }
            if (password.isEmpty()) {
                System.out.println("Password cannot be empty!");
            }
            if (confirmPassword.isEmpty()) {
                System.out.println("Password confirm cannot be empty!");
            }

            File file = new File("LostProperty/src/com/backend/data/user.txt");
            boolean usernameExists = false;
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(",");
                    if (username.equals(parts[0])) {
                        System.out.println("Username exists!");
                        JOptionPane.showMessageDialog(this, "Username Exist!!.");
                        usernameExists = true;
                        break;
                    }
                }
            }
            catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }

            if (usernameExists) {
                return;
            }
            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this, "Password doesn't match");
                return;
            }

            try (FileWriter writer = new FileWriter("LostProperty/src/com/backend/data/user.txt", true)) {

                writer.write(username + "," + password + "\n");
                System.out.println("Successfully registered！");
                JOptionPane.showMessageDialog(this, "Success!!");
            }
            catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            if (source == button2) {
            this.dispose();
            new LoginGUI();
            }
        }

    }
}
