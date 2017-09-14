package com.data.util;

import java.util.AbstractMap;
import java.util.Map;

/**
 * @author zhailz
 *
 * 时间：2016年11月29日 ### 下午7:32:44
 * @param <K>
 * @param <V>
 */
public class MyTreeMap<K, V> {

  private transient Entry<K,V> root;
  
  public Map.Entry<K,V> firstEntry() {
    /**
     * 为什么会另外的包装出来一个方法？
     * */
     return exportEntry(getFirstEntry());
    }
  
  static <K,V> Map.Entry<K,V> exportEntry(Entry<K,V> e) {
    return (e == null) ? null :
      /**
       * 为什么会另外的包装出来一个方法？
       * 为了返回的数据不被修改
       * public V setValue(V value) {
            throw new UnsupportedOperationException();
        }
       * 
       * */
      new AbstractMap.SimpleImmutableEntry(e);
  }


    //获得TreeMap里第一个节点(即根据key排序最小的节点)，如果TreeMap为空，返回null
    final Entry<K,V> getFirstEntry() {
     Entry<K,V> p = root;
     if (p != null)
      while (p.left != null)
       p = p.left;
     return p;
    }

  
  private static final boolean RED = false;
  private static final boolean BLACK = true;
  //就是一个红黑树的节点
  static final class Entry<K,V> implements Map.Entry<K,V> {
   K key;
   V value;
   Entry<K,V> left = null; //左子节点
   Entry<K,V> right = null; //右子节点
   Entry<K,V> parent; //父节点
   boolean color = BLACK; //树的颜色，默认为黑色

   Entry(K key, V value, Entry<K,V> parent) { //构造方法
    this.key = key;
    this.value = value;
    this.parent = parent;
   }

   public K getKey() { //获得key
    return key;
   }

   public V getValue() { //获得value
    return value;
   }

   public V setValue(V value) { //设置value
    V oldValue = this.value;
    this.value = value;
    return oldValue;
   }

   public boolean equals(Object o) { //key和value均相等才返回true
    if (!(o instanceof Map.Entry))
     return false;
    Map.Entry<?,?> e = (Map.Entry<?,?>)o;

    return valEquals(key,e.getKey()) && valEquals(value,e.getValue());
   }

   public int hashCode() { //计算hashCode
    int keyHash = (key==null ? 0 : key.hashCode());
    int valueHash = (value==null ? 0 : value.hashCode());
    return keyHash ^ valueHash;
   }

   public String toString() { //重写toString方法
    return key + "=" + value;
   }
  }
  
  /**
   * Test two values for equality.  Differs from o1.equals(o2) only in
   * that it copes with {@code null} o1 properly.
   */
  static final boolean valEquals(Object o1, Object o2) {
      return (o1==null ? o2==null : o1.equals(o2));
  }

}

