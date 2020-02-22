package Testers;

import LaboratoryExercise.*;
import java.util.Scanner;

public class Lab03Tester{
    private Scanner scan = new Scanner (System.in);
    private AdjacencyMatrix graph = new AdjacencyMatrix();

    public Lab03Tester(){
        int choice = 0;

        while(true){
            System.out.println("\nMODIFICATIONS");
            System.out.println("\t1. Insert Vertex");
            System.out.println("\t2. Remove Vertex");
            System.out.println("\t3. Insert Edge");
            System.out.println("\t4. Remove Edge");

            System.out.println("\nQUERIES");
            System.out.println("\t5. Get Adjacent Vertices");
            System.out.println("\t6. Depth-First Traversal");
            System.out.println("\t7. Breadth-First Traversal");
            System.out.println("\t8. Get Distance of All Vertices from a given Vertex");

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
                System.out.print("Enter a vertex: ");
                Vertex[] neighborArr = graph.getAdjacentVertices(scan.next());
                for(int i=0; i<neighborArr.length; i++){
                    System.out.print("[" + neighborArr[i].vert +"] ");
                }
                System.out.println();
            }
            if(choice == 6){
                System.out.print("Select root: ");
                graph.depthFirst(scan.next());
            }
            if(choice == 7){
                System.out.print("Select root: ");
                graph.breadthFirst(scan.next());
            }
            if(choice == 8){
                System.out.print("Select source vertex: ");
                String vertex = scan.next();
                int[] distanceArr = graph.getDistanceToAll(vertex);

                System.out.println("\nDISTANCE TO ALL VERTICES FROM VERTEX: " + vertex);
                for(int i=0; i<distanceArr.length; i++){
                    System.out.print("[" + distanceArr[i] + "] ");
                }
            }

            if(choice == 0){
                break;
            }

            //Show Graph
            Vertex[] vertArr = graph.getVertexArr();
            int[][] matrix = graph.getMatrix();

            // System.out.println("\nVERTICES: ");
            // for(int i=0; i<vertArr.length; i++){
            //     System.out.print("[" + vertArr[i].vert + "] ");
            // }
            System.out.println("\n\nMATRIX: ");
            System.out.print("VERT");
            for(int i=0; i<vertArr.length; i++){
                System.out.print("\t" + vertArr[i].vert);
            }
            System.out.println();
            for(int i=0; i<vertArr.length; i++){
                System.out.print(vertArr[i].vert);
                for(int j=0; j<vertArr.length; j++){
                    System.out.print("\t" + matrix[i][j]);
                }
                System.out.println();
            }
            System.out.println("");
        }
    }

    public static void main (String [] args){
        new Lab03Tester();
    }
}