package methods;

public class Methods {
    
    public static double pi(){
        return Math.PI;
    }
    
    public static void printPI() {
        System.out.println();
    }    
    public static void main(String[] args) {
        MyMath m = new MyMath();
        int value = m.powOfExp(10,3);
        double d = Math.pow(3.2, 4.1);
        m.print(""+value, 1);
        m.print(""+d, 1);
        double omkr = 2*pi();
        System.out.println(pi());
      
          
    }
    
}
