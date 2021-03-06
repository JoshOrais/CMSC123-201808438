package MachineProblems.MP_AStar.Panels;

import javax.swing.*;
import java.awt.*;

public class AlgoPanel extends JPanel{
    private String content = "";
    private JTextArea textArea;
    private JScrollPane scrollPane;

    public AlgoPanel(Dimension panelDimension){
        this.setSize(panelDimension);
        this.setLayout(new BorderLayout());
        this.setBackground(Color.green); 
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        textArea = new JTextArea("Sample Text");
        textArea.setEditable(false);
        scrollPane = new JScrollPane(textArea);

        this.add(scrollPane, BorderLayout.CENTER); 
    }

    public void updatePanel(String update){
        content = content + update;
        textArea.setText(content);
        System.out.println("Algo panel updated successfully!");
    }

    public void clearContent(){
        content = "";
    }

}