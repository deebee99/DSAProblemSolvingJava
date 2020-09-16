public class MaximumXOROfTwoNumbersInAnArray {
    public int findMaximumXOR(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int ans = 0;
        Trie trie = new Trie();
        TrieNode root = trie.getRoot();
        for (int i = 0; i < n; i++) {
            insert(root, nums[i]);
            ans = Math.max(ans, findMaxXOPair(root, nums[i]));
        }
        return ans;
    }

    private int findMaxXOPair(TrieNode root, int prefix) {
        TrieNode currentNode = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (prefix >> i) & 1;
            char ch = bit == 1 ? '1' : '0';
            char chDesired = ch == '1' ? '0' : '1';
            if (currentNode.children.get(chDesired) != null) {
                currentNode = currentNode.children.get(chDesired);
            } else if (currentNode.children.get(ch) != null) {
                currentNode = currentNode.children.get(ch);
            }
        }
        return currentNode.value ^ prefix;
    }

    private void insert(TrieNode root, int prefix) {
        TrieNode currentNode = root;

        for (int i = 31; i >= 0; i--) {
            int k = (prefix >> i) & 1;
            char bit = k == 1 ? '1' : '0';

            if (currentNode.children.get(bit) == null) currentNode.children.put(bit, new TrieNode());

            currentNode = currentNode.children.get(bit);
        }
        currentNode.value = prefix;
    }

    public static void main(String[] args) {
        int arr[] = {3, 10, 5, 25, 2, 8};
        System.out.println(new MaximumXOROfTwoNumbersInAnArray().findMaximumXOR(arr));
    }
}