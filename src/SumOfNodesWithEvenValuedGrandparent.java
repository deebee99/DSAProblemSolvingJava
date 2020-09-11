import java.util.HashMap;
import java.util.Map;

public class SumOfNodesWithEvenValuedGrandparent {
    private int sum=0;

    public int sumEvenGrandparent(TreeNode root) {
        findGrandParents(root,null,null);
        return sum;
    }

    private void findGrandParents(TreeNode root,TreeNode parent, TreeNode grandParent) {
        if(root==null) return;
        if(grandParent!=null && grandParent.val%2==0){
            sum+=root.val;
        }
        findGrandParents(root.left,root,parent);
        findGrandParents(root.right,root,parent);
    }
}
