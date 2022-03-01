package readandwrite;

import java.util.*;
public class ReadAndWrite {

    public static void main(String[] args) {
        System.out.println("mata in ett tecken");
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int ii = 0;
        int storlek = 7;
        //System.out.println(s);
        
        /*for(int i = 0; i < storlek; i++) {
            for(int j = 0; j < i; j++){
                System.out.print(s);
            }   
                System.out.println();
                ii = i;
                if (i > (storlek - 2)) {
                    for (int x = ii; x > 0; x--){
                        for(int y = x; y > 0; y--) {
                            System.out.print(s);
                        }
                            System.out.println();
                    }
                }
            }*/
        
        
        for(int i = 0; i < 10; i++) {
            for(int j = i; j < 10; j++){
                System.out.print(s);
            }   
                System.out.println();
                ii = i;
                if (i > 8) {
                    for (int x = ii; x > 0; x--){
                        for(int y = x; y > 0; y--) {
                            System.out.print(s);
                        }
                            System.out.println();
                    }
                }
            }
        }
    }
