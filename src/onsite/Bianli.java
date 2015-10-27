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
        Content c3 = new Content(3, 75);
        area1.add(c1);
        area1.add(c2);
        area2.add(c1);
        area3.add(c1);
        area3.add(c3);
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
        for (int i = 0; i < area1.size(); i++) {
            HashSet<Content> hash = new HashSet<>();
            if (area1.get(i) != null) {
                hash.add(area1.get(i));
            }
            for (int j = 0; j < area2.size(); j++) {
                if (hash.contains(area2.get(j))) {
                    continue;
                }
                if (area2.get(j) != null) {
                    hash.add(area2.get(j));
                }
                for (int k = 0; k < area3.size(); k++) {
                    if (hash.contains(area3.get(k))) {
                        continue;
                    }
                    if (area3.get(k) != null) {
                        hash.add(area3.get(k));
                    }
                    for (int l = 0; l < area4.size(); l++) {
                        if (hash.contains(area4.get(l))) {
                            continue;
                        }
                        if (area4.get(l) != null) {
                            hash.add(area4.get(l));
                        }
                        for (int m = 0; m < area5.size(); m++) {
                            if (hash.contains(area5.get(m))) {
                                continue;
                            }
                            if (area5.get(m) != null) {
                                hash.add(area5.get(m));
                            }
                            for (int n = 0; n < area6.size(); n++) {
                                if (hash.contains(area6.get(n))) {
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

    public static double sumSixArea(int i, int j, int k, int l, int m, int n) {
        double result = 0;
        if (area1.get(i) != null) {
            result += area1.get(i).value * possibility[0];
        }
        if (area2.get(j) != null) {
            result += area2.get(j).value * possibility[1];
        }
        if (area3.get(k) != null) {
            result += area3.get(k).value * possibility[2];
        }
        if (area4.get(l) != null) {
            result += area4.get(l).value * possibility[3];
        }
        if (area5.get(m) != null) {
            result += area5.get(m).value * possibility[4];
        }
        if (area6.get(n) != null) {
            result += area6.get(n).value * possibility[5];
        }
        return result;
    }

    public static void main(String[] args) {
        selection();
    }
}
