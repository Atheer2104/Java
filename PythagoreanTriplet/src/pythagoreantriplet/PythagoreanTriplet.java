package pythagoreantriplet;

public class PythagoreanTriplet {
    
    public static void main(String[] args) {
        
        for (int a = 1; a < 1000; a++) {
            for (int b = a + 1; b < 1000; b++) {
                int c = 1000 - a - b;
                if ( a * a + b * b == c * c) {
                    System.out.println("the product of abc is " + a*b*c);
                    System.out.println("a is " + a);
                    System.out.println("b is " + b);
                    System.out.println("c is " + c);
            }
        }
        
        
    }
    
}

}