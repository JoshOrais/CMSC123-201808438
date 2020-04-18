package MachineProblems.MP_AStar.Panels;

import javax.swing.*;
import java.awt.*;

public class RightPanel extends JPanel{
    private Dimension buttonDimension = new Dimension(150,50);
    private Dimension radioDimension = new Dimension(75,25);

    private JButton start = new JButton("Start"), 
                    results = new JButton("Results"), 
                    exit = new JButton("Exit");
    private JRadioButton    step = new JRadioButton("Step"), 
                            slow = new JRadioButton("Slow"), 
                            fast = new JRadioButton("Fast");
    private ButtonGroup buttonGroup = new ButtonGroup();
    private JComboBox inputSelection;

    public RightPanel(Dimension panelDimension){
        this.setSize(panelDimension);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setLayout(null);
        setComponents();
    }
    
    public void setComponents(){
        start.setBounds(50, 450, buttonDimension.width , buttonDimension.height);
        results.setBounds(50,550, buttonDimension.width , buttonDimension.height);
        exit.setBounds(50,650, buttonDimension.width , buttonDimension.height);

        step.setBounds(10,400, radioDimension.width, radioDimension.height);
        slow.setBounds(85,400, radioDimension.width, radioDimension.height);
        fast.setBounds(160,400, radioDimension.width, radioDimension.height);

        String[] choices = {"Input File","Random"};
        inputSelection = new JComboBox(choices);
        inputSelection.setBounds(50,125,150,50);

        buttonGroup.add(step);
        buttonGroup.add(slow);
        buttonGroup.add(fast);

        this.add(start);
        this.add(results);
        this.add(exit);
        this.add(step);
        this.add(slow);
        this.add(fast);

        this.add(inputSelection);
    }
}