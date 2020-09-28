public class carPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        int passengers[] = new int[1001];
        for (int i = 0; i < n; i++)
            for (int j = trips[i][1]; j < trips[i][2]; j++)
                passengers[j] += trips[i][0];

        for (int i = 0; i < 1001; i++)
            if (passengers[i] > capacity) return false;

        return true;
    }
}
