package quizgame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Rules extends JFrame implements ActionListener{
    JButton back, start;
    String name;
    
    Rules(String name) {
        this.name = name;
        setLayout(null);
        
        JLabel heading = new JLabel("Welcome "+ name + " to Simple Minds");
        heading.setBounds(50, 20, 700, 30);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel rules = new JLabel("Welcome "+ name + " to Simple Minds");
        rules.setBounds(20, 90, 700, 350);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rules.setText(
                "<html>" +
                        "1. Each question has only one correct answer.<br><br>" +
                        "2. You have 15 seconds to answer each question.<br><br>" +
                        "3. No negative marking for wrong answers.<br><br>" +
                        "4. The quiz will end automatically after all questions are answered or time runs out.<br><br>" +
                        "5. Your score will be displayed at the end of the quiz.<br><br>" +
                        "6. Make sure to submit your answer before time runs out.<br><br>" +
                        "7. There are no second chances, so think carefully before answering.<br><br>" +
                        "8. Enjoy the quiz and do your best!" +
                        "<html>"
                    );
        add(rules);
        
//      Buttons  
        start = new JButton("start");
        start.setBounds(250, 500, 100, 30);
        start.setBackground(Color.BLUE);
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);

        back = new JButton("Back");
        back.setBounds(400, 500, 100, 30);
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setSize(800, 650);
        setLocation(350, 50);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Rules("User");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == start) {
            setVisible(false);
            new Quiz(name);
        } else {
            setVisible(false);
            new Login();
        }
    }
}
