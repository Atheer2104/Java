package consecutiveprimesum;

public class ConsecutivePrimeSum {

    public static void main(String[] args) {
        int maxSum = 1000000;
        int currentSum = 0;
        int currentNumber = 6;
        
        while((currentSum + currentNumber) < maxSum) {
            System.out.println("current number while loop " + currentNumber);
            if (isNumberPrime(currentNumber)) {
                currentSum += currentNumber;
                System.out.println("current sum if loop" + currentSum);
            }
            currentNumber++;
        }
        System.out.println(currentSum);
        
    }
    
    public static boolean isNumberPrime(int number) {
        for (int j = 2; j < number; j++) {
                if (number % j == 0) {
                    return false;
                }
            }
        return true;
    }
    
}
