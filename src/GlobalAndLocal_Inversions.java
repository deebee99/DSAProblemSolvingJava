import java.util.TreeSet;

public class GlobalAndLocal_Inversions {

    public boolean isIdealPermutation(int[] A) {
        TreeSet <Integer> treeSet=new TreeSet<>();
        int localInversions=0,globalInversions=0;
        final int n = A.length;
        for(int i = 0; i< n-1; i++)
            if(A[i]>A[i+1]) localInversions++;

            for(int i=0;i<n;i++){
                if(treeSet.ceiling(A[i])!=null){
                    int ceiling=treeSet.ceiling(A[i]);
                    int position=treeSet.headSet(ceiling).size();
                    globalInversions+=treeSet.size()-position;
                    System.out.println("ceiling : "+ceiling);
                }
                System.out.println(localInversions+ " "+globalInversions);
                treeSet.add(A[i]);
            }

        return localInversions==globalInversions;
    }
}
