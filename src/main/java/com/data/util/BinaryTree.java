package com.data.util;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author zhailz
 * @Date 2017年8月20日 - 上午10:38:02
 * @Doc: 二叉树的一些操作
 */
public class BinaryTree<E> {
  private TreeNode root = null;

  public static void main(String[] args) {
    List<String> collect = new ArrayList<String>();
    collect.add("a");
    collect.add("b");
    collect.add("c");
    collect.add("null");
    collect.add("d");
    collect.add("e");
    collect.add("f");
    collect.add("null");
    collect.add("null");
    collect.add("g");
    collect.add("h");
    BinaryTree<String> tree = new BinaryTree<String>(collect);
    System.out.println(tree.toFirstString());
    System.out.println(tree.toMiddleString());
    System.out.println(tree.toLastString());
    System.out.println(tree.toLevelString());

    int[] fir = new int[] { 1, 2, 4, 7, 3, 5, 6, 8 };
    int[] mid = new int[] { 4, 7, 2, 1, 5, 3, 8, 6 };
    TreeNode build = rebuildTree(fir, mid);
    tree.root = build;
    System.out.println(tree.toFirstString());
    System.out.println(tree.toMiddleString());
  }

  /**
   * 根据中序遍历和前序遍历输出，重构二叉树。
   * 条件：输出的元素不重样
   */
  private static TreeNode rebuildTree(int[] fir,int[] mid) {
    if (fir.length <= 0 || mid.length <= 0 || fir.length != mid.length) {
     return null;
    }
    int rootValue = fir[0];
    TreeNode root = new TreeNode(rootValue);
    // 第二次迭代的时候，左子树的中序遍历和右子树的中序遍历
    int index = findIndexInMid(rootValue, mid);
    int[] midl = new int[index];
    System.arraycopy(mid, 0, midl, 0, midl.length);
    int[] midr = new int[mid.length - midl.length-1];
    System.arraycopy(mid, index + 1, midr, 0,midr.length);

    // 第二次迭代的时候，左子树的前序遍历和右子树的前序遍历
    int[] firl = new int[midl.length];
    System.arraycopy(fir, 1, firl, 0, firl.length);
    int[] firr = new int[midr.length];
    System.arraycopy(fir, firl.length+1, firr, 0, firr.length);
    
    //第二次迭代开始
    root.setLeft(rebuildTree(firl,midl));
    root.setRight(rebuildTree(firr, midr));
    return root;
  }

  private static int findIndexInMid(int rootValue, int[] mid) {
    for (int i = 0; i <mid.length; i++) {
      if (mid[i] == rootValue) {
        return i;
      }
    }
    return -1;
  }

  /**
   * 根据集合创建二叉树
   * */
  public BinaryTree(Collection<? extends E> c) {
    Object[] a = new Object[c.size()];
    c.toArray(a);
    int i = 0;
    if (root == null) {
      root = new TreeNode(null, null, a[i]);
      if (root.getLeft() == null) {
        setLeftNode(i, a, root);
      }
      if (root.getRight() == null) {
        setRightNode(i, a, root);
      }
    } else {
      throw new IllegalArgumentException();
    }

  }

  public BinaryTree(TreeNode root) {
    this.root = root;
  }

  /**
   * @param i
   */
  public BinaryTree(int i) {
    this.root = new TreeNode(i);
  }

  /**
   * 
   */
  public BinaryTree() {
  }

  public TreeNode getRoot() {
    return root;
  }

  private void setLeftNode(int i, Object[] a, TreeNode temp) {
    int leftindex = 2 * i + 1;
    if (temp.getLeft() == null && leftindex < a.length) {
      if (a[leftindex].toString().equals("null")) {
        return;
      }
      TreeNode left = new TreeNode(null, null, a[leftindex]);
      temp.setLeft(left);
      setRightNode(leftindex, a, left);
      setLeftNode(leftindex, a, left);
    }
  }

  private void setRightNode(int i, Object[] a, TreeNode temp) {
    int rightindex = 2 * i + 2;
    if (temp.getRight() == null && rightindex < a.length) {
      if (a[rightindex].toString().equals("null")) {
        return;
      }
      TreeNode right = new TreeNode(null, null, a[rightindex]);
      temp.setRight(right);
      setLeftNode(rightindex, a, right);
      setRightNode(rightindex, a, right);
    }
  }

