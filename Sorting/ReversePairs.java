package Sorting;

public class ReversePairs {

    /**
     * 在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。给你一个数组，求出这个数组中逆序对的总数。
     * 概括：如果a[i] > a[j] 且 i < j， a[i] 和 a[j] 构成一个逆序对。
     * 样例1
     * 输入: A = [2, 4, 1, 3, 5]
     * 输出: 3
     * 解释:
     * (2, 1), (4, 1), (4, 3) 是逆序对
     * 样例2
     * 输入: A = [1, 2, 3, 4]
     * 输出: 0
     * 解释:
     * 没有逆序对
     *
     * 使用归并排序，因为归并排序时候后半段如果有元素先于前半段数并入数组中，则说明当前比较的前半段i 到mid 都比它大，则逆序对增量为 mid - i +1。
     * 其实归并排序找逆序对的原理就是先从小部分比较找出逆序对，然后在逐步扩大，复杂度nlgn
     * */

    long res = 0;
    public long reversePairs(int[] A) {
        // write your code here
        mergeSort(A, 0, A.length - 1);
        return res;
    }

    private void mergeSort(int[] A, int start, int end){
        if(start >= end){ //至少有保证两个数才能归并
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(A, start, mid);
        mergeSort(A, mid + 1, end);

        merge(A, start, mid, end);
    }

    private void merge(int[]A, int start, int mid, int end){
        int temp[]= new int[end - start + 1];

        int k = 0;
        int i = start;
        int j = mid +1;

        while(i <= mid && j <= end){
            if(A[i] <= A[j]){
                temp[k] = A[i];
                i++;
                k++;
            }else{
                temp[k] = A[j];
                res+= mid - i + 1;
                k++;
                j++;
            }
        }

        while(i <= mid){
            temp[k] = A[i];
            i++;
            k++;
        }
        while(j <= end){
            temp[k] = A[j];
            j++;
            k++;
        }
        for(int p = 0; p < temp.length; p++){
            A[start + p] = temp[p];
        }//别忘了把原数组给覆盖掉
    }
}
