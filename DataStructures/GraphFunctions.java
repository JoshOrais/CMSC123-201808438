package DataStructures;

public class GraphFunctions{
    private Traversal traversal = new Traversal();
    private SSUPL singleSourceUndirectedPathLength = new SSUPL();

    public String[] dfs(AdjacencyMatrix graph, Vertex start){
        return traversal.depthFirstSearch(graph, start);
    }

    public String[] bfs(AdjacencyMatrix graph, Vertex start){
        return traversal.breadthFirstSearch(graph, start);
    }

    public double[] ssupl(AdjacencyMatrix graph, Vertex source){
        return singleSourceUndirectedPathLength.getDistanceToAllVertices(graph, source);
    }
}