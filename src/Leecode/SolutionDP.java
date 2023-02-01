package Leecode;

/**
 * TODO
 *
 * @author Administrator
 * @version 1.0
 * @date 2022/11/3 21:42
 */
public class SolutionDP {

    public static void main(String[] args) {
        int[] nums = new int[]{7, 1, 5, 3, 6, 4};
        int num = 3;
        System.out.println(climbStairs(num));

    }

    /**
     * 70. 爬楼梯
     **/
    public static int climbStairs(int n) {

        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int dp[] = new int[n];
        if (n > 2) {
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;
        }

        for (int i = 3; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n - 1] + dp[n - 2];
    }

    /**
     * 122. 买卖股票的最佳时机 II
     */
    public static int maxProfit2(int[] prices) {
//        1. 定义 dp[][]
        int len = prices.length;
        int[][] dp = new int[len][2];
//        2. 考虑特殊值
        if (len < 2) {
            return 0;
        }
//        3. 设置初始值
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
//        4. 状态转移方程
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }


    /**
     * 121. 买卖股票的最佳时机 -- 最低价格，最高收益
     *
     * @date: 2022/11/3 21:45
     */
    public static int maxProfit(int[] prices) {

        int res = 0, pre = prices[0];

        for (int i = 0; i < prices.length; i++) {
            pre = Math.min(pre, prices[i]);
            res = Math.max(prices[i] - pre, res);
        }

        return res;
    }

    /**
     * 63 不同路径(障碍物版)--  注意：障碍物的判断条件，到障碍物的路径走法是0
     *
     * @date: 2022/11/3 21:45
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        // 注意初始值设置 -- 排除障碍物
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 62 不同路径--  注意：是多少种不同路径，不是多少步
     *
     * @date: 2022/11/3 21:45
     */
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 注意初始值设置 -- 从（0,0） 到（i,j）有多少种路径（不是步数！不是步数！）
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /* 53 最大连续子数组和
     * @param null:
     * @return: null
     * @author: chensq
     * @date: 2022/11/3 21:45
     * @description:
     */
    public static int maxSubArray(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }
        // 注意状态转移 连续子数组  --> 以i结尾的连续子数组的和 -->  dp[i]=dp[i-1]+dp[i]

        // 1. 定义dp[i]为以i结尾的连续子组的和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        // 注意初始值设置，不能直接设置为0，而是dp[0]初始值
        int maxSum = dp[0];
        for (int i = 1; i < nums.length; i++) {
            // 2. 注意判断dp[i-1]的值是否>0
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxSum = Math.max(dp[i], maxSum);
        }

        return maxSum;

    }


}
