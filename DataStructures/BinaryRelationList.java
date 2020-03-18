package DataStructures;

import java.util.*;

public class BinaryRelationList{
    private Vertex[] vertArr = new Vertex[0];
    private String[] edgeArr = new String[0];
    private int vertexCount = 0;
    private int edgeCount = 0;

    public void insertVertex(String vertex){
        Vertex current = new Vertex(vertex, 1);
        if(current.exists(vertArr) == true){
            System.out.println("Vertex already exists!!!");
        }
        else{
            vertexCount++;
            Vertex[] tempVert = new Vertex[vertArr.length+1];
            for(int i=0; i<vertArr.length; i++){
                tempVert[i] = vertArr[i];
            }

            tempVert[vertArr.length] = current;
            vertArr = tempVert;
        } 
    }
    public void removeVertex(String vertex){

    }
    public void insertEdge(String vert1, String vert2){
        Vertex vertex1 = new Vertex(vert1, 1);
        Vertex vertex2 = new Vertex(vert2, 1);
        boolean checker = false;

        if(vertex1.exists(vertArr) == false){
            System.out.println("Vertex 1 does not exist!!!");
        }
        if(vertex2.exists(vertArr) == false){
            System.out.println("Vertex 2 does not exist!!!");
        }
        else{
            for(int i=0; i<edgeArr.length; i++){
                if(edgeArr[i].equals(vert1 + ", " + vert2) || edgeArr[i].equals(vert2 + ", " + vert1)){
                    checker = true;
                }
            }

            if(checker == true){
                System.out.println("The edge already exists!!!");
            }
            else{
                edgeCount++;
                String[] tempEdge = new String[edgeArr.length+1];
            
                for(int i=0; i<edgeArr.length; i++){
                    tempEdge[i] = edgeArr[i];
                }

                tempEdge[edgeArr.length] = vert1 + ", " + vert2;
                edgeArr = tempEdge;
            }
        }
    }
    public void removeEdge(String vert1, String vert2){
        Vertex vertex1 = new Vertex(vert1, 1);
        Vertex vertex2 = new Vertex(vert2, 1);
        boolean checker = false;

        if(vertex1.exists(vertArr) == false){
            System.out.println("Vertex 1 does not exist!!!");
        }
        if(vertex2.exists(vertArr) == false){
            System.out.println("Vertex 2 does not exist!!!");
        }
        else{
            int pos = -1;
            for(int i=0; i<edgeArr.length; i++){
                if(edgeArr[i].equals(vert1+", "+vert2) || edgeArr[i].equals(vert2+", "+vert1)){
                    checker = true;
                    pos=i;
                    System.out.println("Position: " + pos + "\ti:" + i);
                }
            }

            if(checker == false){
                System.out.println("The edge does not exist exists!!!");
            }
            else{
                edgeCount--;
                String[] tempEdge = new String[edgeArr.length-1];

            
                for(int i=0; i<edgeArr.length-1; i++){
                    if(i<pos){
                        tempEdge[i] = edgeArr[i];
                    }
                    if(i>pos){
                        tempEdge[i] = edgeArr[i-1];
                    }
                }

                edgeArr = tempEdge;
            }
        }
    }

    public int getVertNum(){
        return vertexCount;
    }
    public int getEdgeNum(){
        return edgeCount;
    }
    public Vertex[] getAdjacentVertices(String str){
        ArrayList<String> adjVert = new ArrayList<String>();

        for(int i=0; i<edgeArr.length; i++){
            
        }
        return null;
    }
    public boolean checkIfAdjacent(String vert1, String vert2){
        return false;
    }
    public boolean checkIfConnected(String vert1, String vert2){
        return false;
    }

    public Vertex[] getVertArr(){
        return vertArr;
    }
    public String[] getEdgeArr(){
        return edgeArr;
    }
}