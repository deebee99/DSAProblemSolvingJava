package LeetCode;

import java.util.ArrayDeque;
import java.util.Queue;

public class RecentCounter {
    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        queue.add(t);
        while (queue.peek() < (t - 3000)) queue.poll();
        return queue.size();
    }
}
