package com.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardFound extends Box {

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
    public CardFound() {
        super(BoxLayout.Y_AXIS);

        JPanel btnPanel = new JPanel();

        JButton credit = new JButton("Credit card");
        JButton school = new JButton("School Card");
        JButton student = new JButton("Student Card");
        JButton transportation = new JButton("Transportation Card");
        JButton bank = new JButton("Bank Card");
        JButton driving = new JButton("Driving Lisence");
        JButton other = new JButton("Other");

        credit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PropertyInformation().init("credit card");
            }
        });

        school.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PropertyInformation().init("school card");
            }
        });

        student.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PropertyInformation().init("student card");
            }
        });

        transportation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PropertyInformation().init("transportation card");
            }
        });

        bank.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PropertyInformation().init("bank card");
            }
        });

        driving.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PropertyInformation().init("driving liscence");
            }
        });

        other.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PropertyInformation().init("other");
            }
        });

        btnPanel.add(credit);
        btnPanel.add(school);
        btnPanel.add(student);
        btnPanel.add(transportation);
        btnPanel.add(bank);
        btnPanel.add(driving);
        btnPanel.add(other);

        this.add(btnPanel);


    }
}
