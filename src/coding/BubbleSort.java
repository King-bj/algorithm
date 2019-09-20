package coding;

/**
 * 冒泡排序
 */
public class BubbleSort {

    /**
     * 双重循环排序
     * @param arr
     */
    private static void sort(int[] arr){
        int count = 0;
        for(int i = 0 ;i<arr.length-1;i++){

            for(int j = 0; j<arr.length-i-1;j++){
                if(arr[i] > arr[j + 1]){
                    int temp = arr[i];
                    arr[i] = arr[j+1];
                    arr[j+1] = temp;
                }
                count ++;
            }
        }
        System.out.println("执行次数"+count);
    }

    /**
     * 双重循环排序优化 增加判断有序后不进行排序
     * @param arr
     */
    private static void sortBoolean(int[] arr){
        int count = 0;
        for(int i = 0 ;i<arr.length-1;i++){
            boolean jump = true;
            for(int j = 0; j<arr.length-i-1;j++){
                int temp = 0;
                if(arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    jump = false;
                }
                count ++;
            }
            if(jump){
                break;
            }

        }
        System.out.println("执行次数"+count);
    }

    /**
     * 双重循环排序优化 增加判断有序后不进行排序  增加边界
     * @param arr
     */
    private static void sortBorder(int[] arr){
        int count = 0;
        int lastChange = 0;
        int sortBorder = arr.length-1;
        for(int i = 0 ;i<arr.length-1;i++){
            boolean jump = true;
            for(int j = 0; j<sortBorder;j++){
                int temp = 0;
                if(arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    jump = false;
                    lastChange = j;
                }
                count ++;
            }
            sortBorder = lastChange;
            if(jump){
                break;
            }

        }
        System.out.println("执行次数"+count);
    }

    /**
     * 鸡尾酒排序 双边循环
     * @param arr
     */
    private static void sortCocktail(int[] arr){
        int count = 0;
        int temp = 0;
        for(int i=0; i<arr.length/2; i++){
            boolean jump = true;
            for(int j=i; j<arr.length-i-1; j++){
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    jump = false;
                }
                count ++;
            }

            if(jump){
                break;
            }

            jump = true;
            for(int j = arr.length-i-1; j > i;j--){
                if(arr[j] < arr[j-1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    jump = false;
                }
                count ++;
            }
            if(jump){
                break;
            }

        }
        System.out.println("执行次数"+count);
    }

    /**
     * 鸡尾酒排序 双重边界
     * @param arr
     */
    private static void sortCocktailBorder(int[] arr){
        int count = 0;
        int temp = 0;
        int lastLeftChange = 0;
        int lastRightChange = 0;
        int leftBorder = arr.length-1;
        int rightBorder = 0;
        for(int i=0; i<arr.length/2; i++){
            boolean jump = true;
            for(int j=i; j<leftBorder; j++){
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    jump = false;
                    lastLeftChange = j;
                }
                count ++;
            }
            leftBorder = lastLeftChange;
            if(jump){
                break;
            }

            jump = true;
            for(int j = arr.length-i-1; j > rightBorder;j--){
                if(arr[j] < arr[j-1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    jump = false;
                    lastRightChange = j;
                }
                count ++;
            }
            rightBorder = lastRightChange;
            if(jump){
                break;
            }

        }
        System.out.println("执行次数"+count);
    }

    public static void main(String[] args) {
        int[] arr = {2,3,5,6,7,1,9};
//        sort(arr);
//        sortBoolean(arr);
//        sortBorder(arr);
//        sortCocktail(arr);
        sortCocktailBorder(arr);
        for(int i : arr){
            System.out.print(i);
        }
    }
}
