public class ImplementTrie_PrefixTree {
    class Trie {

        private class TrieNode {
            TrieNode children[];
            boolean endOfWord;

            public TrieNode() {
                children = new TrieNode[27];
                endOfWord = false;
            }
        }

        TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {

            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                final char ch = word.charAt(i);
                TrieNode node = cur.children[ch - 'a'];
                if (node == null) cur.children[ch - 'a'] = new TrieNode();
                cur = cur.children[ch - 'a'];
            }
            cur.endOfWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                final char ch = word.charAt(i);
                TrieNode node = cur.children[ch - 'a'];
                if (node == null) return false;
                cur = cur.children[ch - 'a'];
            }
            return cur.endOfWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode cur = root;
            for (int i = 0; i < prefix.length(); i++) {
                final char ch = prefix.charAt(i);
                TrieNode node = cur.children[ch - 'a'];
                if (node == null) return false;
                cur = cur.children[ch - 'a'];
            }
            return true;
        }
    }
}