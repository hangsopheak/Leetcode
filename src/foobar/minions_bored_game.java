/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foobar;

import java.math.BigInteger;
import java.util.Arrays;

/**
 *
 * @author SONGSONG Minion's bored game ===================
 *
 * There you have it. Yet another pointless "bored" game created by the bored
 * minions of Professor Boolean.
 *
 * The game is a single player game, played on a board with n squares in a
 * horizontal row. The minion places a token on the left-most square and rolls a
 * special three-sided die.
 *
 * If the die rolls a "Left", the minion moves the token to a square one space
 * to the left of where it is currently. If there is no square to the left, the
 * game is invalid, and you start again.
 *
 * If the die rolls a "Stay", the token stays where it is.
 *
 * If the die rolls a "Right", the minion moves the token to a square, one space
 * to the right of where it is currently. If there is no square to the right,
 * the game is invalid and you start again.
 *
 * The aim is to roll the dice exactly t times, and be at the rightmost square
 * on the last roll. If you land on the rightmost square before t rolls are done
 * then the only valid dice roll is to roll a "Stay". If you roll anything else,
 * the game is invalid (i.e., you cannot move left or right from the rightmost
 * square).
 *
 * To make it more interesting, the minions have leaderboards (one for each n,t
 * pair) where each minion submits the game he just played: the sequence of dice
 * rolls. If some minion has already submitted the exact same sequence, they
 * cannot submit a new entry, so the entries in the leader-board correspond to
 * unique games playable.
 *
 * Since the minions refresh the leaderboards frequently on their mobile
 * devices, as an infiltrating hacker, you are interested in knowing the maximum
 * possible size a leaderboard can have.
 *
 * Write a function answer(t, n), which given the number of dice rolls t, and
 * the number of squares in the board n, returns the possible number of unique
 * games modulo 123454321. i.e. if the total number is S, then return the
 * remainder upon dividing S by 123454321, the remainder should be an integer
 * between 0 and 123454320 (inclusive).
 *
 * n and t will be positive integers, no more than 1000. n will be at least 2.
 *
 *
 * Languages =========
 *
 * To provide a Python solution, edit solution.py To provide a Java solution,
 * edit solution.java
 *
 * Test cases ==========
 *
 * Inputs: (int) t = 1 (int) n = 2 Output: (int) 1
 *
 * Inputs: (int) t = 3 (int) n = 2 Output: (int) 3
 *
 */
public class minions_bored_game {

    static final BigInteger MODULO = new BigInteger("123454321");
    
    public static int answer(int t, int n) {
        BigInteger[] current = new BigInteger[n];
        BigInteger[] last = new BigInteger[n];
        Arrays.fill(current, BigInteger.ZERO);
        Arrays.fill(last, BigInteger.ZERO);
        current[n - 1] = BigInteger.ONE;
        
        for (int a = 0; a < t; a++) {
            BigInteger[] tmp = last;
            last = current;
            current = tmp;
            
            for (int b = 0; b < n; b++) {
                current[b] = last[b];
                if (b + 1 == n) {
                    continue;
                }
                if (b != 0) {
                    current[b] = current[b].add(last[b - 1]);
                }
                current[b] = current[b].add(last[b + 1]);
            }
        }
        
        return current[0].remainder(MODULO).intValue();
    }
    
    public static void main(String[] args) {
        System.out.println(answer(50, 20));
    }
}
