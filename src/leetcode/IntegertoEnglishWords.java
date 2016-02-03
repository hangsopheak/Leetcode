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
public class IntegertoEnglishWords {

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder result = new StringBuilder();
        String[] level = new String[4];
        level[0] = "";
        level[1] = " Thousand";
        level[2] = " Million";
        level[3] = " Billion";
        int index = 0;
        int[] nums = new int[4];
        for (int i = 0; i < 4 && num != 0; i++) {
            nums[i] = num % 1000;
            num /= 1000;
        }
        for (int i = 3; i >= 0; i--) {
            String tmp = threeDigit(nums[i]);
            if (!tmp.equals("")) {
                result.append(tmp).append(level[i]);
            }
        }
        return result.delete(0, 1).toString();
    }

    public String threeDigit(int num) {
        if (num < 10) {
            return oneDigit(num);
        }
        if (num < 100) {
            return twoDigit(num);
        }
        return oneDigit(num / 100) + " Hundred" + twoDigit(num % 100);
    }

    public String twoDigit(int num) {
        if (num < 10) {
            return oneDigit(num);
        }
        if (num < 20) {
            return tens(num);
        }
        return tys(num / 10) + oneDigit(num % 10);
    }

    public String tys(int num) {
        switch (num) {
            case 2:
                return " Twenty";
            case 3:
                return " Thirty";
            case 4:
                return " Forty";
            case 5:
                return " Fifty";
            case 6:
                return " Sixty";
            case 7:
                return " Seventy";
            case 8:
                return " Eighty";
            case 9:
                return " Ninety";
            default:
                return "";
        }
    }

    public String tens(int num) {
        switch (num) {
            case 10:
                return " Ten";
            case 11:
                return " Eleven";
            case 12:
                return " Twelve";
            case 13:
                return " Thirteen";
            case 14:
                return " Fourteen";
            case 15:
                return " Fifteen";
            case 16:
                return " Sixteen";
            case 17:
                return " Seventeen";
            case 18:
                return " Eighteen";
            case 19:
                return " Nineteen";
            default:
                return "";
        }
    }

    public String oneDigit(int num) {
        switch (num) {
            case 1:
                return " One";
            case 2:
                return " Two";
            case 3:
                return " Three";
            case 4:
                return " Four";
            case 5:
                return " Five";
            case 6:
                return " Six";
            case 7:
                return " Seven";
            case 8:
                return " Eight";
            case 9:
                return " Nine";
            default:
                return "";
        }
    }
}
