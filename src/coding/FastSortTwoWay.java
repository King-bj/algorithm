package coding;

/**
 * 快速排序 双边循环
 */
public class FastSortTwoWay  {

    public static void quickSort(int[] arr, int startIndex, int endIndex){
        // 递归结束条件：startIndex大于或等于endIndex时
        if (startIndex >= endIndex) {
                return;
        }
        // 得到基准元素位置
        int pivotIndex = partition(arr, startIndex, endIndex);
        //对基准元素左边的再进行递归排序
        quickSort(arr, startIndex, pivotIndex - 1);
        //对基准元素右边的数据再进行递归排序
        quickSort(arr, pivotIndex + 1, endIndex);
    }

    /**
        * 分治（双边循环法） 数列中的元素依据自身大小，分别交换到基准元素的左右两边
       * @param arr         待交换的数组
       * @param startIndex      起始下标
      * @param endIndex      结束下标
    */
    private static int partition(int[] arr, int startIndex,int endIndex) {
        //初始位置从0 开始 也可以选择随机位置开始
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        //两个坐标相等时，停止比较
        while( left != right) {
            //如果右元素比基准大，右坐标向左移动，直到右元素小于等于基准元素，循环结束
            while(left<right && arr[right] > pivot){
                right--;
            }
            //如果左元素比基准小，左坐标向右移动，直到左元素大于基准元素，循环结束
            while(left<right && arr[left] <= pivot){
                left++;
            }
            //循环完成后，arr[rignt]一定小于等于基准   arr[left] 大于 基准元素  所以要把左右交换位置
            //交换left和right 指针所指向的元素
            if(left<right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }
        //pivot 和指针重合点交换   起始点换成left
        arr[startIndex] = arr[left];
        arr[left] = pivot;

        return left;
    }


    public static void main(String[] args) {
        int[] arr = {2,3,5,6,7,1,9};
        quickSort(arr,0,arr.length-1);
        for(int i : arr){
            System.out.print(i);
        }
    }
}
