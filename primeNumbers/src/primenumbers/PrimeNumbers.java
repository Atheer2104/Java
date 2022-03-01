
package primenumbers;

public class PrimeNumbers {

    public static void main(String[] args) {
        long num = 41;
        //int maxNum = (int) Math.sqrt(num);
        
        for (int i = 2; i <= num; i++) {
            while (num % i == 0) {
                
                System.out.println(i + " ");
                num/=i;
            
            }
        
        }
        
        
    }
    
}
