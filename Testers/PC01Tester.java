package Testers;

import PaperCoding.Triangle;
import java.util.Scanner;

public class PC01Tester{
    private Triangle triangle;
    private Scanner scan = new Scanner(System.in);

    public PC01Tester(){
        System.out.print("Enter a number: ");
        triangle = new Triangle(scan.nextInt());
    }

    public static void main(String []args){
        new PC01Tester();
    }
}