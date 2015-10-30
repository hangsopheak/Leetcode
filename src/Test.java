
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
    public static void main(String[] args) {
        String input = "222222222222222222222222a**2222222222222dasda22222222222******!***!W!WQW!sadasdite7qw7egskjG";
        String encode = Test.Encode(input);
        String decode = Test.Decode(encode);
        System.out.println(input + "->" + encode + "->" + decode);
        System.out.println("success? " + input.equals(decode));
        System.out.println("rate " + (double) encode.length() / decode.length());
    }
}
