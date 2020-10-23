package LeetCode;

public class WordDictionary {
    Trie trie;

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
            children = new TrieNode[26];
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


    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        trie = new Trie();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        insert(trie.getRoot(), word);
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return search(trie.getRoot(), word, 0);
    }

    public boolean search(TrieNode cur, String word, int ind) {
        if (ind == word.length()) return cur.endOfWord;

        if (word.charAt(ind) == '.') {
            for (int i = 0; i < 26; i++) {
                if (cur.children[i] != null)
                    if (search(cur.children[i], word, ind + 1)) return true;
            }
            return false;
        } else {
            if (cur.children[word.charAt(ind) - 'a'] == null) return false;
            return search(cur.children[word.charAt(ind) - 'a'], word, ind + 1);
        }
    }
}