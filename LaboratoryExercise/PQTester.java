package LaboratoryExercise;

import java.util.Scanner;

public class PQTester{
    private Scanner scan = new Scanner(System.in);
    private PriorityQueue queue = new PriorityQueue();

    public PQTester(){
        int choice  = -1;

        while(choice != 0){
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.print("\nChoice: ");
            choice = scan.nextInt();

            if(choice == 1){
                System.out.print("Enter Vertex: ");
                String str = scan.next();
                System.out.print("Enter weight: ");
                int num = scan.nextInt();
                Vertex vertex = new Vertex(str);
                vertex.pathLength = num;
                queue.enqueue(vertex);
            }
            if(choice == 2){
                Vertex vertex = queue.dequeue();
                System.out.println("Vertex: " + vertex.vert + "\tWeight: " + vertex.pathLength);
            }

            queue.display();
        }
    }

    public static void main(String [] args){
        new PQTester();
    }
}