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
            System.out.println("\t5. List of vertices adjacent to a given vertex");
            System.out.println("\t6. Adjacency Checker");
            System.out.println("\t7. Connectedness Checker");
            System.out.println("\t8. Breadth-First Traversal");
            System.out.println("\t9. Depth-First Traversal");

            System.out.println("\n\t10. EXIT");

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
                graph.insertEdge(scan.next(), scan.next());
            }
            if(choice == 4){
                System.out.println("Enter 2 Vertices to disconnect: ");
                graph.removeEdge(scan.next(), scan.next());
            }
            if(choice == 5){
                System.out.print("Enter vertex: ");
                graph.adjVert(scan.next());
            }
            if(choice == 6){
                System.out.print("Enter two vertices: ");
                boolean adjacency = graph.getAdjacency(scan.next(), scan.next());
                
                if(adjacency == true){
                    System.out.println("The given vertices are adjacent");
                }
                else{
                    System.out.println("The given vertices are not adjacent");
                }
            }
            if(choice == 7){
                System.out.print("Enter two vertices: ");
                boolean connectivity = graph.getConnectivity(scan.next(), scan.next());
                
                if(connectivity == true){
                    System.out.println("The given vertices are connected");
                }
                else{
                    System.out.println("The given vertices are not connected");
                }
            }
            if(choice == 8){
                System.out.print("Select root: ");
            }
            if(choice == 9){
                System.out.print("Select root: ");
            }
            if(choice == 10){
                break;
            }
            graph.showGraph();
        }
    }

    public static void main (String [] args){
        new Lab02Tester();
    }
}