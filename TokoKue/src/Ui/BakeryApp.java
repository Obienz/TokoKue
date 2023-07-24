package Ui;

import javax.swing.*;
import java.awt.*;

public class BakeryApp {
    private JPanel bakeryPanel;
    private JList<String> itemList;
    private JButton refreshButton;
    private JLabel headerLabel;

    public BakeryApp() {

        JFrame frame = new JFrame("Toko Kue App");


        bakeryPanel = new JPanel();

        itemList = new JList<>();
        refreshButton = new JButton("Refresh");
        headerLabel = new JLabel("Bakery Items");

        bakeryPanel.setLayout(new BorderLayout());
        bakeryPanel.add(headerLabel, BorderLayout.NORTH);
        bakeryPanel.add(new JScrollPane(itemList), BorderLayout.CENTER);
        bakeryPanel.add(refreshButton, BorderLayout.SOUTH);

        frame.setContentPane(bakeryPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 300));
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getBakeryPanel() {
        return bakeryPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BakeryApp::new);
    }

}
