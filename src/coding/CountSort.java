package coding;

import java.util.Arrays;

/**
 * 计数排序 根据数组坐标来排序
 * 1. 当数列最大和最小值差距过大时，并不适合用计数排序。
 * 例如给出20个随机整数，范围在0到1亿之间，这时如果使用计数排序，需要创建长度为1亿的数组。不但严重浪费空间，而且时间复杂度也会随之升高。
 * 2. 当数列元素不是整数时，也不适合用计数排序。
 * 如果数列中的元素都是小数，如25.213，或0.00 000 001这样的数字，则无法创建对应的统计数组。这样显然无法进行计数排序
 * 测试提交git
 */
public class CountSort {

    /**
     * 计数排序  根据最大值定义数组长度
     *
     * @param array
     * @return
     */
    public static int[] countSort(int[] array) {
        //1.得到数列的最大值
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        //2.根据数列最大值确定统计数组的长度
        int[] countArray = new int[max + 1];
        //3.遍历数列，填充统计数组
        for (int i = 0; i < array.length; i++) {
            countArray[array[i]]++;
        }
        //4.遍历统计数组，输出结果
        int index = 0;
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                sortedArray[index++] = i;
            }
        }
        return sortedArray;
    }

    /**
     * 计数排序  根据最小值-最大值的偏移量得到数组
     *
     * @param array
     * @return
     */
    public static int[] countSort2(int[] array) {
        //1.得到数列的最大值
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        int count = max - min + 1;
        //2.根据数列最大值确定统计数组的长度
        int[] countArray = new int[count];
        //3.遍历数列，填充统计数组
        for (int i = 0; i < array.length; i++) {
            countArray[array[i] - min]++;
        }
        //4.遍历统计数组，输出结果
        int index = 0;
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                sortedArray[index++] = i;
            }
        }
        return sortedArray;
    }


    public static int[] countSortOrder(int[] array) {
        //1.得到数列的最大值和最小值，并算出差值d
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        int d = max - min;
        //2.创建统计数组并统计对应元素的个数
        int[] countArray = new int[d + 1];
        for (int i = 0; i < array.length; i++) {
            countArray[array[i] - min]++;
        }

        //3.统计数组做变形，后面的元素等于前面的元素之和
        for (int i = 1; i < countArray.length; i++) {

            countArray[i] += countArray[i - 1];
        }
        //4.倒序遍历原始数列，从统计数组找到正确位置，输出到结果数组
        int[] sortedArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            sortedArray[countArray[array[i] - min] - 1] = array[i];
            countArray[array[i] - min]--;
        }
        return sortedArray;
    }


    public static void main(String[] args) {
        int[] array = new int[]{95,94,91,98,99,90,99,93,91,92};
//        int[] sortedArray = countSort2(array);
        int[] sortedArray = countSortOrder(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}
