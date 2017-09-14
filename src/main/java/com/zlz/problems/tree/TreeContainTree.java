package com.zlz.problems.tree;

/**
 * @author zhailz
 * @date 17/9/14 - 下午6:31.
 * DOC: 输入两颗二叉树A，B，判断B是不是A的子结构。
 */
public class TreeContainTree {

  /**
   * 迭代的判断
   * */
  boolean DoesParentHaveChild (TreeNode parent, TreeNode child) {
    if (child == null)      //  子树为NULL，那么必然是子树
    {
      return true;
    }
    else if (parent == null)      //  子树不是NULL, 但是父亲树是NULL
    {
      return false;
    }

    //  两个节点的值不相等，那么两个树必然不是父子关系
    if (parent.getValue ().equals (child.getValue ())) {
      return false;
    }
    else      // 否则当前节点当前相等，则递归的判断左子树和右子树对应节点是否相同
    {
      return DoesParentHaveChild (parent.getLeft (), child.getLeft ())
          && DoesParentHaveChild (parent.getRight (), child.getRight ());
    }
  }

  /**
   * 迭代的解决
   * */
  boolean HasSubtree (TreeNode parent, TreeNode child) {
    if (child == null) {
      return false;
    }
    else if (parent == null) {
      return false;
    }

    boolean result = false;

    //  如果当前父树的节点与子树的根节点相同，则直接从父树的当前位置开始判定
    if (parent.getValue ().equals (child.getValue ())) {
      result = DoesParentHaveChild (parent, child);
    }

    if (!result) {
      return HasSubtree (parent.getLeft (), child)
          || HasSubtree (parent.getRight (), child);
    }else {
      return true;
    }

  }
}
