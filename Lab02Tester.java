import java.util.Scanner;

public class Lab02Tester{
    private Scanner scan = new Scanner (System.in);
    private AdjacencyMatrix graph = new AdjacencyMatrix();

    public Lab02Tester(){
        int choice = 0;

        while(true){
            System.out.println("\nMODIFICATIONS");
            System.out.println("\t1. Insert Vertex");
            System.out.println("\t2. Remove Vertex");
            System.out.println("\t3. Insert Edge");
            System.out.println("\t4. Remove Edge");

            System.out.println("\nQUERIES");
            System.out.println("\t5. Breadth-First Traversal");
            System.out.println("\t6. Depth-First Traversal");

            System.out.println("\n\t7. EXIT");

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
                System.out.println("Enter 2 Vertices to connect: ");
                graph.insertEdge(scan.next(), scan.next(), 1);
            }
            if(choice == 4){
                System.out.println("Enter 2 Vertices to disconnect: ");
                graph.removeEdge(scan.next(), scan.next());
            }
            if(choice == 5){
                System.out.print("Select root: ");
                graph.depthFirst(scan.next());
            }
            if(choice == 6){
                System.out.print("Select root: ");
                graph.breadthFirst(scan.next());
            }
            if(choice == 7){
                break;
            }
            graph.showGraph();
        }
    }

    public static void main (String [] args){
        new Lab02Tester();
    }
}