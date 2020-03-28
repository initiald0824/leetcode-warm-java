//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//
// 必须原地修改，只允许使用额外常数空间。
//
// 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
//1,2,3 → 1,3,2
//3,2,1 → 1,2,3
//1,1,5 → 1,5,1
// Related Topics 数组

/**
 * @author initiald0824
 * @date 2020/3/20 7:28 下午
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        for (int i = len-1; i > 0; i--) {
            if (nums[i-1] < nums[i]) {
                int index = getLargerValIndex(nums, i, nums[i-1]);
                swap(nums, i-1, index);
                ascSort(nums, i, len-1);
                return;
            }
        }
        reverse(nums);
    }

    private void ascSort(int[] nums, int start, int end) {
        for (int i = start; i <= end; i++) {
            int val = nums[i];
            for (int j = i+1; j <= end; j++) {
                if (nums[j] < val) {
                    swap(nums, i, j);
                }
            }
        }
    }

    private void reverse(int[] nums) {
        int i = 0, j = nums.length-1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int val = nums[i];
        nums[i] = nums[j];
        nums[j] = val;
    }

    private int getLargerValIndex(int[] nums, int start, int val) {
        int index = start;
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > val && nums[i] <= nums[index]) {
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2};
        new NextPermutation().nextPermutation(nums);
        for (int num: nums) {
            System.out.println(num);
        }
    }
}
