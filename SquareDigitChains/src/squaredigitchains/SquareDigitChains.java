package squaredigitchains;

import java.math.BigInteger;
public class SquareDigitChains {
    
    public static void main(String[] args) {
        int size = 10000000;
        int count = 0;
        
        for (long i = 1; i < size; i++) {
        
            BigInteger startNumber = BigInteger.valueOf(i);
            
                while (!startNumber.equals(1) && !startNumber.equals(89)) {
                    startNumber = squareDigits(startNumber);
                    //System.out.println(num);

                    if (startNumber.equals(BigInteger.valueOf(89))) {
                        count++;
                    }

                    if (startNumber.equals(BigInteger.ONE) || startNumber.equals(BigInteger.valueOf(89))) {
                        break;
                    }
            }
        }   
        
        System.out.println("89's count " + count);
       
        
        
       
       
       
        
    }
    
    public static BigInteger squareDigits (BigInteger number) {
    
        String num = number.toString();
        int len = num.length();
        BigInteger sum = BigInteger.ZERO;
        
        for (int i = 0; i < len; i++) {
        
            long digits = Character.getNumericValue(num.charAt(i));
            BigInteger bigDigits = BigInteger.valueOf(digits);
            sum = sum.add(bigDigits.pow(2));
            
        }
        
       return sum;
    }
            
            
    
}
