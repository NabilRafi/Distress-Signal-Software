package org.example.views;

import org.example.controllers.SignUpController;
import org.example.services.UserService;
import org.example.views.base.Layout;

import javax.swing.*;
import java.awt.*;

public class Signup extends Layout {

    public JTextField nidText, nameText, phoneText, bloodGroupText, sexText, ageText, emergencyNumbersText, emergencyMailsText;
    public JPasswordField passwordText;
    public JButton registerButton, goToSignInButton;

    private SignUpController signUpController;
    private UserService userService;

    public Signup() {
        super("Sign Up");
        setContentPane(createForm());
        userService = new UserService();
        signUpController = new SignUpController(this, userService);
    }

    private JPanel createForm() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createEmptyBorder(40, 20, 20, 20));

        JLabel titleLabel = new JLabel("Sign Up", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(new Color(34, 193, 195));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.add(titleLabel);
        formPanel.add(Box.createVerticalStrut(30));

        JPanel fieldsPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        fieldsPanel.setOpaque(false);
        addLabelAndField(fieldsPanel, "NID:", nidText = new JTextField(20));
        addLabelAndField(fieldsPanel, "Password:", passwordText = new JPasswordField(20));
        addLabelAndField(fieldsPanel, "Name:", nameText = new JTextField(20));
        addLabelAndField(fieldsPanel, "Phone:", phoneText = new JTextField(20));
        addLabelAndField(fieldsPanel, "Blood Group:", bloodGroupText = new JTextField(20));
        addLabelAndField(fieldsPanel, "Sex:", sexText = new JTextField(20));
        addLabelAndField(fieldsPanel, "Age:", ageText = new JTextField(20));
        addLabelAndField(fieldsPanel, "Emergency Numbers:", emergencyNumbersText = new JTextField(20));
        addLabelAndField(fieldsPanel, "Emergency Emails:", emergencyMailsText = new JTextField(20));

        formPanel.add(fieldsPanel);
        formPanel.add(Box.createVerticalStrut(20));

        registerButton = new JButton("Register");
        styleButton(registerButton, new Color(34, 193, 195));
        formPanel.add(registerButton);
        formPanel.add(Box.createVerticalStrut(10));

        goToSignInButton = new JButton("Already have an account? Go to Sign-In");
        styleButton(goToSignInButton, new Color(200, 200, 200));
        formPanel.add(goToSignInButton);

        JPanel centeredPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centeredPanel.setOpaque(false);
        centeredPanel.add(formPanel);

        return centeredPanel;
    }

    private void addLabelAndField(JPanel panel, String labelText, JTextField textField) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        label.setForeground(new Color(70, 70, 70));

        textField.setFont(new Font("Arial", Font.PLAIN, 16));
        textField.setPreferredSize(new Dimension(250, 35));
        textField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        textField.setBackground(Color.WHITE);
        textField.setCaretColor(new Color(34, 193, 195));

        panel.add(label);
        panel.add(textField);
    }

    private void styleButton(JButton button, Color bgColor) {
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Fix for macOS: ensure background color applies
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setBorderPainted(false);
    }

    public static void main(String[] args) {
        try {
            // Set Nimbus Look and Feel for better cross-platform consistency
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            Signup signUp = new Signup();
            signUp.setVisible(true);
        });
    }
}
