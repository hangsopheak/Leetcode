
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SONGSONG
 */
public class test2 {

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for (int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = x;
            for(int j : dp){
                System.out.print(j + " ");
            }
            System.out.println();
            if (i == len) {
                len++;
            }
        }
        return len;
    }
    public static void main(String[] args) {
        int[] nums = {8, 10, 12};
        System.out.println(Arrays.binarySearch(nums,  9));
        lengthOfLIS(nums);
    }
}
