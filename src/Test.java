
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SONGSONG
 */
class ReverseComparator implements Comparator<Integer> {

    public int compare(Integer a, Integer b) {
        return b - a;
    }
}

public class Test {

    public static void main(String[] args) {
        Integer[] test = {1, 5, 2, 3, 4};
        Arrays.sort(test, new ReverseComparator());
        for (int i = 0; i < 5; i++) {
            System.out.println(test[i]);
        }
    }
}
