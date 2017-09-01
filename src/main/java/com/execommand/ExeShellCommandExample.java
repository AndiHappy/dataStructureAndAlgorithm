package com.execommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author zhailz
 *
 *         时间：2016年12月9日 ### 上午9:33:47
 * 
 *         执行shell命令
 */
public class ExeShellCommandExample {
  /**
   * @param args
   */
  public static void main(String[] args) {
    try {
      String[] cmd = new String[] { "/bin/sh", "-c", "pwd ;ls" };
      Process ps = Runtime.getRuntime().exec(cmd);
      BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
      StringBuffer sb = new StringBuffer();
      String line;
      while ((line = br.readLine()) != null) {
        sb.append(line).append("\n");
      }
      String result = sb.toString();

      System.out.println(result);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
