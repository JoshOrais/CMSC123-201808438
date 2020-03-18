package DataStructures;

import java.io.*;

public class GraphReader{
    public AdjacencyMatrix read(String inputName){
        String fileName = "GraphFiles/" + inputName;
        AdjacencyMatrix graph = new AdjacencyMatrix();

        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)));

            int contentChecker = 0;
            String contentLine = bufferedReader.readLine();

            while(contentLine != null){
                System.out.println(contentLine);

                if(contentLine.equals("EDGES")){
                    contentChecker = 1;
                }

                else{
                    if(contentChecker == 0){
                        String vertexName;
                        float vertexWeight;
                        int colonPosition;

                        int i=0;
                        while(contentLine.charAt(i) != ':'){
                            i++;
                        }
                        colonPosition = i;

                        vertexName = contentLine.substring(0, colonPosition);
                        vertexWeight = Float.parseFloat(contentLine.substring(colonPosition+1, contentLine.length()));

                        graph.insertVertex(vertexName, vertexWeight);
                    }

                    if(contentChecker == 1){
                        String vertexA = "";
                        String vertexB = "";
                        float edgeWeight = 0;
                        int comaPosition = 0;
                        int colonPosition = 0;

                        int i=0;
                        while(i<contentLine.length()){
                            if(contentLine.charAt(i) == ','){
                                comaPosition = i;
                            }
                            if(contentLine.charAt(i) == ':'){
                                colonPosition = i;
                            }
                            i++;
                        }

                        vertexA = contentLine.substring(0,comaPosition);
                        vertexB = contentLine.substring(comaPosition+1, colonPosition);
                        edgeWeight = Float.parseFloat(contentLine.substring(colonPosition+1,contentLine.length()));

                        graph.insertEdge(vertexA, vertexB, edgeWeight, true);
                    }
                }
                
                contentLine = bufferedReader.readLine();
            }
            bufferedReader.close();
        }
        catch(Exception s){
            System.out.println("Error!!! Please Try Again: ");
            // s.printStackTrace();
            return null;
        }

        return graph;
    }
}