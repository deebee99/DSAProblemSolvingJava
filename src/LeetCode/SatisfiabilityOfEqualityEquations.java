package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class SatisfiabilityOfEqualityEquations {
    List<Integer>[] adj = new List[26];
    int[] parent = new int[26];
    int[] rank = new int[26];

    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
            adj[i] = new ArrayList<>();
        }
        for (String s : equations) {
            int i = s.charAt(0) - 'a';
            int j = s.charAt(3) - 'a';
            if (s.charAt(2) == '=') {
                union(i, j);
            }
        }
        for (int i = 0; i < 26; i++) {
            find(i);
        }
        for (String s : equations) {
            int i = s.charAt(0) - 'a';
            int j = s.charAt(3) - 'a';
            if (s.charAt(2) == '!') {
                if (parent[i] == parent[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private void union(int i, int j) {
        int pi = find(i);
        int pj = find(j);
        if (pi == pj) return;
        parent[i] = parent[j];
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
