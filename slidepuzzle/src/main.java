public class main {
    public static void main(String[] args) {
        //{15, 2, 3, 4, 5, 6 ,7, 8, 9, 10, 11, 12, 13, 14, 1}
        //{2, 3, 4, 1, 6, 7, 8, 5, 10, 11, 12, 9, 14, 15, 13};
        int[] initialState = {6, 13, 7, 10, 8, 9, 11, 15, 2, 12, 5, 14, 3, 1, 4};

        checkPermutation(inversionCount(initialState));
    }

    public static int sort(int[] arr) {
        int numberOfSwaps = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            int m = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[m]) {
                    m = j;
                }
            }

            if (m != i) {
                int temp = arr[i];
                arr[i] = arr[m];
                arr[m] = temp;
                numberOfSwaps++;
            }
        }

        return numberOfSwaps;
    }

    public static int inversionCount(int[] arr) {
        int inversion = 0;
        for (int i = 0; i < arr.length; i++) {
            int currentNumber = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < currentNumber) {
                    inversion++;
                }
            }
        }

        return inversion;

    }

    public static void checkPermutation(int numberOfSwaps) {
        if ((numberOfSwaps % 2) == 0) {
            System.out.println("Even, permutation this state is solvable");
            System.out.println(numberOfSwaps);
        } else {
            System.out.println("Odd, permutation not solvable");
            System.out.println(numberOfSwaps);
        }
    }

}
