package sortering;

import java.awt.*;
import javax.swing.*;
import java.util.*;
public class Sortering extends Canvas{
    
    private JFrame frame = new JFrame();
    private Canvas c = new Canvas();
    
    
    public static void main(String[] args) {
       /*Scanner scan = new Scanner(System.in);
       System.out.println("Mata in 5 tal");
       System.out.println("tal 1");
       int talOne = scan.nextInt();
       System.out.println("tal 2");
       int talTwo = scan.nextInt();
       System.out.println("tal 3");
       int talThree = scan.nextInt();
       System.out.println("tal 4");
       int talFour = scan.nextInt();
       System.out.println("tal 5");
       int talFive = scan.nextInt();
       
       int[] numbers = {talOne, talTwo, talThree, talFour, talFive};
       insertionSort(numbers);
       for (int i = 0; i < numbers.length; i++) {
           System.out.println(numbers[i]);
       }*/
      
      JFrame frame = new JFrame("My Drawing");
      Canvas canvas = new Sortering();
      canvas.setSize(400,400);
      frame.add(canvas);
      frame.pack();
      frame.setVisible(true);
      
       
       
        
    }
    
    public static void insertionSort(int[] array) {
          
        int i;
        int temp;
        
        for (int n = 1; n < array.length; n++) {
            temp = array[n]; // temp is the value we currently are on
            i = n - 1; // i is n-1 so if n is 1 i is 0
            
            //is our array at i position is bigge than temp then we move one step to right 
            while (i >= 0 && array[i] > temp) {
                array[i + 1] = array[i];
                i--;
            }
            array[i+1] = temp;
        }
        
    }
    
    public static void bubbleSort(int[] array) {
        // vi börjar med det näst sista talet och sänker m 
        for (int m = array.length -1; m > 0; m--) {
            for (int n = 0; n < m; n++) {
                // om vi har ett större tal än den nästa då ska vi flytta 
                if (array[n] > array[n + 1]) {
                    
                    int temp = array[n];
                    array[n] = array[n+1];
                    array[n+1] = temp;
                
                }
            }
        }
    }
    
    public void paint(Graphics g) {
        int x = 40;
        int y = 150;
        int[] tal = {5, 10, 3, 8};
        bubbleSort(tal);
        
        g.drawLine(x, y, x, y-100);
        g.drawLine(x, y, x+200, y);
        
        g.setColor(Color.blue);
        
        for (int i=0; i < tal.length; i++) {
            g.fillOval(x+1, y-tal[i], 2, 2);
        }
    }
    
}
