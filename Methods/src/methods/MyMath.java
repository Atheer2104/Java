package methods;

public class MyMath {
    
     public static void print(String s1, int i) {
        int x = 0;
        while (x < i) {
        System.out.println(s1);
        x++;
        }
    }
    
    public static int powOf2(int x) { 
        return x * x;
    }
    
    public int powOfExp(int num, int exponent) {
        //return (int) Math.pow(num, exponent);
        
        int x = 0;
        int result = 1;
        while (x < exponent) {
            result *= num;
            x++;
        }
        return result;
    }
    
}
