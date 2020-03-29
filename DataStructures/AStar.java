package DataStructures;

public class AStar{
    private AdjacencyMatrix graph = new AdjacencyMatrix();
    private Vertex[] vertexArray;
    private String startName;
    private String endName;

    private String shortestPath = "";
    private double time = 0;

    public AStar(AdjacencyMatrix inputGraph, String startName, String endName){
        graph = inputGraph;
        vertexArray = graph.getVertexArr();
        this.startName = startName;
        this.endName = endName;
        start();
    }

    public void start(){
        //create node
            //name
            //vertex
            //g(n)
            //h(n)
            //prev
        //set the g(n) of all nodes to positive infinity
        //find the h(n) of all nodes

        //enqueue starting vertex
        //while dequeued node.vertex is not endVertex || queue is not empty
        //  get adjacent vertices
        //      for every adjacent vertex
        //          if g(n) of adjacent is greater than the g(n) of current + pathLength
        //              then update g(n)
        //              update f(n)
        //              enqueue

        int vertexNum = graph.getVertexNum();
        Node[] nodeArray = new Node[vertexNum];
        PriorityQueue priorityQueue = new PriorityQueue();

        for(int i=0; i<vertexNum; i++){
            nodeArray[i] = new Node(vertexArray[i]);
            nodeArray[i].g = Double.POSITIVE_INFINITY;
            nodeArray[i].h = getHeuristic(vertexArray[i].name);
            nodeArray[i].f = nodeArray[i].g + nodeArray[i].h;
        }

        int startPos = graph.findPosition(startName); 
        priorityQueue.enqueue(vertexArray[startPos]);

    }

    public double getHeuristic(String vertexName){
        return 1;
    }

    public String getShortestPath(){
        return shortestPath;
    }

    public double getTime(){
        return time;
    }


    class Node{
        String name;
        Vertex vertex;
        double g;
        double h;
        double f;
        Node prev;

        public Node(Vertex vertex){
            this.vertex = vertex;
            name = vertex.name;
        }
    }
}