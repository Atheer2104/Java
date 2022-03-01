package undantaget;

import javax.swing.*;
public class Undantaget {

    public static void main(String[] args) {
       
       // Exception t.ex throwable som kastar en error måste vi ha innuti try & catch
       
       /*String stars = "*";
       while (true) {
           stars += "*";
           System.out.println(stars);
           try {
                Thread.sleep(1000);
           }catch(InterruptedException ie) {
                ie.printStackTrace();
           }
       }*/
       
       // runtime Exception t.ex vi skriver 100 med bokstäver då kan inte vi inte 
       // parse det till en double eftersom den hittade inga siffror
       
       String sAmount = JOptionPane.showInputDialog("Hur mycket vill du växla");
       //double dollar = 0;
       try {
            double dollar = Double.parseDouble(sAmount) / 10;
            JOptionPane.showMessageDialog(null, "Du får " + dollar + " $");
       } catch(NumberFormatException nfe) {
           JOptionPane.showMessageDialog(null, "ogiltiga tecken");
           main(args);
           
       }
       //JOptionPane.showMessageDialog(null, "Du får " + dollar + " $");
               
    }
    
}
