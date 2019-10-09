package leetcode;

import java.util.HashMap;
import java.util.Map;

public class twoSum {
    /**
     * 原理：target - nums 然后再次循环进行比较
     * 时间复杂度：O(n^2)
     * 空间复杂度 O(1)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] returnInt = new int[2];
        for(int i=0;i<nums.length;i++){
            int key =  target - nums[i];
            for(int j=0;j<nums.length;j++){
                if(i==j) continue;
                if(nums[j] == key){
                    returnInt[0] = i;
                    returnInt[1] = j;
                    return returnInt;
                }
            }
        }
        return returnInt;
    }


    /**
     * 存到hash表中
     * target - nums 然后直接去hash表进行查找
     * 时间复杂度：O(n)
     * 空间复杂度 O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i< nums.length; i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int key =  target - nums[i];
            if (map.containsKey(key) && map.get(key) != i){
                return new int[] { i, map.get(key) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 在遍历hash表时就进行判断
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        System.out.println(twoSum2(nums,target)[0]+":"+twoSum2(nums,target)[1]);
    }
}
