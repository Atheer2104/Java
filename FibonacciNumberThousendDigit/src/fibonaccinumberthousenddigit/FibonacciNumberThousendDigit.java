package fibonaccinumberthousenddigit;

import java.math.BigInteger;

public class FibonacciNumberThousendDigit {

    public static void main(String[] args) {
        
        BigInteger n1 = new BigInteger("1");
        BigInteger n2 = new BigInteger("1");
        int count = 10000;
        int index = 2;
        BigInteger n3 = new BigInteger("0");

        
        for (int i = 1; i < count; i++) {
            
            index += 1;
            n3 = n1.add(n2);
            //System.out.println(" the number " + n3 + " the index " + index);
            n1 = n2;
            n2 = n3;
            
            
            int length = String.valueOf(n3).length();
            
            if (length == 1000) {
                System.out.println(index);
            }
            
            
        }
        
    }
    
}
