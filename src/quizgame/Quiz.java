package quizgame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Quiz extends JFrame implements ActionListener {

    JLabel question;
    String[][] questions = new String[10][5];
    String[][] answers = new String[10][2];
    String[][] useranswer = new String[10][1];
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupOptions;
    JButton next, life, submit;
    JLabel qno;

    public static int timer = 15;
    public static int ansGiven = 0;
    public static int count = 0;
    public static int score = 0;

    String name;

    Quiz(String name) {
        this.name = name;
        setLayout(null);

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz1.jpg"));
        JLabel quizIcon = new JLabel(image1);
        quizIcon.setBounds(0, 0, 1260, 350);
        add(quizIcon);

        qno = new JLabel();
        qno.setBounds(100, 400, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        question = new JLabel();
        question.setBounds(150, 400, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        // Questions and options
        questions[0][0] = "What does CPU stands for?";
        questions[0][1] = "Central Processing Unit";
        questions[0][2] = "Central Process Unit";
        questions[0][3] = "Computer Personal Unit";
        questions[0][4] = "Central Processor Unit";

        questions[1][0] = "Which of the following is a programming language?";
        questions[1][1] = "Python";
        questions[1][2] = "CSS";
        questions[1][3] = "HTML";
        questions[1][4] = "SQL";

        questions[2][0] = "Which company developed the Java programming language?";
        questions[2][1] = "Sun Microsystems";
        questions[2][2] = "Google";
        questions[2][3] = "Microsoft";
        questions[2][4] = "Apple";

        questions[3][0] = "What does RAM stand for?";
        questions[3][1] = "Random Access Memory";
        questions[3][2] = "Read Access Memory";
        questions[3][3] = "Run Access Memory";
        questions[3][4] = "Random Allocate Memory";

        questions[4][0] = "Which of the following is an example of an operating system?";
        questions[4][1] = "Windows";
        questions[4][2] = "Python";
        questions[4][3] = "Java";
        questions[4][4] = "HTML";

        questions[5][0] = "What is the main function of a web browser?";
        questions[5][1] = "To display web pages";
        questions[5][2] = "To compile code";
        questions[5][3] = "To edit images";
        questions[5][4] = "To manage files";

        questions[6][0] = "What does HTML stand for?";
        questions[6][1] = "HyperText Markup Language";
        questions[6][2] = "HyperTool Markup Language";
        questions[6][3] = "HyperText Module Language";
        questions[6][4] = "HyperText Machine Language";

        questions[7][0] = "Which one is a version control system?";
        questions[7][1] = "Git";
        questions[7][2] = "Python";
        questions[7][3] = "Eclipse";
        questions[7][4] = "IntelliJ";

        questions[8][0] = "What is the main use of SQL?";
        questions[8][1] = "Database management";
        questions[8][2] = "System administration";
        questions[8][3] = "Web development";
        questions[8][4] = "Network security";

        questions[9][0] = "Which of the following is a mobile operating system?";
        questions[9][1] = "Android";
        questions[9][2] = "Windows";
        questions[9][3] = "Linux";
        questions[9][4] = "Unix";

        // Answers
        answers[0][1] = "Central Processing Unit";
        answers[1][1] = "Python";
        answers[2][1] = "Sun Microsystems";
        answers[3][1] = "Random Access Memory";
        answers[4][1] = "Windows";
        answers[5][1] = "To display web pages";
        answers[6][1] = "HyperText Markup Language";
        answers[7][1] = "Git";
        answers[8][1] = "Database management";
        answers[9][1] = "Android";

//      Option Buttons  
        opt1 = new JRadioButton();
        opt1.setBounds(170, 450, 700, 25);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt1.setBackground(Color.WHITE);
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 490, 700, 25);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt2.setBackground(Color.WHITE);
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 530, 700, 25);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt3.setBackground(Color.WHITE);
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 570, 700, 25);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt4.setBackground(Color.WHITE);
        add(opt4);

//      Radio Button Group
        groupOptions = new ButtonGroup();
        groupOptions.add(opt1);
        groupOptions.add(opt2);
        groupOptions.add(opt3);
        groupOptions.add(opt4);

//      Button Group  
        next = new JButton("Next");
        next.setBounds(1000, 420, 150, 40);
        next.setBackground(Color.BLUE);
        next.setFont(new Font("Tahoma", Font.BOLD, 22));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

//      Buttons  
        life = new JButton("Help");
        life.setBounds(1000, 490, 150, 40);
        life.setFont(new Font("Tahoma", Font.BOLD, 22));
        life.setBackground(Color.BLUE);
        life.setForeground(Color.WHITE);
        life.addActionListener(this);
        add(life);

        submit = new JButton("Submit");
        submit.setBounds(1000, 560, 150, 40);
        submit.setBackground(Color.BLUE);
        submit.setFont(new Font("Tahoma", Font.BOLD, 22));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        start(count);

        setBounds(50, 0, 1260, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);

        String time = "Time left " + timer + " seconds";// Set time for 15 seconds
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 20));

        if (timer > 0) {
            g.drawString(time, 1000, 400);
        } else {
            g.drawString("Times up!!", 1000, 400);
        }

        timer--;

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (ansGiven == 1) {
            ansGiven = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) {   //Submit Button 
                if (groupOptions.getSelection() == null) {
                    useranswer[count][0] = "";
                } else {
                    useranswer[count][0] = groupOptions.getSelection().getActionCommand();
                }

                for (int i = 0; i < useranswer.length; i++) {
                    if (useranswer[i][0].equals(answers[i][1])) {
                        score += 10;
                    }
                }
                setVisible(false);
//              Score Class
                    new Score(name, score);

            } else {
                if (groupOptions.getSelection() == null) {
                    useranswer[count][0] = "";
                } else {
                    useranswer[count][0] = groupOptions.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }
        }
    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupOptions.clearSelection();
    }

    public static void main(String[] args) {
        new Quiz("User");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            ansGiven = 1;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            if (groupOptions.getSelection() == null) {
                useranswer[count][0] = "";
            } else {
                useranswer[count][0] = groupOptions.getSelection().getActionCommand();
            }

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);
        } else if (ae.getSource() == life) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            life.setEnabled(false);
        } else { //Submit
            if (groupOptions.getSelection() == null) {
                useranswer[count][0] = "";
            } else {
                useranswer[count][0] = groupOptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswer.length; i++) {
                if (useranswer[i][0].equals(answers[i][1])) {
                    score += 10;
                } 
            }
            setVisible(false);
//              Score Class
            new Score(name, score);
        }
    }

}
