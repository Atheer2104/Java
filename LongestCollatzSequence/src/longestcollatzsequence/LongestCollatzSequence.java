
package longestcollatzsequence;

public class LongestCollatzSequence {

    public static void main(String[] args) {
        int size = 1000000;
        
        int sequenceLength = 0;
        int startingNumber = 0;
        
        for (int i = 2; i < size; i++) {
            
            int count = EvenOrOdd(i);
            
            if (count > sequenceLength) {
                sequenceLength = count;
                startingNumber = i;
            }
        }
        
       System.out.println("The starting number " + startingNumber + " produces a sequence of " + sequenceLength);
        
    }
    
    public static int EvenOrOdd(int num) {
        int count = 1;
        
        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            }else {
                num = (3*num) + 1;
            }
            count++;             
        } 
     
      return count;
    }

    
}
