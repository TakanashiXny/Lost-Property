package com.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ElectronicProduct extends Box {

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
    public ElectronicProduct() {
        super(BoxLayout.Y_AXIS);

        JPanel btnPanel = new JPanel();

        JButton phone = new JButton("Phone");
        JButton udisk = new JButton("U-disk");
        JButton tablet = new JButton("Tablet");
        JButton pen = new JButton("Pen");
        JButton earphone = new JButton("Earphone");
        JButton camera = new JButton("Camera");
        JButton other = new JButton("other");

        phone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnPanel.add(phone);
        btnPanel.add(udisk);
        btnPanel.add(tablet);
        btnPanel.add(pen);
        btnPanel.add(earphone);
        btnPanel.add(camera);
        btnPanel.add(other);

        this.add(btnPanel);
    }
}
