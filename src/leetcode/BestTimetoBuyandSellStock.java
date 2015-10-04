/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author SONGSONG
 */
public class BestTimetoBuyandSellStock {

    public int maxProfit(int[] prices) {
        int result = 0;
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            max = max + prices[i + 1] - prices[i];
            if (max >= 0) {
                if (max > result) {
                    result = max;
                }
            } else {
                max = 0;
            }
        }
        return result;
    }
}
