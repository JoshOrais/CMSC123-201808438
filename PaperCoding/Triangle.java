package PaperCoding;

public class Triangle{
    public Triangle(int x){
        for(int i=0; i<x; i++){
            for(int j=i+1; j<x; j++)
                System.out.print(" ");
            for(int k=0; k<=i; k++)
                System.out.print("I ");
            System.out.println();
        }
    }
}