package ui;

import java.awt.*;
import javax.swing.*;
import model.*;
import service.*;

public class AssignTransportUI extends JFrame {

    private JComboBox<String> typeBox, numberBox;
    private JTextField nameField, idField, deptField, pickupField, dropField;

    public AssignTransportUI() {
        setTitle("UTMS-UFTB Assign Transport");
        // Increased size for the "Simply Large" look and header room
        setSize(650, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Main Panel with GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(245, 245, 245));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 30, 30));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 15, 10, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // --- Large Fonts ---
        Font headerFont = new Font("SansSerif", Font.BOLD, 28);
        Font labelFont = new Font("SansSerif", Font.BOLD, 18);
        Font fieldFont = new Font("SansSerif", Font.PLAIN, 16);

        // --- 1. Header Label ---
        JLabel headerLabel = new JLabel("UFTB UTMS(Transport)", SwingConstants.CENTER);
        headerLabel.setFont(headerFont);
        headerLabel.setForeground(new Color(0, 51, 102)); // Dark Blue

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Span across both columns
        gbc.insets = new Insets(10, 10, 40, 10); // Extra space below the header
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(headerLabel, gbc);

        // --- Reset Gridwidth for Rows ---
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 15, 10, 15);

        // --- Initialize Components ---
        typeBox = new JComboBox<>(new String[] { "UFTB Student", "UFTB Teacher" });
        typeBox.setFont(fieldFont);

        nameField = new JTextField(20);
        nameField.setFont(fieldFont);
        idField = new JTextField(20);
        idField.setFont(fieldFont);
        deptField = new JTextField(20);
        deptField.setFont(fieldFont);
        pickupField = new JTextField(20);
        pickupField.setFont(fieldFont);
        dropField = new JTextField(20);
        dropField.setFont(fieldFont);

        numberBox = new JComboBox<>();
        numberBox.setFont(fieldFont);

        JButton saveButton = new JButton("Save Transport");
        saveButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        saveButton.setPreferredSize(new Dimension(200, 50));
        saveButton.setBackground(new Color(0, 51, 102));
        saveButton.setForeground(Color.WHITE);

        // --- Add Form Rows (Row starts at 1 because header is 0) ---
        int row = 1;
        addFormRow(panel, "Type:", typeBox, gbc, row++, labelFont);
        addFormRow(panel, "Name:", nameField, gbc, row++, labelFont);
        addFormRow(panel, "ID:", idField, gbc, row++, labelFont);
        addFormRow(panel, "Department:", deptField, gbc, row++, labelFont);
        addFormRow(panel, "Pickup Location:", pickupField, gbc, row++, labelFont);
        addFormRow(panel, "Drop Location:", dropField, gbc, row++, labelFont);
        addFormRow(panel, "Vehicle Number:", numberBox, gbc, row++, labelFont);

        // --- Save Button (Centered at bottom) ---
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(40, 0, 0, 0);
        panel.add(saveButton, gbc);

        add(panel);

        // Listeners
        updateVehicleNumbers();
        typeBox.addActionListener(e -> updateVehicleNumbers());
        saveButton.addActionListener(e -> saveRecord());

        setVisible(true);
    }

    private void addFormRow(JPanel panel, String labelText, JComponent field, GridBagConstraints gbc, int row,
            Font font) {
        JLabel label = new JLabel(labelText);
        label.setFont(font);

        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx = 0.3;
        gbc.anchor = GridBagConstraints.LINE_END; // Aligns labels to the right
        panel.add(label, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.7;
        gbc.anchor = GridBagConstraints.LINE_START; // Aligns fields to the left
        field.setPreferredSize(new Dimension(300, 40));
        panel.add(field, gbc);
    }

    private void updateVehicleNumbers() {
        numberBox.removeAllItems();
        numberBox.addItem("1");
        numberBox.addItem("2");
    }

    private void saveRecord() {
        String type = (String) typeBox.getSelectedItem();
        String name = nameField.getText().trim();
        String id = idField.getText().trim();
        String dept = deptField.getText().trim();
        String pickup = pickupField.getText().trim();
        String drop = dropField.getText().trim();
        String number = (String) numberBox.getSelectedItem();

        if (name.isEmpty() || id.isEmpty() || dept.isEmpty() || pickup.isEmpty() || drop.isEmpty()) {
            JOptionPane.showMessageDialog(this, " All fields are required!");
            return;
        }

        Person person = type.equals("UFTB Student") ? new Student(name, id, dept) : new Staff(name, id, dept);
        Route route = new Route(pickup, drop);
        Transport transport = TransportService.createTransport(type.equals("UFTB Student") ? "Student" : "Staff",
                number, route);
        Assignment assignment = new Assignment(person, transport);

        RecordService.saveRecord(assignment);
        JOptionPane.showMessageDialog(this, " Record Saved Successfully");

        nameField.setText("");
        idField.setText("");
        deptField.setText("");
        pickupField.setText("");
        dropField.setText("");
    }
}