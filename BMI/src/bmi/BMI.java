package bmi;

import java.util.*;
public class BMI {

    public static void main(String[] args) {
       
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Ange din vikt i kg, tack");
        double weight = scan.nextDouble();
        System.out.println("Ange din längd i meter");
        double heigth = scan.nextDouble();
        
        System.out.println(BMI(weight, heigth));
        
    }
    
    public static String BMI(double weight, double heigth) {
        double i = weight / (heigth * heigth);
        
        String s = "";
        System.out.println("i: " + i);
        if (i < 18.5) {
            s = "you are underweight " + (int) i;
        }else if ( i <= 24.9) {
            s = "you are normalweight " + (int) i;
        }else if (i <= 30) {
            s = "you are overweight " + (int) i;
        }
        return s;
    }
    
}
