package ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import service.RecordService;

public class ViewRecordsUI extends JFrame {

    public ViewRecordsUI() {
        setTitle("UFTB UTMS - View All Records");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Main Panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(245, 245, 245));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Header
        JLabel headerLabel = new JLabel("UFTB UTMS (View Records)", SwingConstants.CENTER);
        headerLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
        headerLabel.setForeground(new Color(0, 51, 102));
        mainPanel.add(headerLabel, BorderLayout.NORTH);

        // Table Setup
        String[] columnNames = { "Passenger Type", "Name", "ID", "Department", "Pickup", "Drop", "Vehicle" };
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);

        table.setRowHeight(35);
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 15));
        mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);

        String rawData = RecordService.loadRecords();
        if (rawData != null && !rawData.isEmpty()) {
            String[] lines = rawData.split("\n");
            for (String line : lines) {
                String[] parts = line.split(",");
                Object[] rowData = new Object[7];

                if (parts.length >= 7) {

                    rowData[0] = parts[0].trim();
                    rowData[1] = parts[1].trim();
                    rowData[2] = parts[2].trim();
                    rowData[3] = parts[3].trim();
                    rowData[4] = parts[4].trim();
                    rowData[5] = parts[5].trim();
                    rowData[6] = parts[6].trim();
                }

                else if (parts.length >= 5) {
                    rowData[0] = parts[3].contains("Staff") ? "Teacher" : "Student";
                    rowData[1] = parts[0].trim();
                    rowData[2] = parts[1].trim();
                    rowData[3] = parts[2].trim();
                    rowData[6] = parts[3].trim();

                    String routeStr = parts[4].trim();
                    if (routeStr.contains("->")) {
                        String[] routeParts = routeStr.split("->");
                        rowData[4] = routeParts[0].trim();
                        rowData[5] = routeParts[1].trim();
                    } else {
                        rowData[4] = routeStr;
                    }
                }
                model.addRow(rowData);
            }
        }

        // Footer Credits
        String footerText = "<html><div style='text-align: right;'>UTMS Created by:<br>" +
                "Grantha, Jim, Rakib, Sajib, Arafat, Nafiz<br>" +
                "Department Of Data Science And Engineering<br>" +
                "University Of Frontier Technology, Bangladesh</div></html>";
        JLabel footerLabel = new JLabel(footerText);
        footerLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        footerLabel.setForeground(new Color(80, 80, 80)); // Light black

        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        footerPanel.setOpaque(false);
        footerPanel.add(footerLabel);

        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }
}