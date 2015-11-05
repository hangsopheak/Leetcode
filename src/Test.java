
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
public class Test {

    /**
     * Return the encode string for input
     *
     * @param input
     * @return
     */
    static String Encode(String input) {
        StringBuilder sb = new StringBuilder();
        int length = input.length();
        for (int i = 0; i < length; i++) {
            char current = input.charAt(i);
            int current_count = 1;
            while (i + 1 < length && current == input.charAt(i + 1)) {
                current_count++;
                i++;
            }
            if (Character.isDigit(current) || current_count > 3) {
                sb.append(current_count);
                sb.append('*');
                sb.append(current);
            } else {
                for (int j = 0; j < current_count; j++) {
                    sb.append(current);
                }
            }
        }

        return sb.toString();
    }

    /**
     * Return the decode string for input
     *
     * @param input
     * @return
     */
    static String Decode(String input) {
        StringBuilder sb = new StringBuilder();

        int length = input.length();
        for (int i = 0; i < length; i++) {
            char current = input.charAt(i);
            StringBuilder number_sb = new StringBuilder();

            while (Character.isDigit(current)) {
                number_sb.append(current);
                i++;
                current = input.charAt(i);
            }

            if (number_sb.toString().length() > 0 && current == '*') {
                current = input.charAt(++i);
                int number = Integer.parseInt(number_sb.toString());
                for (int j = 0; j < number; j++) {
                    sb.append(current);
                }
            } else {
                sb.append(current);
            }
        }

        return sb.toString();
    }

    /**
     * For test only
     *
     * @param args
     */
    static int countDuplicates(int[] input) {
        int result = 0;
        for (int i = 0; i < input.length; i++) {
            input[i] = Math.abs(input[i]);
        }
        for (int i : input) {
            int j = Math.abs(i);
            if (input[j - 1] < 0) {
                result++;
            } else {
                input[j - 1] *= -1;
            }
        }
        return result;
    }

    static String compress(char[] input) {
        int end = 0;
        int length = input.length;
        int count = 1;
        for (int i = 0; i < length - 1; i++) {
            if (input[i] == input[i + 1]) {
                count++;
            } else {
                if (count > 1) {
                    input[end++] = (char) (count + '0');
                    input[end++] = input[i];
                } else {
                    input[end++] = input[i];
                }
                count = 1;
            }
        }
        if(count == 1){
            input[end++] = input[length -1];
        }else{
            input[end++] = (char) (count + '0');
            input[end++] = input[length -1];
        }
        return new String(Arrays.copyOfRange(input, 0, end));
    }

    public static void main(String[] args) {
        char[] ary = {'B', 'B', 'B', 'B', 'c', 'c', 'c', 'D', 'D', 'D'};
        System.out.println(compress(ary));
    }
}
