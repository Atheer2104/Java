/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    package projecteuler;

    public class ProjectEuler {

        public static void main(String[] args) {
        int numberOne = 5;
        int numberTwo = 3;
        int maxNumber = 999;
        int howMany = 0;
        int howManyFiften = 0;
        
       for (int i = maxNumber; i > 0; i--) {
            
           if (i % numberOne == 0) {
                //System.out.println(i);
                howMany += i;
            }
           
            if (i % numberTwo == 0) {
                //System.out.println(i);
                howMany += i;    
            }
            
            /* 3 times 5 is 15 and every number that is divided by 15 was counted twice because
            we are making the counting for 3 and 5 seperatly so the number is counted twice instead of
            once. We only need to subtract that amount from the orginal amount to get the right value
            */
            if (i % 15 == 0) {
                //System.out.println(i);
                howManyFiften -= i;
            } 
       }
       
        System.out.println("final Reslts is: ");
        System.out.println( howMany + howManyFiften);
  
    }
}
