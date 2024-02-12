package com.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PropertyInformation {
    JFrame jFrame = new JFrame("Property");

    final int WIDTH = 500;
    final int HEIGHT = 600;
    final int LEFT = 400;
    final int RIGHT = 400;

    final String path = "LostProperty/src/com/backend/data/Property.txt";

    public void init(String type) {
        jFrame.setBounds(LEFT, RIGHT, WIDTH, HEIGHT);

        JPanel jPanel = new JPanel(new FlowLayout());

        // Add components
        Box allBox = Box.createVerticalBox();

        // Menu Bar
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("Menu");
        JMenuItem report = new JMenuItem("Report");
        JMenu menuHome = new JMenu("Home");
        JMenu menuCategory = new JMenu("Category");
        JMenu menuReport = new JMenu("Report");
        JMenu menuAccount = new JMenu("Account");

        report.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new TypeReport().init();
                    jFrame.dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        jMenu.add(report);
        jMenuBar.add(jMenu);

        // Item Name
        Box nameBox = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel("Item name: ");
        JTextField nameField = new JTextField(20);

        nameBox.add(nameLabel);
        nameBox.add(Box.createHorizontalBox());
        nameBox.add(nameField);

        // Category
//        Box categoryBox = Box.createHorizontalBox();
//        JLabel categoryLabel = new JLabel("Category: ");
//        JTextField categoryField = new JTextField(20);
//
//        categoryBox.add(categoryLabel);
//        categoryBox.add(Box.createHorizontalBox());
//        categoryBox.add(categoryField);

        // Time
        Box timeBox = Box.createHorizontalBox();
        JLabel timeLabel = new JLabel("Time: ");
        JTextField timeField = new JTextField(20);

        timeBox.add(timeLabel);
        timeBox.add(Box.createHorizontalBox());
        timeBox.add(timeField);

        // Location
        Box locationBox = Box.createHorizontalBox();
        JLabel locationLabel = new JLabel("Location: ");
        JTextField locationField = new JTextField(20);

        locationBox.add(locationLabel);
        locationBox.add(Box.createHorizontalBox());
        locationBox.add(locationField);

        // Contact
        Box contactBox = Box.createHorizontalBox();
        JLabel contactLabel = new JLabel("Contact: ");
        JTextField contactField = new JTextField(20);

        contactBox.add(contactLabel);
        contactBox.add(Box.createHorizontalBox());
        contactBox.add(contactField);

        // Description
        Box descriptionBox = Box.createHorizontalBox();
        JLabel descriptionLabel = new JLabel("Desctiption: ");
        JTextField descriptionField = new JTextField(20);
        descriptionField.setPreferredSize(new Dimension(20, 50));

        descriptionBox.add(descriptionLabel);
        descriptionBox.add(Box.createHorizontalBox());
        descriptionBox.add(descriptionField);

        // Confirm
        Box confirmBox = Box.createHorizontalBox();
        JButton lostBtn = new JButton("Lost");
        JButton foundBtn = new JButton("Found");

        lostBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemName = nameField.getText().trim();
                // String category = categoryField.getText().trim();
                String time = timeField.getText().trim();
                String location = locationField.getText().trim();
                String contact = contactField.getText().trim();
                String desctiption = descriptionField.getText().trim();

                String content = "Lost" + type + "," + itemName + "," + time + "," + location + "," + contact + "," + desctiption;
                //TODO
                // Write into the file
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
                    writer.write(content);
                    writer.newLine();
                    writer.close();
                    System.out.println("Success");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                jFrame.dispose();
            }
        });

        foundBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemName = nameField.getText().trim();
                // String category = categoryField.getText().trim();
                String time = timeField.getText().trim();
                String location = locationField.getText().trim();
                String contact = contactField.getText().trim();
                String desctiption = descriptionField.getText().trim();

                String content = "Found" + "," + type + "," + itemName + "," + time + "," + location + "," + contact + "," + desctiption;
                //TODO
                // Write into the file
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
                    writer.write(content);
                    writer.newLine();
                    writer.close();
                    System.out.println("Success");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                jFrame.dispose();
            }
        });

        confirmBox.add(lostBtn);
        confirmBox.add(foundBtn);

        allBox.add(nameBox);
        allBox.add(Box.createHorizontalBox());
        allBox.add(Box.createVerticalStrut(10));

//        allBox.add(categoryBox);
//        allBox.add(Box.createHorizontalBox());
//        allBox.add(Box.createVerticalStrut(10));

        allBox.add(timeBox);
        allBox.add(Box.createHorizontalBox());
        allBox.add(Box.createVerticalStrut(10));


        allBox.add(locationBox);
        allBox.add(Box.createHorizontalBox());
        allBox.add(Box.createVerticalStrut(10));

        allBox.add(contactBox);
        allBox.add(Box.createHorizontalBox());
        allBox.add(Box.createVerticalStrut(10));

        allBox.add(descriptionBox);
        allBox.add(Box.createHorizontalBox());
        allBox.add(Box.createVerticalStrut(10));

        allBox.add(confirmBox);
        allBox.add(Box.createVerticalStrut(10));

        jPanel.add(allBox);

        jFrame.add(jPanel);
        jFrame.setJMenuBar(jMenuBar);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new PropertyInformation().init("credit");
    }

}
