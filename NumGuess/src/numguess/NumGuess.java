package numguess;

import java.util.Scanner;
public class NumGuess {

    public static void main(String[] args) {   
        System.out.println("Gissa på ett tal mellan 0-10");
        int number = (int)(Math.random()*11);
        int counter = 0;
        
        Scanner scan = new Scanner(System.in);
        boolean found = false;
        while(!found) {
            
            counter++;
            int guess= scan.nextInt();
            System.out.println("Your guess: "+ guess);
            
            if (number == guess) {
                System.out.println(" Correct, number of guesses: " + counter);
                found = true;
            }else  if (number > guess){
                System.out.println("To low, damn");
            }else {
                System.out.println("To high, damn");
            }
             
            
        }
     
    }
    
}
