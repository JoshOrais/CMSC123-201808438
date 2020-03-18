package DataStructures;

import java.util.ArrayList;

public class Edge{
    private ArrayList<Float> weight = new ArrayList<Float>();

    public void addWeight(float input){
        weight.add(input);
    }

    public void removeWeight(float input){
        weight.remove(input);
    }

    public float[] getWeightArray(){
        Float[] weightFloat = weight.toArray(new Float[weight.size()]);
        float[] convertedArray = new float[weightFloat.length];

        for(int i=0; i<weightFloat.length; i++){
            convertedArray[i] = weightFloat[i].floatValue();
        }

        return convertedArray;
    }
}