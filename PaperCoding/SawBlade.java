package PaperCoding;

public class SawBlade{
    public SawBlade(int x){
        for(int i=0; i<x; i++){
            for(int j=0, y=x, z=i; j<=i; j++, y--, z--){
                for(int k=0; k<y; k++){
                    if(k<=z){
                        System.out.print("*");
                    }
                    else{
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
}