public class VideoStitching {
    public int videoStitching(int[][] clips, int T) {
        int[] arr = new int[101];

        for (int[] clip : clips) arr[clip[0]] = Math.max(arr[clip[0]], clip[1]);

        for (int i = 1; i < T + 1; i++)
            arr[i] = Math.max(arr[i], arr[i - 1]);

        int steps = 0;

        int start = 0;
        while (true) {
            int lastNum = arr[start];
            if (lastNum <= start) return -1;
            start = lastNum;
            steps++;
            if (lastNum >= T) return steps;
        }
    }
}
