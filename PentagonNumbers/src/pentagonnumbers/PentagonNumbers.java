
package pentagonnumbers;

public class PentagonNumbers {

    public static void main(String[] args) {
        
        int size = 10000;
        
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                
                int pentagonK = pentagon(i);
                int pentagonJ = pentagon(j);
                
                if (isPentagon(pentagonK + pentagonJ)) {
                    if (isPentagon(pentagonK - pentagonJ)) {
                        System.out.println("diffiernce " + (pentagonK - pentagonJ));
                    }
                    
                }
            
            }
        }
    }
    
    public static int pentagon (int index) {
    
        return index*((3*index) -1 )/2;
        
    }
    
    public static boolean isPentagon (int number) {
    
        switch (number) {
            case 1:
                return true;
            case 0:
                return false;
            default:
                float x = (float) Math.sqrt( (number*2) / 3);
                int i = Math.round(x);
                int indexNumber = pentagon(i);
                if (indexNumber == number) {
                    return true;
                }   break;
        }
        return false;
    } 
    
}
