package Testers;

import DataStructures.*;
import java.util.Scanner;

public class Lab02Tester{
    private Scanner scan = new Scanner (System.in);
    private AdjacencyMatrix graph = new AdjacencyMatrix();
    private GraphFunctions functions = new GraphFunctions();

    public Lab02Tester(){
        int type = 1;
        int choice = 0;

        // System.out.println("\nSELECT TYPE OF GRAPH");
        // System.out.println("\t1. Unweighted");
        // System.out.println("\t2. Weighted");
        // System.out.print("\nEnter type of graph: ");
        // type = scan.nextInt();

        while(true){
            System.out.println("\nMODIFICATIONS");
            System.out.println("\t1. Insert Vertex");
            System.out.println("\t2. Remove Vertex");
            System.out.println("\t3. Insert Edge");
            System.out.println("\t4. Remove Edge");

            System.out.println("\nQUERIES");
            System.out.println("\t5. Depth-First Traversal");
            System.out.println("\t6. Breadth-First Traversal");

            System.out.println("\n\t0. EXIT");

            System.out.print("\nEnter Choice: ");
            choice = scan.nextInt();

            if(choice == 1){
                System.out.print("Enter Vertex to Insert: ");
                String name = scan.next();
                graph.insertVertex(name, 1);
            }
            if(choice == 2){
                System.out.print("Enter Vertex to Remove: ");
                graph.removeVertex(scan.next());
            }
            if(choice == 3){
                if(type == 1){
                    System.out.println("Enter 2 Vertices to connect: ");
                    System.out.print("\tVertex 1: ");
                    String str1 = scan.next();
                    System.out.print("\tVertex 2: ");
                    String str2 = scan.next();
                    graph.insertEdge(str1, str2, 1, false);
                }
                else if(type == 2){
                    System.out.println("Enter 2 Vertices to connect: ");
                    System.out.print("\tVertex 1: ");
                    String str1 = scan.next();
                    System.out.print("\tVertex 2: ");
                    String str2 = scan.next();
                    System.out.print("\tWeight: ");
                    int weight = scan.nextInt();
                    graph.insertEdge(str1, str2, weight, false);
                }
            }
            if(choice == 4){
                System.out.println("Enter 2 Vertices to disconnect: ");
                System.out.print("\tVertex 1: ");
                String str1 = scan.next();
                System.out.print("\tVertex 2: ");
                String str2 = scan.next();
                graph.removeEdge(str1, str2, false);
            }
            if(choice == 5){
                System.out.print("Select root: ");
                String vertexName = scan.next();
                Vertex start = new Vertex(vertexName, 1);
                String[] dfs = functions.dfs(graph, start);
                // String[] dfs = graph.depthFirst(scan.next();

                System.out.println("DEPTH FIRST SEARCH: ");
                for(int i=0; i<dfs.length; i++){
                    System.out.print("[" + dfs[i] + "]");
                }
                System.out.println();
            }
            if(choice == 6){
                System.out.print("Select root: ");
                String vertexName = scan.next();
                Vertex start = new Vertex(vertexName, 1);
                String[] bfs = functions.bfs(graph, start);
                // String[] bfs = graph.breadthFirst(scan.next());

                System.out.println("BREADTH FIRST SEARCH: ");
                for(int i=0; i<bfs.length; i++){
                    System.out.print("[" + bfs[i] + "]");
                }
                System.out.println();
            }

            if(choice == 0){
                break;
            }

            //Show Graph
            Vertex[] vertArr = graph.getVertexArr();
            double[][] matrix = graph.getMatrix();

            // System.out.println("\nVERTICES: ");
            // for(int i=0; i<vertArr.length; i++){
            //     System.out.print("[" + vertArr[i].vert + "] ");
            // }
            System.out.println("\n\nMATRIX: ");
            System.out.print("VERT");
            for(int i=0; i<vertArr.length; i++){
                System.out.print("\t" + vertArr[i].name);
            }
            System.out.println();
            for(int i=0; i<vertArr.length; i++){
                System.out.print(vertArr[i].name);
                for(int j=0; j<vertArr.length; j++){
                    System.out.print("\t" + matrix[i][j]);
                }
                System.out.println();
            }
            System.out.println("");
        }
    }

    public static void main (String [] args){
        new Lab02Tester();
    }
}