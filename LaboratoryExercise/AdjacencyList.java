package LaboratoryExercise;

public class AdjacencyList{
    Node head = null;

    public void insertVertex(String vert){
        Vertex vertex = new Vertex(vert);
        Node current = new Node(vertex);

        if(head == null){
            head = current;
        }
    }
    public void removeVertex(String vert){

    }
    public void insertEdge(String vert1, String vert2){

    }
    public void removeEdge(String vert1, String vert2){

    }

    public int getVertNum(){
        return 0;
    }
    public int getEdgeNum(){
        return 0;
    }
    public Vertex[] getAdjacentVertices(String str){
        return null;
    }
    public boolean checkIfAdjacent(String vert1, String vert2){
        return false;
    }
    public boolean checkIfConnected(String vert1, String vert2){
        return false;
    }

    class Node{
        Node nodeHead = null;
        Vertex vertex = null;
        Node next = null;

        public Node(Vertex vert){
            vertex = vert;
        }
    }
}