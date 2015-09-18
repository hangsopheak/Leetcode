
import java.util.ArrayList;
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
public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        int length = s.length();
        if (length == 0) {
            return result;
        }
        List<String> start = new ArrayList<>();
        start.add(s.substring(0, 1));
        result.add(start);
        for (int i = 1; i < length; i++) {
            List<List<String>> resulttmp = new ArrayList<List<String>>();
            for (List<String> tmp : result) {
                String tail = s.substring(i, i + 1);
                tmp.add(tail);
                resulttmp.add(new ArrayList<String>(tmp));
                tmp.remove(tail);
                for (int j = tmp.size() - 1; j >= 0; j--) {
                    tail = tmp.get(j).concat(tail);
                    tmp.remove(j);
                    if (tail.charAt(0) == tail.charAt(tail.length() - 1)) {
                        if (isPalindrome(tail)) {
                            tmp.add(tail);
                            resulttmp.add(new ArrayList<String>(tmp));
                        }
                    }
                }
            }
            result = resulttmp;
        }
        return result;
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        if (right == -1 || right == 0) {
            return true;
        }
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aweqwda";
        PalindromePartitioning a = new PalindromePartitioning();
        a.partition(s);
    }
}
