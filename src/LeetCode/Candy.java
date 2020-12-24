package LeetCode;

import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {

        final int length = ratings.length;
        if (length == 1) return 1;

        int candyCount[] = new int[length];
        Arrays.fill(candyCount, 1);

        for (int i = 1; i < length; i++)
            if (ratings[i] > ratings[i - 1])
                candyCount[i] = candyCount[i - 1] + 1;

        int candyNeeded = candyCount[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                candyCount[i] = Math.max(candyCount[i], candyCount[i + 1] + 1);
            candyNeeded += candyCount[i];
        }

        return candyNeeded;
    }
}
