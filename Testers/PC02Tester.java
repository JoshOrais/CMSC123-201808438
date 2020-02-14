package Testers;

import PaperCoding.SawBlade;
import java.util.Scanner;

public class PC02Tester{
    private SawBlade sawBlade;
    private Scanner scan = new Scanner(System.in);

    public PC02Tester(){
        System.out.print("Enter a number: ");
        sawBlade = new SawBlade(scan.nextInt());
    }

    public static void main(String []args){
        new PC02Tester();
    }
}