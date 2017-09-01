package com.problems;

import java.util.Stack;

/**
 * @author zhailzh жϱʽǲǺϺ'{','[','(',')',']','}'
 */
public class Al06PiPei {

  public Boolean isPatternRight(String value) {
    if (value != null && !value.isEmpty()) {
      Stack<Character> fuhao = new Stack<Character>();
      Stack<Character> number = new Stack<Character>();

      for (int i = 0; i < value.length(); i++) {
        char temp = value.charAt(i);

        if (isNumber(temp)) {
          number.push(temp);
        } else {
          if (false)
            number.push(temp);
        }
      }
    }

    return true;
  }

  // ֻĸ
  private boolean isNumber(char temp) {
    return Character.isLetter(temp);
  }

  private boolean judge(Stack<String> pattern, char temp) {
    // TODO Auto-generated method stub
    return false;
  }

  public static void main(String[] args) {
    Al06PiPei piper = new Al06PiPei();
    String test = "e+{r*c+[d*(a+b*c)+f]}+p";
    boolean res = piper.isPatternRight(test);
    System.out.println(" pattern  " + test + "  " + res);
  }
}
