package LeetCode;

import java.util.Arrays;

public class ThreeEqualParts {
    private int[] ans = {-1, -1};

    /**
     * TlE solution
     *
     * @param arr
     * @return
     */
    public int[] threeEqualPartsTLE(int[] arr) {
        StringBuilder firstPart = new StringBuilder();
        final int length = arr.length;
        int flag = 0;
        for (int i : arr) {
            if (i == 1) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            ans[0] = 0;
            ans[1] = length - 1;
            return ans;
        }

        for (int i = 0; i < length - 2; i++) {

            if (arr[i] != 0) firstPart.append('1');
            else if (arr[i] == 0 && firstPart.length() > 0) firstPart.append('0');

            int j = i + 1;
            StringBuilder secondPart = new StringBuilder();
            while (j < length - 1 && arr[j] == 0) j++;
            while (j < length - 1) {
                secondPart.append(arr[j++]);
                StringBuilder thirdPart = new StringBuilder();
                int k = j;
                while (k < length && arr[k] == 0) k++;
                while (k < length) thirdPart.append(arr[k++]);

                if (secondPart.toString().equals(firstPart.toString()) && secondPart.toString().equals(thirdPart.toString())) {
                    ans[0] = i + 1;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }

    /**
     * Optimized solution
     * ref : LeetCode solution
     */
    public int[] threeEqualParts(int[] A) {
        int[] IMP = new int[]{-1, -1};
        int N = A.length;

        int S = 0;
        for (int x : A) S += x;
        if (S % 3 != 0) return IMP;
        int T = S / 3;
        if (T == 0)
            return new int[]{0, N - 1};

        int i1 = -1, j1 = -1, i2 = -1, j2 = -1, i3 = -1, j3 = -1;
        int su = 0;
        for (int i = 0; i < N; ++i) {
            if (A[i] == 1) {
                su += 1;
                if (su == 1) i1 = i;
                if (su == T) j1 = i;
                if (su == T + 1) i2 = i;
                if (su == 2 * T) j2 = i;
                if (su == 2 * T + 1) i3 = i;
                if (su == 3 * T) j3 = i;
            }
        }

        // The array is in the form W [i1, j1] X [i2, j2] Y [i3, j3] Z
        // where [i1, j1] is a block of 1s, etc.
        int[] part1 = Arrays.copyOfRange(A, i1, j1 + 1);
        int[] part2 = Arrays.copyOfRange(A, i2, j2 + 1);
        int[] part3 = Arrays.copyOfRange(A, i3, j3 + 1);

        if (!Arrays.equals(part1, part2)) return IMP;
        if (!Arrays.equals(part1, part3)) return IMP;

        // x, y, z: the number of zeros after part 1, 2, 3
        int x = i2 - j1 - 1;
        int y = i3 - j2 - 1;
        int z = A.length - j3 - 1;

        if (x < z || y < z) return IMP;
        return new int[]{j1 + z, j2 + z + 1};
    }
}
