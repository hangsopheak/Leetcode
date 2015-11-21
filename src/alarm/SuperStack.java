/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alarm;

import java.util.*;

/**
 *
 * @author SONGSONG
 */
public class SuperStack {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numCommands = input.nextInt();
        List<Integer> stack = new ArrayList<>();
        input.nextLine();

        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < numCommands; i++) {
            String curLine = input.nextLine();
            String[] s = curLine.split(" ");
            int size = stack.size();

            if (s[0].charAt(1) == 'u') {
                int num = Integer.parseInt(s[1]);
                stack.add(num);
                size++;
            } else if (s[0].charAt(1) == 'o' && size > 0) {
                if (map.containsKey(size)) {
                    if (map.containsKey(size - 1)) {
                        map.put(size - 1, map.get(size) + map.get(size - 1));
                    } else {
                        map.put(size - 1, map.get(size));
                    }
                    map.remove(size);
                }
                stack.remove(size - 1);
                size--;
            } else if (s[0].charAt(1) == 'n') {
                int count = Integer.parseInt(s[1]);
                long increase = Long.parseLong(s[2]);

                if (map.containsKey(count)) {
                    map.put(count, increase + map.get(count));
                } else {
                    map.put(count, increase);
                }
            }

            if (stack.isEmpty()) {
                map.clear();
                System.out.println("EMPTY");
            } else {
                if (map.containsKey(size)) {
                    System.out.println(stack.get(size - 1) + map.get(size));
                } else {
                    System.out.println(stack.get(size - 1));
                }
            }
        }
    }
}
