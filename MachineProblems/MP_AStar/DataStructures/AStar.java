package MachineProblems.MP_AStar.DataStructures;


public class AStar{
    private AdjacencyMatrix graph = new AdjacencyMatrix();
    private Vertex[] vertexArray;
    private double[][] matrix;
    private String startName;
    private String endName;

    private String shortestPath = "";
    private double time = 0;

    public AStar(AdjacencyMatrix inputGraph, String startName, String endName){
        graph = inputGraph;
        vertexArray = graph.getVertexArr();
        matrix = graph.getMatrix();
        this.startName = startName;
        this.endName = endName;
        start();
    }

    public void start(){
        for (int i=0; i<vertexArray.length; i++){
            vertexArray[i].g = Double.POSITIVE_INFINITY;
            vertexArray[i].h = getHeuristic(vertexArray[i].name);
            vertexArray[i].f = 0;
            vertexArray[i].prev = null;
        }

        PriorityQueue priorityQueue = new PriorityQueue();
        int startPos = graph.findPosition(startName);
        int endPos = graph.findPosition(endName);
        
        vertexArray[startPos].g = vertexArray[startPos].weight;
        vertexArray[startPos].f = vertexArray[startPos].g + vertexArray[startPos].h;
        priorityQueue.enqueue(vertexArray[startPos]);

        while(!priorityQueue.peek().equals(vertexArray[endPos].name)){
            Vertex dequeuedVertex = priorityQueue.dequeue();
            int dequeuedPos = graph.findPosition(dequeuedVertex.name);
            shortestPath += "[" + dequeuedVertex.name + "] ";

            Vertex[] adjacentVertices = graph.getAdjacentVertices(dequeuedVertex.name);
                for(int i=0; i<adjacentVertices.length; i++){
                    if(adjacentVertices[i].g > (dequeuedVertex.g + matrix[dequeuedPos][i] + adjacentVertices[i].weight)){
                        adjacentVertices[i].g = dequeuedVertex.g + matrix[dequeuedPos][i] + adjacentVertices[i].weight;
                        adjacentVertices[i].f = adjacentVertices[i].g + adjacentVertices[i].h;
                        priorityQueue.enqueue(adjacentVertices[i]);
                    }
                }
        }

        Vertex endVertex = priorityQueue.dequeue();
        time = endVertex.g;
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