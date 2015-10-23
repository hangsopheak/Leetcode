/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onsite;

import java.util.*;

/**
 *
 * @author SONGSONG
 */
class Person {

    int id;
    int name;

    Person(int id) {
        this.id = id;
    }

    boolean equals(Person p) {
        return id == p.id;
    }
}

public class PriorityQ {

    public static void main(String[] args) {

        PriorityQueue tmp = new PriorityQueue(3, new Comparator<Character>() {
            public int compare(Character a, Character b) {
                return a - b;
            }
        });
        tmp.add('1');
        tmp.add('a');
        tmp.add('3');
        tmp.add('2');
        int size = tmp.size();
        for (int i = 0; i < size; i++) {
            System.out.println(tmp.poll());
        }
        Person wan = new Person(1);
        Person wan2 = new Person(2);
        System.out.println(wan.equals(wan2));
        String example = "wan song song";
        String[] as = example.split(" ");
        for (int i = 0; i < as.length; i++) {
            System.out.println(as[i]);
        }
    }
}
