package prime;

public class Prime {

    public static void main(String[] args) {
        
        int num = 0;
        boolean isPrime;
        int count = 0;
        
        for (int i = 2; i < 1000000; i++) {
            num = i;
            isPrime = true;
            for (int j = 2; j < num; j++) {
                if (num % j == 0) {
                    System.out.println(i);
                    //System.out.println(num + " is not a prime number factor with " + j);
                    isPrime = false;

                }

            }

            if (isPrime) {
                    count += 1;
                    if (count == 10001) {
                    System.out.println("the number you are looking for is " + num);
                    }
                    //System.out.println(i);
                    
            }
        }
      
    }
    
}
