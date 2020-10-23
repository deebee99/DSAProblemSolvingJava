package LeetCode;

//wrong solution
public class ImageOverlap {
    private int n;
    public int largestOverlap(int[][] a, int[][] b) {
    n=a.length;
    int maxCount=0;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            maxCount=Math.max(maxCount,count(a,b,i,j));
        }
    }
    return maxCount;
    }

    private int count(int[][] a, int[][] b, int i, int j) {
        int count=0;
        int bRow,bCol,aRow=i,aCol=j;
        for(bRow=0;bRow<n;bRow++){
            aCol=j;
            for(bCol=0;bCol<n;bCol++){
                if(b[bRow][bCol]==1 && a[aRow][aCol]==1) count++;
                aCol=(aCol+1)%n;
            }
            aRow=(aRow+1)%n;
        }
        return count;
    }
}
