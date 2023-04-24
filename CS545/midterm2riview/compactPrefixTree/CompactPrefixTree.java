package CS545.midterm2riview.compactPrefixTree;

import CS545.week6.queue.Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CompactPrefixTree {

    private Node add(String s, Node node) {
        if (node == null) {
            Node newNode = new Node(s);
            newNode.isWord = true;
            return newNode;
        }

        if (s.equals(node.prefix) && node.isWord) {
            return node;
        }
        if (s.equals(node.prefix) && !node.isWord) {
            node.isWord = true;
            return node;
        }

        //recursive case
        String commonPrefix = "";
        commonPrefix = getCommonPrefix(s, node.prefix);

        String suffix = node.prefix.substring(commonPrefix.length());
        String suffixWord = s.substring(commonPrefix.length());

        if (suffix.length() == 0) {
            node.children[suffixWord.charAt(0) - 'a'] = add(suffixWord, node.children[suffixWord.charAt(0) - 'a']);
            return node;
        }

        //condition need to create a new node, only part of prefix and word is in common
        Node newNode = new Node(commonPrefix);
        node.prefix = suffix;
        //handle suffix first
        newNode.children[suffix.charAt(0) - 'a'] = node;
        //handle suffixWord
        if (suffixWord.length() != 0) {
            //add
            newNode.children[suffixWord.charAt(0) - 'a'] =
                add(suffixWord, newNode.children[suffixWord.charAt(0) - 'a']);
        }
        return newNode;
    }

    private String getCommonPrefix(String s, String prefix) {
        int s1 = s.length();
        int s2 = prefix.length();
        int minLength = Math.min(s1, s2);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minLength; i++) {
            if (s.charAt(i) != prefix.charAt(i)) {
                break;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    private boolean check(String s, Node node) {
        if (node == null) {
            return false;
        }
        if (!s.startsWith(node.prefix)) {
            return false;
        }

        if (s.equals(node.prefix) && !node.isWord) {
            return false;
        }
        if (s.equals(node.prefix) && node.isWord) {
            return true;
        }

        String suffix = s.substring(node.prefix.length());
        if (node.children[suffix.charAt(0) - 'a'] == null) {
            return false;
        }

        return check(suffix, node.children[suffix.charAt(0) - 'a']);
    }

    public boolean checkPrefix(String prefix, Node node) {
        if (node == null) {
            return false;
        }
        if (node.prefix.startsWith(prefix)) {
            return true;
        }
        if (!node.prefix.startsWith(prefix) && !prefix.startsWith(node.prefix)) {
            return false;
        }

        String remainPrefix = prefix.substring(node.prefix.length());
        return checkPrefix(remainPrefix, node.children[remainPrefix.charAt(0) - 'a']);
    }

    private boolean isLeaf(Node node) {
        for (int i = 0; i < node.children.length; i++) {
            if (node.children[i] != null) {
                return false;
            }
        }
        return true;
    }

    public String toString(Node node, int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append(" ");
        }
        sb.append(node.prefix);
        if (node.isWord) {
            sb.append("*");
        }
        sb.append("\n");

        for (int i = 0; i < node.children.length; i++) {
            if (node.children[i] == null) {
                continue;
            }
            sb.append(toString(node.children[i], indent + 1));
        }

        return sb.toString();
    }

    public void printTree(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String word = br.readLine();

            while (word != null) {
                //
                word = br.readLine();
            }



            FileWriter fw = new FileWriter(filename);
            Node root = null;
            fw.write(toString(root, 0));
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean checkPrefix1(String prefix, Node node) {
        if (node == null) {
            return false;
        }
//        else if (node.prefix.equals(prefix)) {
        else if (node.prefix.equals(prefix) && node.isWord) {
            return true;
        }
        else if (node.prefix.startsWith(prefix)) {
//            int index = ((int) node.prefix.charAt(prefix.length())) - ((int) 'a');
            int index = node.prefix.charAt(prefix.length()) - 'a';
            return checkPrefix1(node.prefix.substring(prefix.length()), node.children[index]);
        }
        else {
            return false;
        }
    }
}
