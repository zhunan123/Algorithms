package Sorting;

public class SortColors2 {

    /**
     * 给定一个有n个对象（包括k种不同的颜色，并按照1到k进行编号）的数组，
     * 将对象进行分类使相同颜色的对象相邻，并按照1,2，...k的顺序进行排序。
     *
     * 输入:
     * [3,2,2,1,4]
     * 4
     * 输出:
     * [1,2,2,3,4]
     * */

    public void sortColors2(int[] colors, int k) {
        if (colors == null || colors.length == 0){
            return;
        }
        rainbowSort(colors, 0, colors.length - 1, 1, k);
    }

    public void rainbowSort(int[] colors, int start, int end, int From, int To){
        if (start >= end || From >= To){
            return;
        }
        //partition
        int pivot = (From + To) / 2;
        int i = start;
        for (int j = start; j <= end; ++j){
            if (colors[j] <= pivot){
                int tmp = colors[i];
                colors[i] = colors[j];
                colors[j] = tmp;
                i++;
            }
        }
        //invariant: any index < i has value <= pivot
        //any index >= i has value > pivot
        //sort left and right subproblem
        rainbowSort(colors, start, i - 1, From, pivot);
        rainbowSort(colors, i, end, pivot + 1, To);
    }
}
