package leetcode;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 *
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMedianSortedArrays {
    /**
     * 思路：
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        if (n > m)  //保证数组1一定最短
        {
            return findMedianSortedArrays(nums2, nums1);
        }

        // Ci 为第i个数组的割,比如C1为2时表示第1个数组只有2个元素。LMaxi为第i个数组割后的左元素。RMini为第i个数组割后的右元素。
        int LMax1 = 0, LMax2= 0, RMin1= 0, RMin2= 0, c1, c2, lo = 0, hi = 2 * n;  //我们目前是虚拟加了'#'所以数组1是2*n长度

        while (lo <= hi)   //二分
        {
            c1 = (lo + hi) / 2;  //c1是二分的结果
            c2 = m + n - c1;

            LMax1 = (c1 == 0) ? 0 : nums1[(c1 - 1) / 2];
            RMin1 = (c1 == 2 * n) ? 0 : nums1[c1 / 2];
            LMax2 = (c2 == 0) ? 0 : nums2[(c2 - 1) / 2];
            RMin2 = (c2 == 2 * m) ? 0: nums2[c2 / 2];

            if (LMax1 > RMin2)
                hi = c1 - 1;
            else if (LMax2 > RMin1)
                lo = c1 + 1;
            else
                break;
        }
        return (Math.max(LMax1, LMax2) + Math.min(RMin1, RMin2)) / 2.0;
    }

    public static void main(String[] args) {
        int[] nums1 = { 2,3, 5 };
        int[] nums2 = { 1,4,7, 9 };

        double ret =   findMedianSortedArrays(nums1, nums2);
        System.out.println(ret);
    }
}
