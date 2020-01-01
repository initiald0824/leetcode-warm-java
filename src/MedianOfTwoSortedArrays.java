// 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
//
// 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
//
// 你可以假设 nums1 和 nums2 不会同时为空。
//
// 示例 1:
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
//
//
// 示例 2:
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
//
// Related Topics 数组 二分查找 分治算法

/**
 * @author initiald0824
 * @date 2020/1/1 8:49
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sumSize = nums1.length + nums2.length;
        int target = sumSize / 2;
        if (sumSize % 2 == 1) {
            return findSortMinVal(nums1, 0, nums1.length, nums2, 0, nums2.length, target + 1);
        } else {
            return (findSortMinVal(nums1, 0, nums1.length, nums2, 0, nums2.length, target)
                    + findSortMinVal(nums1, 0, nums1.length, nums2, 0, nums2.length, target+1)) / 2.0;
        }
    }

    public int findSortMinVal(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int rank) {
        if (end1 - start1 > end2 - start2) {
            return findSortMinVal(nums2, start2, end2, nums1, start1, end1, rank);
        }
        if (start1 == end1) {
            return nums2[start2 + rank - 1];
        }
        if (rank == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        } else {
            int step = rank / 2;
            if (end1 - start1 < step) {
                int index2 = start2 + rank - (end1 - start1) - 1;
                if (nums1[end1 - 1] < nums2[index2]) {
                    return nums2[index2];
                } else {
                    return findSortMinVal(nums1, start1, end1, nums2, start2 + step, end2, rank - step);
                }
            } else {
                if (nums1[start1 + step - 1] < nums2[start2 + step - 1]) {
                    return findSortMinVal(nums1, start1 + step, end1, nums2, start2, end2, rank - step);
                } else {
                    return findSortMinVal(nums1, start1, end1, nums2, start2 + step, end2, rank - step);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2));
        System.out.println(new MedianOfTwoSortedArrays().findSortMinVal(nums1, 0, nums1.length, nums2, 0, nums2.length, 5));
        System.out.println(new MedianOfTwoSortedArrays().findSortMinVal(nums1, 0, nums1.length, nums2, 0, nums2.length, 6));
    }
}
