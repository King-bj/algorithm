package leetcode;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 *
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Reverse {
    /**
     * 数学逻辑，主要判断是否溢出，
     * 如果 temp=rev⋅10+poptemp = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop 导致溢出，那么一定有 rev≥INTMAX10\text{rev} \geq \frac{INTMAX}{10}rev≥10INTMAX​。
     * 如果 rev>INTMAX10\text{rev} > \frac{INTMAX}{10}rev>10INTMAX​，那么 temp=rev⋅10+poptemp = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop 一定会溢出。
     * 如果 rev==INTMAX10\text{rev} == \frac{INTMAX}{10}rev==10INTMAX​，那么只要 pop>7\text{pop} > 7pop>7，temp=rev⋅10+poptemp = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop 就会溢出。
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(reverse(150));
    }
}
