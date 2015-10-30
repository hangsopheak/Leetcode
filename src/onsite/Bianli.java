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
class Content {

    int id;
    int value;

    public Content(int id, int value) {
        this.id = id;
        this.value = value;
    }
}

public class Bianli {

    static double[] possibility = {1, 0.8, 0.75, 0.5, 0.3, 0.2};
    static ArrayList<Content> area1 = new ArrayList<>();
    static ArrayList<Content> area2 = new ArrayList<>();
    static ArrayList<Content> area3 = new ArrayList<>();
    static ArrayList<Content> area4 = new ArrayList<>();
    static ArrayList<Content> area5 = new ArrayList<>();
    static ArrayList<Content> area6 = new ArrayList<>();

    public static void getCandidates() {
        Content c1 = new Content(1, 100);
        Content c2 = new Content(2, 80);
        area1.add(c1);
        area1.add(c2);
        area2.add(c1);
        area2.add(new Content(3, 40));
        area1.add(null);
        area2.add(null);
        area3.add(null);
        area4.add(null);
        area5.add(null);
        area6.add(null);
    }

    public static void selection() {
        getCandidates();
        String result = "";
        double max = 0;
        for (Content i : area1) {
            HashSet<Content> hash = new HashSet<>();
            if (i != null) {
                hash.add(i);
            }
            for (Content j : area2) {
                if (hash.contains(j)) {
                    continue;
                }
                if (j != null) {
                    hash.add(j);
                }
                for (Content k : area3) {
                    if (hash.contains(k)) {
                        continue;
                    }
                    if (k != null) {
                        hash.add(k);
                    }
                    for (Content l : area4) {
                        if (hash.contains(l)) {
                            continue;
                        }
                        if (l != null) {
                            hash.add(l);
                        }
                        for (Content m : area5) {
                            if (hash.contains(m)) {
                                continue;
                            }
                            if (m != null) {
                                hash.add(m);
                            }
                            for (Content n : area6) {
                                if (hash.contains(n)) {
                                    continue;
                                }
                                double tmp = sumSixArea(i, j, k, l, m, n);
                                if (tmp > max) {
                                    max = tmp;
                                    result = i + " " + j + " " + k + " " + l + " " + m + " " + n;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(result);
        System.out.println(max);
    }

    public static double sumSixArea(Content i, Content j, Content k, Content l, Content m, Content n) {
        double result = 0;
        if (i != null) {
            result += i.value * possibility[0];
        }
        if (j != null) {
            result += j.value * possibility[1];
        }
        if (k != null) {
            result += k.value * possibility[2];
        }
        if (l != null) {
            result += l.value * possibility[3];
        }
        if (m != null) {
            result += m.value * possibility[4];
        }
        if (n != null) {
            result += n.value * possibility[5];
        }
        return result;
    }

    public static void main(String[] args) {
        selection();
    }
}
