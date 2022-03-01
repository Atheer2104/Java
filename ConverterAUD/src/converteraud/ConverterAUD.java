package converteraud;

import java.util.Scanner;
public class ConverterAUD {

    public static void main(String[] args) {
        //new javax.swing.JFrame("foo").setVisible(true);
        System.out.println("Buy (1) or sell (2) ?");
        Scanner scan = new Scanner(System.in);
        
        int sellOrBuy = scan.nextInt();
        double amount;
        double value;
        double result;
        
        switch (sellOrBuy) {
            case 1:
                System.out.println("Hur många AUD?");
                amount = scan.nextDouble();
                value = 7.45;
                result = amount * value;
                System.out.println("You get: " + result + " SEK");
                break;
            case 2:
                System.out.println("Hur många SEK?");
                amount = scan.nextDouble();
                value = 6.47;
                result = amount / value;
                System.out.println("You get: " + result + " AUD");
                break;
            default:
                System.out.println("We are not sure if you want to sell or sell");
                break;
        }
        
        
        
         
    }
    
}
