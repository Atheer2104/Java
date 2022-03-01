package fibonaccinumbers;


public class FibonacciNumbers {

    
    public static void main(String[] args) {  
        long fib1 = 1;
        long fib2 = 1;
        long result = 0;
        long summed = 0;
 
            while (result < 4000000) {
                if ((result % 2) == 0) {
                    summed += result;
                }

                result = fib1 + fib2;
                fib2 = fib1;
                fib1 = result;
            }
            System.out.println(summed);
    }
    
}
