package DataStructures;

public class AStar{
    private AdjacencyMatrix graph = new AdjacencyMatrix();
    private String start;
    private String end;

    private String shortestPath = "";
    private double time = 0;

    public AStar(AdjacencyMatrix inputGraph, String startName, String endName){
        graph = inputGraph;
        start = startName;
        end = endName;
        start();
    }

    public void start(){
        
    }

    public String getShortestPath(){
        return shortestPath;
    }

    public double getTime(){
        return time;
    }
}