package Testers;

import java.util.Scanner;
import DataStructures.*;

public class AStarTester{
    private Scanner scan = new Scanner(System.in);
    private AdjacencyMatrix graph = new AdjacencyMatrix();
    private GraphReader reader = new GraphReader();
    private AStar aStar;
    private String startVertex;
    private String endVertex;

    public AStarTester(){
        //reading the graph file
        graph = null;
        while(true){
            if(graph == null){
                System.out.print("Enter text File: ");
                String fileName = scan.next();
                graph = reader.read(fileName);   
            }
            else{
                break;
            }
        }

        //ask for starting vertex
        while(true){
            System.out.print("Enter starting vertex: ");
            startVertex = scan.next();

            if(graph.exists(startVertex)){
                break;
            }
            else{
                System.out.println("Vertex not found!");
            }
        } 

        //ask for end vertex
        while(true){
            System.out.print("Enter end vertex: ");
            endVertex = scan.next();

            if(graph.exists(endVertex)){
                break;
            }
            else{
                System.out.println("Vertex not found!");
            }
        }

        //feeding the graph to the AStar algo
        aStar = new AStar(graph, startVertex, endVertex);

        //get shortest path
        String path = aStar.getShortestPath();
        System.out.println("The shirtest path is: " + path);

        //get time taken
        double time = aStar.getTime();
        System.out.println("Time taken of the shortest path: " + time);
    }

    public static void main(String [] args){
        new AStarTester();
    }
}