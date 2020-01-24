import java.util.Scanner;

public class UGraphTester{
    private Scanner scan = new Scanner (System.in);
    private Modifications modify = new Modifications();
    private Queries query = new Queries();

    public UGraphTester(){
        int choice = 0;

        while(choice != 10){
            System.out.println("\nMODIFICATIONS");
            System.out.println("\t1. Insert Vertex");
            System.out.println("\t2. Remove Vertex");
            System.out.println("\t3. Insert Edge");
            System.out.println("\t4. Remove Edge");

            System.out.println("\nQUERIES");
            System.out.println("\t5. Number of Vertices");
            System.out.println("\t6. Number of Edges");
            System.out.println("\t7. List of vertices adjacent to a given vertex");
            System.out.println("\t8. Adjacency Checker");
            System.out.println("\t9. Connectedness Checker");

            System.out.println("\n\t10. EXIT");

            System.out.print("\nEnter Choice: ");
            choice = scan.nextInt();

            switch(choice){
                case 1:
                    System.out.print("Enter Vertex to Insert: ");
                    modify.InsertVertex(scan.nextLine());
                    System.out.println("Vertex Sucessfully Added!");
                case 2:
                    System.out.print("Enter Vertex to Remove: ");
                    modify.RemoveVertex(scan.nextLine());
                    System.out.println("Vertex Sucessfully Removed!");
                case 3:
                    System.out.print("Enter 2 Vertices to connect: ");
                    modify.InsertEdge(scan.nextLine(), scan.nextLine());
                    System.out.println("Edge Sucessfully Inserted!");
                case 4:
                    System.out.print("Enter 2 Vertices to disconnect: ");
                    modify.RemoveEdge(scan.nextLine(), scan.nextLine());
                    System.out.println("Edge Sucessfully Removed!");
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                default:
            }
        }
    }

    public static void main (String [] args){
        new UGraphTester();
    }
}