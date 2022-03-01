package powerfuldigitsum;

import java.math.BigInteger;

public class PowerfulDigitSum {

    public static void main(String[] args) {
        int size = 100;
        int maxSum = 0;
        
        for (int i = 2; i < size; i++) {
            for (int j = 1; j < size; j++) {
                
               BigInteger ii = BigInteger.valueOf(i);
               BigInteger n = ii.pow(j);
               //System.out.println(n + " " + i);
               //System.out.println(digitSum(n));
               
               if (digitSum(n) > maxSum) {
                   maxSum = digitSum(n);
               } 
            }
        }
        
        System.out.println(maxSum);
        
    }
    
    public static int digitSum(BigInteger number) {
    
        String s = number.toString();
        int len = s.length();
        int sum = 0;
        
        for (int i = 0; i < len; i++) {
        
           char c = s.charAt(i);
           int charToInt = Integer.parseInt(String.valueOf(c));
           sum += charToInt;
            
        }
        
        return sum;
    } 
    
}
