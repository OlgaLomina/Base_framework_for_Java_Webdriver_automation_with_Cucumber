package codingTasks;

import java.util.Arrays;
import java.util.HashMap;

public class FinSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> num = new HashMap<>();
        int l = nums.length;
        int difference;

        for (int i = 0; i < l; i++) {
            difference = target - nums[i];
            if (num.containsKey(nums[i])) {
                result[0] = num.get(nums[i]);
                result[1] = i;
                return result;
            } else {
                num.put(difference, i);
            }
        }
        return null;
    }
}
