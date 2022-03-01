
package powerdigitsum;

import java.math.BigInteger;

public class PowerDigitSum {

    public static void main(String[] args) {
        
        BigInteger n = new BigInteger("2").pow(1000);
        BigInteger ten = new BigInteger("10");
        BigInteger sum = BigInteger.ZERO;
        while (n.compareTo(BigInteger.ZERO) == 1) {
            sum = sum.add(n.remainder(ten));
            n = n.divide(ten);
        }
        
        System.out.println(sum);
   
        
    }
   
}
