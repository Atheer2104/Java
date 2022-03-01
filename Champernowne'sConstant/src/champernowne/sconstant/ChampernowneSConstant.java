package champernowne.sconstant;

import java.util.*;
import java.io.*;

public class ChampernowneSConstant {
    
    public static void main(String[] args) {
        
        int result = 1;
        
        for (int k = 1; k < 1000000; k ++) {
        
        int nthDigit = 0, counter = 0;
        String numb;
        
        if ( k == 1 || k == 10 || k == 100 || k == 1000 || k == 10000 || k == 100000 || k == 1000000) {
            nthDigit = k;
        }
        
        for(int i = 1; i<=nthDigit; i++) {
            numb ="";
            numb +=i;
            counter +=numb.length();
            if (counter >= nthDigit) {
                counter -= numb.length();
                int j = 0;
                while(counter != nthDigit) {
                    counter++;
                    j++;
                    }
                System.out.println("Value at "+nthDigit+" is "+numb.charAt(j-1));    
                break;
                }
            } 
        
        }
        
    }
}
