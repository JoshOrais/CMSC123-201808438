package LaboratoryExercise;

public class PriorityQueue{
    private Node head = null;

    public void enqueue(Vertex vertex){
        Node current = new Node(vertex);
        if(head == null){
            head = current;
        }
        else{
            Node node = head;
            Node temp = null;

            while(node.vert.pathLength <= vertex.pathLength){
                if(node.next == null){
                    temp = node;
                    node = null;
                    break;
                }
                else{
                    temp = node;
                    node = node.next;
                }
            }

            if(temp == null){
                temp = head;
                head = current;
                current.next = temp;
            }
            else{
                temp.next = current;
                current.next = node;
            }
        }
    }
    public Vertex dequeue(){
        Vertex dequeued = head.vert;
        head = head.next;
        return dequeued;
    }
    public void display(){
        Node node = head;
        System.out.println();
        while(node != null){
            System.out.print("[" + node.vert.vert + ", " + node.vert.pathLength + "] ");
            node = node.next;
        }
        System.out.println("\n");
    }
    public boolean isEmpty(){
        if(head == null){
            return true;
        }
        else{
            return false;
        }
    }

    class Node{
        Vertex vert = null;
        Node next = null;

        public Node(Vertex vertex){
            vert = vertex;
        }

    }
}