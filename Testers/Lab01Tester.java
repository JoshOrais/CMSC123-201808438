package Testers;

import DataStructures.*;
import java.util.Scanner;

public class Lab01Tester{
    private Scanner scan = new Scanner (System.in);
    private AdjacencyMatrix graph = new AdjacencyMatrix();
    private GraphReader reader = new GraphReader();

    public Lab01Tester(){
        int choice = 0;

        while(true){
            System.out.println("\nMODIFICATIONS");
            System.out.println("\t1. Insert Vertex");
            System.out.println("\t2. Remove Vertex");
            System.out.println("\t3. Insert Edge");
            System.out.println("\t4. Remove Edge");

            System.out.println("\nQUERIES");
            System.out.println("\t5. Get Number of Vertices");
            System.out.println("\t6. Get Number of Edges");
            System.out.println("\t7. Get Adjacent Vertices");
            System.out.println("\t8. Check Adjacency");
            System.out.println("\t9. Check Connectedness");

            System.out.println("\n\t10. Input Graph");

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
                String input = scan.next();
                graph.removeVertex(input);
            }
            if(choice == 3){
                System.out.println("Enter 2 Vertices to connect: ");
                System.out.print("\tVertex 1: ");
                String str1 = scan.next();
                System.out.print("\tVertex 2: ");
                String str2 = scan.next();
                graph.insertEdge(str1, str2, 1, false);
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
                System.out.println("Number of Vertices: " + graph.getVertNum());
            }
            if(choice == 6){
                System.out.println("Number of Edges: " + graph.getEdgeNum());
            }
            if(choice == 7){
                System.out.print("Enter a vertex: ");
                String vertexName = scan.next();
                Vertex[] neighborArr1 = graph.getAdjacentVertices(vertexName);

                System.out.println("\nVertices Adjacent to Vertex " + vertexName + ":");
                System.out.print("\t");
                for(int i=0; i<neighborArr1.length; i++){
                    System.out.print("[" + neighborArr1[i].name + "] ");
                }
                System.out.println();
            }
            if(choice == 8){
                System.out.print("Enter 1st Vertex: ");
                String str1 = scan.next();
                System.out.print("Enter 2nd Vertex: ");
                String str2 = scan.next();

                System.out.println("\nAdjacency: " + graph.checkIfAdjacent(str1, str2));
            }
            if(choice == 9){
                System.out.print("Enter 1st Vertex: ");
                String str1 = scan.next();
                System.out.print("Enter 2nd Vertex: ");
                String str2 = scan.next();

                System.out.println("\nConnectedness: " + graph.checkIfConnected(str1, str2));
            }
            if(choice == 10){
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
            }

            if(choice == 0){
                break;
            }

            //Show Graph
            Vertex[] vertexArray = graph.getVertexArr();
            double[][] matrix = graph.getMatrix();

            System.out.println("\nVERTICES: ");
            for(int i=0; i<vertexArray.length; i++){
                System.out.print("[" + vertexArray[i].name + "] ");
            }
            System.out.println("\n\nADJACENCY MATRIX");
            System.out.print("Vert");
            for(int i=0; i<vertexArray.length; i++){
                System.out.print("\t" + vertexArray[i].name);
            }
            System.out.println();
            for(int i=0; i<vertexArray.length; i++){
                System.out.print(vertexArray[i].name);
                for(int j=0; j<vertexArray.length; j++){
                    System.out.print("\t" + matrix[i][j]);
                }
                System.out.println();
            }
            System.out.println("");
        }
    }

    public static void main (String [] args){
        new Lab01Tester();
    }
}