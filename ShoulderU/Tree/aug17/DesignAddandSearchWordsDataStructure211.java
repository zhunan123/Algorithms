package ShoulderU.Tree.aug17;

public class DesignAddandSearchWordsDataStructure211 {
    class TrieNode {
        boolean isWord;
        String word;
        TrieNode[] children;

        public TrieNode () {
            children = new TrieNode[26];
            isWord = false;
            word = "";
        }
    }

    private TrieNode root;

    public DesignAddandSearchWordsDataStructure211 () {
        root = new TrieNode();
    }

    public void addWord(String word) {
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
        // use dfs to do search
        return find(word, root, 0);
    }

    private boolean find(String word, TrieNode node, int word_index) {
        if (node == null) {
            return false;
        }
        if (word_index == word.length()) {
            return node.isWord;
        }

        if (word.charAt(word_index) == '.') {
            // traverse all node's children to find if have children node
            for (TrieNode node2 : node.children) {
                if (find(word, node2, word_index + 1)) {
                    return true;
                }
            }
        } else {
            // regular word
            char ch = word.charAt(word_index);
            int current_index = ch - 'a';
            node = node.children[current_index];
            return find(word, node, word_index + 1);
        }

        return false;
    }
}
