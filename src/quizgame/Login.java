package quizgame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {

    JTextField nameField;
    JButton rules, back;

    Login() {
        setLayout(null);
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiztime.jpg"));
        JLabel quizIcon = new JLabel(image1);
        quizIcon.setBounds(0, 0, 600, 500);
        add(quizIcon);

        JLabel heading = new JLabel("Simple Minds");
        heading.setBounds(750, 60, 300, 45);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
        heading.setForeground(Color.BLUE);
        add(heading);

        JLabel name = new JLabel("Enter Your Name");
        name.setBounds(810, 150, 200, 20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
        name.setForeground(Color.BLUE);
        add(name);

        nameField = new JTextField();
        nameField.setBounds(735, 200, 300, 25);
        nameField.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(nameField);

        rules = new JButton("Rules");
        rules.setBounds(735, 270, 120, 30);
        rules.setBackground(Color.BLUE);
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        add(rules);

        back = new JButton("Back");
        back.setBounds(915, 270, 120, 30);
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        getContentPane().setBackground(Color.WHITE);
        setSize(1200, 500);
        setLocation(100, 150);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == rules) {
            setVisible(false);
            String name = nameField.getText();
            new Rules(name).setVisible(true);
        } else if (ae.getSource() == back) {
            setVisible(false);
        }
    }

}
