package MachineProblems.MP_AStar.Panels;

import javax.swing.*;
import java.awt.*;

public class TablePanel extends JPanel{
    private String[][] content = {};
    private String[] header = {"Vertex", "G(n)", "H(n)", "F(n)", "Prev"};
    private JTable table;
    private JScrollPane scrollPane;

    public TablePanel(Dimension panelDimension){
        this.setSize(panelDimension);
        this.setLayout(new BorderLayout());
        this.setBackground(Color.green); 
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        table = new JTable(content, header);
        scrollPane = new JScrollPane(table);

        this.add(scrollPane, BorderLayout.CENTER);
    }

    public void updatePanel(String update, int x, int y){

    }

    public void clearContent(){
        String[][] temp = {};
        content = temp;
    }
}