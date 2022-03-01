package latticepaths;


public class LatticePaths {

    public static void main(String[] args) {
        int gridSize = 20;
        long paths = 1;
        
        for (int i = 0; i < gridSize; i++) {
            
            // Binomial coefficient
            paths *= (2 * gridSize) - i;
            System.out.println("first paths " + paths + " at " + i );
            paths /= i + 1;
             System.out.println("second paths " + paths + " at " + i );
        
        }
        
        System.out.println(paths);
        
    }
    
}
