package MachineProblems.MP_AStar.Panels;

import javax.swing.*;
import java.awt.*;

public class RightPanel extends JPanel{
    private JLabel inputTitle = new JLabel("INPUT");
    public JComboBox<String> inputSelection;
    public JRadioButton    step = new JRadioButton("Step"), 
                            slow = new JRadioButton("Slow"), 
                            fast = new JRadioButton("Fast");
    private ButtonGroup buttonGroup = new ButtonGroup();
    public JButton start = new JButton("Start"), 
                    pause = new JButton("Pause"),
                    stop = new JButton("Stop"),
                    results = new JButton("Results"), 
                    exit = new JButton("Exit");

    public RightPanel(Dimension panelDimension){
        this.setSize(panelDimension);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setLayout(null);
        setComponents();
    }
    
    public void setComponents(){
        String[] choices = {"Select File","Random Input"};
        inputSelection = new JComboBox<String>(choices);
        inputSelection.setSelectedIndex(-1);

        inputTitle.setBounds(50,100,100,25);
        inputSelection.setBounds(50,125,150,50);

        step.setBounds(10,400, 75, 25);
        slow.setBounds(85,400, 75, 25);
        fast.setBounds(160,400, 75, 25);

        start.setBounds(40, 450, 80, 50);
        pause.setBounds(130, 450, 80, 50);
        stop.setBounds(40, 510, 170,40);
        results.setBounds(40,575, 170, 50);
        exit.setBounds(40,675, 170, 30);

        buttonGroup.add(step);
        buttonGroup.add(slow);
        buttonGroup.add(fast);

        this.add(inputTitle);
        this.add(inputSelection);
        this.add(step);
        this.add(slow);
        this.add(fast);
        this.add(start);
        this.add(pause);
        this.add(stop);
        this.add(results);
        this.add(exit);        
    }
}