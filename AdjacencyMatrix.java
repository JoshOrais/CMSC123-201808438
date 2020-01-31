public class AdjacencyMatrix{
    private String[] vertArr = new String[0];
    private int[][] connectivityArr = new int[0][0];

    public void insertVertex(String vert){
        String[] newArr = new String[vertArr.length+1];
        for(int i=0; i<vertArr.length; i++){
            newArr[i] = vertArr[i];
        }
        newArr[vertArr.length] = vert;
        vertArr = newArr;
        //check duplication of vertex
    }
    public void removeVertex(String vert){
        String[] newArr = new String[vertArr.length-1];
        int checker = 0;
        
        for(int i=0; i<vertArr.length; i++){
            if(vertArr[i].equals(vert)){
                
            }
        }

    }
    public void insertEdge(String vert1, String vert2){
        
    }
    public void removeEdge(String vert1, String vert2){

    }

    public void adjVert(String vert){

    }
    public boolean getAdjacency(String vert1, String vert2){
        boolean status = false;
        return status;
    }
    public boolean getConnectivity(String vert1, String vert2){
        boolean connectivity = false;
        return connectivity;
    }

    public void showGraph(){
        System.out.println("\nVERTICES: ");
        for(int i=0; i<vertArr.length; i++){
            System.out.print("[" + vertArr[i] + "] ");
        }
        System.out.println("\n\nBINARY MATRIX: ");
        System.out.print("VERT");
        for(int i=0; i<vertArr.length; i++){
            System.out.print("\t" + vertArr[i]);
        }
        System.out.println();
        for(int i=0; i<vertArr.length; i++){
            System.out.print(vertArr[i]);
            for(int j=0; j<vertArr.length; j++){
                System.out.print("\t0");
            }
            System.out.println();
        }
        System.out.println("");
    }
}