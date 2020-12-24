package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class ProfitableSchemes {
    class Solution {
        private int mod = 1000000007;
        private Map<String, Integer> map = new HashMap<>();

        /**
         * TLE 
         * @param index
         * @param count
         * @param m
         * @param cashRobbedSoFar
         * @param k
         * @param group
         * @param profit
         * @return
         */
        private int calcMaxAmt(int index, int count, int m, int cashRobbedSoFar, int k, int[] group, int[] profit) {

            int ans = 0;
            if (count > m) return 0;
            String s = index + "," + count + "," + cashRobbedSoFar;
            if (index == group.length && count <= m && cashRobbedSoFar >= k) return 1;
            if (index == group.length) return 0;
            if (map.containsKey(s)) return map.get(s);


            ans += calcMaxAmt(index + 1, count, m, cashRobbedSoFar, k, group, profit) % mod;
            ans = ((ans % mod) + (calcMaxAmt(index + 1, count + group[index], m, cashRobbedSoFar + profit[index], k, group, profit)) % mod) % mod;
            map.put(s, ans);
            return ans;
        }

        public int profitableSchemes(int g, int p, int[] group, int[] profit) {
            int profitSum = 0;
            for (int money : profit) profitSum += money;

            return calcMaxAmt(0, 0, g, 0, p, group, profit);
        }
    }
}
