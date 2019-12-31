import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author initiald0824
 * @date 2019/12/31 17:57
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            record.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (record.containsKey(target - nums[i])) {
                int index = record.get(target - nums[i]);
                if (i != index) {
                    return new int[]{i, index};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4};
        int target = 6;
        System.out.println(Arrays.toString(new TwoSum().twoSum(nums, target)));
    }

}
