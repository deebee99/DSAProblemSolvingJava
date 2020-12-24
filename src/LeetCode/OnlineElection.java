package LeetCode;

import java.util.HashMap;
import java.util.TreeMap;

public class OnlineElection {
    class TopVotedCandidate {
        private TreeMap<Integer, Integer> map;

        public TopVotedCandidate(int[] persons, int[] times) {
            this.map = new TreeMap<>();
            int cur = persons[0];
            int flag = 0;
            map.put(times[0], persons[0]);
            HashMap<Integer, Integer> temp = new HashMap<>();
            temp.put(persons[0], 1);
            for (int i = 1; i < persons.length; i++) {
                temp.put(persons[i], temp.getOrDefault(persons[i], 0) + 1);
                if (temp.get(persons[i]) >= temp.get(cur)) {
                    flag = 1;
                    cur = persons[i];
                }
                if (flag == 1)
                    map.put(times[i], cur);
            }
        }

        public int q(int t) {
            int key = map.floorKey(t);
            return map.get(key);
        }
    }
/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
}
