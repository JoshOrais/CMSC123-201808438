package MachineProblems.MP_AStar.Panels;

import javax.swing.*;
import java.awt.*;

public class TablePanel extends JPanel{
    private String[][] content = {};
    private String[] header = {"Vertex", "G(n)", "H(n)", "F(n)", "Prev"};
    private JTable table = new JTable(content, header);
    private JScrollPane scrollPane = new JScrollPane(table);
    private int m = 10;

    public TablePanel(Dimension panelDimension){
        this.setSize(panelDimension);
        this.setBorder(BorderFactory.createEmptyBorder(m,m,m,m));
        this.setLayout(new BorderLayout());

        this.add(scrollPane, BorderLayout.CENTER);
    }

    public void updatePanel(String update, int x, int y){

    }

    public void clearContent(){
        String[][] temp = {};
        content = temp;
    }
}