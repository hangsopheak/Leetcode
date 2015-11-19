
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
public class myHashTable<K, V> {

    class Entry<K, V> {

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        K key;
        V value;
    }
    private int size = 0;
    private ArrayList<LinkedList<Entry<K, V>>> ary = new ArrayList<>(size);

    public myHashTable(int size) {
        this.size = size;
        for (int i = 0; i < size; i++) {
            ary.add(i, null);
        }
    }

    public void put(K key, V value) {
        if (key == null) {
            throw new NullPointerException("null of key is not allowed");
        }
        if (ary.get(key.hashCode() % size) == null) {
            ary.add(key.hashCode() % size, new LinkedList<Entry<K, V>>());
        } else {
            LinkedList<Entry<K, V>> res = ary.get(key.hashCode() % size);
            Iterator<Entry<K, V>> iterator = res.iterator();
            while (iterator.hasNext()) {
                Entry<K, V> e = iterator.next();
                if (e.key.equals(key)) {
                    ary.get(key.hashCode() % size).remove(e);
                }
            }
            ary.get(key.hashCode() % size).addFirst(new Entry<K, V>(key, value));
        }
    }

    public V get(K key) {
        if (key == null) {
            throw new NullPointerException("null of key is not allowed");
        }
        if (ary.get(key.hashCode() % size) == null) {
            return null;
        } else {
            LinkedList<Entry<K, V>> res = ary.get(key.hashCode() % size);
            Iterator<Entry<K, V>> iterator = res.iterator();
            while (iterator.hasNext()) {
                Entry<K, V> e = iterator.next();
                if (e.key.equals(key)) {
                    return e.value;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        myHashTable<String, String> m = new myHashTable<>(1000);
        m.put("abc", "eee");
        m.put("abc", "bbb");
        System.out.println(m.get("abc"));
    }
}
