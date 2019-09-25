package question;

/**
 * 有一个无序整型数组，如何求出该数组排序后的任意两个相邻元素的最大差值？要求时间和空间复杂度尽可能低
 */
public class MaxSortedDistance {

    /**
     * @param array
     * @return
     */
    public static int getMaxSortedDistance(int[] array) {
        int max = array[0];
        int min = array[0];
        for (int arr : array) {
            if (arr > max) {
                max = arr;
            }
            if (arr < min) {
                min = arr;
            }
        }
        int d = max - min;
        if (d == 0) {
            return 0;
        }
        int bucketNum = array.length;
        Bucket[] buckets = new Bucket[bucketNum];
        for (int i = 0; i < bucketNum; i++) {
            buckets[i] = new Bucket();
        }
        for (int i = 0; i < array.length; i++) {
            //确定数组元素所归属的桶下标   该元素所在桶位置 =  (元素-最小值) * 桶数量 / 区间跨度  (6-2) *  6 /8
            int index = ((array[i] - min) * (bucketNum - 1) / d);
            if (buckets[index].min == null || buckets[index].min > array[i]) {
                buckets[index].min = array[i];
            }
            if (buckets[index].max == null || buckets[index].max < array[i]) {
                buckets[index].max = array[i];
            }
        }
        //4.遍历桶，找到最大差值
        int leftMax = buckets[0].max;
        int maxDistance = 0;
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i].min == null) {
                continue;
            }
            if (buckets[i].min - leftMax > maxDistance) {
                maxDistance = buckets[i].min - leftMax;
            }
            leftMax = buckets[i].max;
        }
        return maxDistance;
    }

    private static class Bucket {
        Integer min;
        Integer max;
    }


    public static void main(String[] args) {
        int[] array = new int[]{2, 6, 3, 4, 5, 10, 9};
        System.out.println(getMaxSortedDistance(array));
    }
}
