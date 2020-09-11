public class MinimumNumberOfDaysToDisconnectIsland {
    private int n,m;
    private int connectedComponents=0;
    public int minDays(int[][] grid) {

        n=grid.length;
        if(n==0) return 0;
        m=grid[0].length;
        int[][] gridTemp=new int[n][m];
        int row=-1,col=-1,compSize=0;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                gridTemp[i][j]=grid[i][j];

        DFS(grid);
        if(connectedComponents!=1) return 0;

        for(int i=0;i<n;i++) {
            for (int j = 0; j < m; j++) {
                if(i==row && j==col) continue;
                if(grid[i][j]==1){
                    grid[i][j]=0;
                    connectedComponents=0;
                    DFS(grid);
                    if(connectedComponents!=1) return 1;
                    grid[i][j]=1;
                }
            }
        }
        return 2;
    }

    private void DFS(int[][] grid) {
        int visited[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
            if(grid[i][j]==1 && visited[i][j]==0) {
                findConnectedComponent(grid,visited, i, j);
                    connectedComponents++;
                }
            }
            }
    }

    private void findConnectedComponent(int[][] grid, int[][] visited,int i, int j) {
        if(i>=n || i<0 || j>=m || j<0) return;
        if(visited[i][j]==1) return;
        if(grid[i][j]==0) return;
        visited[i][j]=1;

        findConnectedComponent(grid,visited,i+1,j);
        findConnectedComponent(grid,visited,i-1,j);
        findConnectedComponent(grid,visited,i,j+1);
        findConnectedComponent(grid,visited,i,j-1);
        return;
    }
}
