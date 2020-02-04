package Graphs;

public class Queue{
    Node head = null;

    public void enqueue(Vertex vertex){
        Node current = new Node(vertex);
        
        if(head == null){
            head = current;
        }
        else{
            Node node = head;
            while(node.next != null){
                node = node.next;
            }
            node.next = current;
        }
    }

    // public void enqueue(Vertex vertex){
    //     Node current = new Node(vertex);

    //     if(head == null){
    //         head = current;
    //     }
    //     else{
    //         Node node = head;
    //         while(true){
    //             if(current.vert.pathLength >= node.vert.pathLength){
    //                 node = node.next;
    //             }
    //             if(current.vert.pathLength < node.vert.pathLength){
    //                 Node temp = node;
    //                 node = current;
    //                 node.next = temp;
    //                 break;
    //             }
    //             if(node.next == null){
    //                 node.next = current;
    //                 break;
    //             }
    //         }
    //     }
    // }

    public Vertex dequeue(){
        Vertex poppedVert = head.vert;
        head = head.next;
        return poppedVert;
    }

    public void display(){
        Node node = head;
        while(node != null){
            System.out.print("[" + node.vert.vert + "] ");
            node = node.next;
        }
        System.out.println();
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