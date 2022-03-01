package triangularpentagonalandhexagonal;

public class TriangularPentagonalAndHexagonal {

    public static void main(String[] args) {
        long sizeIndex = 100000000000L;    
        
        for (long i = 1; i <= sizeIndex; i++) {
        
            long trian = trinagular(i);

            long indexPentag = IndexPentagonal(trian);
            long indexHexag = IndexHexagonal(trian);

            long pentag = Pentagonal(indexPentag);
            long hexag = Hexagonal(indexHexag);

            if (pentag == hexag){

                if (trian == pentag && trian == hexag) {

                System.out.println("number found " + trian + " at index " + i);

                }
            }
        
        }
           
    }
    
    public static long trinagular (long num) {
        long i = (num*(num+1)) / 2;
        return i;
    }
    
    public static long Pentagonal (long num) {
        long i = (num*(3*num-1)) / 2;
        return i;
    }
    
    public static long Hexagonal (long num) {
        long i = num*(2*num-1);
        return i;
    }
    
    public static long IndexPentagonal (long num) {
        float x = (float) Math.sqrt( (num*2) / 3);
        long i = Math.round(x);
        return i;
    }
    
    public static long IndexHexagonal (long num) {
        float x = (float) Math.sqrt(num/2);
        long i = Math.round(x);
        return i;
    }
    

    
}
