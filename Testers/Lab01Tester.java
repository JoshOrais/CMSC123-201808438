package Testers;

import LaboratoryExercise.*;
import java.util.Scanner;

public class Lab01Tester{
    private Scanner scan = new Scanner (System.in);
    private AdjacencyMatrix graph = new AdjacencyMatrix();
    // private AdjacencyList list = new AdjacencyList();
    private BinaryRelationList naive = new BinaryRelationList();

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

            System.out.println("\n\t0. EXIT");

            System.out.print("\nEnter Choice: ");
            choice = scan.nextInt();

            if(choice == 1){
                System.out.print("Enter Vertex to Insert: ");
                String name = scan.next();
                graph.insertVertex(name, 1);
                // list.insertVertex(input);
                naive.insertVertex(name);
            }
            if(choice == 2){
                System.out.print("Enter Vertex to Remove: ");
                String input = scan.next();
                graph.removeVertex(input);
                // list.removeVertex(input);
                naive.removeVertex(input);
            }
            if(choice == 3){
                System.out.println("Enter 2 Vertices to connect: ");
                System.out.print("\tVertex 1: ");
                String str1 = scan.next();
                System.out.print("\tVertex 2: ");
                String str2 = scan.next();
                graph.insertEdge(str1, str2, 1, false);
                // list.insertEdge(str1, str2);
                naive.insertEdge(str1, str2);
            }
            if(choice == 4){
                System.out.println("Enter 2 Vertices to disconnect: ");
                System.out.print("\tVertex 1: ");
                String str1 = scan.next();
                System.out.print("\tVertex 2: ");
                String str2 = scan.next();
                graph.removeEdge(str1, str2, false);
                // list.removeEdge(str1, str2);
                naive.removeEdge(str1, str2);
            }
            if(choice == 5){
                System.out.println("Number of Vertices");
                System.out.println("\tAdjacency Matrix:\t" + graph.getVertNum());
                // System.out.println("\tAdjacency List:\t\t" + list.getVertNum());
                System.out.println("\tBinary Relation List:\t" + naive.getVertNum());
            }
            if(choice == 6){
                System.out.println("Number of Edges");
                System.out.println("\tAdjacency Matrix:\t" + graph.getEdgeNum());
                // System.out.println("\tAdjacency List:\t\t" + list.getEdgeNum());
                System.out.println("\tBinary Relation List:\t" + naive.getEdgeNum());
            }
            if(choice == 7){
                System.out.print("Enter a vertex: ");
                String str = scan.next();

                Vertex[] neighborArr1 = graph.getAdjacentVertices(str);
                // Vertex[] neighborArr2 = list.getAdjacentVertices(str);
                Vertex[] neighborArr3 = naive.getAdjacentVertices(str);

                System.out.println("\nVertices Adjacent to Vertex " + str);

                System.out.print("\tAdjacency Matrix:\t");
                for(int i=0; i<neighborArr1.length; i++){
                    System.out.print("[" + neighborArr1[i].vert + "] ");
                }
                System.out.println();

                // System.out.print("\tAdjacency List:\t\t");
                // for(int i=0; i<neighborArr2.length; i++){
                //     System.out.print("[" + neighborArr2[i].vert + "] ");
                // }
                // System.out.println();

                System.out.print("\tBinary Relation List:\t");
                for(int i=0; i<neighborArr3.length; i++){
                    System.out.print("[" + neighborArr3[i].vert + "] ");
                }
                System.out.println();
            }
            if(choice == 8){
                System.out.print("Enter 1st Vertex: ");
                String str1 = scan.next();
                System.out.print("Enter 2nd Vertex: ");
                String str2 = scan.next();

                System.out.println("\nAdjacency");
                System.out.println("\tAdjacency Matrix:\t" + graph.checkIfAdjacent(str1, str2));
                // System.out.println("\tAdjacency List:\t\t" + list.checkIfAdjacent(str1, str2));
                System.out.println("\tBinary Relation List:\t" + naive.checkIfAdjacent(str1, str2));
            }
            if(choice == 9){
                System.out.print("Enter 1st Vertex: ");
                String str1 = scan.next();
                System.out.print("Enter 2nd Vertex: ");
                String str2 = scan.next();

                System.out.println("\nConnectedness");
                System.out.println("\tAdjacency Matrix:\t" + graph.checkIfConnected(str1, str2));
                // System.out.println("\tAdjacency List:\t\t" + list.checkIfConnected(str1, str2));
                System.out.println("\tBinary Relation List:\t" + naive.checkIfConnected(str1, str2));
            }

            if(choice == 0){
                break;
            }

            //Show Graph
            Vertex[] vertArr1 = graph.getVertexArr();
            int[][] matrix = graph.getMatrix();

            // System.out.println("\nVERTICES: ");
            // for(int i=0; i<vertArr.length; i++){
            //     System.out.print("[" + vertArr[i].vert + "] ");
            // }
            System.out.println("\n\nADJACENCY MATRIX");
            System.out.print("Vert");
            for(int i=0; i<vertArr1.length; i++){
                System.out.print("\t" + vertArr1[i].vert);
            }
            System.out.println();
            for(int i=0; i<vertArr1.length; i++){
                System.out.print(vertArr1[i].vert);
                for(int j=0; j<vertArr1.length; j++){
                    System.out.print("\t" + matrix[i][j]);
                }
                System.out.println();
            }
            System.out.println("");

            Vertex[] vertArr2 = naive.getVertArr();
            String[] edgeArr = naive.getEdgeArr();

            System.out.println("\nBINARY RELATION LIST");
            System.out.print("\tVertices: ");
            for(int i=0; i<vertArr2.length; i++){
                System.out.print("[" + vertArr2[i].vert + "] ");
            }
            System.out.print("\n\tEdges: ");
            for(int i=0; i<edgeArr.length; i++){
                System.out.print("[" + edgeArr[i] + "] ");
            }
            System.out.println();
        }
    }

    public static void main (String [] args){
        new Lab01Tester();
    }
}