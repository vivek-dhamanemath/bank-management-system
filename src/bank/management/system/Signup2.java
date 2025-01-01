package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import java.sql.*;
import java.util.regex.*;

public class Signup2 extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13;
    JButton b;
    JRadioButton r1, r2, r3, r4;
    JTextField t1, t2;
    JComboBox<String> c1, c2, c3, c4, c5;
    ButtonGroup bgSeniorCitizen, bgExistingAccount;
    String formno;

    Signup2(String formno) {
        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        l1 = new JLabel("Page 2: Additional Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));

        l2 = new JLabel("Religion:");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));

        l3 = new JLabel("Category:");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));

        l4 = new JLabel("Income:");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));

        l5 = new JLabel("Educational");
        l5.setFont(new Font("Raleway", Font.BOLD, 18));

        l11 = new JLabel("Qualification:");
        l11.setFont(new Font("Raleway", Font.BOLD, 18));

        l6 = new JLabel("Occupation:");
        l6.setFont(new Font("Raleway", Font.BOLD, 18));

        l7 = new JLabel("PAN Number:");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));

        l8 = new JLabel("Aadhar Number:");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));

        l9 = new JLabel("Senior Citizen:");
        l9.setFont(new Font("Raleway", Font.BOLD, 18));

        l10 = new JLabel("Existing Account:");
        l10.setFont(new Font("Raleway", Font.BOLD, 18));

        l12 = new JLabel("Form No:");
        l12.setFont(new Font("Raleway", Font.BOLD, 13));

        l13 = new JLabel(formno);
        l13.setFont(new Font("Raleway", Font.BOLD, 13));

        b = new JButton("Next");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));
        ((AbstractDocument) t1.getDocument()).setDocumentFilter(new PANFilter());

        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));
        ((AbstractDocument) t2.getDocument()).setDocumentFilter(new AadharFilter());

        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);

        r2 = new JRadioButton("No");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);

        r3 = new JRadioButton("Yes");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(Color.WHITE);

        r4 = new JRadioButton("No");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(Color.WHITE);

        // Group for Senior Citizen radio buttons
        bgSeniorCitizen = new ButtonGroup();
        bgSeniorCitizen.add(r1);
        bgSeniorCitizen.add(r2);

        // Group for Existing Account radio buttons
        bgExistingAccount = new ButtonGroup();
        bgExistingAccount.add(r3);
        bgExistingAccount.add(r4);

        String religion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        c1 = new JComboBox<>(religion);
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 14));

        String category[] = {"General", "OBC", "SC", "ST", "Other"};
        c2 = new JComboBox<>(category);
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 14));

        String income[] = {"Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000", "Above 10,00,000"};
        c3 = new JComboBox<>(income);
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 14));

        String education[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Others"};
        c4 = new JComboBox<>(education);
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 14));

        String occupation[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"};
        c5 = new JComboBox<>(occupation);
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 14));

        setLayout(null);

        l12.setBounds(700, 10, 60, 30);
        add(l12);

        l13.setBounds(760, 10, 60, 30);
        add(l13);

        l1.setBounds(280, 30, 600, 40);
        add(l1);

        l2.setBounds(100, 120, 100, 30);
        add(l2);

        c1.setBounds(350, 120, 320, 30);
        add(c1);

        l3.setBounds(100, 170, 100, 30);
        add(l3);

        c2.setBounds(350, 170, 320, 30);
        add(c2);

        l4.setBounds(100, 220, 100, 30);
        add(l4);

        c3.setBounds(350, 220, 320, 30);
        add(c3);

        l5.setBounds(100, 270, 150, 30);
        add(l5);

        c4.setBounds(350, 270, 320, 30);
        add(c4);

        l11.setBounds(100, 290, 150, 30);
        add(l11);

        l6.setBounds(100, 340, 150, 30);
        add(l6);

        c5.setBounds(350, 340, 320, 30);
        add(c5);

        l7.setBounds(100, 390, 150, 30);
        add(l7);

        t1.setBounds(350, 390, 320, 30);
        add(t1);

        l8.setBounds(100, 440, 180, 30);
        add(l8);

        t2.setBounds(350, 440, 320, 30);
        add(t2);

        l9.setBounds(100, 490, 150, 30);
        add(l9);

        r1.setBounds(350, 490, 100, 30);
        add(r1);

        r2.setBounds(460, 490, 100, 30);
        add(r2);

        l10.setBounds(100, 540, 180, 30);
        add(l10);

        r3.setBounds(350, 540, 100, 30);
        add(r3);

        r4.setBounds(460, 540, 100, 30);
        add(r4);

        b.setBounds(570, 640, 100, 30);
        add(b);

        b.addActionListener(this);

        // Add a focus listener to provide additional validation on losing focus
        t1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String pan = t1.getText();
                if (!isValidPAN(pan)) {
                    JOptionPane.showMessageDialog(null, "Please follow the standard PAN format: ABCDE1234F.");
                    t1.setText(""); // Clear the text field
                }
            }
        });

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 750);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(500, 120);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
    String religion = (String) c1.getSelectedItem();
    String category = (String) c2.getSelectedItem();
    String income = (String) c3.getSelectedItem();
    String education = (String) c4.getSelectedItem();
    String occupation = (String) c5.getSelectedItem();

    String pan = t1.getText();
    String aadhar = t2.getText();

    String seniorcitizen = "";
    if (r1.isSelected()) {
        seniorcitizen = "Yes";
    } else if (r2.isSelected()) {
        seniorcitizen = "No";
    }

    String eaccount = "";
    if (r3.isSelected()) {
        eaccount = "Yes";
    } else if (r4.isSelected()) {
        eaccount = "No";
    }

    // Validation for Senior Citizen selection
    if (!r1.isSelected() && !r2.isSelected()) {
        JOptionPane.showMessageDialog(null, "Please select whether you are a Senior Citizen or not.");
        return;
    }

    // Validation for Existing Account selection
    if (!r3.isSelected() && !r4.isSelected()) {
        JOptionPane.showMessageDialog(null, "Please select whether you have an Existing Account or not.");
        return;
    }

    // Validation for PAN
    if (!isValidPAN(pan)) {
        JOptionPane.showMessageDialog(null, "Please follow the standard PAN format: ABCDE1234F.");
        return;
    }

    // Validation for Aadhar
    if (!isValidAadhar(aadhar)) {
        JOptionPane.showMessageDialog(null, "Aadhar Number should be exactly 12 numeric digits.");
        return;
    }

    if (aadhar.equals("")) {
        JOptionPane.showMessageDialog(null, "Aadhar Number is Required");
        return;
    }

    try {
        Conn c1 = new Conn();
        String q1 = "insert into signup2 values('" + formno + "','" + religion + "','" + category + "','" + income + "','" + education + "','" + occupation + "','" + pan + "','" + aadhar + "','" + seniorcitizen + "','" + eaccount + "')";
        c1.s.executeUpdate(q1);

        new Signup3(formno).setVisible(true);
        setVisible(false);
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}


    private boolean isValidPAN(String pan) {
        return pan.matches("[A-Z]{5}[0-9]{4}[A-Z]");
    }

    private boolean isValidAadhar(String aadhar) {
        return aadhar.matches("[0-9]{12}");
    }

    public static void main(String[] args) {
        new Signup2("").setVisible(true);
    }
}