  /**
   * 前序输出
   * */
  public List<TreeNode> toFirSortNodes() {
    if (root != null) {
      List<TreeNode> firnodes = new ArrayList<TreeNode>();
      toFirSortNodes(root, firnodes);
      return firnodes;
    }
    return null;
  }

  private void toFirSortNodes(TreeNode node, List<TreeNode> firnodes) {
    if (node != null) {
      if (node.getLeft() != null) {
        toFirSortNodes(node.getLeft(), firnodes);
      }
      firnodes.add(node);
      if (node.getRight() != null) {
        toFirSortNodes(node.getRight(), firnodes);
      }
    }

  }

  /**
   * 前序输出
   * */
  private String toFirString(TreeNode node) {
    String temp = null;
    if (node != null) {
      temp = temp == null ? node.getValue().toString() : temp + node.getValue().toString();

      if (node.getLeft() != null) {
        temp = temp == null ? toFirString(node.getLeft()) : temp + toFirString(node.getLeft());
      }

      if (node.getRight() != null) {
        temp = temp == null ? toFirString(node.getRight()) : temp + toFirString(node.getRight());
      }

    }
    return temp;
  }

  /**
   * 前序输出
   * */
  public String toFirstString() {

    if (root != null) {
      return toFirString(root);
    }
    return null;
  }

  private void tolasSortNodes(TreeNode node, List<TreeNode> lasnodes) {
    if (node != null) {
      if (node.getLeft() != null) {
        tolasSortNodes(node.getLeft(), lasnodes);
      }
      lasnodes.add(node);
      if (node.getRight() != null) {
        tolasSortNodes(node.getRight(), lasnodes);
      }
    }
  }

  /**
   * 后序输出
   * */
  public List<TreeNode> toLasSortNodes() {
    if (root != null) {
      List<TreeNode> lasnodes = new ArrayList<TreeNode>();
      tolasSortNodes(root, lasnodes);
      return lasnodes;
    }
    return null;
  }

  private String toLasString(TreeNode node) {
    String temp = null;
    if (node != null) {

      if (node.getLeft() != null) {
        temp = temp == null ? toLasString(node.getLeft()) : temp + toLasString(node.getLeft());
      }

      if (node.getRight() != null) {
        temp = temp == null ? toLasString(node.getRight()) : temp + toLasString(node.getRight());
      }

      temp = temp == null ? node.getValue().toString() : temp + node.getValue().toString();
    }
    return temp;
  }

  /**
   * 后序输出
   * */
  public String toLastString() {

    if (root != null) {
      return toLasString(root);
    }
    return null;
  }


  private String toLeavel(ArrayDeque<TreeNode> queue) {
    String temp = null;
    while (!queue.isEmpty()) {
      TreeNode node = queue.pollFirst();
      if (temp == null) {
        temp = node.getValue().toString();
      } else {
        temp = temp + node.getValue().toString();
      }
      if (node.getLeft() != null) {
        queue.add(node.getLeft());
      }
      if (node.getRight() != null) {
        queue.add(node.getRight());
      }
    }
    return temp;
  }

  /**
   * 层次输出
   * */
  public String toLevelString() {
    ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
    if (root != null) {
      queue.add(root);
      return toLeavel(queue);
    } else {
      throw new IllegalAccessError("根节点为NULL");
    }
  }

  /**
   * 中序输出
   * */
  public String toMiddleString() {

    if (root != null) {
      return toMidString(root);
    }
    return null;
  }

  /**
   * 中序输出
   * */
  public List<TreeNode> toMidSortNodes() {
    if (root != null) {
      List<TreeNode> midnodes = new ArrayList<TreeNode>();
      toMidSortNodes(root, midnodes);
      return midnodes;
    }
    return null;
  }

  private void toMidSortNodes(TreeNode node, List<TreeNode> midnodes) {
    if (node != null) {
      if (node.getLeft() != null) {
        toMidSortNodes(node.getLeft(), midnodes);
      }
      midnodes.add(node);
      if (node.getRight() != null) {
        toMidSortNodes(node.getRight(), midnodes);
      }
    }
  }

  private String toMidString(TreeNode node) {
    String temp = null;
    if (node != null) {

      if (node.getLeft() != null) {
        temp = temp == null ? toMidString(node.getLeft()) : temp + toMidString(node.getLeft());
      }
      temp = temp == null ? node.getValue().toString() : temp + node.getValue().toString();

      if (node.getRight() != null) {
        temp = temp == null ? toMidString(node.getRight()) : temp + toMidString(node.getRight());
      }

    }
    return temp;
  }

}
