
package largestpalindromeproduct;

public class LargestPalindromeProduct {

    public static void main(String[] args) {
        
        for (int i = 1; i < 1000; i++) {
            for (int j = 1; j < 1000; j++) {
                
                /*int factor = i*j;
                if (isPalindrome(factor)) {
                   String s = String.valueOf(factor);
                   int len = s.length();
                   if ( len > 5) {
                       System.out.println(factor);
                   }
                }*/

                
            }
        }
        
         if (isPalindrome(121)) {
                    
        }
        
    }
    
    public static boolean isPalindrome (int number) {
        int palindrome = number;
        int reverse = 0;
        
        while (palindrome != 0) {
            int remainder = palindrome % 10;
            System.out.println(remainder);
            reverse = reverse * 10 + remainder;
            System.out.println(reverse);
            palindrome = palindrome / 10;
        }
        
        // if original and reverse of number is equal means
        // number is palindrome in Java
        if ( number == reverse ) {
            return true;
        }
        return false;
    }
    
}
