package wordsbackword;

import java.util.*;
public class WordsBackword {

    public static void main(String[] args) {
       
        Scanner scan = new Scanner(System.in);
        
        System.out.println("skriv ett ord");
        
        String word = scan.nextLine();
        // exepct reehta
        String wordBackword = reverseTheWord(word);
        
        if (word.equals(wordBackword)) {
            System.out.println("ordet " + word + " är likadant framåt som bakåt");
        }
        else {
            System.out.println("ordet " + word + " är INTE likadant framåt som bakåt");
        }
        
        
        
    }
    
    public static String reverseTheWord (String word) {
        
        int length = word.length();
        String[] backword = new String[length];
        
        for (int i = 0; i < length; i++) {
        
            backword[i] = String.valueOf(word.charAt(i));
                
        }
        
        for (int j = 0; j < backword.length/2; j++) {
            
            String temp = backword[j];
            backword[j] = backword[backword.length - j - 1];
            backword[backword.length - j - 1] = temp;
            
        }
        
        String value = String.join("", backword);
        return value;
             
    }
    
}
