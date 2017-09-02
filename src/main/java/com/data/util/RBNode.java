package com.data.util;
//红黑树的节点
  public class RBNode<E>{
    // 父节点
    RBNode<E> parent = null;
    // 左节点
    RBNode<E> left = null;
    // 右节点
    RBNode<E> right = null;
    // 包含的值
    E item = null;
    
    //红黑节点
    boolean red;
    
    public RBNode(E item ) {
      this.item = item;
    }
  }