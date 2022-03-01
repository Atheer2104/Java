package powerfuldigitcounts;

public class PowerfulDigitCounts {

 
    public static void main(String[] args) {
     
        int result = 0;
        int lower = 0;
        int n = 1;

        while (lower < 10) {
            lower = (int) Math.ceil(Math.pow(10,(n-1.0)/n));
            result += 10 - lower;
            n++;
            System.out.println(result);
            
        }


       
        
    }

    
    
}
