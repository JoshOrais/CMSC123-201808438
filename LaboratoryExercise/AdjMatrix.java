package LaboratoryExercise;

public class AdjMatrix{
    private Vertex[] vertArr = new Vertex[0];
    private int[][] matrix = new int[0][0];

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
            for(int i=0; i<length; i++){
                if(vertArr[i].vert.equals(vert)){
                    pos = i;
                }
            }

            Vertex[] tempVert = new Vertex[length-1];
            int[][] tempMatrix = new int[length-1][length-1];

            for(int i=0; i<length; i++){
                if(i<pos){
                    tempVert[i] = vertArr[i];

                    for(int j=0; j<pos; j++){
                        tempMatrix[i][j] = matrix[i][j];
                    }
                }
                else if(i>pos){
                    tempVert[i-1] = vertArr[i];

                    for(int j=i; j<length; j++){
                        tempMatrix[i-1][j-1] = matrix[i-1][j-1];
                    }
                }
            }

            vertArr = tempVert;
            matrix = tempMatrix;
        }
    }

//----------INSERTS AN EDGE, ACCEPTS TWO STRINGS AND A WEIGHT----------

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

            if(directed == true){
                matrix[index1][index2] = weight;
            }
            else{
                matrix[index1][index2] = weight;
                matrix[index2][index1] = weight;
            }
        }
    }

//----------REMOVES AN EDGE, ACCEPTS TWO STRINGS----------
    
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

            if(directed == true){
                matrix[index1][index2] = 0;
            }
            else{
                matrix[index1][index2] = 0;
                matrix[index2][index1] = 0;
            } 
        }
    }   

//----------RETURNS THE NEIGHBORS OF A GIVEN VERTEX, ACCEPTS A STRING----------
    
    public Vertex[] getAdjacentVertices(String str){
        Vertex[] neighborArr = new Vertex[0];
        int pos = -1;

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
                neighborArr = tempArr;
            }
        }

        return neighborArr;
    }

//----------DEPTH FIRST SEARCH TRAVERSAL STARTING FROM A GIVEN VERTEX, ACCEPTS A STRING----------

    public void depthFirst(String str){
        Vertex start = new Vertex(str);
        Stack stack = new Stack();

        if(start.exists(vertArr) == false){
            System.out.println("Vertex does not exist!!!");
        }
        else{
            stack.push(start);
            int pos;

            System.out.println("\nDEPTH-FIRST SEARCH");
            while(stack.isEmpty() == false){
                Vertex popped = stack.pop();
                System.out.print("[" + popped.vert + "] ");
                
                pos = popped.findPosition(vertArr);
                vertArr[pos].isVisited = true;

                Vertex[] adjVert = getAdjacentVertices(popped.vert);

                for(int i=0; i<adjVert.length; i++){
                    pos = adjVert[i].findPosition(vertArr);
                    if(vertArr[pos].isVisited == false){
                        stack.push(vertArr[pos]);
                        vertArr[pos].isVisited = true;
                    }
                }
            }
            System.out.println("");
            
            for(int i=0; i<vertArr.length; i++){
                vertArr[i].isVisited = false;
            }
        }
    }

//----------BREADTH FIRST SEARCH TRAVERSAL STARTING FROM A GIVEN VERTEX, ACCEPTS A STRING----------

    public void breadthFirst(String str){
        Vertex start = new Vertex(str);
        Queue queue = new Queue();

        if(start.exists(vertArr) == false){
            System.out.println("Vertex does not exist!!!");
        }
        else{
            queue.enqueue(start);
            int pos;

            System.out.println("\nBREADTH-FIRST SEARCH");
            while(queue.isEmpty() == false){
                Vertex dequeued = queue.dequeue();
                System.out.print("[" + dequeued.vert + "] ");
                
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
            System.out.println("");

            for(int i=0; i<vertArr.length; i++){
                vertArr[i].isVisited = false;
            }
        }
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

//----------RETURNS A COLLECTION OF THE TOPOLOGICAL SORTING OF THE GRAPH----------
public void topologicalSorting(){
    
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