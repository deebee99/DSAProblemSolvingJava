public class SumofRootToLeafBinaryNumbers {
    private int sum=0;
    public int sumRootToLeaf(TreeNode root) {
        if(root==null) return 0;
        StringBuilder s=new StringBuilder("");
        traverse(root,s);
        return sum;
    }

    private void traverse(TreeNode root, StringBuilder s) {
        if(root==null) return;
        s.append(root.val==0 ? '0' : '1');
        if(root.left==null && root.right==null){
            sum+=Integer.parseInt(s.toString(),2);
            s.deleteCharAt(s.length()-1);
            return;
        }
        traverse(root.left,s);
        traverse(root.right,s);
        s.deleteCharAt(s.length()-1);
    }
}
