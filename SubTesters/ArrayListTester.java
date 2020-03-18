package SubTesters;

import java.util.ArrayList;

public class ArrayListTester{
    public ArrayListTester(){
        ArrayList<Float> array = new ArrayList<Float>();
        array.add(12.3f);
        array.add(new Float(12.3));
        array.add(new Float(13));
        array.add(new Float(10.1));
        array.add(new Float(12.3));
        array.add(new Float(8.3));

        System.out.println("\nOriginal: ");
        for(int i=0; i<array.size(); i++){
            System.out.println("[" + array.get(i).floatValue() + "] ");
        }

        array.remove(new Float(12.3));

        System.out.println("\nAltered: ");
        for(int i=0; i<array.size(); i++){
            System.out.println("[" + array.get(i).floatValue() + "] ");
        }

        // Float x = new Float(13);
        // float y = (float)x;
    }

    public static void main(String [] args){
        new ArrayListTester();
    }
}