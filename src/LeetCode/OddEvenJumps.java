package LeetCode;

import java.util.TreeMap;

public class OddEvenJumps {
    class Solution {
        public int oddEvenJumps(int[] nums) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int n = nums.length;
            if (n <= 1) return n;
            int odd[] = new int[n];
            int even[] = new int[n];
            map.put(nums[n - 1], n - 1);

            for (int i = n - 2; i > 0; i--) {
                even[i] = map.floorKey(nums[i]) != null ? map.get(map.floorKey(nums[i])) : -1;
                odd[i] = map.ceilingKey(nums[i]) != null ? map.get(map.ceilingKey(nums[i])) : -1;
                map.put(nums[i], i);
            }
            int count = 1;
            for (int i = 0; i < n - 1; i++) {
                int flag = 0;
                int jump = odd[i];
                while (jump != -1 && jump != n - 1) {
                    if (flag == 0) {
                        jump = even[jump];
                        flag = 1;
                    } else {
                        jump = odd[jump];
                        flag = 0;
                    }
                }
                if (jump == n - 1) count++;
            }
            return count;
        }

    }
}