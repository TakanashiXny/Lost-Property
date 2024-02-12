package com.ui;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class TypeSearch {
    JFrame jFrame = new JFrame("Property");

    final int WIDTH = 500;
    final int HEIGHT = 600;
    final int LEFT = 400;
    final int RIGHT = 400;

    public void init() {
        jFrame.setBounds(LEFT, RIGHT, WIDTH, HEIGHT);

        JPanel jPanel = new JPanel();

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

//        report.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    new PropertyInformation().init();
//                    jFrame.dispose();
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//        });

        jMenu.add(report);
        jMenuBar.add(jMenu);

        // Split Panel
        JSplitPane sp = new JSplitPane();

        sp.setContinuousLayout(true);
        sp.setDividerLocation(150);
        sp.setDividerSize(7);

        // Left
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Type");
        DefaultMutableTreeNode card = new DefaultMutableTreeNode("Card");
        DefaultMutableTreeNode dailyUse = new DefaultMutableTreeNode("Daily Use");
        DefaultMutableTreeNode electronicProducts = new DefaultMutableTreeNode("Electronic Products");
        DefaultMutableTreeNode others = new DefaultMutableTreeNode("Others");

        root.add(card);
        root.add(dailyUse);
        root.add(electronicProducts);
        root.add(others);

        JTree tree = new JTree(root);
        // tree.setSelectionRow(1);
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            // When an item is chosen, somthing will be executed
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                // Get the current node
                Object lastPathComponent = e.getNewLeadSelectionPath().getLastPathComponent();

                if (card.equals(lastPathComponent)) {
                    sp.setRightComponent(new Card());
                    sp.setDividerLocation(150);
                } else if (dailyUse.equals(lastPathComponent)) {
                    sp.setRightComponent(new DailyUse());
                    sp.setDividerLocation(150);
                } else if (electronicProducts.equals(lastPathComponent)) {
                    sp.setRightComponent(new ElectronicProduct());
                    sp.setDividerLocation(150);
                } else if (others.equals(lastPathComponent)) {

                }
            }
        });

        sp.setLeftComponent(tree);

        jFrame.add(sp);
        // Different Panel

        jFrame.setJMenuBar(jMenuBar);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new TypeSearch().init();
    }
}
