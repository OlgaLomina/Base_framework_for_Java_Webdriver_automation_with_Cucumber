package codingTasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumOfConsistent {
    public static void main(String[] args) {
        //System.out.println(countConsistentStrings("abc", new String[]{"a","b","c","ab","ac","bc","abc"}));
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    public static int countConsistentStrings(String allowed, String[] words) {
        int count = words.length - 1;
        for  (int i = 0; i < count; i++) {
            for (int w = 0; w < allowed.length(); w++) {
                if (words[i].indexOf(allowed.charAt(w)) == -1) {
                    count--;
                }
            }
        }
        return count;
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> respond = new ArrayList<>();
        int max = Arrays.stream(candies).max().getAsInt();
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max) {
                respond.add(true);
            } else {
                respond.add(false);
            }
        }
        return respond;
    }

    public static int removeDuplicates(int[] nums) {
        int s=nums.length;
        int j=1;
        for(int i=1;i<s;i++){
            if(nums[i] != nums[i-1]){
                nums[j]=nums[i];
                j++;
            }
        }
        return j;
    }
}
