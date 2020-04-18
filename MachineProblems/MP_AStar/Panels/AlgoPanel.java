package MachineProblems.MP_AStar.Panels;

import javax.swing.*;
import java.awt.*;

public class AlgoPanel extends JPanel{
    private JTextArea textArea = new JTextArea();
    private JScrollPane scrollPane = new JScrollPane(textArea);
    private int m = 10;
    private String content = "";

    public AlgoPanel(Dimension panelDimension){
        this.setSize(panelDimension);
        this.setBorder(BorderFactory.createEmptyBorder(m,m,m,m));
        this.setLayout(new BorderLayout());

        textArea.setEditable(false);
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