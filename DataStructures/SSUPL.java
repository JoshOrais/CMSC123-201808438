package DataStructures;

public class SSUPL{
    public double[] getDistanceToAllVertices(AdjacencyMatrix graph, Vertex source){
        Vertex[] vertexArray = graph.getVertexArr();
        double[] distanceArr = new double[vertexArray.length];
        Queue queue = new Queue();

        for(int i=0; i<vertexArray.length; i++){
            vertexArray[i].pathLength = 2147483647;
        }

        source.pathLength = 0;
        queue.enqueue(source);

        while(queue.isEmpty() == false){

            Vertex current = queue.dequeue();
            int posCurr = current.findPosition(vertexArray);
            vertexArray[posCurr].isVisited = true;
            vertexArray[posCurr].pathLength = current.pathLength;

            Vertex[] adjVert = graph.getAdjacentVertices(vertexArray[posCurr].name);

            for(int i=0; i<adjVert.length; i++){
                int adjPos = adjVert[i].findPosition(vertexArray);

                if(vertexArray[adjPos].isVisited == false){
                    if(vertexArray[adjPos].pathLength > vertexArray[posCurr].pathLength){
                        vertexArray[adjPos].pathLength = vertexArray[posCurr].pathLength + 1;
                    }
                    queue.enqueue(vertexArray[adjPos]);
                }
            }
        }

        for(int i=0; i<vertexArray.length; i++){
            if(vertexArray[i].pathLength == 2147483647){
                distanceArr[i] = 0;
            }
            else{
                distanceArr[i] = vertexArray[i].pathLength;
            }
        }

        for(int i=0; i<vertexArray.length; i++){
            vertexArray[i].isVisited = false;
            vertexArray[i].pathLength = 0;
        }

        return distanceArr;
    }
}