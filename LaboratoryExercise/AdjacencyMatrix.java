package LaboratoryExercise;

import java.util.ArrayList;

public class AdjacencyMatrix{
    private Vertex[] vertArr = new Vertex[0];
    private int[][] matrix = new int[0][0];
    private int vertNum = 0;
    private int edgeNum = 0;
    private String[] collection = new String[0];

//----------INSERTS A VERTEX, ACCEPTS STRING-----------
    public void insertVertex(String strVert){
        Vertex vertex = new Vertex(strVert);
        int arrLength = vertArr.length;
        Vertex[] newArr = new Vertex[arrLength+1];
        int[][] newMatrix = new int[arrLength+1][arrLength+1];

        if(vertex.exists(vertArr) == true){
            System.out.println("Vertex already exists!!!");
        }
        else{
            vertNum++;
            for(int i=0; i<arrLength; i++){
                newArr[i] = vertArr[i];
                for(int j=0; j<arrLength; j++){
                    newMatrix[i][j] = matrix[i][j];
                }
            }

            Vertex newVert = new Vertex(strVert);
            newArr[arrLength] = newVert;
            vertArr = newArr;
            
            for(int i=0; i<=arrLength; i++){
                newMatrix[arrLength][i] = 0;
                newMatrix[i][arrLength] = 0;
            }
            matrix = newMatrix;
        }
    }

//----------REMOVES A VERTEX, ACCEPTS STRING----------
    public void removeVertex(String vert){
        Vertex vertex = new Vertex(vert);
        int length = vertArr.length;
        int pos = -1;

        if(vertex.exists(vertArr) == false){
            System.out.println("The vertex does not exist!!!");
        }
        else{
            vertNum--;
            for(int i=0; i<length; i++){
                if(vertArr[i].vert.equals(vert)){
                    pos = i;
                }
            }

            for(int i=0; i<vertArr.length; i++){
                if(matrix[pos][i] > 0){
                    vertArr[i].inDegree--;
                }
            }

            Vertex[] tempVert = new Vertex[length-1];
            int[][] tempMatrix = new int[length-1][length-1];

            for(int i=0; i<length; i++){
                if(i<pos){
                    tempVert[i] = vertArr[i];

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
                    tempVert[i-1] = vertArr[i];

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

            vertArr = tempVert;
            matrix = tempMatrix;
        }
    }

//----------INSERTS AN EDGE, ACCEPTS TWO STRINGS, A WEIGHT, AND A BOOLEAN TO KNOW IF DIRECTED OR NOT----------
    public void insertEdge(String vert1, String vert2, int weight, boolean directed){
        Vertex vertex1 = new Vertex(vert1);
        Vertex vertex2 = new Vertex(vert2);
        int index1 = -1;
        int index2 = -1;

        if(vertex1.exists(vertArr) == false){
            System.out.println("Vertex 1 does not exist!!!");
        }
        if(vertex2.exists(vertArr) == false){
            System.out.println("Vertex 2 does not exist!!!");
        }
        else{
            for(int i=0; i<vertArr.length; i++){
                if(vertArr[i].vert.equals(vert1)){
                    index1 = i;
                }
                if(vertArr[i].vert.equals(vert2)){
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
                    vertArr[index2].inDegree++;
                }
                else{
                    matrix[index1][index2] = weight;
                    matrix[index2][index1] = weight;
                }
            }
        }
    }

//----------REMOVES AN EDGE, ACCEPTS TWO STRINGS AND A BOOLEAN TO KNOW IF DIRECTED OR NOT----------  
    public void removeEdge(String vert1, String vert2, boolean directed){
        Vertex vertex1 = new Vertex(vert1);
        Vertex vertex2 = new Vertex(vert2);
        int index1 = -1;
        int index2 = -1;

        if(vertex1.exists(vertArr) == false){
            System.out.println("Vertex 1 does not exist!!!");
        }
        if(vertex2.exists(vertArr) == false){
            System.out.println("Vertex 2 does not exist!!!");
        }
        else{
            for(int i=0; i<vertArr.length; i++){
                if(vertArr[i].vert.equals(vert1)){
                    index1 = i;
                }
                if(vertArr[i].vert.equals(vert2)){
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
                    vertArr[index2].inDegree--;
                }
                else{
                    matrix[index1][index2] = 0;
                    matrix[index2][index1] = 0;
                } 
            }
        }
    }   


//----------RETURNS NUMBER OF VERTICES----------
    public int getVertNum(){
        return vertNum;
    }

//----------RETURNS NUMBER OF EDGES----------
    public int getEdgeNum(){
        return edgeNum;
    }

//----------RETURNS THE NEIGHBORS OF A GIVEN VERTEX, ACCEPTS A STRING----------
    public Vertex[] getAdjacentVertices(String str){
        Vertex vertex = new Vertex(str);
        Vertex[] neighborArr = new Vertex[0];
        int pos = -1;

        if(vertex.exists(vertArr) == false){
            System.out.println("Vertex does not exist!!!");
        }
        else{
            for(int i=0; i<vertArr.length; i++){
                if(str.equals(vertArr[i].vert)){
                    pos = i;
                }
            }

            for(int i=0; i<vertArr.length; i++){
                if(matrix[pos][i] > 0){
                    Vertex[] tempArr = new Vertex[neighborArr.length + 1];
                    for(int j=0; j<neighborArr.length; j++){
                        tempArr[j] = neighborArr[j];
                    }
                    
                    tempArr[neighborArr.length] = vertArr[i];
                    tempArr[neighborArr.length].inWeight = matrix[pos][i];
                    neighborArr = tempArr;
                }
            }
        }

        return neighborArr;
    }

//----------RETURNS A BOOLEAN WHETHER TWO VERTICES ARE ADJACENT OR NOT----------
    public boolean checkIfAdjacent(String vert1, String vert2){
        Vertex vertex1 = new Vertex(vert1);
        Vertex vertex2 = new Vertex(vert2);

        Vertex[] adjVert = getAdjacentVertices(vertex1.vert);
        if(vertex2.exists(adjVert) == true){
            return true;
        }
        else{
            return false;
        }
    }

//----------RETURNS A BOOLEAN WHETHER TWO VERTICES ARE CONNECTED OR NOT----------
    public boolean checkIfConnected(String vert1, String vert2){
        Vertex vertex1 = new Vertex(vert1);
        Vertex vertex2 = new Vertex(vert2);
        int vertPos2;
        Stack stack = new Stack();
        boolean status = false;

        if(vertex1.exists(vertArr) == false){
            System.out.println("Vertex 1 does not exist!!!");
        }
        if(vertex2.exists(vertArr) == false){
            System.out.println("Vertex 2 does not exist!!!");
        }
        else{
            vertPos2 = vertex2.findPosition(vertArr);

            stack.push(vertex1);
            int pos;

            while(stack.isEmpty() == false){
                Vertex popped = stack.pop();
                
                pos = popped.findPosition(vertArr);
                vertArr[pos].isVisited = true;

                Vertex[] adjVert = getAdjacentVertices(popped.vert);

                for(int i=0; i<adjVert.length; i++){
                    pos = adjVert[i].findPosition(vertArr);
                    if(vertArr[pos].isVisited == false){
                        vertArr[pos].inWeight = adjVert[i].inWeight;
                        stack.push(vertArr[pos]);
                        vertArr[pos].isVisited = true;
                    }
                }
            }
            
            if(vertArr[vertPos2].isVisited == true){
                status = true;
            }

            for(int i=0; i<vertArr.length; i++){
                vertArr[i].isVisited = false;
            }
        }

        return status;
    }

//----------DEPTH FIRST SEARCH TRAVERSAL STARTING FROM A GIVEN VERTEX, ACCEPTS A STRING----------
    public String[] depthFirst(String str){
        Vertex start = new Vertex(str);
        Stack stack = new Stack();
        ArrayList<String> dfs = new ArrayList<String>();

        if(start.exists(vertArr) == false){
            System.out.println("Vertex does not exist!!!");
        }
        else{
            stack.push(start);
            int pos;

            while(stack.isEmpty() == false){
                Vertex popped = stack.pop();
                dfs.add(popped.vert);
                
                pos = popped.findPosition(vertArr);
                vertArr[pos].isVisited = true;

                Vertex[] adjVert = getAdjacentVertices(popped.vert);

                for(int i=0; i<adjVert.length; i++){
                    pos = adjVert[i].findPosition(vertArr);
                    if(vertArr[pos].isVisited == false){
                        vertArr[pos].inWeight = adjVert[i].inWeight;
                        stack.push(vertArr[pos]);
                        vertArr[pos].isVisited = true;
                    }
                }
            }
            
            for(int i=0; i<vertArr.length; i++){
                vertArr[i].isVisited = false;
            }
        }

        String[] dfsArr = dfs.toArray(new String[dfs.size()]);
        return dfsArr;
    }

//----------BREADTH FIRST SEARCH TRAVERSAL STARTING FROM A GIVEN VERTEX, ACCEPTS A STRING----------
    public String[] breadthFirst(String str){
        Vertex start = new Vertex(str);
        Queue queue = new Queue();
        ArrayList<String> bfs = new ArrayList<String>();

        if(start.exists(vertArr) == false){
            System.out.println("Vertex does not exist!!!");
        }
        else{
            queue.enqueue(start);
            int pos;

            while(queue.isEmpty() == false){
                Vertex dequeued = queue.dequeue();
                bfs.add(dequeued.vert);
                
                pos = dequeued.findPosition(vertArr);
                vertArr[pos].isVisited = true;

                Vertex[] adjVert = getAdjacentVertices(dequeued.vert);

                for(int i=0; i<adjVert.length; i++){
                    pos = adjVert[i].findPosition(vertArr);
                    if(vertArr[pos].isVisited == false){
                        queue.enqueue(vertArr[pos]);
                        vertArr[pos].isVisited = true;
                    }
                }
            }

            for(int i=0; i<vertArr.length; i++){
                vertArr[i].isVisited = false;
            }
        }
        
        String[] bfsArr = bfs.toArray(new String[bfs.size()]);
        return bfsArr;
    }

//----------RETURNS DISTANCE OF ALL VERTICES FROM A GIVEN VERTEX, ACCEPTS STRING----------
    public int[] getDistanceToAll(String str){
        int[] distanceArr = new int[vertArr.length];
        Vertex source = new Vertex(str);
        Queue queue = new Queue();

        for(int i=0; i<vertArr.length; i++){
            vertArr[i].pathLength = 2147483647;
        }

        source.pathLength = 0;
        queue.enqueue(source);

        while(queue.isEmpty() == false){

            Vertex current = queue.dequeue();
            int posCurr = current.findPosition(vertArr);
            vertArr[posCurr].isVisited = true;
            vertArr[posCurr].pathLength = current.pathLength;

            Vertex[] adjVert = getAdjacentVertices(vertArr[posCurr].vert);

            for(int i=0; i<adjVert.length; i++){
                int adjPos = adjVert[i].findPosition(vertArr);

                if(vertArr[adjPos].isVisited == false){
                    if(vertArr[adjPos].pathLength > vertArr[posCurr].pathLength){
                        vertArr[adjPos].pathLength = vertArr[posCurr].pathLength + 1;
                    }
                    queue.enqueue(vertArr[adjPos]);
                }
            }
        }

        for(int i=0; i<vertArr.length; i++){
            if(vertArr[i].pathLength == 2147483647){
                distanceArr[i] = 0;
            }
            else{
                distanceArr[i] = vertArr[i].pathLength;
            }
        }

        for(int i=0; i<vertArr.length; i++){
            vertArr[i].isVisited = false;
            vertArr[i].pathLength = 0;
        }

        return distanceArr;
    }

//----------RETURNS ALL VERTICES WITH 0 IN-DEGREE----------
    public Vertex[] getZeroInDegree(){
        ArrayList<Vertex> zeroInDegreeList = new ArrayList<Vertex>();
        
        for(int i=0; i<vertArr.length; i++){
            if(vertArr[i].inDegree == 0){
                zeroInDegreeList.add(vertArr[i]);
            }
        }

        Vertex[] zeroInDegreeArr = zeroInDegreeList.toArray(new Vertex[zeroInDegreeList.size()]);

        return zeroInDegreeArr;
    }


//----------RETURNS ARRAY OF VERTICES----------
    public Vertex[] getVertexArr(){
        return vertArr;
    }

//----------RETURNS MATRIX OF EDGES----------
    public int[][] getMatrix(){
        return matrix;
    }
}