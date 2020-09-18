import java.util.List;

public class replaceWords {
    private class Trie {
        private final TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public TrieNode getRoot() {
            return root;
        }
    }

    private class TrieNode {
        TrieNode children[];
        boolean endOfWord;

        public TrieNode() {
            children = new TrieNode[27];
            endOfWord = false;
        }
    }

    private void insert(TrieNode root, String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            final char ch = word.charAt(i);
            TrieNode node = cur.children[ch - 'a'];
            if (node == null) cur.children[ch - 'a'] = new TrieNode();
            cur = cur.children[ch - 'a'];
        }
        cur.endOfWord = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie=new Trie();
        TrieNode root=trie.getRoot();
        for(String s : dictionary) insert(root,s);
        String ans="";

        for(String s : sentence.split(" ")) ans+=wordBreak(root,s)+" ";

        return ans.trim();
    }

    private String wordBreak(TrieNode root, String s) {
        TrieNode cur=root;
        String replaceString="";
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            replaceString+=ch;
            TrieNode node=cur.children[ch-'a'];
            if(node==null) return s;
            if(node.endOfWord) return replaceString;
            cur=node;
        }
        return s;
    }

}
