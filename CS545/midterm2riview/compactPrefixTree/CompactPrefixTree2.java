package CS545.midterm2riview.compactPrefixTree;

import CS545.week6.queue.Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CompactPrefixTree2 {
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

    //recursive
    String commonPrefix = "";
    commonPrefix = getCommonPrefix(s, node.prefix);
    String suffix = node.prefix.substring(commonPrefix.length());
    String suffixWord = s.substring(commonPrefix.length());

//    //suffix == 0, dont need to create newNode; 插abcd进入abc abc是nodeprefix， abcd 是s
//    //就是suffixword length > suffix length
//    if (suffix.length() == 0) {
//      node.children[suffixWord.charAt(0) - 'a'] = add(suffixWord, node.children[suffixWord.charAt(0) - 'a']);
//      return node;
//    }
//
//    //need to create new Node, two condition
//    //condition1, 插 ab进入abc, 没有suffix word, 只有suffix
//    Node newNode = new Node(commonPrefix);
//    node.prefix = suffix;
//    //插入suffix into newNode， 插入suffix c into newNode ab
//    newNode.children[suffix.charAt(0) - 'a'] = node;
//    if (suffixWord.length() == 0) {
//      newNode.isWord = true;
//    }
//
//
//    //condition2, 如果有suffix word，也有suffix， 插入abd进入abc
//    if (suffixWord.length() != 0) {
//      newNode.children[suffixWord.charAt(0) - 'a'] = add(suffixWord, newNode.children[suffixWord.charAt(0) - 'a']);
//    }
//    return newNode;

    //insert abcd into abc
    if (suffix.length() == 0) {
      node.children[suffixWord.charAt(0) - 'a'] = add(suffixWord, node.children[suffixWord.charAt(0) - 'a']);
      return node;
    }

    //insert ab into abc
    Node newNode = new Node(s);
    node.prefix = suffix;
    newNode.children[suffix.charAt(0) - 'a'] = node;
    if (suffixWord.length() == 0) {
      newNode.isWord = true;
    }

    //insert abd into abc   上面已经把c加入ab了，这里只需要把d加入ab
    if (suffixWord.length() != 0) {
      newNode.children[suffixWord.charAt(0) - 'a'] = add(suffixWord, newNode.children[suffixWord.charAt(0) - 'a']);
    }
    return newNode;
  }

  private String getCommonPrefix(String s, String prefix) {
    int s1 = s.length();
    int s2 = prefix.length();
    int minLen = Math.min(s1, s2);

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i< minLen; i++) {
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

    String suffix = prefix.substring(node.prefix.length());
    return checkPrefix(suffix, node.children[suffix.charAt(0) - 'a']);
  }

  private boolean isLeaf(Node node) {
    return false;
  }

  public String toString(Node node, int indent) {
    return "";
  }

  public void printTree(String filename) {

  }

}
