package coding;

/**
 * 快速排序 单边循环
 */
public class FastSortOneWay {

    public static void quickSort(int[] arr, int startIndex, int endIndex){
        // 递归结束条件：startIndex大于或等于endIndex时
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
        * 单边循环
       * @param arr         待交换的数组
       * @param startIndex      起始下标
      * @param endIndex      结束下标
    */
    private static int partition(int[] arr, int startIndex,int endIndex) {
        //初始位置从0 开始 也可以选择随机位置开始
        int pivot = arr[startIndex];
        int mark = startIndex;
        for(int i=startIndex+1; i<=endIndex; i++){
            //基准元素 > 当前元素   mark右移，当前元素和mark所在位置元素交换位置
            if(arr[i] <= pivot ){
                mark++;
                int p = arr[i];
                arr[i] = arr[mark];
                arr[mark] = p;
            }

        }

        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }


    public static void main(String[] args) {
        int[] arr = {2,3,5,6,7,1,9};
        quickSort(arr,0,arr.length-1);
        for(int i : arr){
            System.out.print(i);
        }
    }
}
