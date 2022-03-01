
package amicablenumbers;

public class AmicableNumbers {

    public static void main(String[] args) {
        
        int n;
        int nSum;
        int nn;
        int nnSum;
        int amicabelSum = 0;
        for (int i = 1; i < 10000; i++) {
            n = 0;
            nn = 0;
            nSum = 0;
            nnSum = 0;
            n = i;
            
            for (int j = 1; j < 10000; j++) {
            if (n % j == 0) {
                //System.out.println(i);
                nSum += j;
            }  
                
        }
        
        nSum = nSum - n; 
        nn = nSum;
            
        for (int k = 1; k < 10000; k++) {
            
            if (nn % k == 0) {
                //System.out.println(i);
                nnSum += k;
            }
        }
        
        nnSum = nnSum - nn; 
        
        if (nnSum == n && nSum == nn && nnSum != nSum) {
               
            System.out.println(nnSum + " and " + nSum + " are amicabelNumbers");
            amicabelSum += (nnSum + nSum)/2;
            System.out.println(amicabelSum);
        }
        
       }
        
    }
    
}
