package com.data.util;

/**
 * @author zhailz
 * @Date 2017年8月20日 - 下午5:33:09
 * @Doc: 
 */
public class StackImplementQueue {
  
   MyStack<Integer> stack1 = new MyStack<Integer>();
   MyStack<Integer> stack2 = new MyStack<Integer>();
   
   /**
    * 增加尾巴
    * */
   public void addTail(int key) {
     this.stack1.push(key);
   }
   
   /**
    * 增加头
    * */
   public void addhead(int key) {
     this.stack2.push(key);
   }
   
   /**
    * 删除头
    * */
   public Integer removeHead() {
     if(stack2.size() == 0 && stack1.size() > 0) {
       while(stack1.size() > 0) {
         stack2.push(stack1.pop());
       }
     }
     
     if(stack2.size() > 0) {
       return stack2.pop();
     }else {
       throw new IllegalAccessError("对立面没有元素了");
     }
   }
   
   /**
    * 删除尾巴
    * */
   public Integer removetail() {
     if(stack1.size() == 0 && stack2.size() > 0) {
       while(stack2.size() > 0) {
         stack1.push(stack2.pop());
       }
     }
     
     if(stack1.size() > 0) {
       return stack1.pop();
     }else {
       throw new IllegalAccessError("对立面没有元素了");
     }
   }
   
   /**
    * 输出队列，从头到尾
    * */
   public String toString() {
     StringBuilder builder = new StringBuilder();
     builder.append(stack2.tailToHeadString());
     builder.append(stack1.headToTailString());
     return  builder.toString();
   }

   
  /**
   * @param args
   */
  public static void main(String[] args) {
    StackImplementQueue qu = new StackImplementQueue();
    qu.addhead(1);
    qu.addhead(2);
    qu.addhead(3);
    System.out.println(qu.toString());
    qu.addTail(4);
    qu.addTail(5);
    System.out.println(qu.toString());

  }

}
