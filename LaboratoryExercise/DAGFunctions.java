package LaboratoryExercise;

import java.util.ArrayList;

public class DAGFunctions{
    private Vertex vertex = new Vertex("");
    private Node root = new Node(vertex);
    private ArrayList<String> tSortCollection = new ArrayList<String>();
    public boolean isDAG = true;

    //----------CONSTRUCTOR----------
    public DAGFunctions(AdjacencyMatrix graph, ArrayList<Vertex> vertexList)throws NotDAGException{
        try{
            createDAGTree(graph, vertexList, root);
            // print(root);
            traverseTree(root, "");
        }
        catch(NotDAGException e){
            throw new NotDAGException(e.getMessage());
        }
    }

    //----------CREATES A TREE TO CHECK WHETHER A GRAPH IS CYCLIC OR NOT----------
    public void createDAGTree(AdjacencyMatrix graph, ArrayList<Vertex> inputVertexList, Node currentNode)throws NotDAGException{
        ArrayList<Vertex> vertexList = new ArrayList<Vertex>();
        for(int i=0; i<inputVertexList.size(); i++){
            Vertex vertex = new Vertex(inputVertexList.get(i).vert);
            vertex.inDegree = inputVertexList.get(i).inDegree;
            vertexList.add(vertex);
        }

        // System.out.println("Recurssion for: " + currentNode.vertex.vert);
        if(!currentNode.vertex.vert.equals("")){
            Vertex removed = new Vertex("");

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
            isDAG = false;
            throw new NotDAGException("Input is not a Directed Acyclic Graph!");
        }
        if((zeroInDegreeList.size() > 0) && (vertexList.size() > 0)){
            for(int i=0; i<zeroInDegreeList.size(); i++){
                Node node = new Node(zeroInDegreeList.get(i));
                currentNode.child.add(node);

                createDAGTree(graph, vertexList, node);
            }
        }
        if((zeroInDegreeList.size() == 0) && (vertexList.size() == 0)){
            // System.out.println("TREE DONE");
        }
    }


    //----------TRAVERSES THE TREE TO COMPILE ALL THE COLLECTION OF TOPOLOGICAL SORTS----------
    public void traverseTree(Node node, String path){
        if(node.child.size() == 0){
            tSortCollection.add(path + " ");
        }

        path = path + " ";
        for(int i=0; i<node.child.size(); i++){
            traverseTree(node.child.get(i), (path + node.child.get(i).vertex.vert));
        }
    }


    //----------RETURNS ALL POSSIBLE TOPOLOGICAL SORTS----------
    public String[] getCollection(){
        String[] collection = tSortCollection.toArray(new String[tSortCollection.size()]);
        return collection;
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