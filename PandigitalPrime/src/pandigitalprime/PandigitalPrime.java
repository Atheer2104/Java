package pandigitalprime;

public class PandigitalPrime {

    public static void main(String[] args) {
        
        solve();
        
    }
    
    public static void solve() {
        // Largest pandigital number that can have possibility of being prime is
        // that where (1+2+...+n) % 3 == 1; This excludes n=9 and n=8;
        int i = 7654321;
        
        // Lower Bound Limit: 20 as 19 is the next smallest prime number, and is
	// not pandigital
        while (i > 20) {
            if (isPandigitalNumber("" + i) && isPrime(i)) {
                break;
            }
            // we can assume that all other primes numbers are odd 
            i -= 2;
        }
        System.out.println("Problem 41: " + i);
    }
    
    private static boolean isPandigitalNumber(String number) {
        boolean panDigital = true;
        int length = number.length();
        
        for (int i = 1; i <= length; i++) {
            if (!number.contains("" + i)) {
                panDigital = false;
                break;
            }
        }
        
        return panDigital;
        
    }
    
    private static boolean isPrime(int number) {
		boolean prime = true;
		double limit = Math.sqrt(number);
		if (number == 1) {
			prime = false;
		} else {
			for (int i = 2; i <= limit; i++) {
				if (number % i == 0) {
					prime = false;
					break;
				}
			}
		}
		return prime;
	}
    
    
}
