package HW13;
import javax.swing.*;
import java.awt.*;

public class ChatApp {

    static String user1;
    static String password1;

    static String user2;
    static String password2;

    static int signUpCount = 0;
    static int loginCount = 0;

    static JTextArea chat1;
    static JTextArea chat2;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Sign Up / Login");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2));

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        JButton signUpButton = new JButton("Sign Up");
        JButton loginButton = new JButton("Login");

        JLabel result = new JLabel("");

        frame.add(userLabel);
        frame.add(userField);

        frame.add(passwordLabel);
        frame.add(passwordField);

        frame.add(signUpButton);
        frame.add(loginButton);

        frame.add(result);

        // Sign Up
        signUpButton.addActionListener(e -> {

            String username = userField.getText();
            String password = new String(passwordField.getPassword());

            if (signUpCount == 0) {

                user1 = username;
                password1 = password;

                signUpCount++;

                result.setText("User 1 signed up.");

            } else if (signUpCount == 1) {

                user2 = username;
                password2 = password;

                signUpCount++;

                result.setText("User 2 signed up.");
            }

            userField.setText("");
            passwordField.setText("");
        });


        // Login
        loginButton.addActionListener(e -> {

            String username = userField.getText();
            String password = new String(passwordField.getPassword());

            if (username.equals(user1)
                    && password.equals(password1)) {

                loginCount++;

                result.setText(user1 + " logged in.");

            } else if (username.equals(user2)
                    && password.equals(password2)) {

                loginCount++;

                result.setText(user2 + " logged in.");

            } else {

                result.setText("Incorrect username or password.");
            }

            userField.setText("");
            passwordField.setText("");

            if (loginCount == 2) {

                frame.dispose();

                openChat();
            }
        });

        frame.setVisible(true);
    }


    public static void openChat() {

        // User 1 window
        JFrame frame1 = new JFrame(user1);
        frame1.setSize(400, 300);
        frame1.setLocation(100, 100);

        chat1 = new JTextArea();
        chat1.setEditable(false);

        JTextField message1 = new JTextField();
        JButton send1 = new JButton("Send");

        frame1.add(new JScrollPane(chat1), BorderLayout.CENTER);
        frame1.add(message1, BorderLayout.SOUTH);
        frame1.add(send1, BorderLayout.EAST);


        // User 2 window
        JFrame frame2 = new JFrame(user2);
        frame2.setSize(400, 300);
        frame2.setLocation(550, 100);

        chat2 = new JTextArea();
        chat2.setEditable(false);

        JTextField message2 = new JTextField();
        JButton send2 = new JButton("Send");

        frame2.add(new JScrollPane(chat2), BorderLayout.CENTER);
        frame2.add(message2, BorderLayout.SOUTH);
        frame2.add(send2, BorderLayout.EAST);


        // User 1 sends message
        send1.addActionListener(e -> {

            String message = user1 + ": "
                    + message1.getText() + "\n";

            chat1.append(message);
            chat2.append(message);

            message1.setText("");
        });


        // User 2 sends message
        send2.addActionListener(e -> {

            String message = user2 + ": "
                    + message2.getText() + "\n";

            chat1.append(message);
            chat2.append(message);

            message2.setText("");
        });


        frame1.setVisible(true);
        frame2.setVisible(true);
    }
}