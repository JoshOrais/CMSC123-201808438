package MachineProblems.MP_AStar;

// import MachineProblems.MP_AStar.DataStructures.*;
import MachineProblems.MP_AStar.Panels.*;
import java.awt.*;
import javax.swing.*;

public class MainPanel{
    private JFrame frame = new JFrame();
    private Dimension frameDimension = new Dimension(1350, 750);
    private Dimension algoPanelDimension = new Dimension(350, 375);
    private Dimension tablePanelDimension = new Dimension(350, 375);
    private Dimension graphPanelDimension = new Dimension(750, 750);
    private Dimension rightPanelDimension = new Dimension(250, 750);
    private JPanel algoPanel = new AlgoPanel(algoPanelDimension);
    private JPanel tablePanel = new TablePanel(tablePanelDimension);
    private JPanel graphPanel = new GraphPanel(graphPanelDimension);
    private JPanel rightPanel = new RightPanel(rightPanelDimension);

    public MainPanel(){
        init();
    }

    public void init(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setBounds(200, 200, frameDimension.width, frameDimension.height);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.setVisible(true);
        
        algoPanel.setBounds(0, 0, algoPanelDimension.width, algoPanelDimension.height);
        tablePanel.setBounds(0,376, tablePanelDimension.width, tablePanelDimension.height);
        graphPanel.setBounds(351,0, graphPanelDimension.width, graphPanelDimension.height);
        rightPanel.setBounds(1101,0, rightPanelDimension.width, rightPanelDimension.height);

        frame.getContentPane().add(algoPanel);
        frame.getContentPane().add(tablePanel);
        frame.getContentPane().add(graphPanel);
        frame.getContentPane().add(rightPanel);
    }

    public static void main(String [] args){
        new MainPanel();
    }
}