package MachineProblems.MP_AStar.Testers;

import java.awt.*;
import javax.swing.*;

public class SampleJFrame{
    private JFrame frame = new JFrame();
    private Dimension frameDimension = new Dimension(1350, 750);
    private Dimension panelDimension = new Dimension(350, 375);
    private JPanel panel = new SampleJPanel(panelDimension);

    public SampleJFrame(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setLayout(null);
        frame.setBounds(200, 200, frameDimension.width, frameDimension.height);
        
        panel.setLocation(0, 0);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String [] args){
        new SampleJFrame();
    }
}