package CS545.Midterm2Review;

import CS545.week6.queue.Node;

public class CompactPrefixTree {
  private Node add(String s, Node node) {
    if (node == null) {
      //if node is null, create a node
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
    commonPrefix = gerCommonPrefix(s, node.prefix);
    Node newNode = new Node(commonPrefix);

    String suffix = node.prefix.substring(commonPrefix.length());
    String suffixWord = s.substring(commonPrefix.length());

    if (suffixWord.length() == 0) {
      int firstCharInt = suffixWord.charAt(0) - 'a';
      newNode.children[firstCharInt] = add(suffixWord, newNode.children[firstCharInt]);
      return newNode;
    } else {
      //if suffixWord.length() not 0
      node.prefix = suffix;
      newNode.children[suffix.charAt(0) - 'a'] = node;
      newNode.children[suffixWord.charAt(0) - 'a'] = add(suffixWord,  newNode.children[suffixWord.charAt(0) - 'a']);
      return newNode;
    }
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

    //recursive case
    String suffix = s.substring(node.prefix.length());
    if (node.children[suffix.charAt(0) - 'a'] == null) {
      return false;
    }

    return check(suffix, node.children[suffix.charAt(0) - 'a']);
  }

  private String gerCommonPrefix(String s, String prefix) {
    return "";
  }
}
