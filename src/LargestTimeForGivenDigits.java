import java.util.Map;
import java.util.TreeMap;

public class LargestTimeForGivenDigits {
    public String largestTimeFromDigits(int[] arr) {
        String ans="";
        TreeMap <Integer,Integer> treeMap=new TreeMap<>();
        for(int i:arr){
            treeMap.merge(i, 1, Integer::sum);
        }

        int hourOneKey=2;
            Integer hourOne=treeMap.floorKey(hourOneKey);
        while(hourOne!=null && hourOne>=0){
            ans += hourOne;
            treeMap.compute(hourOne, (key, value) -> (value - 1));
            if (treeMap.get(hourOne) == 0) treeMap.remove(hourOne);
            Integer hourTwoKey = (hourOne == 2) ? 3 : 9;
            Integer hourTwo = treeMap.floorKey(hourTwoKey);
            if (hourTwo != null) {
                ans += hourTwo;
                treeMap.compute(hourTwo, (key, val) -> (val - 1));
                if (treeMap.get(hourTwo) == 0) treeMap.remove(hourTwo);
                ans += ':';
                Integer minOne = treeMap.floorKey(5);
                if (minOne != null) {
                    ans += minOne;
                    treeMap.compute(minOne, (key, val) -> (val - 1));
                    if (treeMap.get(minOne) == 0) treeMap.remove(minOne);
                    ans += treeMap.firstKey();
                }
            }
            if (ans.length() == 5) return ans;
        ans="";
        treeMap.clear();
            for(int i:arr){
                treeMap.merge(i, 1, Integer::sum);
            }
            hourOne=treeMap.floorKey(hourOne-1);
        }

        return new String("");
    }

    public static void main(String[] args) {
        LargestTimeForGivenDigits timeCalc=new LargestTimeForGivenDigits();
        int[] arr={2,0,6,6};
        System.out.println(timeCalc.largestTimeFromDigits(arr));
    }
}
