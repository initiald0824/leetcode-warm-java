//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 你的算法时间复杂度必须是 O(log n) 级别。
//
// 如果数组中不存在目标值，返回 [-1, -1]。
//
// 示例 1:
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4]
//
// 示例 2:
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1]
// Related Topics 数组 二分查找

import java.util.Arrays;

/**
 * @author initiald0824
 * @date 2020/3/28 10:21 下午
 */
public class RotateSearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int pos = getIndex(nums, target, 0, nums.length-1);
        if (pos == -1) {
            return res;
        }
        int left = pos, right = pos, border = 0;
        while (border != -1) {
            border = getIndex(nums, target, 0, left);
            if (border != -1) {
                if (border == 0) {
                    left = border;
                    break;
                }
                left = border-1 >= 0 ? border -1 : left;
                if (left == 0) {
                    break;
                }
            }
        }
        border = 0;
        while (border != -1) {
            border = getIndex(nums, target, right, nums.length-1);
            if (border != -1) {
                if (border == nums.length - 1) {
                    right = border;
                    break;
                }
                right = border+1 <=nums.length-1 ? border + 1 : right;
                if (right == nums.length - 1) {
                    break;
                }
            }
        }
        if (nums[left] != target) {
            left++;

        }
        if (nums[right] != target) {
            right--;
        }

        res[0] = left;
        res[1] = right;
        return res;
    }

    private int getIndex(int[] nums, int target, int start, int end) {
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new RotateSearchRange().searchRange(new int[]{1, 1, 2}, 1)));
    }
}
