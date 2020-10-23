package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumbersWithRepeatedDigits {
    public int numDupDigitsAtMostN(int N) {
        List<Integer> nums = new ArrayList<>();
        int tempN = N + 1;
        while(tempN != 0){
            nums.add(0,tempN%10);
            tempN/=10;
        }
        int countInvalid = 0;
        for(int i = 0;i<nums.size()-1;i++){
            countInvalid += 9*permutation(9,i);
        }
        int[] isOccupied = new int[10];
        Arrays.fill(isOccupied,-1);
        for(int i = 0;i<nums.size();i++){
            int digit = nums.get(i);
            for(int j = i==0?1:0;j<digit;j++){
                if(isOccupied[j] != -1) continue;
                else countInvalid += permutation(10-(i+1),nums.size()-i-1);
            }
            if(isOccupied[digit] != -1) break;
            isOccupied[digit] = 1;
        }
        return N - countInvalid;
    }
    private int permutation(int n, int c){
        int ans = 1;
        for(int i = 0;i<c;i++,n--) ans *= n;
        return ans;
    }
}
