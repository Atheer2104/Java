package largenonmersenneprime;

import java.math.BigInteger;
public class LargeNonMersennePrime {

    public static void main(String[] args) {
        
        BigInteger multiplyWith = new BigInteger("28433");
        BigInteger number = new BigInteger("2");
        number = number.pow(7830457);
        number = number.multiply(multiplyWith);
        number = number.add(BigInteger.ONE);
        
        System.out.println(lastTenDigits(number));
     
        
       
       
        
        
        }
    
    public static int lastTenDigits (BigInteger number) {
    
        String s = number.toString();
        int len = s.length();
        System.out.println(len);
        
        for (int i = 0; i < len; i++) {
            
            int digit = Character.getNumericValue(s.charAt(i));
            
            if (i >= len - 10) {
                System.out.print(digit);
            }
            
           }
        return 0;
     }
    
         
    }
