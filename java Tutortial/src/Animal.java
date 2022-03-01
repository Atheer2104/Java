/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author elev
 */
import java.util.Scanner;
import java.util.*;
public class Animal {
    
    // public anybody can acces it
    //static every animal object can share these values, dosn't belong to a object but instead to the class
    // final can't be subclassed and can't be changed thus means they can't not be overridden
    // double allows a value to be in decimal points
    public static final double FAVNUMBER = 1.6180;
    
    //can only be acces by other methods in the class and that is it
    private String name;
    private int weight;
    private boolean hasOwner = false;
    //byte can be between -28 and 127
    private byte age;
    //long can be ridiclous huge number
    private long uniqueID;
    private char favoriteChar;
    private double speed;
    private float height;
    //by defualt the animal doesn't have an owner and name and weight is like attributes that can be filled in
    
    // can only be access by other code in the package, source package
    protected static int numberOfAnimals = 0;
    
    // we can get user inputs by using Scanner
    static Scanner userInput = new Scanner(System.in);
            
    public Animal() {
        numberOfAnimals++;
        
        // /n is new line
        System.out.print("Enter the name: \n");
        
        // hasNextInt, hasNextFloat, hasNextFloat, hasNextDouble, hasNextBoolean
        // hasNextByte
        
        if(userInput.hasNextLine()){
            
            // when we type this we mean the object that we created 
            this.setName(userInput.nextLine());
            
            /* we can do something called method overflow where the same data for example unique id
             can have more than one setter and  so it one with long value and it can have another one*/
        }
        
        this.setFavoriteChar();
	this.setUniqueID();
        
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getWeigt() {
        return weight;
    }
    
    public void setWeigth(int weight) {
        this.weight = weight;
    }
    
    public boolean isHasOwner() {
        return hasOwner;
    }
    
    public void setHasOwner(boolean hasOwner) {
        this.hasOwner = hasOwner;
    }
    
    public byte getAge() {
        return age;
    }
    
    public void setAge(byte age) {
        this.age = age;
    }
    
    public long getUniqueID() {
        return uniqueID;
    }
    
    public void setUniqueID(long uniqueID) {
        this.uniqueID = uniqueID;
        System.out.println("Unique ID Set to: " + this.uniqueID);
    }
    
    public void setUniqueID() {
        long minNumber = 1;
        long maxNumber = 1000000;
        
        // we have (long) there because we are casting this value as a long value
        this.uniqueID = minNumber + (long) (Math.random() * ((maxNumber - minNumber) + 1));
        String stringNumber = Long.toString(maxNumber);
        
        int numberString = Integer.parseInt(stringNumber);
        System.out.println("Unique ID Set to: " + this.uniqueID);
    }
    
    public char getFavoriteChar() {
        return favoriteChar;
    }
    
    public void setFavoriteChar(char favoriteChar) {
        this.favoriteChar = favoriteChar;
    }
    
    public void setFavoriteChar() {
        // we go from 1 to 126 wehick can be alphabets, numbers, sign and digits
        int randomNumber = (int) (Math.random() * 126) + 1;
        
        this.favoriteChar = (char) randomNumber;
        
        // number 32 repsents space 
        if(randomNumber == 32) {
            
            System.out.println("Favorite character set to Space");
            
        } else if(randomNumber == 10) {
            
            System.out.println("Favorite character set to NewLine");
            
        }else {
        
            System.out.println("Favorite character set to " + this.favoriteChar);
            
        }
        // && means and that both has to be true to make the if statment go through
        if((randomNumber > 97) && (randomNumber < 122)){
            System.out.println("Favorite character is a lowercase letter");
        } 
        
        // || means or 
        if(((randomNumber > 97) && (randomNumber < 122)) || ((randomNumber > 64) && (randomNumber < 91))){
            System.out.println("Favorite character is a letter");
        } 
        
        /* if statment shortcut so if 50 is bigger than random number then whichIsBigger is 50 
        but if randomNumbe is less than 50 then whichIsBigger is equal to randomNumber */
        int whichIsBigger = (50 > randomNumber) ? 50 : randomNumber;
        
        switch(randomNumber) {
            
            case 8: System.out.println("Favorite CHar set to backspace");
            break;
            
            case 10 :
            case 11 :
            case 12 :
                System.out.println("Favorite character set to: Something else weird");
                break;

             

            default :
                System.out.println("Favorite character set to: " + this.favoriteChar);
                break;

        }
        
        
    }
    
    public double getSpeed() {
        return speed;
    }
    
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    
    public float getHeight() {
        return height;
    }
    
    public void setHeight(float height) {
        this.height = height;
    }
    
    protected static void countTo(int startingNumber){
        
        for(int i = startingNumber; i <= 100; i++){
            
            /* continue is like don't go any further down here it wont print 90 becuase we 
            are saying to it just go, so the prin statment won't be called  */
            if (i == 90) continue;
            
            System.out.println(i);
            
        }
        
    }   
    
    //string instead of void means that it is going to return a string
    protected static String printNumbers(int maxNumbers) {
        
        int i = 1;
        
        while(i <(maxNumbers / 2)) {
            
            System.out.println(i);
            i++; 
            
            //break jumping out of the while loop
            if (i == (maxNumbers / 2)) break;
            
        }
        
        Animal.countTo(maxNumbers / 2);
        
        return "End of printNumbers";
    }
    
    protected static void guessMyNumber() {
        int number;
        
        // do going to run at least one time
        do {
            
            System.out.println("Guess Number up to 100");
            
            while(!userInput.hasNextInt()){
                
                String numberEntered = userInput.next();
                /*%s to print a string value inside the print function, ver important also 
                %s the s menans string but if we want for example float the we do 
                %.2f the f means float means it has 2 decimal places like 1.23*/
               System.out.printf("%s is not a number\n", numberEntered);

                
            }
            
            // here we know they entered a number because if the didn't then the while statment above will run 
            
            number = userInput.nextInt();
            
        } while(number != 50);
        
    }
    
    public String makeSound() {
      
        return "Grrrr";
        
    }
    
    public static void speakAnimal(Animal randAnimal){
        
        System.out.println("Animal says " + randAnimal.makeSound());
        
    }
    
    public static void main(String[] args) {
        
//objectit should be, the name to object, making the object
        Animal theAnimal = new Animal();
        
        
        
    }
    
}
