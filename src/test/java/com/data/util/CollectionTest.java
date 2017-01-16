package com.data.util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

/**
 * @author AndiHappy  CollectionTest.java 
 *
 * @date 2017年1月14日 上午10:40:22
 */
public class CollectionTest {
  LinkedList<Integer> value = new LinkedList<Integer>();
  public static void main(String[] args) {
    LinkedList<Integer> value = new LinkedList<Integer>();
    value.add(1);
    value.add(2);
    value.add(3);
    value.add(1);
    value.add(2);
    value.add(3);
    value.add(1);
    value.add(2);
    value.add(3);
    for (Integer integer : value) {
      System.out.println(integer);
    }
    
    ListIterator<Integer> list = value.listIterator(3);
    while (list.hasNext()) {
      System.out.println(list.next());
    }
    
  }

}