package factorialdigitsum;

import java.math.BigInteger;
public class FactorialDigitSum {

    public static void main(String[] args) {
        
        int n = 100;
        BigInteger result = new BigInteger("1");
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            
            result = result.multiply(BigInteger.valueOf(i));
        }
        
        System.out.println(result);
        
        
        String s = String.valueOf(result);
        long length = s.length();
        
        for (int i = 0; i < length; i++) {
            
            char number =  s.charAt(i);
            String stringToNumber = String.valueOf(number);
            int stringToInt = Integer.parseInt(stringToNumber);
            
            sum += stringToInt;
        }
        
        System.out.println(sum);
        
    }
    
}