// DocumentFilter to enforce PAN format
class PANFilter extends DocumentFilter {
    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (isValidPANInput(fb.getDocument(), offset, string)) {
            super.insertString(fb, offset, string.toUpperCase(), attr);
        } else {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Please follow the standard PAN format: ABCDE1234F.");
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (isValidPANInput(fb.getDocument(), offset, text)) {
            super.replace(fb, offset, length, text.toUpperCase(), attrs);
        } else {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Please follow the standard PAN format: ABCDE1234F.");
        }
    }

    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        super.remove(fb, offset, length);
    }

    private boolean isValidPANInput(Document doc, int offset, String text) {
        try {
            String currentText = doc.getText(0, doc.getLength());
            String newText = new StringBuilder(currentText).insert(offset, text).toString();

            return newText.matches("^[A-Z]{0,5}[0-9]{0,4}[A-Z]?$") && newText.length() <= 10;
        } catch (BadLocationException e) {
            return false;
        }
    }
}

// DocumentFilter to enforce Aadhar number format
class AadharFilter extends DocumentFilter {
    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (isValidAadharInput(fb.getDocument(), offset, string)) {
            super.insertString(fb, offset, string, attr);
        } else {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Aadhar Number should be exactly 12 numeric digits.");
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (isValidAadharInput(fb.getDocument(), offset, text)) {
            super.replace(fb, offset, length, text, attrs);
        } else {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Aadhar Number should be exactly 12 numeric digits.");
        }
    }

    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        super.remove(fb, offset, length);
    }

    private boolean isValidAadharInput(Document doc, int offset, String text) {
        try {
            String currentText = doc.getText(0, doc.getLength());
            String newText = new StringBuilder(currentText).insert(offset, text).toString();

            return newText.matches("[0-9]*") && newText.length() <= 12;
        } catch (BadLocationException e) {
            return false;
        }
    }
}
