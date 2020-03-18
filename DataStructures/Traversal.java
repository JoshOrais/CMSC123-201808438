package DataStructures;

import java.util.ArrayList;

public class Traversal{
    public String[] depthFirstSearch(AdjacencyMatrix graph, Vertex start){
        Stack stack = new Stack();
        ArrayList<String> dfs = new ArrayList<String>();
        Vertex[] vertexArray = graph.getVertexArr();

        if(start.exists(vertexArray) == false){
            System.out.println("Vertex does not exist!!!");
        }
        else{
            stack.push(start);
            int pos;

            while(stack.isEmpty() == false){
                Vertex popped = stack.pop();
                dfs.add(popped.name);
                
                pos = popped.findPosition(vertexArray);
                vertexArray[pos].isVisited = true;

                Vertex[] adjVert = graph.getAdjacentVertices(popped);

                for(int i=0; i<adjVert.length; i++){
                    pos = adjVert[i].findPosition(vertexArray);
                    if(vertexArray[pos].isVisited == false){
                        vertexArray[pos].inWeight = adjVert[i].inWeight;
                        stack.push(vertexArray[pos]);
                        vertexArray[pos].isVisited = true;
                    }
                }
            }
            
            for(int i=0; i<vertexArray.length; i++){
                vertexArray[i].isVisited = false;
            }
        }

        String[] dfsArr = dfs.toArray(new String[dfs.size()]);
        return dfsArr;
    }

    public String[] breadthFirstSearch(AdjacencyMatrix graph, Vertex start){
        Queue queue = new Queue();
        ArrayList<String> bfs = new ArrayList<String>();
        Vertex[] vertexArray = graph.getVertexArr();

        if(start.exists(vertexArray) == false){
            System.out.println("Vertex does not exist!!!");
        }
        else{
            queue.enqueue(start);
            int pos;

            while(queue.isEmpty() == false){
                Vertex dequeued = queue.dequeue();
                bfs.add(dequeued.name);
                
                pos = dequeued.findPosition(vertexArray);
                vertexArray[pos].isVisited = true;

                Vertex[] adjVert = graph.getAdjacentVertices(dequeued);

                for(int i=0; i<adjVert.length; i++){
                    pos = adjVert[i].findPosition(vertexArray);
                    if(vertexArray[pos].isVisited == false){
                        queue.enqueue(vertexArray[pos]);
                        vertexArray[pos].isVisited = true;
                    }
                }
            }

            for(int i=0; i<vertexArray.length; i++){
                vertexArray[i].isVisited = false;
            }
        }
        
        String[] bfsArr = bfs.toArray(new String[bfs.size()]);
        return bfsArr;
    }
}