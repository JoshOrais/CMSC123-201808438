package Graphs;

public class Stack{
    private Node head = null;

    public void push(Vertex vertex){
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
    public Vertex pop(){
        Vertex vertPopped = null;

        if(head.next == null){
            vertPopped = head.vert;
            head = null;
            return vertPopped;
        }
        else{
            Node node = head;
            Node temp = null;

            while(node.next != null){
                temp = node;
                node = node.next;
            }
            vertPopped = node.vert;
            temp.next = null;
            return vertPopped;
        }
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