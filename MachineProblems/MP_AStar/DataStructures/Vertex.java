package MachineProblems.MP_AStar.DataStructures;

public class Vertex{
    public String name = "no_name";
    public double weight = 0;
    public double g;
    public double h;
    public double f;
    public Vertex prev = null;

    public Vertex(String vertexName, double vertexWeight){
        name = vertexName;
        weight = vertexWeight;
    }
}