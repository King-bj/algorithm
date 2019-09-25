package question;

/**
 * 判断是否是2的整数次幂
 */
public class PowerOf2 {

    /**
     * 定义一个中间变量tmp = 2 ,每次让tmp*2 当tmp>a时，说明不是，等于是就是
     * @param a
     * @return
     */
    public static boolean powerOf2(int a){
        int tmp = 2;

        while(a > tmp){
            tmp = tmp << 1;
        }

        if(a == tmp) {
            return true;
        }
        return  false;
    }

    /**
     * 一个数如果是2的整数次幂，那么转化为二进制除了首位其他都是0
     * 该数-1转化为二进制，全都是1
     * 对 参数 和 参数-1 进行位运算，如果是2的整数次幂，则结果为0
     * @param num
     * @return
     */
    public static boolean isPowerOf2(int num) {
             return (num&num-1) == 0;
    }

    public static void main(String[] args) {
        System.out.println(powerOf2(2));
        System.out.println(powerOf2(8));
        System.out.println(powerOf2(18));
        System.out.println(isPowerOf2(2));
        System.out.println(isPowerOf2(8));
        System.out.println(isPowerOf2(18));
    }

}
