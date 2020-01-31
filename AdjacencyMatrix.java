public class AdjacencyMatrix{
    private String[] vertArr = new String[0];
    private int[][] matrix = new int[0][0];

    public void insertVertex(String vert){
        int arrLength = vertArr.length;
        boolean occurenceChecker = false;
        String[] newArr = new String[arrLength+1];
        int[][] newMatrix = new int[arrLength+1][arrLength+1];

        for(int i=0; i<arrLength; i++){
            newArr[i] = vertArr[i];
            if(vertArr[i].equals(vert)){
                occurenceChecker = true;
            }

            for(int j=0; j<arrLength; j++){
                newMatrix[i][j] = matrix[i][j];
            }
        }

        if(occurenceChecker == false){
            newArr[arrLength] = vert;
            vertArr = newArr;
            
            for(int i=0; i<=arrLength; i++){
                newMatrix[arrLength][i] = 0;
                newMatrix[i][arrLength] = 0;
            }
            matrix = newMatrix;
        }
        else{
            System.out.println("Vertex already existing!!!");
        }
    }
    public void removeVertex(String vert){
        int pos = -1;
        int length = vertArr.length;

        for(int i=0; i<length; i++){
            if(vertArr[i].equals(vert)){
                pos = i;
            }
        }

        if(pos == -1){
            System.out.println("Vertex not found!!!");
        }
        else{
           System.out.println("Vertex at: " + pos);
           //WORK ON REMOVE VERTEX 
        }
    }
    public void insertEdge(String vert1, String vert2, int weight){
        int index1 = -1;
        int index2 = -1;

        for(int i=0; i<vertArr.length; i++){
            if(vertArr[i].equals(vert1)){
                index1 = i;
            }
            if(vertArr[i].equals(vert2)){
                index2 = i;
            }
        }

        if(index1 == -1){
            System.out.println("Vertex 1 not found!!!");
        }
        if(index2 == -1){
            System.out.println("Vertex 2 not found!!!");
        }
        else{
            matrix[index1][index2] = weight;
            matrix[index2][index1] = weight;
        }
    }
    public void removeEdge(String vert1, String vert2){
        int index1 = -1;
        int index2 = -1;

        for(int i=0; i<vertArr.length; i++){
            if(vertArr[i].equals(vert1)){
                index1 = i;
            }
            if(vertArr[i].equals(vert2)){
                index2 = i;
            }
        }

        if(index1 == -1){
            System.out.println("Vertex 1 not found!!!");
        }
        if(index2 == -1){
            System.out.println("Vertex 2 not found!!!");
        }
        else{
            matrix[index1][index2] = 0;
            matrix[index2][index1] = 0;
        }
    }

    // public String[] adjVert(String vert){
    //     String[] arr = null;
    //     return arr;
    // }
    // public boolean getAdjacency(String vert1, String vert2){
    //     boolean status = false;
    //     return status;
    // }
    // public boolean getConnectivity(String vert1, String vert2){
    //     boolean connectivity = false;
    //     return connectivity;
    // }

    // public int[] findVertices(String vert1, String vert2){
    //     int[] index = new int[2];
    //     return index;
    // }

    public void depthFirst(String start){
        if(exists(start) == false){
            System.out.println("Vertex does not exist!!!");
        }
        else{
            
        }
    }
    public void breadthFirst(String start){
        if(exists(start) == false){
            System.out.println("Vertex does not exist!!!");
        }
        else{
            
        }
    }

    public boolean exists(String vert){
        return true;
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
                System.out.print("\t" + matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println("");
    }
}