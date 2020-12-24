package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class StreamOfCharacters {

    private class StreamChecker {
        List<Character> characterList;
        private TrieNode root;

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
            TrieNode[] children;
            boolean endOfWord;

            public TrieNode() {
                children = new TrieNode[27];
                endOfWord = false;
            }
        }

        public StreamChecker(String[] words) {
            characterList = new ArrayList<>();
            Trie trie = new Trie();
            root = trie.getRoot();

            for (String s : words) insert(root, s);
        }

        private void insert(TrieNode root, String word) {
            TrieNode cur = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                final char ch = word.charAt(i);
                TrieNode node = cur.children[ch - 'a'];
                if (node == null) cur.children[ch - 'a'] = new TrieNode();
                cur = cur.children[ch - 'a'];
            }
            cur.endOfWord = true;
        }

        public boolean query(char letter) {
            TrieNode cur = root;
            characterList.add(letter);
            for (int i = characterList.size() - 1; i >= 0; i--) {
                TrieNode node = cur.children[characterList.get(i) - 'a'];
                if (node == null) return false;
                if (node.endOfWord) return true;
                cur = node;
            }
            return cur.endOfWord;
        }
    }
}
