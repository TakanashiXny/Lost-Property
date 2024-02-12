package com.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DailyUse extends Box {

    /**
     * Creates a <code>Box</code> that displays its components
     * along the specified axis.
     *
     * @param axis can be {@link BoxLayout#X_AXIS},
     *             {@link BoxLayout#Y_AXIS},
     *             {@link BoxLayout#LINE_AXIS} or
     *             {@link BoxLayout#PAGE_AXIS}.
     * @throws AWTError if the <code>axis</code> is invalid
     * @see #createHorizontalBox
     * @see #createVerticalBox
     */
    public DailyUse() {
        super(BoxLayout.Y_AXIS);

        JPanel btnPanel = new JPanel();

        JButton cup = new JButton("Cup");
        JButton key = new JButton("Key");
        JButton umbrella = new JButton("Umbrella");
        JButton wallet = new JButton("Wallet");
        JButton glasses = new JButton("Glasses");
        JButton money = new JButton("Money");
        JButton watch = new JButton("Watch");
        JButton other = new JButton("other");

        cup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnPanel.add(cup);
        btnPanel.add(key);
        btnPanel.add(umbrella);
        btnPanel.add(wallet);
        btnPanel.add(glasses);
        btnPanel.add(money);
        btnPanel.add(watch);
        btnPanel.add(other);

        this.add(btnPanel);
    }
}
