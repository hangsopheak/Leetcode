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
public class BestTimetoBuyandSellStockII {

    public int maxProfit(int[] prices) {
        int length = prices.length;
        int result = 0;
        for (int i = 0; i < length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                result = result + prices[i + 1] - prices[i];
            }
        }
        return result;
    }
}
