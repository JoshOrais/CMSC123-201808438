package Graphs;

public class Vertex{
    public String vert;
    public boolean isVisited = false;
    public int pathLength = 0;

    public Vertex(String str){
        vert = str;
    }

    public boolean exists(Vertex[] allVerts){
        for(int i=0; i<allVerts.length; i++){
            if(vert.equals(allVerts[i].vert)){
                return true;
            }
        }
        return false;
    }

    public int findPosition(Vertex[] allVerts){
        int pos=0;
        for(int i=0; i<allVerts.length; i++){
            if(vert.equals(allVerts[i].vert)){
                pos = i;
            }
        }
        return pos;
    }
}