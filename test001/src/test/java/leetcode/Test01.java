package leetcode;

import org.junit.Test;

import java.time.Instant;

public class Test01 {
  @Test
  public void test01() {
    long start = Instant.now().toEpochMilli();
    int count = new Solution().superEggDrop(9, 10000);
    long end = Instant.now().toEpochMilli();
    System.out.println(end - start);
    System.out.println(count);
  }
}

/**
 * k = 1 return n
 * n = 0 return 0
 */
class Solution {
  public int superEggDrop(int k, int n) {
    //k个鸡蛋，n层楼，最坏情况下，最小次数
    int[][] dp = new int[k + 1][n + 1];

    for (int i = 1; i <= k; i++) {
      for (int j = 1; j <= n; j++) {
        if (i == 1) {
          //1个鸡蛋时，只能从第一层开始试，所以返回楼层数
          dp[i][j] = j;
        } else if (j == 1) {
          //1个楼层时，始终是1次
          dp[i][j] = 1;
        } else {

          //超时
         /* dp[i][j] = Integer.MAX_VALUE;
          // 1-j层做选择，碎或不碎
          for (int m = 1; m <= j; m++) {
            int max = Integer.max(dp[i - 1][m - 1], dp[i][j - m]) + 1;
            dp[i][j] = Integer.min(dp[i][j], max);
          }*/

          //二分法
          int start = 1;
          int end = j;
          int ans = Integer.MAX_VALUE;
          while (start < end) {
            int mid = start + (end - start) / 2;

            int left = dp[i - 1][mid - 1];
            int right = dp[i][j - mid];
            ans = Math.min(Math.max(left, right), ans);
            if (left == right) {
              break;
            }
            if (left < right) {
              start = mid + 1;
            } else {
              end = mid;
            }
          }
          dp[i][j] = ans + 1;
        }
      }
    }
    return dp[k][n];
  }
}