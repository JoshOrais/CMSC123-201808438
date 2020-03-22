package Testers;

import DataStructures.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Lab05Tester{
    private Scanner scan = new Scanner (System.in);
    private AdjacencyMatrix graph = new AdjacencyMatrix();

    public Lab05Tester(){
        int choice = 0;

        while(true){
            System.out.println("\nMODIFICATIONS");
            System.out.println("\t1. Insert Vertex");
            System.out.println("\t2. Remove Vertex");
            System.out.println("\t3. Insert Edge");
            System.out.println("\t4. Remove Edge");

            System.out.println("\nQUERIES");
            System.out.println("\t5. Get Critical Path");

            System.out.println("\n\t0. EXIT");

            System.out.print("\nEnter Choice: ");
            choice = scan.nextInt();

            if(choice == 1){
                System.out.print("Enter Vertex to Insert: ");
                String name = scan.next();
                System.out.print("Enter Weight of Vertex: ");
                double weight = scan.nextDouble();
                graph.insertVertex(name, weight);
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
                graph.insertEdge(str1, str2, 1, true);
            }
            if(choice == 4){
                System.out.println("Enter 2 Vertices to disconnect: ");
                System.out.print("\tVertex 1: ");
                String str1 = scan.next();
                System.out.print("\tVertex 2: ");
                String str2 = scan.next();
                graph.removeEdge(str1, str2, true);
            }
            if(choice == 5){
                Vertex[] vertexArr = graph.getVertexArr();
                ArrayList<Vertex> vertexList = new ArrayList<Vertex>();

                for(int i=0; i<vertexArr.length; i++){
                    vertexList.add(vertexArr[i]);
                }

                try{
                    DAGFunctions dagFunctions = new DAGFunctions(graph, vertexList, false);
                    dagFunctions.traverseCriticalPath();

                    System.out.println("\nCRITICAL TIME: " + dagFunctions.getCriticalTime());
                    System.out.println("CRITICAL PATH: " + dagFunctions.getCriticalPath());
                }
                catch(NotDAGException e){
                    System.out.println(e.getMessage());
                }
            }

            if(choice == 0){
                break;
            }

            //----------SHOWS GRAPH: ARRAY OF VERTICES AND CORRESPONDING MATRIX----------

            Vertex[] vertArr = graph.getVertexArr();
            double[][] matrix = graph.getMatrix();

            System.out.println("\nVERTICES: ");
            for(int i=0; i<vertArr.length; i++){
                System.out.print("[" + vertArr[i].name + ":" + vertArr[i].weight + "] ");
            }
            
            System.out.println("\n\nMATRIX: ");
            System.out.print("Vertex");
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
        new Lab05Tester();
    }
}