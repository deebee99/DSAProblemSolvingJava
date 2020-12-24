package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RankTeamsByVotes {
    public String rankTeams(String[] votes) {
        int n = votes[0].length();
        int present[] = new int[26];
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add(new int[n + 1]);
            list.get(i)[n] = i;
        }
        for (String vote : votes) {
            for (int i = 0; i < n; i++) {
                present[vote.charAt(i) - 'A'] = 1;
                list.get(vote.charAt(i) - 'A')[i]++;
            }
        }
        Collections.sort(list, (a, b) -> {
            int i = 0;
            for (; i < n; i++) {
                if (a[i] != b[i]) break;
            }
            if (i != n) return b[i] - a[i];
            return a[i] - b[i];

        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (present[list.get(i)[n]] == 1)
                sb.append((char) ('A' + list.get(i)[n]));
        }
        return sb.toString();
    }
}
