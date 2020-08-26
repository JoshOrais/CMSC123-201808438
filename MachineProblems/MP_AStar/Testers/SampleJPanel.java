package MachineProblems.MP_AStar.Testers;

import javax.swing.*;
import java.awt.*;

public class SampleJPanel extends JPanel{
    private JButton b =new JButton("CENTER");
    private JTextArea textArea;
    private JScrollPane scrollPane;

    public SampleJPanel(Dimension panelDimension){
        this.setSize(panelDimension);
        this.setLayout(new BorderLayout());
        this.setBackground(Color.green); 
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        textArea = new JTextArea("Sample Text");
        scrollPane = new JScrollPane(textArea);

        this.add(scrollPane, BorderLayout.CENTER); 
    }
}