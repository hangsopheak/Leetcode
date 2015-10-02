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
public class HIndexII {

    public int hIndex(int[] citations) {
        int length = citations.length;
        if (length == 0) {
            return 0;
        }
        if (citations[length - 1] == 0) {
            return 0;
        }
        if (citations[0] >= length) {
            return length;
        }
        int left = 1;
        int right = length;
        int mid = 0;
        while (right > left) {
            mid = left + (right - left) / 2;
            if (citations[length - mid] < mid) {
                right = mid - 1;
            } else if (citations[length - mid] > mid) {
                if (citations[length - mid - 1] <= mid) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else {
                return mid;
            }
        }
        return left;
    }
}
