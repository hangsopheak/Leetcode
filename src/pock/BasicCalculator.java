/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pock;

/**
 *
 * @author SONGSONG
 */
public class BasicCalculator {

    int index = 0;

    public int calculate(String s) {
        s = s.replaceAll("\\s", "");
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        long current = 0;
        current = nextNum(s);
        if (index == length) {
            return (int) current;
        }
        char cur = s.charAt(index++);
        while (index < length) {
            long next = nextNum(s);
            if (index == length) {
                if (cur == '*') {
                    current *= next;
                } else if (cur == '/') {
                    current /= next;
                } else if (cur == '+') {
                    current += next;
                } else if (cur == '-') {
                    current -= next;
                }
                return (int) current;
            }
            char nex = s.charAt(index++);
            if (nex == '+' || nex == '-') {
                if (cur == '*') {
                    current *= next;
                } else if (cur == '/') {
                    current /= next;
                } else if (cur == '+') {
                    current += next;
                } else if (cur == '-') {
                    current -= next;
                }
                cur = nex;
            } else {
                if (cur == '*') {
                    next = current * next;
                } else if (cur == '/') {
                    next = current / next;
                }
                while (nex == '*' || nex == '/') {
                    long tmp = nextNum(s);
                    if (nex == '*') {
                        next *= tmp;
                    } else {
                        next /= tmp;
                    }
                    if (index == length) {
                        if (cur == '+') {
                            current += next;
                            return (int) current;
                        } else if (cur == '-') {
                            current -= next;
                            return (int) current;
                        }
                        return (int) next;
                    }
                    nex = s.charAt(index++);
                }
                if (cur == '+') {
                    current += next;
                } else if (cur == '-') {
                    current -= next;
                } else {
                    current = next;
                }
                cur = nex;
            }
        }
        return (int) current;
    }

    public long nextNum(String s) {
        int length = s.length();
        long current = 0;
        char tmp = s.charAt(index);
        while (tmp <= '9' && tmp >= '0') {
            current = current * 10 + Integer.parseInt(s.charAt(index++) + "");
            if (index == length) {
                break;
            }
            tmp = s.charAt(index);
        }
        return current;
    }
}
