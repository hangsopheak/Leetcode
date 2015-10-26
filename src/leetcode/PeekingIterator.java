/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.*;

/**
 *
 * @author SONGSONG
 */
class PeekingIterator implements Iterator<Integer> {

    private Integer next = null;
    private Iterator<Integer> iter;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
        if (iter.hasNext()) {
            next = iter.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    /** 
     * 
     * @return next element without move next
     */
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer tmp = next;
        next = iter.hasNext() ? iter.next() : null;
        return tmp;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
