package com.alg.util;

import java.util.Comparator;

/**
 * @author AndiHappy  RedBlackTree.java 
 *
 * @date 2017年1月16日 下午3:36:35
 */

/**
 * 红黑树的特性： （1）每个节点或者是黑色，或者是红色。 （2）根节点是黑色。 （3）每个叶子节点（NIL）是黑色。
 * [注意：这里叶子节点，是指为空(NIL或NULL)的叶子节点！] （4）如果一个节点是红色的，则它的子节点必须是黑色的。
 * （5）从一个节点到该节点的子孙节点的所有路径上包含相同数目的黑节点。
 */
public class RedBlackTree<T> {

  private RBNode<T> root; // 根结点
  private Comparator<? super T> comparator; // 比较器

  /**
   * 插入节点(key)
   */
  public void insert(T key) {
    RBNode<T> item = new RBNode<T>(key);
    insert(item);
  }

  /**
   * @param item
   *          插入的数据
   */
  private void insert(RBNode<T> node) {
    int cmp;
    RBNode<T> y = null;
    RBNode<T> x = this.root;
    // 1. 将红黑树当作一颗二叉查找树，将节点添加到二叉查找树中。
    while (x != null) {
      y = x;
      cmp = compare(node.item, x.item);
      if (cmp < 0) {
        x = x.left;
      } else {
        x = x.right;
      }
    }

    // y 就是插入的位置
    node.parent = y;
    if (y != null) {
      cmp = compare(node.item, y.item);
      if (cmp < 0)
        y.left = node;
      else
        y.right = node;
    } else {
      // 设置根节点
      this.root = node;
    }
    // 2. 设置节点的颜色为红色
    node.red = true;
    // 3. 将它重新修正为一颗二叉查找树
    balanceInsertion(node);
  }

  /**
   * 插入后，维护红黑树的颜色正常
   * 
   * @param node
   * @return 根节点
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  RBNode balanceInsertion( RBNode x) {
    x.red = true;
    // xp x的父节点，xpp x的祖父节点，xppl x祖父节点的左节点，xppr x祖父节点的右节点
    for (RBNode xp, xpp, xppl, xppr;;) {
      if ((xp = x.parent) == null) {
        // xp 为null的情况下，x为根节点，所以设置x为黑色
        x.red = false;
        return x;
      } else if (!xp.red || (xpp = xp.parent) == null){
        // xp存在，并且为黑色的情况下，直接的返回即可，因为插入一个红色的节点不影响数据
        // xpp不存在，那么父节点为根节点，x插入红色节点也没有问题
        return root;
      } 
      
      if (xp == (xppl = xpp.left)) {
     // 如果父节点是祖父的左节点，并且祖父节点的右节点，即叔叔节点，是红色的
        if ((xppr = xpp.right) != null && xppr.red) {
//        当前节点的父节点是红色，且当前节点的祖父节点的另一个子节点（叔叔节点）也是红色。  
//        (01) 将“父节点”设为黑色。
//        (02) 将“叔叔节点”设为黑色。
//        (03) 将“祖父节点”设为“红色”。
//        (04) 将“祖父节点”设为“当前节点”(红色节点)；即，之后继续对“当前节点”进行操作。
          xppr.red = false;
          xp.red = false;
          xpp.red = true;
          x = xpp;
        } else {
          // 如果父节点是祖父的左节点
          if (x == xp.right) { 
//          叔叔节点是黑色（即使叔叔节点不存在，也能看做是黑色的），且当前节点是其父节点的右孩子  
//          (01) 将“父节点”作为“新的当前节点”。
//          (02) 以“新的当前节点”为支点进行左旋。
            root = rotateLeft(root, x = xp);
            xpp = (xp = x.parent) == null ? null : xp.parent;
          }
          // 当前节点是其父节点的左节点
          if (xp != null) {
//            当前节点的父节点是红色，叔叔节点是黑色，且当前节点是其父节点的左孩子  
//            (01) 将“父节点”设为“黑色”。
//            (02) 将“祖父节点”设为“红色”。
//            (03) 以“祖父节点”为支点进行右旋。
            xp.red = false;
            if (xpp != null) {
              xpp.red = true;
              root = rotateRight(root, xpp);
            }
          }
        }
      } else {
     // 如果父节点是祖父的右节点，并且祖父节点的左节点，即叔叔节点，是红色的
//      (01) 将“父节点”设为黑色。
//      (02) 将“叔叔节点”设为黑色。
//      (03) 将“祖父节点”设为“红色”。
//      (04) 将“祖父节点”设为“当前节点”(红色节点)；即，之后继续对“当前节点”进行操作。
        if (xppl != null && xppl.red) {
          xppl.red = false;
          xp.red = false;
          xpp.red = true;
          x = xpp;
        } else {
          //父节点是祖父的右节点
          if (x == xp.left) {
            //叔叔节点是黑色（即使叔叔节点不存在，也能看做是黑色的），且当前节点是其父节点的左孩子  
//          (01) 将“父节点”作为“新的当前节点”。
//          (02) 以“新的当前节点”为支点进行左旋。
            root = rotateRight(root, x = xp);
            xpp = (xp = x.parent) == null ? null : xp.parent;
          }
          if (xp != null) {
//叔叔节点是黑色（即使叔叔节点不存在，也能看做是黑色的），且当前节点是其父节点的左孩子  
//          (01) 将“父节点”设为“黑色”。
//          (02) 将“祖父节点”设为“红色”。
//          (03) 以“祖父节点”为支点进行右旋。
            xp.red = false;
            if (xpp != null) {
              xpp.red = true;
              root = rotateLeft(root, xpp);
            }
          }
        }
      }
    }
  }

  /**
   * 以p节点右旋
   * @param root2
   * @param rbNode
   * @return
   */
  @SuppressWarnings({ "rawtypes", "unchecked" })
  private RBNode<T> rotateRight(RBNode<T> root2, RBNode p) {
    RBNode l, pp, lr;
    if (p != null && (l = p.left) != null) {
        if ((lr = p.left = l.right) != null)
            lr.parent = p;
        if ((pp = l.parent = p.parent) == null)
            (root = l).red = false;
        else if (pp.right == p)
            pp.right = l;
        else
            pp.left = l;
        l.right = p;
        p.parent = l;
    }
    return root;
  }

  /**
   * p 节点左旋
   * @param root2
   * @param rbNode
   * @return
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  private RBNode<T> rotateLeft(RBNode<T> root, RBNode p) {
    RBNode<T> r, pp, rl;
    if (p != null && (r = p.right) != null) {
        if ((rl = p.right = r.left) != null)
            rl.parent = p;
        if ((pp = r.parent = p.parent) == null)
            (root = r).red = false;
        else if (pp.left == p)
            pp.left = r;
        else
            pp.right = r;
        r.left = p;
        p.parent = r;
    }
    return root;
  }

  @SuppressWarnings("unchecked")
  final int compare(T k1, T k2) {
    return comparator == null ? ((Comparable<? super T>) k1).compareTo((T) k2)
        : comparator.compare((T) k1, (T) k2);
  }

}
