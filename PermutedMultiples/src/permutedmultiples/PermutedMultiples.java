package permutedmultiples;

public class PermutedMultiples {

    public static void main(String[] args) {
        int size = 1000000;
        
        for (int i = 1; i <= size; i++) {
            
            String iIntoString = String.valueOf(i);
            String x2 = String.valueOf(i*2);
            
            if (ContainSameDigits(iIntoString, x2)) {
                String x3 = String.valueOf(i*3);
                if (ContainSameDigits(x2, x3)) {
                    String x4 = String.valueOf(i*4);
                    if (ContainSameDigits(x3, x4)) {
                        String x5 = String.valueOf(i*5);
                        if (ContainSameDigits(x4, x5)) {
                            String x6 = String.valueOf(i*6);
                            if (ContainSameDigits(x5, x6)) {
                                System.out.println(i);
                            }
                        }
                    }
                }
            }     
        }
    }
    
    public static boolean ContainSameDigits(String number, String numberX2) {
        boolean containsDigit = true;
        int length = number.length();
        
        for (int i = 0; i < length; i++) {
            
            char c = number.charAt(i);
            if (!numberX2.contains("" + c)) {
                 containsDigit = false;
                 break;
             }
        }
        return containsDigit;
    }
}
