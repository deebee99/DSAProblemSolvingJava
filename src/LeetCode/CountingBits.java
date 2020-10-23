package LeetCode;

public class CountingBits {
    public int[] countBits(int num) {
        int arr[] = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            String s = Integer.toBinaryString(i);
            for (char ch : s.toCharArray())
                if (ch == '1') arr[i]++;
        }
        return arr;
    }
}
