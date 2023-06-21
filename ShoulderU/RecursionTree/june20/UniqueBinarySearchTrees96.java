package ShoulderU.RecursionTree.june20;

public class UniqueBinarySearchTrees96 {
    public int numTrees(int n) {
        // 思路：每个n(ex 1-5) 分表找到以每个数做root，有几种可能性，最后再加起来
        // base condition 就是当n <= 1 就只有一种坑行
        // recursive case： 当确定好某一个数字作为root。 左子树有几个数字 * 右子树几个数字，就是最终答案
        // 左子树每次产出可能性，就是左子树几个数字如何分配，要跟有自己几个数字如何分配order可能兴，相乘，才是最后结果
        // base case
        if (n <= 1) {
            return 1;
        }

        // recursive case
        //define res
        int res = 0;
        // start loop
        for (int i = 0; i < n; i++){
            res += numTrees(i) * numTrees(n - i - 1);
        }

        return res;
    }
}
