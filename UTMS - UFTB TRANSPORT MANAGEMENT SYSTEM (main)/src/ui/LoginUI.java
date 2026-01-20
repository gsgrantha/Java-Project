package ui;

import java.awt.*;
import javax.swing.*;

public class LoginUI extends JFrame {

    public LoginUI() {
        setTitle("UFTB UTMS LOGIN SYSTEM");

        setSize(550, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridBagLayout());
        getContentPane().setBackground(new Color(245, 245, 245));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 15, 10, 15);

        // Fonts
        Font headingFont = new Font("SansSerif", Font.BOLD, 24);
        Font largeLabelFont = new Font("SansSerif", Font.BOLD, 18);
        Font fieldFont = new Font("SansSerif", Font.PLAIN, 16);
        Font footerFont = new Font("SansSerif", Font.PLAIN, 11);

        // Heading
        JLabel headingLabel = new JLabel("UFTB Transport Management System");
        headingLabel.setFont(headingFont);
        headingLabel.setForeground(new Color(0, 51, 102));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 10, 40, 10);
        add(headingLabel, gbc);

        // Spacer (center content)
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        add(Box.createVerticalGlue(), gbc);

        gbc.weighty = 0;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 15, 10, 15);

        // Fields
        JTextField user = new JTextField(15);
        user.setFont(fieldFont);

        JPasswordField pass = new JPasswordField(15);
        pass.setFont(fieldFont);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setFont(largeLabelFont);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setFont(largeLabelFont);

        JButton login = new JButton("Login");
        login.setFont(new Font("SansSerif", Font.BOLD, 16));
        login.setPreferredSize(new Dimension(120, 40));

        // Username
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(userLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(user, gbc);

        // Password
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(passLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(pass, gbc);

        // Login Button
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(30, 10, 10, 10);
        add(login, gbc);

        // Footer
        String footerText =
                "<html><div style='text-align:right;'>UTMS Created by:<br>" +
                "Grantha, Jim, Rakib, Sajib, Arafat, Nafiz<br>" +
                "Department Of - Data Science And Engineering<br>" +
                "University Of Frontier Technology, Bangladesh</div></html>";

        JLabel footerLabel = new JLabel(footerText);
        footerLabel.setFont(footerFont);
        footerLabel.setForeground(new Color(80, 80, 80));

        gbc.gridx = 1;                  
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.SOUTHEAST;
        gbc.insets = new Insets(20, 10, 10, 20);
        add(footerLabel, gbc);

        // Login logic
        login.addActionListener(e -> {
            if (user.getText().equals("admin") &&
                new String(pass.getPassword()).equals("1234")) {
                new DashboardUI();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid login!");
            }
        });

        setVisible(true);
    }
}
