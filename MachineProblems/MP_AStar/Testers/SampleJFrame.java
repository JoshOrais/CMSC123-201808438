package MachineProblems.MP_AStar.Testers;

import java.awt.*;
import javax.swing.*;

public class SampleJFrame{
    public SampleJFrame(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setBounds(200, 200, 1250, 750);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.setVisible(true);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        panel1.setBounds(0,0,625,750);
        panel2.setBounds(626,0,625,750);
        panel1.setBackground(Color.green);
        panel2.setBackground(Color.blue);
        panel1.setLayout(null);
        panel2.setLayout(null);        

        JButton button1 = new JButton("Test 1");
        JButton button2 = new JButton("Test 2");
        button1.setBounds(100,100,100,100);
        button2.setBounds(100,100,100,100);

        panel1.add(button1);
        panel2.add(button2);

        frame.getContentPane().add(panel1);
        frame.getContentPane().add(panel2);
    }

    public static void main(String [] args){
        new SampleJFrame();
    }
}