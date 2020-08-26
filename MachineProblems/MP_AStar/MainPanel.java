package MachineProblems.MP_AStar;

// import MachineProblems.MP_AStar.DataStructures.*;
import MachineProblems.MP_AStar.Panels.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MainPanel implements ActionListener, Runnable{
    private JFrame frame = new JFrame();
    private Dimension frameDimension = new Dimension(1350, 750);
    private Dimension leftPanelDimension = new Dimension(350, 375);
    private Dimension centerPanelDimension = new Dimension(750, 750);
    private Dimension rightPanelDimension = new Dimension(250, 750);
    private JPanel algoPanel = new AlgoPanel(leftPanelDimension);
    private JPanel tablePanel = new TablePanel(leftPanelDimension);
    private JPanel graphPanel = new GraphPanel(centerPanelDimension);
    private JPanel rightPanel = new RightPanel(rightPanelDimension);

    public MainPanel(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setLayout(null);
        frame.setBounds(200, 200, frameDimension.width, frameDimension.height);
        
        algoPanel.setLocation(0, 0);
        tablePanel.setLocation(0,376);
        graphPanel.setLocation(351,0);
        rightPanel.setLocation(1101,0);

        frame.add(algoPanel);
        frame.add(tablePanel);
        frame.add(graphPanel);
        frame.add(rightPanel);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String action = e.getActionCommand();

        if (action.equals("Start")){
            System.out.println("Start Pressed");
        }
    }

    @Override
    public void run(){

    }
    public static void main(String [] args){
        new MainPanel();
    }
}