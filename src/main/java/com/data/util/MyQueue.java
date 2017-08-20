package com.data.util;

import java.util.NoSuchElementException;

/**
 * @author zhailz
 *
 * 时间：2016年9月26日 ### 下午3:51:35
 * 
 */
public class MyQueue<E> {

	/**
	 * 队列对外提供的方法，说简单也挺简单的，只有两个：出队列和入队列
	 * 就队列的实现可以分为两类：数组和链表。
	 * 就队列的支持来说也可以分支两类：线程安全的，和线程不安全的
	 * */

	transient Object[] elements; // non-private to simplify nested class access
	transient int head;
	transient int tail;
	private static final int MIN_INITIAL_CAPACITY = 8;

	public MyQueue() {
		elements = new Object[16];
	}

	public MyQueue(int numElements) {
		allocateElements(numElements);
	}

	public void add(E e) {
		if (e == null)
			throw new NullPointerException();
		elements[tail] = e;
		/**
		 * tail = (tail + 1) 尾巴上面增加1
		 * 先下的值对数组的长度取余 与 head的值进行比较，确定队列时候已满
		 * tail & (elements.length - 1) == head
		 * 
		 * */
		if ((tail = (tail + 1) & (elements.length - 1)) == head)
			doubleCapacity();
	}

	public E remove() {
		E result = pollFirst();
		if (result == null)
			throw new NoSuchElementException();
		return result;
	}

	public E poll() {
		E result = pollFirst();
		return result;
	}

	public E pollFirst() {
		int h = head;
		@SuppressWarnings("unchecked")
		E result = (E) elements[h];
		// Element is null if deque empty
		if (result == null)
			return null;
		elements[h] = null; // Must null out slot
		//出队列的时候的，对头的增长
		head = (h + 1) & (elements.length - 1);
		return result;
	}

	public E element() {
		return getFirst();
	}

	public E getFirst() {
		@SuppressWarnings("unchecked")
		E result = (E) elements[head];
		if (result == null)
			throw new NoSuchElementException();
		return result;
	}

	@SuppressWarnings("unchecked")
	public E peek() {
		// elements[head] is null if deque empty
		return (E) elements[head];
	}

	private void doubleCapacity() {
		assert head == tail;
		int p = head;
		int n = elements.length;
		int r = n - p; // number of elements to the right of p
		int newCapacity = n << 1;
		if (newCapacity < 0)
			throw new IllegalStateException("Sorry, deque too big");
		Object[] a = new Object[newCapacity];
		System.arraycopy(elements, p, a, 0, r);
		System.arraycopy(elements, 0, a, r, p);
		elements = a;
		head = 0;
		tail = n;
	}

	//分配元素很有趣，为什么这么分配呢？
	private void allocateElements(int numElements) {
		int initialCapacity = MIN_INITIAL_CAPACITY;
		if (numElements >= initialCapacity) {
			initialCapacity = numElements;
			initialCapacity |= (initialCapacity >>> 1);
			initialCapacity |= (initialCapacity >>> 2);
			initialCapacity |= (initialCapacity >>> 4);
			initialCapacity |= (initialCapacity >>> 8);
			initialCapacity |= (initialCapacity >>> 16);
			initialCapacity++;
			if (initialCapacity < 0) // Too many elements, must back off
				initialCapacity >>>= 1;// Good luck allocating 2 ^ 30 elements
		}
		elements = new Object[initialCapacity];
	}
}
