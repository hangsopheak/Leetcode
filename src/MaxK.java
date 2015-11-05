
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SONGSONG
 */
public class MaxK {

    public static int[] maxSlidingWindow(int[] a, int k) {
        if (a == null || k <= 0) {
            return null;
        }
        int n = a.length;
        int[] r = new int[n - k + 1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peekFirst() < i - k + 1) {
                q.pollFirst();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.addLast(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peekFirst()];
            }
        }
        return r;
    }

    public void sortColors(int A[]) {
        int second = A.length - 1, zero = 0;
        for (int i = 0; i <= second; i++) {
            if (A[i] == 2 && i < second) {
                int tmp = A[i];
                A[i] = A[second];
                A[second--] = tmp;
            }
            if (A[i] == 0 && i > zero) {
                int tmp = A[i];
                A[i] = A[zero];
                A[zero++] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 9, 7, 4, 6, 8, 4};
        int[] result = maxSlidingWindow(nums, 5);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
    }
}
