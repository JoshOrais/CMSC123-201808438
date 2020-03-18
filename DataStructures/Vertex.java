package DataStructures;

public class Vertex{
    public String name;
    public boolean isVisited = false;
    public int pathLength = 0;
    public int inDegree = 0;
    public float inWeight = 0;
    public float weight = 0;

    public Vertex(String str, float num){
        name = str;
        weight = num;
    }

    public boolean exists(Vertex[] allVertices){
        for(int i=0; i<allVertices.length; i++){
            if(name.equals(allVertices[i].name)){
                return true;
            }
        }
        return false;
    }

    public int findPosition(Vertex[] allVertices){
        int pos=0;
        for(int i=0; i<allVertices.length; i++){
            if(name.equals(allVertices[i].name)){
                pos = i;
            }
        }
        return pos;
    }
}