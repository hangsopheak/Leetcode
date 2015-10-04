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
public class BestTimetoBuyandSellStockIII {

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int tmp1 = 0;
        int max = 0;
        int mark = 0;
        int count = 0;
        int markc = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            max = max + prices[i + 1] - prices[i];
            count++;
            if (max >= 0) {
                if (max > tmp1) {
                    tmp1 = max;
                    mark = i + 1;
                    markc = count;
                }
            } else {
                max = 0;
                count = 0;
            }
        }
        int tmp2 = Math.max(maxAtOne(prices, 0, mark - markc, true), maxAtOne(prices, mark, prices.length - 1, true));
        tmp2 = Math.max(tmp2, maxAtOne(prices, mark - markc, mark, false));
        return tmp1 + tmp2;
    }

    public int maxAtOne(int[] prices, int start, int end, boolean status) {
        if (prices.length <= 1) {
            return 0;
        }
        int max = 0;
        int result = 0;
        for (int i = start; i < end; i++) {
            if (status) {
                max = max + prices[i + 1] - prices[i];
            } else {
                max = max - prices[i + 1] + prices[i];
            }
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
