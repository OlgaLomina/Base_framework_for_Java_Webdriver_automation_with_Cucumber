package codingTasks;

import java.util.Arrays;

public class FinSum {
    public int[] twoSum(int[] nums, int target) {
//        int[] a = new int[2];
//        if (target == 0) {
//            boolean firstExist = false;
//            for (int i = 0; i < nums.length; i++) {
//                if (nums[i] == 0) {
//                    if (!firstExist) {
//                        a[0] = i;
//                        firstExist = true;
//                    } else {
//                        a[1] = i;
//                        break;
//                    }
//                }
//            }
//            return a;
//        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
