package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    Map<Character, TrieNode> children;
    boolean endOfWord;
    int value;

    public TrieNode() {
        children = new HashMap<>();
        endOfWord = false;
    }
}