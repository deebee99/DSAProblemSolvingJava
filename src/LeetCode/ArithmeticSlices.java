package LeetCode;

public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] arr) {
    int diff=Integer.MIN_VALUE;
    int n=arr.length;
    int start=-1,end=-1;
    if(n<=2) return 0;

    for(int i=1;i<n;i++){
    if(arr[i]-arr[i-1]==arr[i+1]-arr[i]){
        start=i-1;
    }
    }

        return 0;
    }
}
