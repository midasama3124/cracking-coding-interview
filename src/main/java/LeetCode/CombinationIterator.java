package LeetCode;

import java.util.*;

class CombinationIterator {
    private String s;
    private Queue<String> q;

    public CombinationIterator(String characters, int combinationLength) {
        this.s = characters;
        this.q = new LinkedList();
        findIter(0, combinationLength, new String());
    }

    public void findIter(int start, int length, String curr) {
        if (length == 0) {
            q.add(curr);
            return;
        }
        for (int i = start; i <= s.length() - length; i++) {
            findIter(i + 1, length - 1, curr + s.charAt(i));
        }
    }

    public String next() {
        return q.poll();
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }
}
