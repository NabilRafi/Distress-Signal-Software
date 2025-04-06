package org.example.views;

import org.example.controllers.HomeController;
import org.example.services.session.UserSession;
import org.example.views.base.Layout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends Layout {

    // Components
    public JButton distressButton;
    public JButton logoutButton;
    private HomeController homeController;

    public Home() {
        super("Home - Distress Signal");
        setLayout(new BorderLayout());

        // Create the navigation bar
        JPanel navBar = new JPanel();
        navBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
        navBar.setBackground(Color.DARK_GRAY);

        // Logout button
        logoutButton = new JButton("Logout");
        logoutButton.setFont(new Font("Arial", Font.PLAIN, 18));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setBackground(Color.RED);
        logoutButton.setFocusPainted(false);
        logoutButton.setOpaque(true);
        logoutButton.setContentAreaFilled(true);
        logoutButton.setBorderPainted(false);
        navBar.add(logoutButton);

        // Add the nav bar to the top
        add(navBar, BorderLayout.NORTH);

        // Center panel for the distress button
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout()); // Center alignment

        // Create the distress button
        distressButton = new JButton("Distress Signal");
        distressButton.setFont(new Font("Arial", Font.BOLD, 30));
        distressButton.setForeground(Color.WHITE);
        distressButton.setBackground(new Color(220, 20, 60)); // Crimson red
        distressButton.setFocusPainted(false);
        distressButton.setPreferredSize(new Dimension(200, 100)); // Fixed size
        distressButton.setOpaque(true);
        distressButton.setContentAreaFilled(true);
        distressButton.setBorderPainted(false);

        // Add the distress button to the center panel
        centerPanel.add(distressButton);

        // Add the center panel to the main layout
        add(centerPanel, BorderLayout.CENTER);

        // Initialize HomeController
        homeController = new HomeController();

        // Add action listeners
        addActionListeners();
    }

    private void addActionListeners() {
        distressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homeController.sendDistress();
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserSession.logOut();
                JOptionPane.showMessageDialog(null, "Logged out successfully!");
                // Navigate back to login screen if needed
            }
        });
    }

    // Main method to test the Home view
    public static void main(String[] args) {
        try {
            // Set Nimbus Look and Feel for consistent button colors across platforms
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            Home home = new Home();
            home.setVisible(true);
        });
    }
}
