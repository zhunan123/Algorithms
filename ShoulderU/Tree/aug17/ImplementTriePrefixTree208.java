package ShoulderU.Tree.aug17;

public class ImplementTriePrefixTree208 {
  class Trie {
    // insert O(N) - n is length of insert word
    // search O(M) - m is length of search word
    // startsWith O(P) - p is length of prefix

    class TrieNode {
      TrieNode[] children;
      boolean isWord;
      String word;

      public TrieNode () {
        children = new TrieNode[26];
        isWord = false;
        word = "";
      }
    }

    private TrieNode root;

    public Trie() {
      root = new TrieNode();
    }

    public void insert(String word) {
      // apple
      TrieNode node = root;
      for (int i = 0; i < word.length(); i++) {
        char ch = word.charAt(i);
        int index = ch - 'a';
        if (node.children[index] == null) {
          node.children[index] = new TrieNode();
        }
        node = node.children[index];
      }
      node.isWord = true;
    }

    public boolean search(String word) {
      TrieNode node = root;
      for (int i = 0; i < word.length(); i++) {
        char ch = word.charAt(i);
        int index = ch - 'a';
        if (node.children[index] == null) {
          return false;
        }
        node = node.children[index];
      }
      if (node.isWord) {
        return true;
      }
      return false;
    }

    public boolean startsWith(String prefix) {
      TrieNode node = root;
      for (int i = 0; i < prefix.length(); i++) {
        char ch = prefix.charAt(i);
        int index = ch - 'a';
        if (node.children[index] == null) {
          return false;
        }
        node = node.children[index];
      }
      return true;
    }
  }
}
