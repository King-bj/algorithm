package question;

/**
 * 面试题 求两数的最大公约数
 */
public class GreatestCommonDiviso {
    /**
     * 辗转相除法求最大公约数
     * 两个正整数a和b（a>b），它们的最大公约数等于a除以b的余数c和b之间的最大公约数。
     * 时间复杂度：可以近似为O(log(max(a, b)))，但是取模运算性能较差
     * @param a
     * @param b
     * @return
     */
    public static int getGreatestCommonDivisorV2(int a, int b) {
        int big = a > b ? a : b;
        int small = a < b ? a : b;
        if (big % small == 0) {
            return small;
        }
        return getGreatestCommonDivisorV2(big % small, small);
    }

    /**
     * 更相减损术求最大公约数
     * 两个正整数a和b（a>b），它们的最大公约数等于a-b的差c和b之间的最大公约数。
     *算法性能不稳定，最坏时间复杂度为O(max(a, b))
     * @param a
     * @param b
     * @return
     */
    public static int getGreatestCommonDivisorV3(int a, int b) {
        if (a == b) {
            return b;
        }
        int big = a > b ? a : b;
        int small = a < b ? a : b;
        return getGreatestCommonDivisorV3(big - small, small);
    }

    /**
     * 移位运算  gcd为求公约数函数  a为偶数时，a和 a/2的最大公约数相同  a/2运算可以看做a向右移位1
     * 当a和b均为偶数时，gcd(a,b) = 2×gcd(a/2, b/2) = 2×gcd(a>>1,b>>1)。
     * 当a为偶数，b为奇数时，gcd(a,b) = gcd(a/2,b) = gcd(a>>1,b)。
     * 当a为奇数，b为偶数时，gcd(a,b) = gcd(a,b/2) = gcd(a,b>>1)。
     * 当a和b均为奇数时，先利用更相减损术运算一次，gcd(a,b) = gcd(b,a-b)，此时a-b必然是偶数，然后又可以继续进行移位运算
     * 时间复杂度为O(log(max(a, b)))
     * @param a
     * @param b
     * @return
     */
    public static int gcd(int a, int b) {
        if (a == b) {
            return a;
        }
        //判断整数奇偶性的方式是让整数和1进行与运算，如果(a&1)==0，则说明整数a是偶数；如果(a&1)!=0，则说明整数a是奇数。
        if ((a & 1) == 0 && (b & 1) == 0) {
            return gcd(a >> 1, b >> 1) << 1;
        } else if ((a & 1) == 0 && (b & 1) != 0) {
            return gcd(a >> 1, b);
        } else if ((a & 1) != 0 && (b & 1) == 0) {
            return gcd(a, b >> 1);
        } else {
            int big = a > b ? a : b;
            int small = a < b ? a : b;
            return gcd(big - small, small);
        }
    }


    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisorV2(25, 5));
        System.out.println(getGreatestCommonDivisorV2(100, 80));
        System.out.println(getGreatestCommonDivisorV2(27, 14));
        System.out.println(getGreatestCommonDivisorV3(25, 5));
        System.out.println(getGreatestCommonDivisorV3(100, 80));
        System.out.println(getGreatestCommonDivisorV3(27, 14));
        System.out.println(gcd(25, 5));
        System.out.println(gcd(100, 80));
        System.out.println(gcd(27, 14));
    }
}
