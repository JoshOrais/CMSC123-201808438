package SubTesters;

import DataStructures.*;
import java.util.Scanner;

public class PriorityQueueTester{
    private Scanner scan = new Scanner(System.in);
    private PriorityQueue prioQueue = new PriorityQueue();

    public PriorityQueueTester(){
        while(true){
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("0. Exit");
            int choice = scan.nextInt();

            if(choice == 1){
                System.out.print("\nEnter vertex: ");
                String name = scan.next();
                System.out.print("Enter weight: ");
                float weight = scan.nextFloat();
                Vertex vertex = new Vertex(name, weight);
                prioQueue.enqueue(vertex);
            }
            if(choice == 2){
                Vertex vertex = prioQueue.dequeue();
                System.out.println("\nDequeued: " + vertex.name);                
            }
            if(choice == 3){
                prioQueue.display();
            }
            if(choice == 0){
                break;
            }
        }
    }

    public static void main(String [] args){
        new PriorityQueueTester();
    }
}