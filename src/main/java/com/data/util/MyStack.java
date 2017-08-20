package com.data.util;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author zhailz
 *
 *         时间：2016年9月26日 ### 上午8:41:22
 * 
 *         栈的逻辑
 * 
 */
public class MyStack<E> {

  protected Object[] elementData;
  protected int elementCount;
  private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
  protected int capacityIncrement;
  protected transient int modCount = 0;

  public MyStack(int initialCapacity, int capacityIncrement) {
    if (initialCapacity < 0) throw new IllegalArgumentException("Illegal Capacity: "
        + initialCapacity);
    this.elementData = new Object[initialCapacity];
    this.capacityIncrement = capacityIncrement;
  }

  public MyStack(int initialCapacity) {
    this(initialCapacity, 0);
  }

  public MyStack() {
    this(10);
  }

  /**
   * 增加元素
   */
  public E push(E item) {
    addElement(item);
    return item;
  }

  public synchronized E pop() {
    E obj;
    int len = size();
    obj = peek();
    removeElementAt(len - 1);
    return obj;
  }

  public synchronized void removeElementAt(int index) {
    modCount++;
    if (index >= elementCount) {
      throw new ArrayIndexOutOfBoundsException(index + " >= " + elementCount);
    } else if (index < 0) {
      throw new ArrayIndexOutOfBoundsException(index);
    }
    int j = elementCount - index - 1;
    // 数组的复制，这种复制的方法免除了循环的复制的方法
    if (j > 0) {
      // index + 1 ：复制开始的位置
      // index ：复制到的位置开始
      // j 复制的长度
      System.arraycopy(elementData, index + 1, elementData, index, j);
    }
    elementCount--;
    elementData[elementCount] = null; /* to let gc do its work */
  }

  public synchronized int size() {
    return elementCount;
  }

  public synchronized E peek() {
    int len = size();

    if (len == 0) throw new EmptyStackException();
    return elementAt(len - 1);
  }

  private synchronized E elementAt(int index) {
    if (index >= elementCount) {
      throw new ArrayIndexOutOfBoundsException(index + " >= " + elementCount);
    }

    return elementData(index);
  }

  @SuppressWarnings("unchecked")
  private E elementData(int index) {
    return (E) elementData[index];
  }

  public synchronized void addElement(E obj) {
    modCount++;
    ensureCapacityHelper(elementCount + 1);
    elementData[elementCount++] = obj;
  }

  // 保证容量
  private void ensureCapacityHelper(int minCapacity) {
    if (minCapacity - elementData.length > 0) grow(minCapacity);
  }

  private void grow(int minCapacity) {
    // overflow-conscious code
    int oldCapacity = elementData.length;
    // 如果设置了增长的元素，每次的增长就按照设置的增长，没有的话，直接*2的增长
    int newCapacity = oldCapacity + ((capacityIncrement > 0) ? capacityIncrement : oldCapacity);
    if (newCapacity - minCapacity < 0) newCapacity = minCapacity;
    // 超大的栈的时候，怎么处理
    if (newCapacity - MAX_ARRAY_SIZE > 0) newCapacity = hugeCapacity(minCapacity);
    elementData = Arrays.copyOf(elementData, newCapacity);
  }

  private static int hugeCapacity(int minCapacity) {
    if (minCapacity < 0) // overflow
                         throw new OutOfMemoryError();
    return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
  }

  public String headToTailString() {
    StringBuilder builder = new StringBuilder();
    if (this.elementData != null && this.elementData.length > 0) {
      for (int i = 0; i < elementData.length; i++) {
        Object object = elementData[i];
        if (object != null) {
          builder.append(object.toString());
        }
      }
    }
    return builder.toString();
  }
  
  public String tailToHeadString() {
    StringBuilder builder = new StringBuilder();
    if (this.elementData != null && this.elementData.length > 0) {
      for (int i = elementData.length-1; i>=0; i--) {
        Object object = elementData[i];
        if (object != null) {
          builder.append(object.toString());
        }
      }
    }
    return builder.toString();
  }

  public static void main(String[] args) {
    int[] a1 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
    int[] a2 = new int[5];
    System.arraycopy(a1, 6, a2, 2, 2);
    System.out.println(Arrays.toString(a2));
  }

}
