package com.zlz.problems.tree.trie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

import com.data.util.StringUtils;

/**
 * 字典树
 */
public class Trie {

  private TrieNode root = new TrieNode();

  class TrieNode {
    public TrieNode[] childNodes;
    /// 词频统计
    public int freq;
    /// 记录该节点的字符
    private char nodeChar;
    /// 插入记录时的编码id
    public HashSet<Integer> hashSet = new HashSet<Integer>();

    /// 初始化
    public TrieNode() {
      // 26个字符，也就是26叉树
      childNodes = new TrieNode[26];
      freq = 0;
    }

    public char getNodeChar() {
      return nodeChar;
    }

    public void setNodeChar(char nodeChar) {
      this.nodeChar = nodeChar;
    }
  }

  public void addTrieNode(String word, int id) {
    addTrieNode(root, word, id);
  }

  // 插入操作
  private void addTrieNode(TrieNode root, String word, int id) {
    if (StringUtils.isEmpty(word)) return;

    // 求字符地址，方便将该字符放入到26叉树中的哪一叉中
    int k = word.charAt(0) - 'a';
    // 如果该叉树为空，则初始化
    if (root.childNodes[k] == null) {
      root.childNodes[k] = new TrieNode();
      // 记录下字符
      root.childNodes[k].setNodeChar(word.charAt(0));
    }

    // 该id途径的节点
    root.childNodes[k].hashSet.add(id);

    String nextWord = word.substring(1);
    // 说明是最后一个字符，统计该词出现的次数
    if (nextWord.length() == 0) {
      root.childNodes[k].freq++;
    }
    addTrieNode(root.childNodes[k], nextWord, id);
  }

  public void deleteTrieNode(String word, int id) {
    deleteTrieNode(root, word, id);
  }

  // 删除操作
  public void deleteTrieNode(TrieNode root, String word, int id) {
    if (StringUtils.isEmpty(word)) return;

    char tmp = word.charAt(0);
    int index = tmp - 'a';
    // 如果对应的节点存在
    if (root.childNodes[index] != null) {
      TrieNode node = root.childNodes[index];
      // 铲除对应的编号
      node.hashSet.remove(id);

      String tmp2 = word.substring(1);
      // 如果是最后一个单词，则减去词频
      if (tmp2 == null && node.freq > 0) {
        node.freq--;
      }
      // 删除沿路的节点
      deleteTrieNode(node, tmp2, id);
    }
  }

  /// 检索单词的前缀,返回改前缀的Hash集合
  public HashSet<Integer> SearchTrie(String s) {
    return SearchTrie(this.root, s);
  }

  /// 检索单词的前缀,返回改前缀的Hash集合
  public HashSet<Integer> SearchTrie(TrieNode root, String word) {
    if (word.length() == 0) {
      return null;
    }

    int k = word.charAt(0) - 'a';
    String nextWord = word.substring(1);
    if (nextWord.length() == 0) {
      // 采用动态规划的思想，word最后节点记录这途经的id
      return root.childNodes[k].hashSet;
    } else {
      return SearchTrie(root.childNodes[k], nextWord);
    }
  }

  public int wordCount(String word) {
    return wordCount(this.root, word);
  }

  /// 统计指定单词出现的次数
  public int wordCount(TrieNode root, String word) {
    if (word.length() == 0) return 0;
    int k = word.charAt(0) - 'a';
    String nextWord = word.substring(1);
    if (nextWord.length() == 0) {
      // 采用动态规划的思想，word最后节点记录这途经的id
      return root.childNodes[k].freq;
    } else {
      return wordCount(root.childNodes[k], nextWord);
    }
  }

  /// 修改操作
  public void updateTrieNode(String newWord, String oldWord, int id) {
    updateTrieNode(root, newWord, oldWord, id);
  }

  /// 修改操作
  private void updateTrieNode(TrieNode root, String newWord, String oldWord, int id) {
    // 先删除
    deleteTrieNode(root, oldWord, id);
    // 再添加
    addTrieNode(root, newWord, id);
  }

  public TrieNode getRoot() {
    return root;
  }

  public void setRoot(TrieNode root) {
    this.root = root;
  }

  public static void main(String[] args) throws IOException {
    Trie trie = new Trie();
    File test = new File("test.txt");
    if (!test.exists()) {
      test.createNewFile();
    }

    BufferedReader in = new BufferedReader(new FileReader(test));
    String value = in.readLine();
    while (value != null) {
      String[] spr = value.split(" ");
      if (Character.isAlphabetic(spr[1].charAt(0))) {
        trie.addTrieNode(spr[1].toLowerCase(), Integer.parseInt(spr[0]));
      }
      value = in.readLine();
    }

    HashSet<Integer> go = trie.SearchTrie("go");
    System.out.println(go);

    int goc = trie.wordCount("go");
    System.out.println(goc);
    in.close();
  }
}