package Ui;

import Util.DatabaseUtil;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginForm {
	
	 private JPanel loginPanel;
	 private JTextField usernameField;
	 private JPasswordField passwordField;
	 private JButton loginButton;

	    public LoginForm() {
	        loginPanel = new JPanel();
	        loginButton = new JButton("Login");
	        loginButton.addActionListener(e -> {
	            String username = usernameField.getText();
	            char[] passwordChars = passwordField.getPassword();
	            String password = new String(passwordChars);

	            try (Connection connection = DatabaseUtil.getConnection()) {
	                if (isValidCredentials(connection, username, password)) {
	                    JOptionPane.showMessageDialog(null, "Login successful!");
	                    openBakeryApp();
	                } else {
	                    JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
	                }
	            } catch (SQLException ex) {
	                JOptionPane.showMessageDialog(null, "Error connecting to the database: " + ex.getMessage());
	            }
	        });
	    }

	    private boolean isValidCredentials(Connection connection, String username, String password) throws SQLException {
	        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setString(1, username);
	            preparedStatement.setString(2, password);

	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                return resultSet.next(); 
	            }
	        }
	    }

	    private void openBakeryApp() {
	        JFrame frame = new JFrame("Bakery App");
	        frame.setContentPane(new BakeryApp().getBakeryPanel());
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.pack();
	        frame.setVisible(true);
	    }

	    public JPanel getLoginPanel() {
	        return loginPanel;
	    }
	    
	    public static void main(String[] args) {

	        SwingUtilities.invokeLater(() -> {
	            LoginForm loginForm = new LoginForm();
	            JFrame frame = new JFrame("Login Form");
	            frame.setContentPane(loginForm.getLoginPanel());
	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            frame.pack();
	            frame.setVisible(true);
	        });
	    }
}
