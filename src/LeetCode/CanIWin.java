package LeetCode;//wrong solution
import java.util.TreeMap;

public class CanIWin {
    TreeMap<Integer,Integer> treeMap=new TreeMap<>();

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    if(desiredTotal==0) return true;
    int total=(maxChoosableInteger*(maxChoosableInteger+1))/2;
    if(total<desiredTotal) return false;
    if(total==desiredTotal) return maxChoosableInteger%2==0;
    for(int i=1;i<=maxChoosableInteger;i++) treeMap.put(i,1);
    return playGame(0,desiredTotal,0);
    }

    private boolean playGame(int curSum, int total,int playerNo) {
//        System.out.println(curSum+ " "+playerNo);
        if(curSum>=total ){
            if(playerNo==0) return true;
            return false;
        }
        boolean ans=false;
        if(treeMap.containsKey(total-curSum) && treeMap.get(total-curSum)==1){
            if(playerNo==0) return true;
            return false;
        }
        if(treeMap.ceilingKey(total-curSum)!=null && treeMap.get(treeMap.ceilingKey(total-curSum))==1){
            if(playerNo==0) return true;
            return false;
        }
        int value=treeMap.lastKey();
        treeMap.remove(value);
            return playGame(curSum+value,total,playerNo==0 ? 1 : 0);
    }

    public static void main(String[] args) {
        CanIWin game=new CanIWin();
        System.out.println(game.canIWin(7,10));

    }
}
