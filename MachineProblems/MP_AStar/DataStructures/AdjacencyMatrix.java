package MachineProblems.MP_AStar.DataStructures;


public class AdjacencyMatrix{
    private Vertex[] vertexArray = new Vertex[0];
    private double[][] matrix = new double[0][0];
    private int vertexNum = 0;
    private int edgeNum = 0;

//----------INSERTS A VERTEX, ACCEPTS STRING-----------
    public void insertVertex(String vertexName, double weight){
        int arrLength = vertexArray.length;
        Vertex[] newArr = new Vertex[arrLength+1];
        double[][] newMatrix = new double[arrLength+1][arrLength+1];

        if(exists(vertexName)){
            System.out.println("Vertex already exists!!!");
        }
        else{
            vertexNum++;
            for(int i=0; i<arrLength; i++){
                newArr[i] = vertexArray[i];
                for(int j=0; j<arrLength; j++){
                    newMatrix[i][j] = matrix[i][j];
                }
            }

            Vertex newVert = new Vertex(vertexName, weight);
            newArr[arrLength] = newVert;
            vertexArray = newArr;
            
            for(int i=0; i<=arrLength; i++){
                newMatrix[arrLength][i] = 0;
                newMatrix[i][arrLength] = 0;
            }
            matrix = newMatrix;
        }
    }

//----------REMOVES A VERTEX, ACCEPTS STRING----------
    public void removeVertex(String vertexName){
        int length = vertexArray.length;
        int pos = -1;

        if(!exists(vertexName)){
            System.out.println("The vertex does not exist!!!");
        }
        else{
            vertexNum--;
            for(int i=0; i<length; i++){
                if(vertexArray[i].name.equals(vertexName)){
                    pos = i;
                }
            }

            Vertex[] tempVert = new Vertex[length-1];
            double[][] tempMatrix = new double[length-1][length-1];

            for(int i=0; i<length; i++){
                if(i<pos){
                    tempVert[i] = vertexArray[i];

                    for(int j=0; j<length; j++){
                        if(j<pos){
                            tempMatrix[i][j] = matrix[i][j];
                        }
                        if(j>pos){
                            tempMatrix[i][j-1] = matrix[i][j];
                        }
                    }
                }
                if(i>pos){
                    tempVert[i-1] = vertexArray[i];

                    for(int j=0; j<length; j++){
                        if(j<pos){
                            tempMatrix[i-1][j] = matrix[i][j];
                        }
                        if(j>pos){
                            tempMatrix[i-1][j-1] = matrix[i][j];
                        }
                    }
                }
            }

            vertexArray = tempVert;
            matrix = tempMatrix;
        }
    }

//----------INSERTS AN EDGE, ACCEPTS TWO STRINGS, A WEIGHT, AND A BOOLEAN TO KNOW IF DIRECTED OR NOT----------
    public void insertEdge(String vertexName1, String vertexName2, double weight, boolean directed){
        int index1 = -1;
        int index2 = -1;

        if(!exists(vertexName1)){
            System.out.println("Vertex 1 does not exist!!!");
        }
        if(!exists(vertexName2)){
            System.out.println("Vertex 2 does not exist!!!");
        }
        else{
            for(int i=0; i<vertexArray.length; i++){
                if(vertexArray[i].name.equals(vertexName1)){
                    index1 = i;
                }
                if(vertexArray[i].name.equals(vertexName2)){
                    index2 = i;
                }
            }

            if(matrix[index1][index2] > 0){
                System.out.println("The vertices are already connected!!!");
            }
            else{
                edgeNum++;
                if(directed == true){
                    matrix[index1][index2] = weight;
                }
                else{
                    matrix[index1][index2] = weight;
                    matrix[index2][index1] = weight;
                }
            }
        }
    }

//----------REMOVES AN EDGE, ACCEPTS TWO STRINGS AND A BOOLEAN TO KNOW IF DIRECTED OR NOT----------  
    public void removeEdge(String vertexName1, String vertexName2, boolean directed){
        int index1 = -1;
        int index2 = -1;

        if(!exists(vertexName1)){
            System.out.println("Vertex 1 does not exist!!!");
        }
        if(!exists(vertexName2)){
            System.out.println("Vertex 2 does not exist!!!");
        }
        else{
            for(int i=0; i<vertexArray.length; i++){
                if(vertexArray[i].name.equals(vertexName1)){
                    index1 = i;
                }
                if(vertexArray[i].name.equals(vertexName2)){
                    index2 = i;
                }
            }

            if(matrix[index1][index2] == 0){
                System.out.println("There is no Edge to remove!!!");
            }
            else{
                edgeNum--;
                if(directed == true){
                    matrix[index1][index2] = 0;
                }
                else{
                    matrix[index1][index2] = 0;
                    matrix[index2][index1] = 0;
                } 
            }
        }
    }   


//----------RETURNS NUMBER OF VERTICES----------
    public int getVertexNum(){
        return vertexNum;
    }

//----------RETURNS NUMBER OF EDGES----------
    public int getEdgeNum(){
        return edgeNum;
    }

//----------RETURNS THE NEIGHBORS OF A GIVEN VERTEX, ACCEPTS A STRING----------
    public Vertex[] getAdjacentVertices(String vertexName){
        Vertex[] neighborArr = new Vertex[0];
        int pos = -1;

        if(!exists(vertexName)){
            System.out.println("Vertex does not exist!!!");
        }
        else{
            for(int i=0; i<vertexArray.length; i++){
                if(vertexName.equals(vertexArray[i].name)){
                    pos = i;
                }
            }

            for(int i=0; i<vertexArray.length; i++){
                if(matrix[pos][i] > 0){
                    Vertex[] tempArr = new Vertex[neighborArr.length + 1];
                    for(int j=0; j<neighborArr.length; j++){
                        tempArr[j] = neighborArr[j];
                    }
                    
                    tempArr[neighborArr.length] = vertexArray[i];
                    neighborArr = tempArr;
                }
            }
        }

        return neighborArr;
    }

//----------RETURNS ARRAY OF VERTICES----------
    public Vertex[] getVertexArr(){
        return vertexArray;
    }

//----------RETURNS MATRIX OF EDGES----------
    public double[][] getMatrix(){
        return matrix;
    }


//----------CHECKS IF A GIVEN VERTEX EXISTS ON THE GRAPH----------
    public boolean exists(String vertexName){
        boolean status = false;

        for(int i=0; i<vertexArray.length; i++){
            if(vertexArray[i].name.equals(vertexName)){
                status = true;
            }
        }
        return status;
    }

//----------FINDS POSITION OF A CERTAIN VERTEX FROM THE GRAPH----------
    public int findPosition(String vertexName){
        int position = -1;

        for(int i=0; i<vertexArray.length; i++){
            if(vertexArray[i].name.equals(vertexName)){
                position = i;
            }
        }
        return position;
    }
}