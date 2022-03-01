/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrayer;

import java.io.*;
import java.util.*;

/**
 *
 * @author elev
 */

public class Arrayer {

    private static String readFirstLine(File f) throws IOException {
    try (BufferedReader br = new BufferedReader(new FileReader(f))) {
        return br.readLine();
    }
}
    
 /**
 * Sum of values of the uppercase letters, treating 'A' as 1, 'Z' as 26.
 * Ignores all other characters.
 */
private static int letterSum(String s) {
    int sum = 0;
    for (char c : s.toCharArray()) {
        if (Character.isUpperCase(c)) {
            sum += c - ('A' - 1);
        }
    }
    return sum;
}
    
    public static void main(String[] args) throws IOException {
    File f = new File("/Users/elev/Desktop/p022_names.txt");
    long time = System.nanoTime();

    String[] names = readFirstLine(f).split(",");
    Arrays.sort(names);

    int total = 0;
    for (int i = 0; i < names.length; i++) {
        total += (i + 1) * letterSum(names[i]);
    }

    time = System.nanoTime() - time;
    System.out.println("The result is: " + total);
    System.out.println("Time taken: " + time + " ns");
    }
    
}
