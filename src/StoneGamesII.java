//public class StoneGamesII {
//    int maxStones=Integer.MIN_VALUE;
//    public int stoneGameII(int[] piles) {
//        int m=1;
//        for(int i=piles.length-2;i>=0;i--){
//            piles[i]+=piles[i+1];
//        }
//        calc(piles,0,1);
//        return maxStones;
//    }
//
//    private int calc(int[] piles, int ind,int m) {
//        if(ind>=piles.length) return 0;
//        int xMax=2*m,ans=0,sum=0;
//            for (int i = 1; i <= Math.min(piles.length, xMax); i++) {
//                for (int j = ind; j < Math.min(ind + i, piles.length); j++) {
//                   sum+=0;
//
//                }
//                return calc(piles, ind + i,Math.max(m, i));
//            }
//        }
//
//    }
//
//    public static void main(String[] args) {
//        StoneGamesII stoneGamesII=new StoneGamesII();
//        int[] arr={2,18,9,4,4};
//        System.out.println(stoneGamesII.stoneGameII(arr));
//    }
//}
