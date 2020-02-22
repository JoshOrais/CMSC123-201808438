package LaboratoryExercise;

import java.util.ArrayList;

public class DAGFunctions{
    private ArrayList<Vertex> vertices = new ArrayList<Vertex>();
    private AdjacencyMatrix inputGraph = new AdjacencyMatrix();
    
    private ArrayList<String> tSortCollection = new ArrayList<String>();
    private int criticalPos = -1;

    private String[] criticalPathArr;
    private float[] criticalTimeArr;
    private float criticalTime = 0;

    private Vertex vert = new Vertex("", 0);
    private Node root = new Node(vert);
    //
    //
    //
    //
    //
    //----------CONSTRUCTOR----------
    public DAGFunctions(AdjacencyMatrix graph, ArrayList<Vertex> originalVertexList)throws NotDAGException{
        
        //----------initialize content of graph
        inputGraph = graph;

        //----------initialize content of vertices by creating another instance of the original vertex list
        for(int i=0; i<originalVertexList.size(); i++){
            Vertex vertex = new Vertex(originalVertexList.get(i).vert, originalVertexList.get(i).weight);
            vertex.inDegree = originalVertexList.get(i).inDegree;
            vertices.add(vertex);
        }

        //----------initialize content of each vertex's critical path
        criticalPathArr = new String[originalVertexList.size()];
        for(int i=0; i<criticalPathArr.length; i++){
            criticalPathArr[i] = "";
        }

        //----------initialize content of each vertex's critical time
        criticalTimeArr = new float[originalVertexList.size()];
        for(int i=0; i<criticalTimeArr.length; i++){
            criticalTimeArr[i] = 0;
        }

        //----------calls a method to create a tree to check whether the given graph is cyclic or not
        //----------also calls a method to compile all the possible topological sorts
        try{
            createDAGTree(inputGraph, vertices, root);
            traverseTree(root, "");
            // print(root);
        }
        catch(NotDAGException e){
            throw new NotDAGException(e.getMessage());
        }
        
    }
    //
    //
    //
    //
    //
    //----------CREATES A TREE TO CHECK WHETHER A GRAPH IS CYCLIC OR NOT----------
    public void createDAGTree(AdjacencyMatrix graph, ArrayList<Vertex> inputVertexList, Node currentNode)throws NotDAGException{
        ArrayList<Vertex> vertexList = new ArrayList<Vertex>();
        for(int i=0; i<inputVertexList.size(); i++){
            Vertex vertex = new Vertex(inputVertexList.get(i).vert, inputVertexList.get(i).weight);
            vertex.inDegree = inputVertexList.get(i).inDegree;
            vertexList.add(vertex);
        }

        // System.out.println("Recurssion for: " + currentNode.vertex.vert);
        if(!currentNode.vertex.vert.equals("")){
            Vertex removed = null;

            for(int i=0; i<vertexList.size(); i++){
                if(vertexList.get(i).vert.equals(currentNode.vertex.vert)){
                    removed = vertexList.get(i);
                    vertexList.remove(i);
                }
            }

            Vertex[] adjacentToRemoved = graph.getAdjacentVertices(removed.vert);
            ArrayList<Vertex> filteredVertices = new ArrayList<Vertex>();

            for(int i=0; i<adjacentToRemoved.length; i++){
                if(adjacentToRemoved[i].exists(vertexList.toArray(new Vertex[vertexList.size()]))){
                    filteredVertices.add(adjacentToRemoved[i]);
                }
            }

            for(int i=0; i<vertexList.size(); i++){
                if(vertexList.get(i).exists(filteredVertices.toArray(new Vertex[filteredVertices.size()]))){
                    vertexList.get(i).inDegree--;
                }
            }
        }

        ArrayList<Vertex> zeroInDegreeList = new ArrayList<Vertex>();
        for(int i=0; i<vertexList.size(); i++){
            if(vertexList.get(i).inDegree == 0){
                zeroInDegreeList.add(vertexList.get(i));
            }
        }

        if((zeroInDegreeList.size() == 0) && (vertexList.size() > 0)){
            throw new NotDAGException("Input is not a Directed Acyclic Graph!");
        }
        if((zeroInDegreeList.size() > 0) && (vertexList.size() > 0)){
            for(int i=0; i<zeroInDegreeList.size(); i++){
                Node node = new Node(zeroInDegreeList.get(i));
                currentNode.child.add(node);

                createDAGTree(graph, vertexList, node);
            }
        }
        // if((zeroInDegreeList.size() == 0) && (vertexList.size() == 0)){
        //     System.out.println("TREE DONE");
        // }
    }
    //
    //
    //
    //
    //
    //----------TRAVERSES THE TREE TO COMPILE THE COLLECTION OF ALL TOPOLOGICAL SORTS----------
    public void traverseTree(Node node, String path){
        if(node.child.size() == 0){
            tSortCollection.add(path + " ");
        }

        path = path + " ";
        for(int i=0; i<node.child.size(); i++){
            traverseTree(node.child.get(i), (path + node.child.get(i).vertex.vert));
        }
    }
    //
    //
    //
    //
    //
    //----------RETURNS ALL POSSIBLE TOPOLOGICAL SORTS----------
    public String[] getCollection(){
        String[] collection = tSortCollection.toArray(new String[tSortCollection.size()]);
        return collection;
    }
    //
    //
    //
    //
    //
    //----------TRAVERSES THE CRITICAL TIME OF EVERY VERTEX----------
    public void traverseCriticalPath(){
        Queue queue = new Queue();

        //----------creates a new instance if vertex list
        ArrayList<Vertex> vertexList = new ArrayList<Vertex>();
        for(int i=0; i<vertices.size(); i++){
            Vertex vertex = new Vertex(vertices.get(i).vert, vertices.get(i).weight);
            vertex.inDegree = vertices.get(i).inDegree;
            vertexList.add(vertex);
        }

        //----------loop until all vertices are removed
        while(vertexList.size() > 0){

            //----------enqueue all vertex with 0 in-degree
            for(int i=0; i<vertexList.size(); i++){
                if(vertexList.get(i).inDegree == 0){
                    if(!queue.contains(vertexList.get(i))){
                        queue.enqueue(vertexList.get(i));
                    } 
                }
            }

            //----------dequeue
            Vertex dequeued = queue.dequeue();

            //----------increment critical Time of dequeued vertex, update critical path
            int dequeuedPositionOnOriginalSet = dequeued.findPosition(vertices.toArray(new Vertex[vertices.size()]));
            criticalTimeArr[dequeuedPositionOnOriginalSet] = criticalTimeArr[dequeuedPositionOnOriginalSet] + dequeued.weight;
            criticalPathArr[dequeuedPositionOnOriginalSet] = criticalPathArr[dequeuedPositionOnOriginalSet] + " " + dequeued.vert;

            //----------remove the dequeued vertex from the vertex list
            for(int i=0; i<vertexList.size(); i++){
                if(vertexList.get(i).vert.equals(dequeued.vert)){
                    vertexList.remove(i);
                }
            }

            //----------find adjacent vertices of the dequeued vertex through the refrence inputGraph
            Vertex[] tempAdjacentVertices = inputGraph.getAdjacentVertices(dequeued.vert);

            //----------check adjacent vertices if it is still present in the vertex list
            for(int i=0; i<tempAdjacentVertices.length; i++){
                if(tempAdjacentVertices[i].exists(vertexList.toArray(new Vertex[vertexList.size()]))){

                    //----------get the position of the adjacent vertex on the original vertex list and the manipulated vertex list
                    int adjacentPositionOnOriginalSet = tempAdjacentVertices[i].findPosition(vertices.toArray(new Vertex[vertices.size()]));
                    int adjacentPositionOnManipulatedSet = tempAdjacentVertices[i].findPosition(vertexList.toArray(new Vertex[vertexList.size()]));

                    //----------decrement its in-degree
                    vertexList.get(adjacentPositionOnManipulatedSet).inDegree--;

                    //----------update vertex's critical time if its less than 
                    if(criticalTimeArr[adjacentPositionOnOriginalSet] < criticalTimeArr[dequeuedPositionOnOriginalSet]){
                        criticalTimeArr[adjacentPositionOnOriginalSet] = criticalTimeArr[dequeuedPositionOnOriginalSet];
                        criticalPathArr[adjacentPositionOnOriginalSet] = criticalPathArr[dequeuedPositionOnOriginalSet];
                    }
                }
            }
        }
    }
    //
    //
    //
    //
    //
    //----------RETURNS THE CRITICAL TIME----------
    public float getCriticalTime(){
        for(int i=0; i<criticalTimeArr.length; i++){
            if(criticalTimeArr[i] > criticalTime){
                criticalTime = criticalTimeArr[i];
                criticalPos = i;
            }
        }
        return criticalTime;
    }
    //
    //
    //
    //
    //
    //----------RETURNS THE CRITICAL PATH----------
    public String getCriticalPath(){
        return criticalPathArr[criticalPos];
    }










    //----------INTERNAL CLASS, A NODE FOR THE TREE----------
    public class Node{
        Vertex vertex;
        ArrayList<Node> child = new ArrayList<Node>();

        public Node(Vertex vert){
            vertex = vert;
        }
    }

    //----------FOR CHECKING PURPOSES, PRE-ORDER TRAVERSAL OF TREE----------
    public void print(Node node){
        System.out.print("[" + node.vertex.vert + "] ");
        int num = node.child.size();
        for(int i=0; i<num; i++){
            print(node.child.get(i));
        }
    } 
}