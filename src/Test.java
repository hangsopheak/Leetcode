
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

    /**
     *
     * @param A
     * @return
     */
    public static int singleNumber(int[] A) {
        int ones = 0, twos = 0;
        for (int i = 0; i < A.length; i++) {
            ones = (ones ^ A[i]) & ~twos;
            twos = (twos ^ A[i]) & ~ones;
            System.out.println(ones + " " + twos);
        }
        return ones;
    }

    public static void main(String[] args) {
        String[] array = new String[2];
        List<String> list2 = Arrays.asList(array);
        list2.add("test");
    }
}
