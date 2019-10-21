package leetcode;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindrome {
    /**
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s.equals("")) {
            return "";
        }
        int length = s.length();
        String reversal = new StringBuffer(s).reverse().toString(); // 反转字符串
        int[][] cell = new int[length][length];
        int maxLen = 0; // 最长公共子串长度
        int maxEnd = 0; // 最长公共子串结束位置
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (reversal.charAt(i) == s.charAt(j)) {
                    if (i == 0 || j == 0) {
                        cell[i][j] = 1;
                    } else {
                        cell[i][j] = cell[i - 1][j - 1] + 1; // 公共子串长度
                    }
                } else {
                    cell[i][j] = 0;
                }
                if (cell[i][j] > maxLen) {
                    maxLen = cell[i][j];
                    maxEnd = j;
                }
            }
        }
        return s.substring(maxEnd + 1 - maxLen, maxEnd + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aabbcc"));
    }
}
