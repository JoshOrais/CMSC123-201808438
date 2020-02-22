package LaboratoryExercise;

public class Vertex{
    public String vert;
    public boolean isVisited = false;
    public int pathLength = 0;
    public int inDegree = 0;
    public int inWeight = 0;
    public float weight = 0;

    public Vertex(String str, float num){
        vert = str;
        weight = num;
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