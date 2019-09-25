package question;

import java.util.Arrays;

/**
 * 给出一个正整数，找出这个正整数所有数字全排列的下一个数。
 * 说通俗点就是在一个整数所包含数字的全部组合中，找到一个大于且仅大于原数的新整数。让我们举几个例子。
 * 如果输入12345，则返回12354。
 * 如果输入12354，则返回12435。
 * 如果输入12435，则返回12453。
 *
 * 保持高位不变，低位在最小的范围内变换顺序。
 * 至于变换顺序的范围大小，则取决于当前整数的逆序区域。
 */
public class findNearestNumber {
    /**
     * 获得全排列下一个数的3个步骤。
     * 从后向前查看逆序区域，找到逆序区域的前一位，也就是数字置换的边界。
     * 让逆序区域的前一位和逆序区域中大于它的最小的数字交换位置。
     * 把原来的逆序区域转为顺序状态
     *
     * @param numbers
     * @return
     */
    public static int[] findNearestNumber(int[] numbers) {
        // 从后向前查看逆序区域，找到逆序区域的前一位，也就是数字置换的边界  12345 逆序区域是 45
        int index = findTransferPoint(numbers);
        // 如果数字置换边界是0，说明整个数组已经逆序，无法得到更大的相同数字组成的整数，返回null
        if (index == 0) {
            return null;
        }
        //把逆序区域的前一位和逆序区域中刚刚大于它的数字交换位置
        //复制并入参，避免直接修改入参
        int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
        exchangeHead(numbersCopy, index);
        //把原来的逆序区域转为顺序
        reverse(numbersCopy, index);
        return numbersCopy;
    }

    private static int findTransferPoint(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i] > numbers[i - 1]) {
                return i;
            }
        }
        return 0;
    }

    private static int[] exchangeHead(int[] numbers, int index) {
        int head = numbers[index - 1];
        for (int i = numbers.length - 1; i > 0; i--) {
            if (head < numbers[i]) {
                numbers[index - 1] = numbers[i];
                numbers[i] = head;
                break;
            }
        }
        return numbers;
    }

    private static int[] reverse(int[] num, int index) {
        for (int i = index, j = num.length - 1; i < j; i++, j--) {
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
        return num;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        //打印12345 之后的10个全排列整数
        for (int i = 0; i < 10; i++) {
            numbers = findNearestNumber(numbers);
            outputNumbers(numbers);
        }
    }

    // 输出数组
    private static void outputNumbers(int[] numbers) {
        for (int i : numbers) {
            System.out.print(i);
        }
        System.out.println();
    }
}
