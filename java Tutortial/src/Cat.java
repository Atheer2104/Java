/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author elev
 */
public class Cat extends Animal {
    
     public Cat() {
    
        
        
    }
    
    public String makeSound(){
        
        return "Moew";
        
    }
    
    public static void main(String[] args) {
        
        Animal fido = new Dog();
        Animal fluffy = new Cat();
        
        // to declare an array of a data type first type the data type and the array bracket after  
        // we create ten spaces inside the array
        Animal[] theAnimals = new Animal[10];
        
        theAnimals[0] = fido;
        theAnimals[1] = fluffy;
        
        System.out.println("Fido Says " + theAnimals[0].makeSound());
        System.out.println("fluffy Says " + theAnimals[1].makeSound());
        
        speakAnimal(fluffy);
        
    }
    
}
