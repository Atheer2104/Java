package sumprime;

public class SumPrime {    
  
    public static void main(String[] args) {
        
        boolean isPrime;
        int sum = 0;
        
        for (int i = 2000000; i > 1; i--) {
        
            isPrime = true;
            //System.out.println(i);
            for (int j = 2; j < i; j++) {
                
                if (i % j == 0) {
                    //System.out.println(i + " not a prime number");
                    isPrime = false;
                }
            }
            
            if (isPrime) {
                sum += i;
                //System.out.println(i + " is a prime");
                
            }
        }
        System.out.println("sum is " + sum); 
        
          
        
    }
    
}
