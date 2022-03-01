package sumsquaredifference;

public class SumSquareDifference {

    public static void main(String[] args) {
        int sumSqaure = 0;
        int squareSum = 0;
        int results = 0;
        
        for (int i = 1; i <= 100; i++) {
            
           sumSqaure += i*i;
        
        }
        
        for (int j = 1; j <= 100; j++) {
            
            squareSum += j;
        
        }
        squareSum = (int) Math.pow(squareSum, 2);
        
        
        results = squareSum - sumSqaure;
        System.out.println("the difference is " + results);
        
    }
    
}
