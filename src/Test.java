
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
public class Test {
//00
    public static int[] solution(int[] f, int[] m) {
        HashMap<Integer, Integer> female = new HashMap<>();
        int flength = f.length;
        int mlength = m.length;
        int[] result = new int[flength];
        int count = 0;
        for (int i = 0; i < f.length; i++) {
            if (female.containsKey(f[i])) {
                female.put(f[i], female.get(f[i]) + 1);
            } else {
                female.put(f[i], 1);
            }
        }
        for (int i = 0; i < mlength; i++) {
            if (female.containsKey(m[i])) {
                if (female.get(m[i]) == 1) {
                    female.remove(m[i]);
                } else {
                    female.put(m[i], female.get(m[i]) - 1);
                }
                result[count] = m[i];
                count++;
            }
        }
        result = Arrays.copyOfRange(result, 0, count);
        Arrays.sort(result);
        for (int i = 0; i < count / 2; i++) {
            int tmp = result[i];
            result[i] = result[count - i - 1];
            result[count - i - 1] = tmp;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] f = {200, 300, 250, 400, 250};
        int[] m = {200, 250, 350, 400};
        int[] result = solution(f, m);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
