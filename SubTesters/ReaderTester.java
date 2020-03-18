package SubTesters;

import DataStructures.*;
import java.util.Scanner;

public class ReaderTester{
    private Scanner scan = new Scanner(System.in);
    private GraphReader reader = new GraphReader();
    private AdjacencyMatrix graph = new AdjacencyMatrix();

    public ReaderTester(){
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

        //Show Graph
        Vertex[] vertArr = graph.getVertexArr();
        float[][] matrix = graph.getMatrix();

        System.out.println("\nVERTICES: ");
        for(int i=0; i<vertArr.length; i++){
            System.out.print("[" + vertArr[i].name + ":" + vertArr[i].weight + "] ");
        }
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

    public static void main(String [] args){
        new ReaderTester();
    }
}