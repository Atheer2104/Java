package selfpower;

import java.math.BigInteger;

public class SelfPower {
    
    
    public static void main(String[] args) {
        
        BigInteger n = new BigInteger("0");
        int size = 1000;
        BigInteger result = new BigInteger("0");
        
        for (int i = 1; i <= size; i++) {
            
            n = BigInteger.valueOf(i);
            BigInteger nn = n.pow(i);
            result = result.add(nn);
            
        }
       
        String s = String.valueOf(result);
        // len = 3001 - 2991 = 10 last ten digits
        int len = s.length();
        
        for (int i = 1; i < len; i++) {
            
            char c = s.charAt(i);
            if (i > 2990) {
                System.out.println(c);
            }
        }
    }   
}
