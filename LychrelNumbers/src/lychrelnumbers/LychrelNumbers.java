
package lychrelnumbers;

import java.math.BigInteger;
public class LychrelNumbers {

    public static void main(String[] args) {
        int size = 10000;
        int count = 0;
        for (int i = 100; i < size; i++) {
            
            BigInteger n = BigInteger.valueOf(i);
            int iteration = 0;
            
            
            while (n != palindromeRevserse(n)) {
                n = n.add(palindromeRevserse(n));
                iteration++;
                if (iteration < 50) {
                    if (isPalindrome(n)) {
                        //System.out.println("i is: " + i);
                        break;
                    }
                }else if (iteration > 50) {
                    if (!isPalindrome(n)) {
                        count++;
                        System.out.println("Number of Lychrel numbers " + count + " Numbers found is " + i);
                        break;
                    }
                }
            }
        }
      
        
        
    }
    
    public static boolean isPalindrome(BigInteger number) {
        BigInteger palindrome = number;
        BigInteger reverse = new BigInteger("0");
        
        while (palindrome != BigInteger.ZERO) {
            BigInteger remainder = palindrome.mod(BigInteger.TEN);
            //System.out.println("remainder " + remainder);
            reverse = reverse.multiply(BigInteger.TEN).add(remainder);
            //System.out.println("revese " + reverse);
            palindrome = palindrome.divide(BigInteger.TEN);
        }
        
        if (number.equals(reverse)) {
            return true;
        }
        
       return false;
    }
    
    public static BigInteger palindromeRevserse(BigInteger number) {
        BigInteger palindrome = number;
        BigInteger reverse = new BigInteger("0");
        
        while (palindrome != BigInteger.ZERO) {
            BigInteger remainder = palindrome.mod(BigInteger.TEN);
            //System.out.println("remainder " + remainder);
            reverse = reverse.multiply(BigInteger.TEN).add(remainder);
            //System.out.println("revese " + reverse);
            palindrome = palindrome.divide(BigInteger.TEN);
        }
        
        return reverse;
    }
    
}
