package com.ui;

import com.ui.TypeReport;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HomePageGUI extends JFrame implements ActionListener {
    private JLabel label1, label2;
    private JTextField textField1;
    private JButton button1, button2, button3;
    private JPanel panel1, panel2, panel3, panel4;
    private JScrollPane scrollPane1, scrollPane2, scrollPane3;
    private JComboBox<String> comboBox1;
    private ArrayList<DefaultListModel<String>> models;
    public HomePageGUI() {
        super("Home Page");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        label1 = new JLabel("LOST&FOUND", JLabel.CENTER);
        label1.setFont(new Font("Arial", Font.BOLD, 36));
        label2 = new JLabel("Search:", JLabel.RIGHT);
        label2.setFont(new Font("Arial", Font.PLAIN, 18));
        textField1 = new JTextField(20); // 修改了文本区域为文本字段
        textField1.setFont(new Font("Arial", Font.PLAIN, 18));
        button1 = new JButton("Lost Item");
        button1.setFont(new Font("Arial", Font.PLAIN, 18));

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TypeReport().init();
            }
        });

        button2 = new JButton("Found Owner");
        button2.setFont(new Font("Arial", Font.PLAIN, 18));

        button3 = new JButton("Search"); // 添加了一个搜索按钮
        button3.setFont(new Font("Arial", Font.PLAIN, 18));

        models = new ArrayList<>();

        DefaultListModel<String> model1 = new DefaultListModel<>();
        model1.addElement("Item name: credit");
        model1.addElement("Found place: Classroom");
        model1.addElement("Description: It's good");
        model1.addElement("Post Time: 2024-2-1");
        model1.addElement("------------------------------------------------------------------------------------------------------------");
        models.add(model1);

        DefaultListModel<String> model2 = new DefaultListModel<>();
        model2.addElement("Item name: cups");
        model2.addElement("Found place: Playground");
        model2.addElement("Description: It's not good");
        model2.addElement("Post Time : 2024-2-2");
        model2.addElement("------------------------------------------------------------------------------------------------------------");
        models.add(model2);

        DefaultListModel<String> model3 = new DefaultListModel<>();
        model3.addElement("Item name : airpods");
        model3.addElement("Found place : Gym");
        model3.addElement("Description : It will be mine");
        model3.addElement("Post Time : 2024-2-3");
        models.add(model3);

        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        scrollPane1 = new JScrollPane(panel1);
        scrollPane2 = new JScrollPane(textField1);
        comboBox1 = new JComboBox<>(new String[] {"Home", "Report"});

        comboBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource(); // 获取事件源
                String selectedOption = (String)cb.getSelectedItem(); // 获取选中的项
                if (selectedOption.equals("Report")) {
                    new TypeReport().init();
                }
            }
        });

        panel1.setLayout(new GridLayout(4, 1));
        panel1.add(label1);
        panel1.add(comboBox1);
        panel1.add(panel2);
        panel1.add(panel3);
        panel2.add(label2);
        panel2.add(textField1);
        panel2.add(button3);
        panel3.add(button1);
        panel3.add(button2);
        panel4.setLayout(new GridLayout(models.size(), 1));
        // 遍历ArrayList中的每个model，创建相应的JList，并添加到新的面板中
        for (int i = 0; i < models.size(); i++) {
            // 获取第i个model
            DefaultListModel<String> model = models.get(i);
            // 创建一个JList，使用第i个model作为数据源
            JList<String> list = new JList<>(model);
            list.setFont(new Font("Arial", Font.PLAIN, 18));
            // 将JList添加到新的面板中
            panel4.add(list);
        }
        scrollPane3 = new JScrollPane(panel4);

        add(panel1, BorderLayout.NORTH);
        add(scrollPane3, BorderLayout.CENTER);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);

        setVisible(true);
    }

    public static void main(String[] args) {
        new HomePageGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == button1) {
            this.dispose();
        }
        else if (source == button2) {
            this.dispose();
        }
        else if (source == button3) {
            // 添加了搜索按钮的逻辑
            String query = textField1.getText(); // 获取文本字段的内容
            if (query.isEmpty()) { // 如果内容为空，提示用户输入
                JOptionPane.showMessageDialog(this, "Please enter something to search.");
            }
            else {
                // 如果内容不为空，执行搜索操作
                // 这里可以调用自己的搜索方法，或者使用预定义的工具 search_web(query)
                // 例如：
                // String result = search_web(query); // 调用预定义的工具
                // JOptionPane.showMessageDialog(this, result); // 显示搜索结果
            }
        }
    }
}
