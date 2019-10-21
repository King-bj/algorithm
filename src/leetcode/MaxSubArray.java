package leetcode;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSubArray {
    /**
     *
     *
     *
     * 动态规划
     * dp[i] - 表示到当前位置 i 的最大子序列和
     * 状态转移方程为： dp[i] = max(dp[i - 1] + nums[i], nums[i])
     * 初始化：dp[0] = nums[0]
     * 从状态转移方程中，我们只关注前一个状态的值，所以不需要开一个数组记录位置所有子序列和，只需要两个变量，
     * currMaxSum - 累计最大和到当前位置i
     * maxSum - 全局最大子序列和:
     *     currMaxSum = max(currMaxSum + nums[i], nums[i])
     *     maxSum = max(currMaxSum, maxSum)
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int currMaxSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currMaxSum = Math.max(currMaxSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currMaxSum);
        }
        return maxSum;
    }
}
