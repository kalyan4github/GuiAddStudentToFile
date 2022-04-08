package com.techdenovo.japps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DemoGuiAddToFile {
    public DemoGuiAddToFile() {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth= (int)size.getWidth();
        int screeHeight= (int)size.getHeight();
        JFrame frame = new JFrame("Add Student");
        frame.setBounds(screenWidth/3,screeHeight/3,500,400);

        JLabel lblFirstName = new JLabel("First Name");
        JLabel lblLastName = new JLabel("Last Name");
        JLabel lblCollegeName = new JLabel("College Name");
        lblFirstName.setBounds(100,50,150,20);
        lblLastName.setBounds(100,80,150,20);
        lblCollegeName.setBounds(100,110,150,20);

        JTextField txtFirstName =new JTextField();
        JTextField txtLastName =new JTextField();
        JTextField txtCollegeName =new JTextField();
        txtFirstName.setBounds(200,50,150,20);
        txtLastName.setBounds(200,80,150,20);
        txtCollegeName.setBounds(200,110,150,20);

        JButton btnAddStudent= new JButton("ADD STUDENT");
        btnAddStudent.setBounds(100,150,250,30);
        btnAddStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = txtFirstName.getText();
                String lastName = txtLastName.getText();
                String collegeName = txtCollegeName.getText();
                String student = firstName+" "+lastName+" "+collegeName+"\n";
                try {
                    FileWriter fileWriter = new FileWriter("STUDENTDATA.txt",true);

                    BufferedWriter writer = new BufferedWriter(fileWriter);
                    writer.write(student);
                    writer.close();
                    JOptionPane.showMessageDialog(frame,"Successfully Added");
                    txtFirstName.setText("");
                    txtLastName.setText("");
                    txtCollegeName.setText("");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        frame.add(lblFirstName);
        frame.add(lblLastName);
        frame.add(lblCollegeName);

        frame.add(txtFirstName);
        frame.add(txtLastName);
        frame.add(txtCollegeName);

        frame.add(btnAddStudent);

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        DemoGuiAddToFile demoGuiAddToFile = new DemoGuiAddToFile();
    }
}
