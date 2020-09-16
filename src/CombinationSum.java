//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的数字可以无限制重复被选取。
//
// 说明：
//
//
// 所有数字（包括 target）都是正整数。
// 解集不能包含重复的组合。
//
//
// 示例 1:
//
// 输入: candidates = [2,3,6,7], target = 7,
//所求解集为:
//[
//  [7],
//  [2,2,3]
//]
//
//
// 示例 2:
//
// 输入: candidates = [2,3,5], target = 8,
//所求解集为:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//]
// Related Topics 数组 回溯算法


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 * @author initiald0824
 * @date 2020/3/29 2:30 下午
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> record = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(record, res, candidates, target, 0);
        return res;
    }

    private void dfs(List<Integer> record, List<List<Integer>> res, int[] candidates, int target, int begin) {
        List<Integer> recordCopy = new ArrayList<>(record);
        for (int i = begin; i < candidates.length; i++) {
            int val = candidates[i];
            if (val == target) {
                recordCopy.add(val);
                res.add(recordCopy);
                return;
            } else if (val < target) {
                recordCopy.add(val);
                dfs(recordCopy, res, candidates, target-val, i);
                recordCopy.remove(recordCopy.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 5};
        int target = 8;
        List<List<Integer>> res = new CombinationSum().combinationSum(candidates, target);
        for (List<Integer> record: res) {
            for (int val: record) {
                System.out.print(val);
            }
            System.out.println();
        }
    }
}
