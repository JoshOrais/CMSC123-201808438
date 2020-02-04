package Testers;

import Graphs.*;
import java.util.Scanner;

public class Lab02Tester{
    private Scanner scan = new Scanner (System.in);
    private AdjMatrix graph = new AdjMatrix();

    public Lab02Tester(){
        int type;
        int choice = 0;

        System.out.println("\nSELECT TYPE OF GRAPH");
        System.out.println("\t1. Unweighted");
        System.out.println("\t2. Weighted");
        System.out.print("\nEnter type of graph: ");
        type = scan.nextInt();

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

            System.out.println("\n\t0. EXIT");

            System.out.print("\nEnter Choice: ");
            choice = scan.nextInt();

            if(choice == 1){
                System.out.print("Enter Vertex to Insert: ");
                graph.insertVertex(scan.next());
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
                    graph.insertEdge(str1, str2, 1);
                }
                else if(type == 2){
                    System.out.println("Enter 2 Vertices to connect: ");
                    System.out.print("\tVertex 1: ");
                    String str1 = scan.next();
                    System.out.print("\tVertex 2: ");
                    String str2 = scan.next();
                    System.out.print("\tWeight: ");
                    int weight = scan.nextInt();
                    graph.insertEdge(str1, str2, weight);
                }
            }
            if(choice == 4){
                System.out.println("Enter 2 Vertices to disconnect: ");
                System.out.print("\tVertex 1: ");
                String str1 = scan.next();
                System.out.print("\tVertex 2: ");
                String str2 = scan.next();
                graph.removeEdge(str1, str2);
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

            if(choice == 0){
                break;
            }

            //Show Graph
            Vertex[] vertArr = graph.getVertexArr();
            int[][] matrix = graph.getMatrix();

            System.out.println("\nVERTICES: ");
            for(int i=0; i<vertArr.length; i++){
                System.out.print("[" + vertArr[i].vert + "] ");
            }
            System.out.println("\n\nBINARY MATRIX: ");
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
        new Lab02Tester();
    }
}