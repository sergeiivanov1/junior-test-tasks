package ru.buyanov.hunting;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  @author https://github.com/alex-on-java 03.02.2016
 */
public class IntIterable implements Iterable<Integer> {
    int[] backed;


    public IntIterable(int[] backed) {
        this.backed = backed;
    }

    public Iterator<Integer> iterator() {
        return new IntIterator();
    }

    private class IntIterator implements Iterator<Integer> {
        private int count = 0;
        public boolean hasNext() {
            if(count < backed.length) return true;
            return false;
        }

        public Integer next() {
            if (count == backed.length)
                throw new NoSuchElementException();
            count++;
            return backed[count-1];
        }

        public void remove() {
            throw new IllegalStateException("Could not remove from array");
        }
    }
}
