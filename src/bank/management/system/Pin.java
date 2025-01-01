package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Pin extends JFrame implements ActionListener {
    
    JPasswordField t1, t2;
    JButton b1, b2;
    JLabel l1, l2, l3;
    String pin;

    Pin(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l4 = new JLabel(i3);
        l4.setBounds(0, 0, 960, 1080);
        add(l4);

        l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setForeground(Color.WHITE);

        l2 = new JLabel("New PIN:");
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setForeground(Color.WHITE);

        l3 = new JLabel("Re-Enter New PIN:");
        l3.setFont(new Font("System", Font.BOLD, 16));
        l3.setForeground(Color.WHITE);

        t1 = new JPasswordField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));
        t1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (t1.getPassword().length >= 4 || !Character.isDigit(e.getKeyChar())) {
                    e.consume();
                }
            }
        });

        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway", Font.BOLD, 25));
        t2.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (t2.getPassword().length >= 4 || !Character.isDigit(e.getKeyChar())) {
                    e.consume();
                }
            }
        });

        b1 = new JButton("CHANGE");
        b2 = new JButton("BACK");

        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(null);

        l1.setBounds(280, 330, 800, 35);
        l4.add(l1);

        l2.setBounds(180, 390, 150, 35);
        l4.add(l2);

        l3.setBounds(180, 440, 200, 35);
        l4.add(l3);

        t1.setBounds(350, 390, 180, 25);
        l4.add(t1);

        t2.setBounds(350, 440, 180, 25);
        l4.add(t2);

        b1.setBounds(390, 588, 150, 35);
        l4.add(b1);

        b2.setBounds(390, 633, 150, 35);
        l4.add(b2);

        setSize(960, 1080);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(500, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String npin = new String(t1.getPassword());
            String rpin = new String(t2.getPassword());

            if (ae.getSource() == b1) {
                // Logic for changing the PIN
                if (npin.length() != 4 || rpin.length() != 4) {
                    JOptionPane.showMessageDialog(null, "PIN must be exactly 4 digits");
                    return;
                }

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }

                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                    return;
                }
                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                    return;
                }

                Conn c1 = new Conn();
                String q1 = "update bank set pin = '" + rpin + "' where pin = '" + pin + "' ";
                String q2 = "update login set pin = '" + rpin + "' where pin = '" + pin + "' ";
                String q3 = "update signup3 set pin = '" + rpin + "' where pin = '" + pin + "' ";

                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);
                c1.s.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);  // Open Transactions with the new PIN

            } else if (ae.getSource() == b2) {
                // Back button logic: Simply go back to the Transactions page without changing the PIN
                dispose();  // Close the Pin frame
                new Transactions(pin).setVisible(true);  // Open Transactions with the original PIN
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Pin("").setVisible(true);
    }
}
