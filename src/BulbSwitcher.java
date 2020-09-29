public class BulbSwitcher {
    /**
     * O(N^2) solution time limited exceeded.
     * @param n
     * @return
     */
    public int bulbSwitchTLE(int n) {
        boolean isLighted[] = new boolean[n + 1];
        int count = 0;
        for (int i = 1; i <= n; i++)
            for (int j = i; j <= n; j += i)
                isLighted[j] = !isLighted[j];

        for (int i = 1; i <= n; i++)
            if (isLighted[i]) count++;

        return count;
    }

    /**
     * O(sqrt(N)) solution
     */
    public int bulbSwitch(int n){
        int i=1,count=0;
        while(i*i<=n){
            count++;
            i++;
        }
        return count;
    }
}

