package ui;

import java.awt.*;
import javax.swing.*;

public class DashboardUI extends JFrame {

    public DashboardUI() {
        // Window Setup
        setTitle("University Of Frontier Technology, Bangladesh - UTMS Dashboard");
        setSize(600, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layout Setup
        setLayout(new GridBagLayout());
        getContentPane().setBackground(new Color(245, 245, 245)); // Clean light grey background
        GridBagConstraints gbc = new GridBagConstraints();
        
        // --- 1. Main Header Title ---
        JLabel mainHeader = new JLabel("University Of Frontier Technology, Bangladesh", SwingConstants.CENTER);
        mainHeader.setFont(new Font("SansSerif", Font.BOLD, 22));
        mainHeader.setForeground(new Color(0, 51, 102)); // Dark Blue
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 10, 5, 10); // Space around top header
        gbc.anchor = GridBagConstraints.CENTER;
        add(mainHeader, gbc);

        // --- 2. Sub Header Title ---
        JLabel subHeader = new JLabel("University Transport Management System", SwingConstants.CENTER);
        subHeader.setFont(new Font("SansSerif", Font.BOLD, 16));
        subHeader.setForeground(new Color(100, 100, 100)); // Grey
        
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 10, 40, 10); // Large gap before buttons start
        add(subHeader, gbc);

        // --- 3. Buttons (Centered & Stacked) ---
        JButton assign = new JButton("Assign Transport");
        JButton view = new JButton("View Records");

        // Styling Buttons for Quality
        Dimension btnSize = new Dimension(220, 45);
        Font btnFont = new Font("SansSerif", Font.BOLD, 14);

        assign.setPreferredSize(btnSize);
        assign.setFont(btnFont);
        
        view.setPreferredSize(btnSize);
        view.setFont(btnFont);

        // Add Assign Transport Button
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 10, 10, 10); // Spacing between buttons
        add(assign, gbc);

        // Add View Records Button (Step Down)
        gbc.gridy = 3;
        add(view, gbc);

        // --- Logic ---
        assign.addActionListener(e -> new AssignTransportUI());
        view.addActionListener(e -> new ViewRecordsUI());

        setVisible(true);
    }
}