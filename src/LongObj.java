
import java.lang.reflect.Field;
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
class LongObj {

    private int m_length;

    LongObj(int length) {

        m_length = length;

    }

    public static void main(String[] args) {

        final List<Integer> list = new ArrayList<Integer>();

        Collections.addAll(list, 1, 5, 2, 3, 7, 3, 8, 9);

        final Integer pos = Integer.valueOf(3);

        list.remove(pos);

        System.out.println(list);

    }
}
