public class LongestWordInTheDictionary {
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        String longestString = "";
        TrieNode root = trie.getRoot();
        for (String word : words) {
            insert(root, word);
        }
        for (int i = 0; i < words.length; i++) {
            if (search(root, words[i])) {
                if (words[i].length() > longestString.length() ||
                        ((words[i].length() == longestString.length()) && words[i].compareTo(longestString) < 1))
                    longestString = words[i];
            }
        }


        return longestString;
    }

    private boolean search(TrieNode root, String word) {
        TrieNode cur = root;
        int len = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!cur.children.get(ch).endOfWord) break;
            len++;
            cur = cur.children.get(ch);
        }
        return len == word.length();
    }

    private void insert(TrieNode root, String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            final char ch = word.charAt(i);
            TrieNode node = cur.children.get(ch);
            if (node == null) cur.children.put(ch, new TrieNode());
            cur = cur.children.get(ch);
        }
        cur.endOfWord = true;
    }
}
