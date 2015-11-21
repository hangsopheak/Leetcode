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
public class Test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int noCommands = in.nextInt();
        in.nextLine();

        List<Integer> stack = new ArrayList();
        for (int i = 0; i < noCommands; ++i) {
            String command = in.nextLine();
            String[] split = command.split(" ");

            if (split[0].equals("push")) {
                int number = Integer.parseInt(split[1]);
                stack.add(0, number);
            } else if (split[0].equals("pop") && stack.size() > 0) {
                stack.remove(0);
            } else if (split[0].equals("inc")) {
                int count = Integer.parseInt(split[1]);
                int increment = Integer.parseInt(split[2]);
                count = Math.min(stack.size(), count);
                int size = stack.size();

                for (int j = 0; j < count; ++j) {
                    stack.set(size - j - 1, stack.get(size - j - 1) + increment);
                }
            }

            if (stack.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(stack.get(0));
            }
        }
    }
}
