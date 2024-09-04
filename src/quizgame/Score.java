package quizgame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Score extends JFrame implements ActionListener{
    JLabel qno, text, showScore;
    JButton playagain;
    
    Score(String name, int score) {
        setLayout(null);

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.jfif"));
        Image im = image1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon im1 = new ImageIcon(im);
        JLabel quizIcon = new JLabel(im1);
        quizIcon.setBounds(0, 200, 300, 250);
        add(quizIcon);

        qno = new JLabel();
        qno.setBounds(600, 150, 750, 550);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);
        
        text = new JLabel("Thankyou " + name + " for playing this game!");
        text.setBounds(45, 30, 700, 30);
        text.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(text);
        
        showScore = new JLabel("Your Score is: "+ score);
        showScore.setBounds(350, 200, 300, 30);
        showScore.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(showScore);
        
        playagain = new JButton("Play Again");
        playagain.setBounds(380, 270, 120, 40);
        playagain.setBackground(Color.BLUE);
        playagain.setForeground(Color.WHITE);
        playagain.addActionListener(this);
        add(playagain);
        
        setBounds(400, 150, 750, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Score("User", 0);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }

}
